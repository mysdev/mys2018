//获取项目根目录
var pathName = window.document.location.pathname;
var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);
//户口性质全局
//var householdTypeValue="";


//点击获取iframe中的URL
function GoPage(url,iframe) {
	var iframeid=iframe || "myiframe";
	if(url && url !='null'){
	    $("#"+iframeid).attr('src', projectName+url);
	}
}


function TopGoPage(url,iframe){
	var iframeid=iframe || "myiframe";
	if(url && url !='null'){
	    top.$("#"+iframeid).attr('src', projectName+url);
	}
}

function TopGoPagedetail(url,iframe,id){
	var iframeid=iframe || "myiframe";
	if(id==null ||id=="" ||id == undefined){
		 top.$("#"+iframeid).attr('src', projectName+url);
	}else{
		if(url && url !='null'){
		    top.$("#"+iframeid).attr('src', projectName+url+'?did='+id);
		}
	}
}
//手机号码校验，长度为11位数字。
function checkMobile(str) {
    // var Str=document.getElementById(str).value;
    RegularExp = /^[0-9]{11}$/
    if (RegularExp.test(str)) {
	return true;
    } else {
	// alert("手机号格式不正确！应该为11位长度的数字！");
	return false;
    }
}// 身份证号合法性验证
// 支持15位和18位身份证号
// 支持地址编码、出生日期、校验位验证
function IdentityCodeValid(code) {
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

// 是否为正整数
function isPositiveInteger(s) {// 是否为正整数
    var re = /^[0-9]+$/;
    return re.test(s)
}
/**
 * 初始化表单验证 formid:表单的id rules:表单验证的规则 messages:表单验证不通过的提示文字
 */
function validform(formid, rules, messages) {
    /* 关键在此增加了一个return，返回的是一个validate对象，这个对象有一个form方法，返回的是是否通过验证 */
    return $("#" + formid).validate({
	rules : rules,
	messages : messages,
	errorLabelContainer : $("#" + formid + " .error")
    });
}

// 绑定下拉框的字典列表
function bindSelect(selectid, group_code, name) {
    var str = name || "";
    $('#' + selectid).html('');
    $('#' + selectid).append('<option value="">-请选择' + str + '-</option>');
    var list = dictionarySelectFild(group_code);
    $.each(list, function(i, item) {
	$('#' + selectid).append('<option value="' + item.code + '">' + item.value + '</option>');
    });
}

// 绑定下拉框的字典列表
function bindCheckBox(selectid, group_code) {
    var str = name || "";
    $('#' + selectid).html('');
    var list = dictionarySelectFild(group_code);
    $.each(list, function(i, item) {
	$('#' + selectid).append('<span style="padding:3px 5px;"><label style="font-weight:normal;" for="' + selectid + '_' + item.code + '"><input id="' + selectid + '_' + item.code + '" name="' + selectid + '" value="' + item.code + '" type="checkbox"/>' + item.value + '</label></span>');
    });
}

// 获取表单数据
function getFormData(formid) {
    var formdata = {};
    $('#' + formid).find('input,select,textarea').each(
			function(i, item) {
				var name=$(item).attr('name');
				if(typeof(name)!="undefined"&&name!=null&&name!="")
				{
					if ($(item).attr('type') == "radio") {
						if (formdata[name]
								&& formdata[name].length > 0) {
							// 已存在 什么都不做
						} else {
							formdata[name] = $('input:radio[name="'+name+ '"]:checked', $('#' + formid)).val();
						}
					} else if ($(item).attr('type') == "checkbox") {
						if ($(item).is(':checked')) {
							var cv = $(item).val();
							var v = formdata[name];
							if (typeof (v) == "undefined" || v == null || v == "") {
								formdata[name] = cv;
							} else {
								formdata[name] = v + ',' + cv;
							}
						}
					} else if ($(item).attr('type') == "file") {
						// 文件标签 什么都不做
					} else if ($(item).attr('type') == "button") {
						// 按钮 什么都不做
					} else if ($(item).attr('type') == "number") {
						formdata[name] = $(item).val();
					}else if ($(item).attr('type') == "hidden") {
						if(formdata[name]&&formdata[name] !="")
						{
							formdata[name]+=",";
							formdata[name] += $(item).val();
						}
						else
						{
							formdata[name] = $(item).val();
						}	 
					} else {
						formdata[name] = $(item).val();
					}
				}	 
			});
    return formdata;
}

//获取搜索表单数据(当值为空时不提交KEY)
function getFormDataBySeach(formid) {
    var formdata = {};
    $('#' + formid).find('input,select,textarea').each(function(i, item) {
	if ($(item).attr('type') == "radio") {
	    if (formdata[$(item).attr('name')] && formdata[$(item).attr('name')].length > 0) {
		// 已存在 什么都不做
	    } else {
	    	if(formdata[$(item).attr('name')].val()!=""){
	    		formdata[$(item).attr('name')] = $('input:radio[name="' + $(item).attr('name') + '"]:checked', $('#' + formid)).val();
	    	}
	    }
	} else if ($(item).attr('type') == "checkbox") {
	    if ($(item).is(':checked')) {
		var cv = $(item).val();
		var v = formdata[$(item).attr('name')];
		if (typeof (v) == "undefined" || v == null || v == "") {
			if(cv!=""){
				formdata[$(item).attr('name')] = cv;
			}
		} else {
			if(cv!=""){
				formdata[$(item).attr('name')] = v + ',' + cv;
			}
		}
	    }
	    /*
	     * if(formdata[$(item).attr('name')]&&formdata[$(item).attr('name')].length>0) {
	     * //已存在 什么都不做 } else {
	     * formdata[$(item).attr('name')]=$('input:checkbox[name="'+$(item).attr('name')+'"]:checked',$('#'+formid)).val(); }
	     */
	} else if ($(item).attr('type') == "file") {
	    // 文件标签 什么都不做
	} else if ($(item).attr('type') == "button") {
	    // 按钮 什么都不做
	} else if ($(item).attr('type') == "number") {
		formdata[$(item).attr('name')] = $(item).val();
	} else {
		if($(item).val()!=""){
			formdata[$(item).attr('name')] = $(item).val();
		}
	}
    });
    return formdata;
}


// 填充表单
function setFormData(formid, formdata) {
    $('#' + formid).find('input,select,textarea').each(function(i, item) {
	// console.log($(item).tagName);
	if ($(item).attr('type') == "radio") {
	    var id = $(item).attr('name');
	    var value = formdata[id];
	    if (value) {
		$('input:radio[name="' + id + '"][value="' + value + '"]', $('#' + formid)).attr('checked', 'checked');
	    }
	} else if ($(item).attr('type') == "checkbox") {
	    var id = $(item).attr('name');
	    var values = formdata[id];
	    if (values) {
		$.each(values.split(','), function(j, val) {
		    if (val && val.length > 0) {
			$('input:checkbox[name="' + id + '"][value="' + val + '"]', $('#' + formid)).attr('checked', 'checked');
		    }
		})
	    }
	} else if ($(item).attr('type') == "file") {
	    // 文件标签 什么都不做
	} else if ($(item).attr('type') == "button") {
	    // 按钮 什么都不做
	} else if ($(item).attr('type') == "number") {
		$(item).val(formdata[$(item).attr('name')]);
	}else if ($(item).attr('type') == "date") {
	    var format = $(item).attr('format');
	    var id = $(item).attr('name');
	    var field_val = formdata[id];
	    if (typeof (field_val) == "string" && field_val.indexOf('-') > 0) {
		$(item).val(field_val);
	    } else if (typeof (field_val) == "number") {
		var text = getLongDateAsString(field_val, format);
		$(item).val(text);
	    }
	}  else {
	    $(item).val(formdata[$(item).attr('name')]);
	}
    });
}

// 清除表单
function clearForm(formid) {
    $('#' + formid).find('input').each(function(i, item) {
	if ($(item).attr('type') == "radio") {
	    $(item).removeAttr('checked');
	} else if ($(item).attr('type') == "checkbox") {
	    $(item).removeAttr('checked');
	} else {
	    $(item).val('');
	}
    });
}

// 填充表格 getFormatDate
function setTableData(tableid, formdata) {
    for ( var key in formdata) {
	var obj = $('#' + key, $('#' + tableid));
	if (obj) {
	    var type = obj.attr('type');
	    if (type && type == "img") {
		if (formdata[key] != null) {
		    var files = formdata[key];
		    var str = "";
		    $.each(files.split(','), function(i, item) {
			if (item && item != "") {
			    str += '<a href="/images/documentImage/' + item + '" class="highslide" onclick="return hs.expand(this)"><img height="70px" src="/images/documentImage/' + item + '"/></a>';
			}

		    });
		    obj.html(str);
		}

	    } else if (type && type == "file") {
		if (formdata[key] != null) {
		    var files = formdata[key];
		    var str = "";
		    $.each(files.split(','), function(i, item) {
			if (item && item != "") {
			    str += '<a class="btn btn-info" style="display:block;width: 30%" href="/document/' + item + '" download> <span class="glyphicon glyphicon-paperclip" ></span>下载附件</a>';
			}
		    });
		    obj.html(str);
		}
	    } else if (type && type == "hidden") {
		obj.val(formdata[key]);
	    } else if (type && type == "dictionary") {
		var group_code = obj.attr('code');
		obj.html(dictionary_checkbox(group_code, formdata[key]));
	    } else if (type && type == "datetime") {
		// obj.html(getFormatDate(formdata[key]));
		obj.html(getLongDateAsString(formdata[key], "yyyy-MM-dd"));
	    } else {
		obj.html(formdata[key]);
	    }
	}
    }
}

/**
 * 加载数据后改变body高度
 */
function changebody() {
    var infoHeight = top.document.body.clientHeight;
    var handH=top.$(".page-header").height();
    var footH=top.$(".page-footer").height();
    var tabH=$(".tabs-header").height();
    $("body").height(infoHeight - handH - footH -tabH -35);
    $(".container_wrap").css("height", infoHeight);
    refreshHeight();
}
 

// 刷新框架页高度
function refreshHeight() {
    top.$('#myiframe').height($('body').height());
}


// 打开遮罩层
function mask() {
    var winHeight = $(window).height();
    var winwidth = $(window).width();
    var maskwrap = $('<div class="maskwrap"></div>');
    $(".maskwrap").css({
	"width" : winwidth,
	"height" : winHeight
    })
    $("body").append(maskwrap);
}
// 关闭遮罩层
function maskClose() {
    $(".maskwrap").remove();
}

/**
 * 封装好的ajax方法
 * 
 * @param action
 * @param type
 * @param data
 * @param success
 * @param async
 */
function myAjax(action, type, data, success, async) {
    var url = action;
    var asy = async;
    var type = type || 'post';
    $.ajax({
	cache : false,
	async : asy,
	url : url,
	data : data,
	timeout : 600000,
	dataType : 'json',
	type : type,
	success : function(rs) {
	    if (!success) {
		return;
	    }
	    success(rs);
	},
	error : function(result, b) {
	    // console.log('发现系统错误 <BR>错误码：' + result.status);
	}
    });
};

/**
 * 长整型时间转化为指定时间格式
 * 
 * @param dt
 *            时间
 * @param format
 *            格式
 * @returns {String}
 */
function getLongDateAsString(dt, format) {
    var bd = new Date(dt);
    var month = bd.getMonth() + 1;
    var date = bd.getDate();
    if (month < 10) {
	month = "0" + month;
    }
    if (date < 10) {
	date = "0" + date;
    }
    if ('yyyy-MM-dd' == format) {
	return bd.getFullYear() + "-" + month + "-" + date;
    } else if ('yyyy-MM-dd hh:mm:ss' == format) {
	return bd.getFullYear() + "-" + month + "-" + date + " " + bd.getHours() + ":" + bd.getMinutes() + ":" + bd.getSeconds();
    } else if ('yyyy-MM' == format) {
	return bd.getFullYear() + "-" + month;
    } else if ('yyyyMMdd' == format) {
	return bd.getFullYear() + month + date;
    }
    // getDate() 查看Date对象并返回日期
    // getDay() 返回星期几
    // getHours() 返回小时数
    // getMinutes() 返回分钟数
    // getMonth() 返回月份值
    // getSeconds() 返回秒数
    // getTime() 返回完整的时间
    // getYear() 返回年份
    return bd.toLocaleString();
}
/**
 * 加入收藏
 */
function addFavoritejl() {

    var url = window.location;
    var title = document.title;
    var ua = navigator.userAgent.toLowerCase();
    console.log("加入收藏" + ua);
    if (ua.indexOf("360se") > -1) {
	alert("由于360浏览器功能限制，请按 Ctrl+D 手动收藏！");
    } else if (ua.indexOf("msie 8") > -1) {
	window.external.AddToFavoritesBar(url, title); // IE8
    } else if (document.all) {
	try {
	    window.external.addFavorite(url, title);
	} catch (e) {
	    alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
	}
    } else if (window.sidebar) {
	try {
	    window.sidebar.addPanel(title, url, "");
	} catch (e) {
	    alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
	}
    } else {
	alert('您的浏览器不支持,请按 Ctrl+D 手动收藏!');
    }
}
/**
 * 设置主页
 * 
 * @param obj
 *            var url = window.location;
 */
function setHomejl(obj) {
    var url = window.location;
    try {
	obj.style.behavior = 'url(#default#homepage)';
	obj.setHomePage(vrl);
    } catch (e) {
	if (window.netscape) {
	    try {
		netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
	    } catch (e) {
		alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
	    }
	    if (Components.classes != undefined) {
		var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
		prefs.setCharPref('browser.startup.homepage', vrl);
	    }
	}
    }
}

/**
 * 获取QueryString的数组
 */
function getQueryString() {
    var result = location.search.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]+", "g"));
    if (result == null) {
	return "";
    }
    for (var i = 0; i < result.length; i++) {
	result[i] = result[i].substring(1);
    }
    return result;
}

