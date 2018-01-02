package com.jing.utils.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IntAndUpperValidator implements ConstraintValidator<IntAndUpper, String> {  
	 private CaseMode caseMode;
	 
    @Override  
    public void initialize(IntAndUpper arg0) {  
        this.caseMode = arg0.value();
    }  
  
    @Override  
    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {  
    	 if (str == null){
             return true;
    	 }
    	 
    	 String regEx="";
    	if(caseMode == CaseMode.INTANDUPPER){
    		regEx = "^[A-Z0-9]+$";
    	}else if(caseMode == CaseMode.INT){
    		regEx = "^[0-9]+$";
    	}
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(str);
        boolean rs = matcher.matches();
        return rs;  
    }  
  
}  
