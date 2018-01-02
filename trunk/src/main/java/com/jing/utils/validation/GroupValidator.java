package com.jing.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class GroupValidator implements ConstraintValidator<Group, String> {  
    private int num;  
    /** 
     * 初始参数,获取注解中num的值 
     */  
    @Override  
    public void initialize(Group arg0) {  
        this.num = arg0.num();  
    }  
  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
    	String regEx = "^([^,]+,){0,"+(num-1)+"}[^,]+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean rs = matcher.matches();
        return rs;  
    }  
  
}  
