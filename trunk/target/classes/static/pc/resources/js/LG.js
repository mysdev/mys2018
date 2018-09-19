
var dataArray = [];


var datadicurl = "/handler/sys.ashx?Action=GetDataDics&TypeName=";

String.prototype.replaceAll = function (FindText, RepText) {
    regExp = new RegExp(FindText, "g");
    return this.replace(regExp, RepText);
}

/*===================下载文件
 * options:{
 * url:'',  //下载地址
 * data:{name:value}, //要发送的数据
 * method:'post'
 * }
 */
var downLoadFile = function (options) {
    var config = $.extend(true, { method: 'post' }, options);
    console.log(config.data);
    var $iframe = $('<iframe id="down-file-iframe" />');
    var $form = $('<form target="down-file-iframe" method="' + config.method + '" />');
    $form.attr('action', config.url);
    for (var key in config.data) {
    	console.log(key+"="+config.data[key]);
        $form.append('<input type="hidden" name="' + key + '" value="' + config.data[key] + '" />');
    }
    $iframe.append($form);
    $(document.body).append($iframe);
    $form[0].submit();
    $iframe.remove();
}




function f_selecarea(obj){
    if (obj.data.children.length <= 0) {
        var tree = liger.get(obj.id);
        if (tree) {
            LG.myAjax("/handler/sys.ashx?action=ShowAreaBaseTreeWithRight", 'post', {
                parentcode: obj.data.AreaCode
            }, function(rs){
                tree.append(obj.target, rs.Data);
            }, true);
        }
    }
}

function f_selecareacq(obj){
    if (obj.data.children.length <= 0) {
        var tree = liger.get(obj.id);
        if (tree) {
            LG.myAjax("/handler/sys.ashx?action=ShowAreaBaseCQWithRight", 'post', {
                parentcode: obj.data.AreaCode
            }, function(rs){
                tree.append(obj.target, rs.Data);
            }, true);
        }
    }
}

function f_selectnext(obj){
    if (obj.data.children.length <= 0) {
        var tree = liger.get(obj.id);
        if (tree) {
            LG.myAjax("/handler/sys.ashx?action=ShowOrgListByPid", 'get', {
                pid: obj.data.Id
            }, function(rs){
                tree.append(obj.target, rs.Data);
            }, true);
        }
    }
}

/*
 * 获取多选框的值
 */
function getCheckBoxValue(inputname){
	var str='';
	$("input[name="+inputname+"]:checked").each(function(index,item){ 
    	str= str +$(item).val() + ",";     
    });
	if(str.length>0){
		str=str.substring(0,str.length-1)
	}
	return str;
}


function VcardId(form){
    var rs = true;
    var retmess = CheckCardId(form, "CardId", "Birthday", "Sex", "Birthplace");
    if (retmess != "" && retmess != "验证通过!") {
        LG.showError(retmess);
        rs = false;
    }
    return rs;
}

//获取QueryString的数组
function getQueryString(){
    var result = location.search.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]+", "g"));
    if (result == null) {
        return "";
    }
    for (var i = 0; i < result.length; i++) {
        result[i] = result[i].substring(1);
    }
    return result;
}

//根据QueryString参数名称获取值
function getQueryStringByName(name){
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) 
        return (r[2]);
    return null;
}

