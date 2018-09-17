package com.jing.system.login.session;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class UidArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer mavContainer,
            NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Uid annotation = methodParameter.getParameterAnnotation(Uid.class);
        if (annotation != null) {
            String uid = webRequest.getRemoteUser();
            if (uid != null) {
                webRequest.setAttribute("uid", uid, NativeWebRequest.SCOPE_REQUEST);
            }
            if (uid == null && annotation.value()) {
                throw new NotLoginedException();
            }
            return uid;
        }
        return new Object();
    }

    public boolean supportsParameter(MethodParameter parameter) {
        Uid annotation = parameter.getParameterAnnotation(Uid.class);
        if (annotation != null) {
            return true;
        }else{
            return false;
        }
    }

}