/**
 * 根据QueryString参数名称获取值
 */
function getQueryStringByName(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null)
	return (r[2]);
    return null;
}

/**
 * 根据QueryString参数索引获取值
 */
function getQueryStringByIndex(index) {
    if (index == null) {
	return "";
    }
    var queryStringList = getQueryString();
    if (index >= queryStringList.length) {
	return "";
    }
    var result = queryStringList[index];
    var startIndex = result.indexOf("=") + 1;
    result = result.substring(startIndex);
    return result;
}

/**
 * 模板引用地址处理-只取最后的页面名称
 * 
 * @param furl
 */
function getPageNameFromUrl(furl) {
    if (furl == undefined || furl.length == 0) {
	return "";
    }
    var u = furl.split("/");
    return u[u.length - 1];
}
/**
 * 获取参数
 * 
 * @param furl
 * @returns
 */
function getParamFromUrl(furl) {
    if (!strIsNullZero(furl) && furl.indexOf("?") != -1) {
	return furl.substr(furl.indexOf("?") + 1);// 去掉?号
    }
    return furl;
}

function getParamUrlAddTimt(url) {
    var timestamp = (new Date()).valueOf();
    if ((url.indexOf("&") >= 0)) {
	url = url + "&timestamp=" + timestamp;
    } else {
	url = url + "?timestamp=" + timestamp;
    }
    return url;
}
/**
 * 添加参数
 * 
 * @param iurl
 *            原
 * @param prms
 *            参数串，支持多个参数
 */
