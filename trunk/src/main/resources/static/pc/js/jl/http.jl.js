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
	if ('yyyy-MM-dd' == format) {
		return bd.getFullYear() + "-" + (bd.getMonth() + 1) + "-"
				+ bd.getDate();
	} else if ('yyyy-MM-dd hh:mm:ss' == format) {
		return bd.getFullYear() + "-" + (bd.getMonth() + 1) + "-"
				+ bd.getDate() + " " + bd.getHours() + ":" + bd.getMinutes()
				+ ":" + bd.getSeconds();
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
 * @param obj  var url = window.location;
 */
function setHomejl(obj){
	var url = window.location;
    try{
            obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl);
    }
    catch(e){
            if(window.netscape) {
                    try {
                            netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect");
                    }
                    catch (e) {
                            alert("此操作被浏览器拒绝！\n请在浏览器地址栏输入“about:config”并回车\n然后将 [signed.applets.codebase_principal_support]的值设置为'true',双击即可。");
                    }
                    if(Components.classes!=undefined){
                    	var prefs = Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);
                    	prefs.setCharPref('browser.startup.homepage',vrl);
                    }
             }
    }
}

/**
 * 获取QueryString的数组
 */
function getQueryString() {
	var result = location.search.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]+",
			"g"));
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
 * @param furl
 */
function getPageNameFromUrl(furl){
	if(furl==undefined || furl.length==0){
		return "";
	}
	var u = furl.split("/");
	return u[u.length-1];
}
/**
 * 获取参数
 * @param furl
 * @returns
 */
function getParamFromUrl(furl){
	if (!strIsNullZero(furl) && furl.indexOf("?") != -1) {
		return furl.substr(furl.indexOf("?")+1);//去掉?号	
	}
	return furl;
}

function getParamUrlAddTimt(url){    
    var timestamp = (new Date()).valueOf();  
    if((url.indexOf("&")>=0)){    
    	url = url + "&timestamp=" + timestamp;    
    }else{    
    	url = url + "?timestamp=" + timestamp;    
    }    
    return url;    
}   
/**
 * 添加参数
 * @param iurl 原
 * @param prms 参数串，支持多个参数
 */
function addParamToUrl(iurl, prms){
	
}

function strIsNullZero(str){
	if(str==undefined || str==null || str.length==0){
		return true;
	}
	return false;
}

/**
 * 去掉HTML代码中的标签
 * 
 */
function getStringByHtml(htmlstr){
	if(htmlstr!=undefined && htmlstr!=null){
		return htmlstr.replace(/<[^>]+>/g,"");
	}
	return "";
}

/**
 * 截取字符串，超过长度时最后三位用...代替
 * @param str 字符
 * @param fi 起点
 * @param ti 终点
 */
function subStringjl(str, fi, ti){
	if(str==undefined){
		return "";
	}
	if(fi>ti){
		var i=ti;
		ti=fi;
		fi=i;
	}
	if(str.length>ti && str.length>5){
		return str.substring(fi,ti-3)+"...";
	}else{
		return str.substring(fi,ti);
	}	
}

//测试请求是手机端还是PC端
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
	    if (bIsIpad || bIsIphoneOs || bIsMidp || bIsUc7 || bIsUc || bIsAndroid || bIsCE || bIsWM ){
	        return true;
	    }
	    return false;
}


