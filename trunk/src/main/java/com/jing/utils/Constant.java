package com.jing.utils;

/**
* @ClassName: Constants  
* @Description: 常量定义  
* @author li chao
* @date 2015年9月10日 上午9:51:45 
* @version V1.0
*    
 */
public class Constant {
	//分页常量
    public static final String PAGELIST = "data"; //分页数据集合
    public static final String PAGINATOR = "page"; //分页配置器
    public static final String PAGE = "page"; //分页信息
    
    //sessionid
    public static final String USER_PERMISSIONS="user:permissions:";
    public static final String SESSIONID="sessionid";
    public static final String USERID="user_id";
    public static final String APPNAME="app_name";
    
    //返回状态
    public static final String HTTP_CODE="httpcode";
    public static final int HTTP_SUSESS=200;
    public static final int HTTP_SERVERERROR=500;        
    public static final int HTTP_BADREQUEST=400;
    public static final int HTTP_NOTLOGIN=401;
    public static final int HTTP_NOTPERMISSION=403;
    public static final int HTTP_NOTFOUND=404;
    
    public static final String PRODUCTTYPE_SINGLE="single";
    public static final String PRODUCTTYPE_GROUP="group";
}