function addParamToUrl(iurl, prms) {

}

function strIsNullZero(str) {
    if (str == undefined || str == null || str.length == 0) {
	return true;
    }
    return false;
}

/**
 * 去掉HTML代码中的标签
 * 
 */
function getStringByHtml(htmlstr) {
    if (htmlstr != undefined && htmlstr != null) {
	return htmlstr.replace(/<[^>]+>/g, "");
    }
    return "";
}

/**
 * 截取字符串，超过长度时最后三位用...代替
 * 
 * @param str
 *            字符
 * @param fi
 *            起点
 * @param ti
 *            终点
 */
function subStringjl(str, fi, ti) {
    if (str == undefined) {
	return "";
    }
    if (fi > ti) {
	var i = ti;
	ti = fi;
	fi = i;
    }
    if (str.length > ti && str.length > 5) {
	return str.substring(fi, ti - 3) + "...";
    } else {
	return str.substring(fi, ti);
    }
}

// 测试请求是手机端还是PC端
function isMobileBrowser() {
    var sUserAgent = navigator.userAgent.toLowerCase();
    var bIsIpad = sUserAgent.match(/ipad/i) == "ipad";
    var bIsIphoneOs = sUserAgent.match(/iphone os/i) == "iphone os";
    var bIsMidp = sUserAgent.match(/midp/i) == "midp";
    var bIsUc7 = sUserAgent.match(/rv:1.2.3.4/i) == "rv:1.2.3.4";
    var bIsUc = sUserAgent.match(/ucweb/i) == "ucweb";
    var bIsAndroid = sUserAgent.match(/android/i) == "android";
    var bIsCE = sUserAgent.match(/windows ce/i) == "windows ce";
    var bIsWM = sUserAgent.match(/windows mobile/i) == "windows mobile";
    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM) {
	return true;
    }
    return false;
}
// 空字段用无展示
function isNull(str) {
    if (!str || str == "undefined") {
	return "无";
    } else {
	return str;
    }
}

