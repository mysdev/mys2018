package com.jing.utils.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author yinde
 * 校验只允许数字+大写字母
 *
 */
@Constraint(validatedBy = IntAndUpperValidator.class) //具体的实现  
@Target( { java.lang.annotation.ElementType.METHOD,  
   java.lang.annotation.ElementType.FIELD })  
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)  
@Documented  
public @interface IntAndUpper {  
   String message() default "{validator.number.upper.message}"; 
     
   CaseMode value();
     
   //下面这两个属性必须添加  
   Class<?>[] groups() default {};  
   Class<? extends Payload>[] payload() default {};  
     
} 