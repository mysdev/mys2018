package com.jing.utils.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
/**
 * 
 * 校验小数点位数
 *
 */
@Constraint(validatedBy = DigitsSizeValidator.class) //具体的实现  
@Target( { METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })  
@Retention(RUNTIME)
@Documented  
public @interface DigitsSize {  
   String message() default "{validator.DigitsSize.message}"; 
     
   int num() default 8;  
     
   //下面这两个属性必须添加  
   Class<?>[] groups() default {};  
   Class<? extends Payload>[] payload() default {};  
     
} 