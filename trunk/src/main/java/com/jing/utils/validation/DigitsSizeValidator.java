package com.jing.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DigitsSizeValidator implements ConstraintValidator<DigitsSize, Object> {  
    private int num;  
    /** 
     * 初始参数,获取注解中num的值 
     */  
    @Override  
    public void initialize(DigitsSize arg0) {  
        this.num = arg0.num();  
    }  
  
    @Override  
    public boolean isValid(Object str, ConstraintValidatorContext constraintValidatorContext) {  
    	String regEx = "^(-)?\\d+(\\.\\d{1,"+num+"})?$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str.toString());
        boolean rs = matcher.matches();
        return rs;  
    }  
  
}  
