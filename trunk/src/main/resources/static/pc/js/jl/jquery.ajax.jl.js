/**
 * 数据交互
 * @param action 地址
 * @param type 类型 get\post\put\delete
 * @param data 数据对象
 * @param success 成功返回函数
 * @param async 是否异步 默认true  false同步卡住等待
 * @returns
 */
function myAjax(action, type, data, success, async){
        var url = '/mys'+action;
        var asy = async || true;
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
                if (!success) {
                	return;
                }                    
                success(rs);
            },
            error: function(xhr, textStatus, errorThrown){             	
            	parent.jsprints(data.message);
                console.log('发现系统错误 <BR>错误码：'+xhr.status + xhr.responseText);
            }
        });
    };

/**
 * JSON数据交互
 * @param action 地址
 * @param type 类型 get\post\put\delete
 * @param data 数据对象
 * @param success 成功返回函数
 * @param async 是否异步 默认true  false同步卡住等待
 * @returns
 */
function myAjaxJson(action, type, data, success, async){
        var url = '/mys'+action;
        var asy = async;
        var type = type || 'post';
        $.ajax({
            cache: false,
            async: asy,
            contentType : "application/json;charset=utf-8", //内容类型
            url: url,
            data: JSON.stringify(data),
            timeout: 600000,
            dataType: 'json',
            type: type,
            success: function(rs){
                if (!success) {
                	return;
                }                    
                success(rs);
            },
            error: function(xhr, textStatus, errorThrown){             	
            	parent.jsprints(data.message);
                console.log('发现系统错误 <BR>错误码：'+xhr.status + xhr.responseText);
            }
        });
    };
    
/**
 * 跨域请求
 * @param action
 * @param type
 * @param data
 * @param success
 * @param async
 * @returns
 */    
function myAjaxp(action, type, data, success, async){
        var url = action;
        var asy = async;
        $.ajax({
            cache: false,
            async: asy,
            url: "http://127.0.0.1:8080"+url,
            data: data,
            timeout: 600000,
            dataType: 'jsonp',
            jsonp:'callback',  
            jsonpCallback:"callback",
            type: 'get',
            success: function(rs){
                if (!success) {
                	return;
                }                    
                success(rs);
            },
            error: function(result, b){
                console.log('发现系统错误 <BR>错误码：' + result.status);
            }
        });
    };
