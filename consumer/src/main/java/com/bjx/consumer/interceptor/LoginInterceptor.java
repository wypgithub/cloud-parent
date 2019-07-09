package com.bjx.consumer.interceptor;

import com.bjx.consumer.bean.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Block all requests and authenticate
 */
public class LoginInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        Object currentUser = request.getSession().getAttribute(Constant.CURRENT_USER);

        if(currentUser == null){
            //判断是否为ajax请求，默认不是
            boolean isAjaxRequest = false;
            if(request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
                response.getWriter().write("notLogin");
            }else {
                response.sendRedirect("/loginPage");
            }
            return false;
        }
        return true;
    }

}