//根据QueryString参数索引获取值
function getQueryStringByIndex(index){
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

(function($){

    //全局系统对象
    window['LG'] = {};
    
    LG.cookies = (function(){
        var fn = function(){
        };
        fn.prototype.get = function(name){
            var cookieValue = "";
            var search = name + "=";
            if (document.cookie.length > 0) {
                offset = document.cookie.indexOf(search);
                if (offset != -1) {
                    offset += search.length;
                    end = document.cookie.indexOf(";", offset);
                    if (end == -1) 
                        end = document.cookie.length;
                    cookieValue = unescape(document.cookie.substring(offset, end));
                }
            }
            return cookieValue;
        };
        fn.prototype.set = function(cookieName, cookieValue, DayValue){
            var expire = "";
            var day_value = 1;
            if (DayValue != null) {
                day_value = DayValue;
            }
            expire = new Date((new Date()).getTime() + day_value * 86400000);
            expire = "; expires=" + expire.toGMTString();
            document.cookie = cookieName + "=" + encodeURIComponent(cookieValue) + ";path=/" + expire;
        };
        fn.prototype.remvoe = function(cookieName){
            var expire = "";
            expire = new Date((new Date()).getTime() - 1);
            expire = "; expires=" + expire.toGMTString();
            document.cookie = cookieName + "=" + escape("") + ";path=/" + expire;
            /*path=/*/
        };
        
        return new fn();
    })();
    
    LG.loadAction = function (menuId){
    	var JsonData = "";
    	var toolbar = {};
    	toolbar.items =  new Array(); 
    	LG.myAjax("/resource/action/"+ menuId +"?" + Math.random(), 'post', null,function(data){
    		JsonData = data;
    		$.each(JsonData, function (i) {
                if (JsonData[i]) {
                	var obj = new Object();
                	obj.text=JsonData[i].resourceTitle;
                	obj.click= function (){
                		try {
                			var str = JsonData[i].resourceID;
                			var fname = str.substring(str.indexOf("_")+1,str.length);
                	        var fn = eval(fname);
            	        } catch(e) {
            	            console.log(e);
            	            alert(fn+'方法不存在！');
            	        }
            	        if (typeof fn === 'function'){
            	            fn.call(this); 
            	        }    
                	};
                	obj.icon=JsonData[i].icon;
                	toolbar.items.push(obj);
                }
    		});
        }, false);
    	return toolbar;
    }
    
    //右下角的提示框
    LG.tip = function(message){
        if (LG.wintip) {
            LG.wintip.set('content', message);
            LG.wintip.show();
        }
        else {
            LG.wintip = $.ligerDialog.tip({
                content: message
            });
        }
        setTimeout(function(){
            LG.wintip.hide();
        }, 4000);
    };
    
    //预加载图片
    LG.prevLoadImage = function(rootpath, paths){
        for (var i in paths) {
            $('<img />').attr('src', rootpath + paths[i]);
        }
    };
    
    //显示loading
    LG.showLoading = function(message){
        message = message || "正在加载中...";
        $('body').append("<div class='jloading'>" + message + "</div>");
        $.ligerui.win.mask();
    };
    
    //隐藏loading
    LG.hideLoading = function(message){
        $('body > div.jloading').remove();
        $.ligerui.win.unmask({
            id: new Date().getTime()
        });
    };
    
    //显示成功提示窗口
    LG.showSuccess = function(message, callback){
        if (typeof(message) == "function" || arguments.length == 0) {
            callback = message;
            message = "操作成功!";
        }
        top.$.ligerDialog.success(message, '提示信息', callback);
    };
    
   //显示消息提示窗口
    LG.showConfirm = function(message, callback){
    	$.ligerDialog.confirm(message, function (yes) {
    		if(yes){
    			callback && callback();
    		}
        });
    };
    
    //弹出窗口
    LG.open = function (option){
    	return top.$.ligerDialog.open(option);
    };
 
    
    //显示失败提示窗口
    LG.showError = function(message, callback){
        if (typeof(message) == "function" || arguments.length == 0) {
            callback = message;
            message = "操作失败!";
        }
        top.$.ligerDialog.error(message, '提示信息', callback);
    };
    
    
    //预加载dialog的图片
    LG.prevDialogImage = function(rootPath){
        rootPath = rootPath || "/";
        LG.prevLoadImage(rootPath + 'lib/ligerUI/skins/Aqua/images/win/', ['dialog-icons.gif']);
        LG.prevLoadImage(rootPath + 'lib/ligerUI/skins/Gray/images/win/', ['dialogicon.gif']);
    };
    
    //提交服务器请求
    //返回json格式
    //1,提交给  方法 action 处理
    //2,并返回 AjaxResult(这也是一个类)类型的的序列化好的字符串
    LG.ajax = function(options){
        var p = options ||
        {};
        var ashxUrl = options.ashxUrl || "/AjaxPage/admin.ashx?";
        var url = p.url ||
        ashxUrl +
        $.param({
            action: p.action
        });
        $.ajax({
            cache: false,
            async: true,
            url: url,
            data: p.data,
            dataType: 'json',
            type: 'post',
            beforeSend: function(){
                LG.loading = true;
                if (p.beforeSend) 
                    p.beforeSend();
                else 
                    LG.showLoading(p.loading);
            },
            complete: function(){
                LG.loading = false;
                if (p.complete) 
                    p.complete();
                else 
                    LG.hideLoading();
            },
            success: function(result){
                if (!result) 
                    return;
                if (!result.IsError) {
                    if (p.success) 
                        p.success(result.Data, result.Message);
                }
                else {
                    if (p.error) 
                        p.error(result.Message);
                }
            },
            error: function(result, b){
                LG.tip('发现系统错误 <BR>错误码：' + result.status);
            }
        });
    };
    
    //获取当前页面的MenuNo
    //优先级1：如果页面存在MenuNo的表单元素，那么加载它的值
    //优先级2：加载QueryString，名字为MenuNo的值
    LG.getPageMenuNo = function(){
        var menuno = $("#MenuNo").val();
        if (!menuno) {
            menuno = getQueryStringByName("MenuNo");
        }
        return menuno;
    };
    
    //创建按钮
    LG.createButton = function(options){
        var p = $.extend({
            appendTo: $('body')
        }, options ||
        {});
        var btn = $('<div class="button button2 buttonnoicon" style="width:60px"><div class="button-l"> </div><div class="button-r"> </div> <span></span></div>');
        if (p.icon) {
            btn.removeClass("buttonnoicon");
            btn.append('<div class="button-icon"> <img src="../' + p.icon + '" /> </div> ');
        }
        //绿色皮肤
        if (p.green) {
            btn.removeClass("button2");
        }
        if (p.width) {
            btn.width(p.width);
        }
        if (p.click) {
            btn.click(p.click);
        }
        if (p.text) {
            $("span", btn).html(p.text);
        }
        if (typeof(p.appendTo) == "string") 
            p.appendTo = $(p.appendTo);
        btn.appendTo(p.appendTo);
    };
    
    /**
     格式化时间显示方式、用法:format="yyyy-MM-dd hh:mm:ss";
     */
    LG.formatDate = function(v, format){
        if (!v) 
            return "";
        var d = v;
        if (typeof v === 'string') {
            if (v.indexOf("/Date(") > -1) 
                d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
            else 
                d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
        }
        else 
            if (typeof v === 'number') {
                d = new Date(v);
            }
        var o = {
            "M+": d.getMonth() + 1, //month
            "d+": d.getDate(), //day
            "h+": d.getHours(), //hour
            "m+": d.getMinutes(), //minute
            "s+": d.getSeconds(), //second
            "q+": Math.floor((d.getMonth() + 3) / 3), //quarter
            "S": d.getMilliseconds() //millisecond
        };
        if (/(y+)/.test(format)) {
            format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
        }
        for (var k in o) {
            if (new RegExp("(" + k + ")").test(format)) {
                format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
            }
        }
        return format;
    };
    
    LG.formatLongDate = function(long,format){
    	if(!long){
    		return '';
    	}
    	var v = new Date(long);
    	 if (!v) 
             return "";
         var d = v;
         if (typeof v === 'string') {
             if (v.indexOf("/Date(") > -1) 
                 d = new Date(parseInt(v.replace("/Date(", "").replace(")/", ""), 10));
             else 
                 d = new Date(Date.parse(v.replace(/-/g, "/").replace("T", " ").split(".")[0]));//.split(".")[0] 用来处理出现毫秒的情况，截取掉.xxx，否则会出错
         }
         else 
             if (typeof v === 'number') {
                 d = new Date(v);
             }
         var o = {
             "M+": d.getMonth() + 1, //month
             "d+": d.getDate(), //day
             "h+": d.getHours(), //hour
             "m+": d.getMinutes(), //minute
             "s+": d.getSeconds(), //second
             "q+": Math.floor((d.getMonth() + 3) / 3), //quarter
             "S": d.getMilliseconds() //millisecond
         };
         if (/(y+)/.test(format)) {
             format = format.replace(RegExp.$1, (d.getFullYear() + "").substr(4 - RegExp.$1.length));
         }
         for (var k in o) {
             if (new RegExp("(" + k + ")").test(format)) {
                 format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
             }
         }
         return format;
    }
    
    //创建过滤规则(查询表单)
    LG.bulidFilterGroup = function(form){
        if (!form) 
            return null;
        var group = {
            op: "and",
            rules: []
        };
        $(":input", form).not(":submit, :reset, :image,:button, [disabled]").each(function(){
            if (!this.name) 
                return;
            if (!$(this).hasClass("field")) 
                return;
            if ($(this).val() == null || $(this).val() == "") 
                return;
            var ltype = $(this).attr("ltype");
            var optionsJSON = $(this).attr("ligerui"), options;
            if (optionsJSON) {
                options = JSON2.parse(optionsJSON);
            }
            var op = $(this).attr("op") || "like";
            //get the value type(number or date)
            var type = $(this).attr("vt") || "string";
            var value = $(this).val();
            var name = this.name;
            //如果是下拉框，那么读取下拉框关联的隐藏控件的值(ID值,常用与外表关联)
            if (ltype == "select" && options && options.valueFieldID) {
                value = $("#" + options.valueFieldID).val();
                name = options.valueFieldID;
            }
            group.rules.push({
                op: op,
                field: name,
                value: value,
                type: type
            });
        });
        return group;
    };
    
    //附加表单搜索按钮：搜索、高级搜索
    LG.appendSearchButtons = function(form, grid){
        if (!form) 
            return;
        form = $(form);
        //搜索按钮 附加到第一个li  高级搜索按钮附加到 第二个li
        var container = $('<ul><li style="margin-right:8px"></li><li></li></ul><div class="l-clear"></div>').appendTo(form);
        LG.addSearchButtons(form, grid, container.find("li:eq(0)"), container.find("li:eq(1)"));
        
    };
    
    //创建表单搜索按钮：搜索、高级搜索
    LG.addSearchButtons = function(form, grid, btn1Container, btn2Container){
        if (!form) 
            return;
        if (btn1Container) {
            LG.createButton({
                appendTo: btn1Container,
                text: '搜索',
                click: function(){
                    var rule = LG.bulidFilterGroup(form);
                    if (rule.rules.length) {
                        grid.set('parms', {
                            where: JSON2.stringify(rule)
                        });
                    }
                    else {
                        grid.set('parms', {});
                    }
                    grid.loadData();
                }
            });
        }
        if (btn2Container) {
            LG.createButton({
                appendTo: btn2Container,
                width: 80,
                text: '高级搜索',
                click: function(){
                    grid.showFilter();
                }
            });
        }
    };
    
    //快速设置表单底部默认的按钮:保存、取消
    LG.setFormDefaultBtn = function(cancleCallback, savedCallback){
        //表单底部按钮
        var buttons = [];
        if (cancleCallback) {
            buttons.push({
                text: '取消',
                onclick: cancleCallback
            });
        }
        if (savedCallback) {
            buttons.push({
                text: '保存',
                onclick: savedCallback
            });
        }
        LG.addFormButtons(buttons);
    };
    
    //增加表单底部按钮,比如：保存、取消
    LG.addFormButtons = function(buttons){
        if (!buttons) 
            return;
        var formbar = $("body > div.form-bar");
        if (formbar.length == 0) 
            formbar = $('<div class="form-bar"><div class="form-bar-inner"></div></div>').appendTo('body');
        if (!(buttons instanceof Array)) {
            buttons = [buttons];
        }
        $(buttons).each(function(i, o){
            var btn = $('<div class="l-dialog-btn"><div class="l-dialog-btn-l"></div><div class="l-dialog-btn-r"></div><div class="l-dialog-btn-inner"></div></div> ');
            $("div.l-dialog-btn-inner:first", btn).html(o.text || "BUTTON");
            if (o.onclick) {
                btn.bind('click', function(){
                    o.onclick(o);
                });
            }
            if (o.width) {
                btn.width(o.width);
            }
            $("> div:first", formbar).append(btn);
        });
    };
    
    //填充表单数据
    LG.loadForm = function(mainform, action, parms){
        var data = null;
        if (!mainform) 
            mainform = $("form:first");
        //ajax for params
        LG.myAjax(action, 'get', parms, function(rs){
            data = rs;
            mainform.setData(rs);
        }, false);
        return data;
    };
    
    //填充表单数据post
    LG.loadFormPost = function(mainform, action, parms){
        var data = null;
        if (!mainform) 
            mainform = $("form:first");
        //ajax for params
        LG.myAjax(action, 'post', parms, function(rs){
            data = rs;
            mainform.setData(rs);
        }, false);
        return data;
    };
    
    //带验证、带loading的提交
  //带验证、带loading的提交
    LG.submitForm = function(mainform, success, form){
        if (!mainform)
            mainform = $("form:first");
        if (form.valid()) {
           $.ajax({
                cache: false,
                async: true,
                url: mainform.attr("action"),
                data: form.getData(),
                dataType: 'json',
                type: form.getData().ajaxType || 'post',
                beforeSend: function(){
                    LG.loading = true;
                    LG.showLoading("正在提交......");
                },
                complete: function(){
                    LG.loading = false;
                    LG.hideLoading();
                },
                success: function(rs){
                	if(rs && rs.code<0){
                		LG.showError("提交失败:"+rs.message);
                		return ;
                	}
                    if (!success) {
                        LG.showSuccess("提交成功");
                    }
                    else {
                        LG.showSuccess("提交成功", success(rs));
                    }                
                },
                error: function(result, b){
                    LG.tip('发现系统错误 <BR>错误码：' + result.status);
                }
            });
        }
        else {
            form.showInvalid();
        }
        
        
        function existInFormData(formData, name){
            for (var i = 0, l = formData.length; i < l; i++) {
                var o = formData[i];
                if (o.name == name) 
                    return true;
            }
            return false;
        }
    };
    
    //新闻公告
    LG.submitJsonForm_dataFM = function(mainform, success, form, noticeStatus){
        if (!mainform) {
            mainform = $("form:first");
        }
        var data = form.getData();
        data.noticeStatus = noticeStatus;
        //        delete data.uploadify;
        console.log(form.getData());
        data = {
            fileList: data.fileList,
            noticeContent: data.noticeContent,
            noticeStatus: data.noticeStatus,
            noticeTitle: data.noticeTitle,
            userList: data.userList
        };
        
        if (form.valid()) {
            $.ajax({
                method: 'POST', //提交方式   application/json //application/x-www-form-urlencoded
                url: mainform.attr("action"), //提交的页面，方法名
                data: data, //参数，如果没有，可以为null
                success: function(data){ //如果执行成功，那么执行此方法
                    if (data.code && data.code >= 0) {
                        LG.showSuccess("保存成功");
                        dialog.close();
                    }
                    else 
                        if (data.code && data.code < 0) {
                            LG.showError("保存失败");
                        }
                        else {
                            LG.showSuccess("保存成功");
                            dialog.close();
                        }
                },
                error: function(err, b){ //如果执行不成功，那么执行此方法
                    LG.tip('发现系统错误 <BR>错误码：');
                }
            });
            
        }
        else {
            form.showInvalid();
        }
        
        
        function existInFormData(formData, name){
            for (var i = 0, l = formData.length; i < l; i++) {
                var o = formData[i];
                if (o.name == name) 
                    return true;
            }
            return false;
        }
    };
    
    //带验证、带loading的提交
    LG.submitJsonForm = function(mainform, success, form){
        if (!mainform) {
            mainform = $("form:first");
        }
        var data = form.getData();
        delete data.uploadify;
        console.log(form.getData());
        if (form.valid()) {
            console.log('submitJsonForm');
            $.ajax({
                cache: false,
                async: true,
                contentType: "application/json;charset=utf-8", //内容类型
                url: mainform.attr("action"),
                data: JSON.stringify(data),
                dataType: 'json',
                type: "POST",
                beforeSend: function(){
                    LG.loading = true;
                    LG.showLoading("正在提交......");
                },
                complete: function(){
                    LG.loading = false;
                    LG.hideLoading();
                },
                success: function(rs){
                    if (rs.code && rs.code >= 0) {
                        LG.showSuccess("保存成功");
                        success(rs);
                    }
                    else 
                        if (rs.code && rs.code < 0) {
                            LG.showError("保存失败");
                        }
                        else {
                            LG.showSuccess("保存成功");
                            success(rs);
                        }
                    //if(dialog){dialog.close();}
                },
                error: function(result, b){
                    LG.tip('发现系统错误 <BR>错误码：' + result.status);
                }
            });
            
        }
        else {
            form.showInvalid();
        }
        
        
        function existInFormData(formData, name){
            for (var i = 0, l = formData.length; i < l; i++) {
                var o = formData[i];
                if (o.name == name) 
                    return true;
            }
            return false;
        }
    };
    
    //带验证、带loading的提交
    LG.submitWWWForm = function(mainform, success, form){
        if (!mainform) {
            mainform = $("form:first");
        }
        var data = form.getData();
        delete data.uploadify;
        if (form.valid()) {
            $.ajax({
                cache: false,
                async: true,
                contentType: "application/x-www-form-urlencoded;charset=utf-8", //内容类型
                url: mainform.attr("action"),
                data: data,
                dataType: 'json',
                type: "POST",
                beforeSend: function(){
                    LG.loading = true;
                    LG.showLoading("正在提交......");
                },
                complete: function(){
                    LG.loading = false;
                    LG.hideLoading();
                },
                success: function(rs){
                		success();
                    if (rs.code && rs.code >= 0) {
                        LG.showSuccess("保存成功");
                    }
                    else 
                        if (rs.code && rs.code < 0) {
                            LG.showError("保存失败");
                        }
                        else {
                            LG.showSuccess("保存成功");
                        }
                },
                error: function(result, b){
                    LG.tip('发现系统错误 <BR>错误码：' + result.status);
                }
            });
            
        }
        else {
            form.showInvalid();
        }
        
        
        function existInFormData(formData, name){
            for (var i = 0, l = formData.length; i < l; i++) {
                var o = formData[i];
                if (o.name == name) 
                    return true;
            }
            return false;
        }
    };
    
    //提示 验证错误信息
    LG.showInvalid = function(validator){
        validator = validator || LG.validator;
        if (!validator) 
            return;
        var message = '<div class="invalid">存在' + validator.errorList.length + '个字段验证不通过，请检查!</div>';
        //top.LG.tip(message);
        $.ligerDialog.error(message);
    };
    
    //表单验证
    LG.validate = function(form, options){
    
        if (typeof(form) == "string") 
            form = $(form);
        else 
            if (typeof(form) == "object" && form.NodeType == 1) 
                form = $(form);
        
        options = $.extend({
            errorPlacement: function(lable, element){
                if (!element.attr("id")) 
                    element.attr("id", new Date().getTime());
                if (element.hasClass("l-textarea")) {
                    element.addClass("l-textarea-invalid");
                }
                else 
                    if (element.hasClass("l-text-field")) {
                        element.parent().addClass("l-text-invalid");
                    }
                $(element).removeAttr("title").ligerHideTip();
                $(element).attr("title", lable.html()).ligerTip({
                    distanceX: 5,
                    distanceY: -3,
                    auto: true
                });
            },
            success: function(lable){
                if (!lable.attr("for")) 
                    return;
                var element = $("#" + lable.attr("for"));
                
                if (element.hasClass("l-textarea")) {
                    element.removeClass("l-textarea-invalid");
                }
                else 
                    if (element.hasClass("l-text-field")) {
                        element.parent().removeClass("l-text-invalid");
                    }
                $(element).removeAttr("title").ligerHideTip();
            }
        }, options ||
        {});
        LG.validator = form.validate(options);
        return LG.validator;
    };
    
    //加载工具条
    LG.loadToolbar = function(grid){
        var menuno = LG.getPageMenuNo();
        var toobar = null;
        $.ajax({
            cache: false,
            async: false,
            url: '/handler/sys.ashx?action=loadToolbar',
            data: {
                pid: menuno,
                grid: grid
            },
            timeout: 600000,
            dataType: 'text',
            type: 'post',
            success: function(d){
                var rs = eval('(' + d + ')');
                if (rs && rs.IsError == "False") {
                    if (rs.Data && rs.Data.length > 0) {
                        toobar = {
                            items: rs.Data
                        };
                    }
                }
                else {
                    if (rs) {
                        if (rs.Message == "unlogon") {
                            LG.showError("登录信息已经过期，请重新登录！", function(){
                                window.top.location.href = "/login.htm";
                            });
                        }
                        else {
                            LG.showError(rs.Message);
                        }
                    }
                }
            },
            error: function(result, b){
            	if(result.status>0){
            		LG.showError('发现系统错误 <BR>错误码：' + result.status);
            	}
            }
        });
        return toobar;
    };
    
    //关闭Tab项,如果tabid不指定，那么关闭当前显示的
    LG.closeCurrentTab = function(tabid){
        if (!tabid) {
            tabid = $("#framecenter > .l-tab-content > .l-tab-content-item:visible").attr("tabid");
        }
        if (tab) {
            tab.removeTabItem(tabid);
        }
    };
    
    //关闭Tab项并且刷新父窗口
    LG.closeAndReloadParent = function(tabid, parentMenuNo){
        LG.closeCurrentTab(tabid);
        var menuitem = $("#mainmenu ul.menulist li[menuno=" + parentMenuNo + "]");
        var parentTabid = menuitem.attr("tabid");
        var iframe = window.frames[parentTabid];
        if (tab) {
            tab.selectTabItem(parentTabid);
        }
        if (iframe && iframe.f_reload) {
            iframe.f_reload();
        }
        else 
            if (tab) {
                tab.reload(parentTabid);
            }
    };
    
    //覆盖页面grid的loading效果
    LG.overrideGridLoading = function(){
        $.extend($.ligerDefaults.Grid, {
            onloading: function(){
                LG.showLoading('正在加载表格数据中...');
            },
            onloaded: function(){
                LG.hideLoading();
            }
        });
    };
    
    //根据字段权限调整 页面配置
    LG.adujestConfig = function(config, forbidFields){
        if (config.Form && config.Form.fields) {
            for (var i = config.Form.fields.length - 1; i >= 0; i--) {
                var field = config.Form.fields[i];
                if ($.inArray(field.name, forbidFields) != -1) 
                    config.Form.fields.splice(i, 1);
            }
        }
        if (config.Grid && config.Grid.columns) {
            for (var i = config.Grid.columns.length - 1; i >= 0; i--) {
                var column = config.Grid.columns[i];
                if ($.inArray(column.name, forbidFields) != -1) 
                    config.Grid.columns.splice(i, 1);
            }
        }
        if (config.Search && config.Search.fields) {
            for (var i = config.Search.fields.length - 1; i >= 0; i--) {
                var field = config.Search.fields[i];
                if ($.inArray(field.name, forbidFields) != -1) 
                    config.Search.fields.splice(i, 1);
            }
        }
    };
    
    //查找是否存在某一个按钮
    LG.findToolbarItem = function(grid, itemID){
        if (!grid.toolbarManager) 
            return null;
        if (!grid.toolbarManager.options.items) 
            return null;
        var items = grid.toolbarManager.options.items;
        for (var i = 0, l = items.length; i < l; i++) {
            if (items[i].id == itemID) 
                return items[i];
        }
        return null;
    };
    
    //设置grid的双击事件(带权限控制)
    LG.setGridDoubleClick = function(grid, btnID, btnItemClick){
        btnItemClick = btnItemClick || toolbarBtnItemClick;
        if (!btnItemClick) 
            return;
        grid.bind('dblClickRow', function(rowdata){
            var item = LG.findToolbarItem(grid, btnID);
            if (!item) 
                return;
            grid.select(rowdata);
            btnItemClick(item);
        });
    };
    
    //自定义异步方法
    LG.myAjax = function(action, type, data, success, async){
        var url = action;
        var asy = async;
        var type = type || 'post';
        $.ajax({
            cache: false,
            async: asy,
            url: url,
            data: data,
            timeout: 600000,
            dataType: 'json',
            type: type,
            success: function(rs){
                if (!success) 
                    return;
                success && success(rs);
            },
            error: function(result, b){
            	if(result.status>0){
            		LG.showError('发现系统错误 <BR>错误码：' + result.status);
            	}
            }
        });
    };
    
    LG.myAjax2 = function(action, type, data, successv, async){
        var url = action;
        var asy = async;
        var type = type || 'post';
        $.ajax({
            cache: false,
            async: asy,
            url: url,
            data: data,
            timeout: 600000,
            type: type,
            success: function(rs){
                console.log(rs);
                successv(rs);
            },
            error: function(result, b){
            	if(result.status>0){
            		LG.showError('发现系统错误 <BR>错误码：' + result.status);
            	}
            }
        });
    };
    LG.myAjax3 = function(action, type, data, successv, async){
        var url = action;
        var asy = async;
        var type = type || 'post';
        $.ajax({
            contentType: "application/json; charset=utf-8",
            cache: false,
            async: asy,
            url: url,
            data: JSON.stringify(data),
            dataType: 'json',
            timeout: 600000,
            type: type,
            success: function(rs){
                if (!successv) {
                    return;
                }
                successv(rs);
            },
            error: function(result, b){
            	if(result.status>0){
            		LG.showError('发现系统错误 <BR>错误码：' + result.status);
            	}
            }
        });
    };
    //根据字典值获取字典文本数据
    LG.GetDataDicName = function(items, obj){
        if (obj) {
            var result = "";
            $.each(items, function(i, item){
                var ov = obj.toString();
                //存储多个处理方法
                if (ov.indexOf(";") != -1) {
                    var or = new Array();
                    or = ov.split(';');
                    for (i = 0; i < or.length; i++) {
                        if (item.id == or[i]) {
                            result += item.text + ";";
                        }
                    }
                }
                else {
                    if (item.id == ov) 
                        result = item.text;
                }
            });
            return result;
        }
    };
    
    //根据userid取得realname
    LG.getRealName = function(obj){
        if (obj) {
            var result = "";
            if (obj.toString().indexOf(';') > -1) {
                $.each(obj.split(';'), function(j, item1){
                    if (item1) {
                        $.each(top.userarray, function(i, item){
                            if (item.uid == item1) {
                                result += item.rname + ';';
                                return false;
                            }
                        });
                    }
                });
                if (result.length > 0) {
                    result.substr(0, result.length - 1);
                }
            }
            else {
                if (obj) {
                    $.each(top.userarray, function(i, item){
                        if (item.uid == obj) {
                            result = item.rname;
                            return false;
                        }
                    });
                }
            }
            return result;
        }
    };
    
    
    LG.InitUpload = function(mainform, fieldname, data, type){
        //照片上传()
        $("#uploadify", mainform).uploadify({
            height: 22,
            width: 80,
            formData: data,
            swf: '/lib/uploadify/uploadify.swf',
            uploader: '/handler/uploadify.ashx',
            buttonText: "上传",
            onInit: function(){
                $("#uploadify-queue", mainform).hide();
            },
            onUploadSuccess: function(file, data, response){
                var rs = eval('(' + data + ')');
                if (rs.IsError == "False") {
                    if ($('.uploadimg', mainform)[0]) {
                        $('.uploadimg', mainform)[0].remove();
                    }
                    //   $('#uploadify').after("<div class='uploadimg' style='height:40px;position:relative'><img height='40px' src='" + rs.Message + "'/><div class='close' style='cursor:pointer;position:absolute;top:0;left:0;line-height:10px;text-align:center;border:1px solid gray;background-color:#fff;height:10px;width:10px' onclick=LG.DeleteUploadFile('"+fieldname+"',this,'"+type+"')>x</div></div>");
                    $('#uploadify', mainform).after("<div class='uploadimg' style='clear:both'><div style='float:left'>" + rs.Message + "</div> <div class='l-icon-delete' style='float:right;cursor: pointer;' title='删除'  onclick=LG.DeleteUploadFile('" + $(mainform).attr('id') + "','" + fieldname + "',this,'" + type + "')>&nbsp;&nbsp;&nbsp;&nbsp;</div></div>");
                    $('#' + fieldname, mainform).val(rs.Message);
                    
                }
                else {
                    LG.showError(rs.Message, null);
                }
            }
        });
    };
    
    
    
    
    
    //删除附件
    LG.DeleteUploadFile = function(formid, fieldname, obj, type){
        var mainform = $('#' + formid);
        $.ligerDialog.confirm('附件删除后不能恢复，确定要删除吗？', function(yes){
            if (yes) {
                LG.myAjax('/handler/sys.ashx?Action=deletefile', 'get', {
                    path: $('#' + fieldname, mainform).val()
                }, function(rs){
                }, true);
                $(obj, mainform).parent().remove();
                $('#' + fieldname, mainform).val('');
            }
        });
    };
    
    
    //文件上传 多个
    LG.InitUploadFiles = function(mainform, fieldname, data, type){
        var s = getSessionId();
        $("#uploadify", mainform).uploadify({
            height: 22,
            width: 80,
            formData: data,
            swf: '/resources/script/uploadify/uploadify.swf',
            uploader: '/document/upload;jsessionid=' + s,
            buttonText: "上传",
            onInit: function(){
                $("#uploadify-queue", mainform).hide();
            },
            onUploadSuccess: function(file, data, response){            	
                var rs = eval('(' + data + ')');
                
                //  if (rs.IsError == "False") {
                //   $('#uploadify').after("<div class='uploadimg' style='height:40px;position:relative'><img height='40px' src='" + rs.Message + "'/><div class='close' style='cursor:pointer;position:absolute;top:0;left:0;line-height:10px;text-align:center;border:1px solid gray;background-color:#fff;height:10px;width:10px' onclick=LG.DeleteUploadFile('"+fieldname+"',this,'"+type+"')>x</div></div>");
                $('#uploadify', mainform).after("<div class='uploadimg' style='clear:both'><div id='file" + rs.id + "' class='filename' style='float:left'><a href='/document/" + rs.id + "'>" + rs.actualName + rs.suffixName + "</a></div> <div class='l-icon-delete' style='float:right;cursor: pointer;' title='删除'  onclick=LG.DeleteUploadFiles('" + $(mainform).attr('id') + "','" + fieldname + "','" + rs.id + "','" + type + "')>&nbsp;&nbsp;&nbsp;&nbsp;</div></div>");
                var ids = $('#' + fieldname, mainform).val();
                if (ids != "") {
                    ids += ",";
                }
                ids += rs.id;
                $('#' + fieldname, mainform).val(ids);
                
                // } else {
                //     LG.showError(rs.Message, null);
                // }
            },
            onError: function(event, queueId, fileObj, errorObj){
                LG.showError(event + ',' + queueId + ',' + fileObj + ',' + errorObj);
                
            }
        });
    };
    //文件删除 多个
    LG.DeleteUploadFiles = function(formid, fieldname, id, type){
        var mainform = $('#' + formid);
        $.ligerDialog.confirm('附件删除后不能恢复，确定要删除吗？', function(yes){
            if (yes) {
                LG.myAjax('/document/delete/' + id, 'post', {}, function(rs){
                }, true);
                $('#file' + id, mainform).parent().remove();
                var ids = $('#' + fieldname, mainform).val();
                var idarray = ids.split(';');
                var newids = '';
                for (var i = 0; i < idarray.length; i++) {
                    if (idarray[i] != id) {
                        newids += idarray[i] + ";";
                    }
                }
                if (idarray.length > 0) {
                    newids = newids.substring(0, newids.length - 1);
                }
                $('#' + fieldname, mainform).val(newids);
                
            }
        });
    };
    
    LG.GetDataDic = function(name){
        if (dataArray[name] && dataArray[name].length > 0) {
            return dataArray[name];
        }
        else {
            LG.myAjax("/handler/sys.ashx?Action=GetDataDics", 'get', {
                TypeName: name
            }, function(rs){
                if (rs.IsError == "False") {
                    dataArray.push({
                        name: rs.Data
                    });
                    return rs.Data;
                }
                else {
                    LG.showError(rs.Message);
                }
            }, false);
        }
    };
    
    function getSessionId(){
        var c_name = 'JSESSIONID';
        if (document.cookie.length > 0) {
            c_start = document.cookie.indexOf(c_name + "=")
            if (c_start != -1) {
                c_start = c_start + c_name.length + 1
                c_end = document.cookie.indexOf(";", c_start)
                if (c_end == -1) 
                    c_end = document.cookie.length
                return unescape(document.cookie.substring(c_start, c_end));
            }
        }
    }
    
    
    //表格照片预览
    $(document).on("mousemove",".myImg",function(event){
		var _this = this;
		if($("div[id='imgDiv']").length>0){
			return ;
		}
		var node = document.getElementsByTagName("body")[0];
        //创建
        var NewDiv = document.createElement("div");
        NewDiv.id="imgDiv";
        //对div设置定位  
        NewDiv.style.position = "absolute";
        //NewDiv.style.left = event.clientX;
        //NewDiv.style.top = event.clientY;
        NewDiv.style.left = event.clientX +'px';
        NewDiv.style.top = event.clientY +'px';
        NewDiv.style.width = '90px';
        NewDiv.style.height='110px';
        NewDiv.style.z_index=999;
        //创建div内加入的内容
        var Newimg = document.createElement("img");
        //对图片设置路径和img的id
        Newimg.src = $(_this).attr("src");
        Newimg.style.width = '100%';
       // Newimg.style.height = '100%';
        //追加一个新的子结点
        NewDiv.appendChild(Newimg);
        //追加一个新的结点
        node.appendChild(NewDiv);
	}); 
	$(document).on("mouseout",".myImg",function(){
		$("#imgDiv").remove();
	});
    
})(jQuery);
