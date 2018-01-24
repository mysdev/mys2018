/**
 * 座机号限7位长度
 * 手机号限11位 13、15、17、18开头
 *
 */
function LsPhoneNoValidate(phonenum) {
    phonenum = phonenum.replace(/ /g, "");   
    if (phonenum.length < 7) {   
        return false;   
    } else if (phonenum.length == 11) {   
        return isPhoneNoValidate11(phonenum);
    } else {   
        return false;   
    }   
}   

/**
 * 手机号码验证
 * @param phonenum
 * @returns
 */
function isPhoneNoValidate11(phonenum){	
	return (/^1[3|5|7|8][0-9]\d{4,8}$/.test(phonenum));
}
/**
 * 邮箱格式验证
 * @param emailnum
 * @returns
 */
function isEmailValidate(emailnum){
	return (/^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/.test(emailnum));
}