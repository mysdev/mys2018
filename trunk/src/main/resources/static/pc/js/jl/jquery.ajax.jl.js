function myAjax(action, type, data, success, async){
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
                if (!success) {
                	return;
                }                    
                success(rs);
            },
            error: function(result, b){
                //console.log('发现系统错误 <BR>错误码：' + result.status);
            }
        });
    };
    
function myAjaxp(action, type, data, success, async){
        var url = action;
        var asy = async;
        $.ajax({
            cache: false,
            async: asy,
            url: "http://172.16.2.11"+url,
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
                //console.log('发现系统错误 <BR>错误码：' + result.status);
            }
        });
    };
