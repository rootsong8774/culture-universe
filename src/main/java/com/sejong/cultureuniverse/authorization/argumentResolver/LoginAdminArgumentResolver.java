package com.sejong.cultureuniverse.authorization.argumentResolver;

import com.sejong.cultureuniverse.SessionConst;
import com.sejong.cultureuniverse.entity.admin.Admin;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class LoginAdminArgumentResolver implements HandlerMethodArgumentResolver {
    
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        
        boolean hasParameterAnnotation = parameter.hasParameterAnnotation(Login.class);
        boolean hasAdminType = Admin.class.isAssignableFrom(parameter.getParameterType());
        
        return hasAdminType && hasParameterAnnotation;
    }
    
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
        NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
    
        HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
        HttpSession session = request.getSession(false);
    
        if (session == null) {
            return null;
        }
    
        return session.getAttribute(SessionConst.LOGIN_ADMIN);
    }
    
}
