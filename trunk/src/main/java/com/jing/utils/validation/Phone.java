package com.jing.utils.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author yinde
 * 校验电话号码
 *
 */
@Constraint(validatedBy = PhoneValidator.class) //具体的实现  
@Target( { java.lang.annotation.ElementType.METHOD,  
   java.lang.annotation.ElementType.FIELD })  
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)  
@Documented  
public @interface Phone {  
   String message() default "{validator.error.message}"; 
   //下面这两个属性必须添加  
   Class<?>[] groups() default {};  
   Class<? extends Payload>[] payload() default {};  
     
} 