// 将data类型long值转为日期字符串
function getFormatDate(time) {
    if (time != null) {
	var date = new Date(time);
	var seperator1 = "-";
	var seperator2 = ":";
	var month = date.getMonth() + 1;
	var strDate = date.getDate();
	var shour = date.getHours();
	var sminutes = date.getMinutes();
	var sseconds = date.getSeconds();
	if (month >= 1 && month <= 9) {
	    month = "0" + month;
	}
	if (strDate >= 0 && strDate <= 9) {
	    strDate = "0" + strDate;
	}
	if (shour >= 0 && shour <= 9) {
	    shour = "0" + shour;
	}
	if (sminutes >= 0 && sminutes <= 9) {
	    sminutes = "0" + sminutes;
	}
	if (sseconds >= 0 && sseconds <= 9) {
	    sseconds = "0" + sseconds;
	}

	var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate + " " + shour + seperator2 + sminutes + seperator2 + sseconds
	return currentdate;
    }
    return "";
}



// 转义0:否 1:是
function isYesOrNo(str) {
    if (str == 0) {
	return "否";
    } else if (str == 1) {
	return "是";
    } else {
	return "未知";
    }

}

// 日期转换方法
Date.prototype.format = function(fmt) {
    var o = {
	"M+" : this.getMonth() + 1, // 月份
	"d+" : this.getDate(), // 日
	"h+" : this.getHours(), // 小时
	"m+" : this.getMinutes(), // 分
	"s+" : this.getSeconds(), // 秒 ;
	"q+" : Math.floor((this.getMonth() + 3) / 3), // 季度
	"S" : this.getMilliseconds()
    // 毫秒
    };
    if (/(y+)/.test(fmt)) {
	fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for ( var k in o) {
	if (new RegExp("(" + k + ")").test(fmt)) {
	    fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
	}
    }
    return fmt;
}

// 选择时间加载时间
function getInitDate() {
    var str = "";
    for (var i = 1; i <= 20; i++) {
	i < 10 ? i = "0" + i : i = i
	str += '<option value=' + i + '>' + i + '</option>'
    }
    $(".hovr_select").append(str);
}


// bootstrap-table colunms获取数据字典的值
function tableGetDic(code) {
    if (code) {
	var c = code;
	var gc = c.substring(0, c.length - 2);
	return dictionary(gc, c);
    } else {
	return;
    }
    if (url && url != 'null') {
	$('#myiframe', window.parent.document).attr('src', url);
    }
}

// 身份证提示窗
function validateIDInput(inputId, calback) {
    console.log("调用common身份证验证方法");
    $("#" + inputId).blur(function() {
	var sfzhFlag = $("#" + inputId).val();
	var ifFlag = IdentityCodeValid(sfzhFlag);
	if (ifFlag) {
	    if (calback) {
		calback(sfzhFlag);
	    }
	} else {
	    $("#" + inputId).val("");
	    window.wxc.xcConfirm("身份证号格式错误", window.wxc.xcConfirm.typeEnum.error);
	}

    });
}

//分页方法
function Page(curpage, pagesize, total, callback, tag) {
    var first = 1;
    var end = 1;
    var last = 1;
    var next = 1;
    var pagenum = 1;

    if (total < pagesize) {
	first = 1;
	end = 1;
	last = 1;
	next = 1;
	pagenum = 1;
    } else {
	pagenum = Math.ceil(total / pagesize);
	first = 1;
	last = parseInt(curpage) - 1;
	next = parseInt(curpage) + 1;
	if (last <= 0) {
	    last = 1;
	}
	if (next > pagenum) {
	    next = pagenum;
	}
	end = pagenum;

    }
    var pagestr = '<ul class="pagination"> ';
    if (total == 0) {
	pagestr = "";
    } else {
	pagestr += '<li> <a href=javascript:' + callback + '("' + first + '") aria-label="Previous"> <span aria-hidden="true">首页</span> </a>  </li> ';
	pagestr += '<li><a href=javascript:' + callback + '("' + last + '") aria-label="Previous"> <span aria-hidden="true"><</span>  </a> </li>';
	if (pagenum <= 5) {
	    for (var i = 1; i <= pagenum; i++) {
		var s = "";
		if (i == parseInt(curpage)) {
		    s = ' class="active"';
		}
		pagestr += '<li ' + s + '><a href=javascript:' + callback + '("' + i + '")  >' + i + '</a></li> ';
	    }
	} else {
	    if (parseInt(curpage) - 2 <= 0) {
		for (var i = 1; i <= 5; i++) {
		    var s = "";
		    if (i == parseInt(curpage)) {
			s = ' class="active"';
		    }
		    pagestr += '<li ' + s + '><a href=javascript:' + callback + '("' + i + '")   >' + i + '</a></li> ';
		}
		pagestr += '<li><a href="#" >...</a></li> ';
	    } else if (parseInt(curpage) + 2 > pagenum) {
		pagestr += '<li><a href="#" >...</a></li> ';
		for (var i = pagenum - 4; i <= pagenum; i++) {
		    var s = "";
		    if (i == parseInt(curpage)) {
			s = ' class="active"';
		    }
		    pagestr += '<li  ' + s + ' ><a href=javascript:' + callback + '("' + i + '") >' + i + '</a></li> ';
		}
	    } else {
		if (parseInt(curpage) - 2 > 1) {
		    pagestr += '<li><a href="#" >...</a></li> ';
		}
		for (var i = parseInt(curpage) - 2; i <= parseInt(curpage) + 2; i++) {
		    var s = "";
		    if (i == parseInt(curpage)) {
			s = ' class="active"';
		    }
		    pagestr += '<li  ' + s + '><a href=javascript:' + callback + '("' + i + '")  >' + i + '</a></li> ';
		}
		if (parseInt(curpage) + 2 < pagenum) {
		    pagestr += '<li><a href="#" >...</a></li> ';
		}
	    }
	}
	pagestr += '<li> <a href=javascript:' + callback + '("' + next + '") aria-label="Next">  <span aria-hidden="true">></span> </a> </li>';
	pagestr += '<li>  <a href=javascript:' + callback + '("' + end + '") aria-label="Next"> <span aria-hidden="true">尾页</span>  </a>  </li>';
	pagestr += '</ul>';
    }
    $('#' + tag).html('');
    $('#' + tag).append(pagestr);
}

//页面回到顶部
function scrollToTop() { //滚动到顶部
    $(top.window).scrollTop('0');
}

//判断附件格式
function getOptions(imgid) {
	var rightstr = "";
	for (var i = 0; i < imgid.length; i++) {
		$.ajax({
			type : 'get',
			url : '/document/index/' + imgid[i],
			dataType : 'json',
			async : false,
			success : function(obj) {
				if (obj.code == 1) {
					rightstr += '<span class="downblock">'
						if (obj.model.suffixName == '.jpg' || obj.model.suffixName == '.png') {
							rightstr += '<a href="/images/documentImage/'+obj.model.id+'" class="highslide" onclick="return hs.expand(this)">'+"<img class='thumbnails' height='40px' src='/images/document/small/" + obj.model.id + "' /></a>";
						} else if (obj.model.suffixName == '.docx' || obj.model.suffixName == '.doc' || obj.model.suffixName == '.txt' || obj.suffixName == 'xls' || obj.suffixName == 'xlsx') {
							rightstr += "<a style='color:#ccc;cursor: pointer;' href='/document/" + obj.model.id + "' downlaod><img class='thumbnails' height='40px' src='../../resources/images/filetype/doc.png' /></a>";
						} else if (obj.model.suffixName == '.avi' || obj.model.suffixName == '.mp4') {
							rightstr += "<a style='color:#ccc;cursor: pointer;' href='/document/" + obj.model.id + "' downlaod><img class='thumbnails' height='40px' src='../../resources/images/filetype/avi.png' /></a>";
						} else if (obj.model.suffixName == '.rar' || obj.model.suffixName == '.zip') {
							rightstr += "<a style='color:#ccc;cursor: pointer;' href='/document/" + obj.model.id + "' downlaod><img class='thumbnails' height='40px' src='../../resources/images/filetype/rar.png' /></a>";
						} else {
							rightstr += "<a style='color:#ccc;cursor: pointer;' href='/document/" + obj.model.id + "' downlaod><img class='thumbnails' height='40px' src='../../resources/images/filetype/undicon.png' /></a>";
						}
						rightstr += '</span>';
				}
			}
		})
	}
	return rightstr;
}

//easyuidatagrid全局变量
var grid_options={
	    dataType: 'json',  
	    method:'post',
	    rownumbers:false,
        width: "100%", //宽度   
       // height:'680px',
        striped: true, //把行条纹化（奇偶行背景色不同）  
        loadMsg: '正在加载用户的信息.......', //从远程站点加载数据是，显示的提示消息  
        pagination: true, //数据网格底部显示分页工具栏  
        pageList: [10, 20], //设置每页记录条数的列表  
        pageSize: 10, //初始化页面尺寸（默认分页大小）  
        pageNumber: 1, //初始化页面（默认显示第一页）  
        beforePageText: '第', //页数文本框前显示的汉字   
        afterPageText: '页 共 {pages} 页',  
        displayMsg: '第{from}到{to}条，共{total}条',
        sortName:'createDate',
        sortOrder:'desc',
        pageNumber:1,
        fit:false,
        onBeforeLoad : function(param){
        	var sort=param.sort; //保存下值
        	delete param.sort;
        	param.sortname=sort;
        	var order=param.order;
        	delete param.order;
        	param.ordername=order;
        	var rows=param.rows;
        	delete param.rows;
        	param.pageSize=rows;
        	var page=param.page;
        	delete param.page;
        	param.pageNumber=page;
        }
	};

//搜索收缩
function searchDown_Up(clickId,searchId){
	$("."+clickId).click(function(){
		if($("."+searchId).is(":hidden")){
			$(this).css({
				"transform": "rotate(180deg)",
				"transition":'all 1s'
			});
			$("."+searchId).slideDown() ;
		}else{
			$(this).css({
				"transform": "rotate(0deg)",
				"transition":'all 1s'
			});
			$("."+searchId).slideUp() ;
		}
	})
};

 