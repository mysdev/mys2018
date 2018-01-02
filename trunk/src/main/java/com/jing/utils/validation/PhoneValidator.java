package com.jing.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {  
    
	@Override  
    public void initialize(Phone arg0) {  
    }  
  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
    	String regEx = "^(((13[0-9])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8})|(0\\d{2}-\\d{8})|(0\\d{3}-\\d{7})$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean rs = matcher.matches();
        return rs;  
    }  
  
}  
