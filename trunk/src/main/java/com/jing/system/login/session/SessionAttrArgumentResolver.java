package com.jing.system.login.session;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.BeanUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class SessionAttrArgumentResolver implements HandlerMethodArgumentResolver {

    protected Object resolveNewInstance(Class<?> clazz) throws Exception {
        if (clazz.isInterface()) {
            if (clazz.isAssignableFrom(ArrayList.class)) {
                return new ArrayList<Object>();
            } else if (clazz.isAssignableFrom(HashMap.class)) {
                return new HashMap<Object, Object>();
            } else {
                throw new RuntimeException("Class[" + clazz.getName() + "]is a interface,can't instantiate. ");
            }
        } else {
            return BeanUtils.instantiate(clazz);
        }
    }

    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        SessionAttr annotation = methodParameter.getParameterAnnotation(SessionAttr.class);
        if (annotation != null) {
            String key = annotation.value();
            key = key.trim();
            if (key.length() == 0) {
                throw new RuntimeException("Method[" + methodParameter.getMethod().getDeclaringClass().getName() + "."
                        + methodParameter.getMethod().getName() + "]Annotation[" + SessionAttr.class.getName()
                        + "]Not setter [value].");
            }
            Object obj = webRequest.getAttribute(key, NativeWebRequest.SCOPE_SESSION);
            if (obj == null) {
                if (annotation.newable()) {
                    obj = resolveNewInstance(methodParameter.getParameterType());
                    webRequest.setAttribute(key, obj, NativeWebRequest.SCOPE_SESSION);
                } else {
                    if (annotation.required()) {
                        throw new SessionAttrNotFoundException(key);
                    } else {
                        return null;
                    }
                }
            }
            webRequest.setAttribute(key, obj, NativeWebRequest.SCOPE_REQUEST);
            return obj;
        }
        return new Object();
    }

    public boolean supportsParameter(MethodParameter parameter) {
        SessionAttr annotation = parameter.getParameterAnnotation(SessionAttr.class);
        if (annotation != null) {
            return true;
        }else{
            return false;
        }
    }

}
