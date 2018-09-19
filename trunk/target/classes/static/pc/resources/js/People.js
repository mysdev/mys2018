var People = {};

People.loadPage = function (eleName,divId,options){
	$("input[name='"+eleName+"']").change(function(){
		var radioObj = this;
		$.each(options, function(i,e) {
//			console.log("1"+options[i].name);
//			console.log("2"+radioObj.value);
			if(options[i].name && options[i].name !=null && options[i].name == radioObj.value){
				$("#"+divId).html("");
//				console.log(divId);
//				console.log(options[i].pageUrl);
				$("#"+divId).load(options[i].pageUrl);
			}
		});
	});
}

//身份证验证
People.IdentityCodeValid =function(code) {
    var city = {
	11 : "北京",
	12 : "天津",
	13 : "河北",
	14 : "山西",
	15 : "内蒙古",
	21 : "辽宁",
	22 : "吉林",
	23 : "黑龙江 ",
	31 : "上海",
	32 : "江苏",
	33 : "浙江",
	34 : "安徽",
	35 : "福建",
	36 : "江西",
	37 : "山东",
	41 : "河南",
	42 : "湖北 ",
	43 : "湖南",
	44 : "广东",
	45 : "广西",
	46 : "海南",
	50 : "重庆",
	51 : "四川",
	52 : "贵州",
	53 : "云南",
	54 : "西藏 ",
	61 : "陕西",
	62 : "甘肃",
	63 : "青海",
	64 : "宁夏",
	65 : "新疆",
	71 : "台湾",
	81 : "香港",
	82 : "澳门",
	91 : "国外 "
    };
    var tip = "";
    var pass = true;

    if (!code || !/^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/.test(code)) {
	tip = "身份证号格式错误";
	pass = false;
    }

    else if (!city[code.substr(0, 2)]) {
	tip = "地址编码错误";
	pass = false;
    } else {
	// 18位身份证需要验证最后一位校验位
	if (code.length == 18) {
	    code = code.split('');
	    // ∑(ai×Wi)(mod 11)
	    // 加权因子
	    var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
	    // 校验位
	    var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
	    var sum = 0;
	    var ai = 0;
	    var wi = 0;
	    for (var i = 0; i < 17; i++) {
		ai = code[i];
		wi = factor[i];
		sum += ai * wi;
	    }
	    var last = parity[sum % 11];
	    if (parity[sum % 11] != code[17]) {
		tip = "校验位错误";
		pass = false;
	    }
	}
    }
    // if(!pass) alert(tip);
    return pass;
}

// 验证身份证号唯一性
People.onlyIdCard = function (sfzhParm) {
    $.get("/base/people/idCard/" + sfzhParm, {}, function(rs) {
	// console.log("rs:");
	// console.log(rs);
	if (rs.code == "0") { // 不采取任何操作
	    $("#add_btn").css("display", "block");
	    $("#move_btn").css("display", "none");
	} else if (rs.code == "1") { // 回滚数据,申请网格
	    // 某某网格,某某楼栋,某某房间
	    var fullName = (rs.model.area != null ? rs.model.area.fullName : null);
	    window.wxc.xcConfirm("该居民已在" + (fullName != null ? fullName : "其他网格") + "登记,继续操作将申请移入本网格！", window.wxc.xcConfirm.typeEnum.warning);

	    // 回滚照片
	    if (rs.model.img) {
		$("#uploadifive-uploadifive").after('<img style="width:50px;height50px;" id="fileimg" src="/images/documentImage/' + rs.model.img + '">');
		$("#uploadifive-uploadifive").remove();
	    }

	    // 回滚表单数据
	    setFormData('addForm_ybry', rs.model);

	    // 回滚所在网格的数据
	    setCodeBack(rs.model.area.areaCode, "areacode");

	    // 隐藏保存按钮,显示移入按钮
	    $("#add_btn").css("display", "none");
	    $("#move_btn").css("display", "block");

	    // 给移入方法加点击事件
	    $('#move_btn').click(function() {
	    	People.transPeopleSpecial
	    	movePeople();
		
	    });

	} else if (rs.code == "-1") {
	    // 弹出错误信息
	    window.wxc.xcConfirm(rs.message, window.wxc.xcConfirm.typeEnum.error);
	} else {
	    window.wxc.xcConfirm("系统错误请与管理员联系", window.wxc.xcConfirm.typeEnum.error);
	}
    }, 'json');
}

//展示人员特殊属性
People.transPeopleSpecial = function(str){
	var flag = str.indexOf(",");
	var strReturn = "";
	if(flag != -1){
		var strArr = str.split(',');
		$.each(strArr, function(i,e) {
			strReturn += Faith.dictionaryToChinese('2600', str)
		});
	}else{
		strReturn = Faith.dictionaryToChinese('2600', str);
	}
	return strReturn;
}


//年龄转出生日期
People.getDateByAge = function(age,type){
	if(type == 0){		//出生日期
		var ageIn = parseInt(age);
		var birthday = new Date();
		var nowYear = parseInt(birthday.getFullYear());
	    var nowMonth = birthday.getMonth() + 1;
	    var nowDay = birthday.getDate();
		nowYear = nowYear - ageIn;
		var strDate = nowYear+'-'+01 + '-' + 01;
	}else{		
		var ageIn = parseInt(age);
		var birthday = new Date();
		var nowYear = parseInt(birthday.getFullYear());
	    var nowMonth = birthday.getMonth() + 1;
	    var nowDay = birthday.getDate();
		nowYear = nowYear - ageIn;
		var strDate = nowYear+'-'+12 + '-' + 30;
	}
	
	return strDate;
}


//拼接地址
People.getAdressByAreaID = function (areaid){
	
	
	
}
