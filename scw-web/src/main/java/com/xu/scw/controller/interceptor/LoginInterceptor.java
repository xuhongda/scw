package com.xu.scw.controller.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static com.xu.scw.pojo.Constants.USER_NAME;

/**
 * @author xuhongda on 2017/11/25
 * com.xu.scw.controller.interceptor
 * scw-parent
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if (session.getAttribute(USER_NAME)!=null){
            return true;
        }
        request.setAttribute("msg","请先登陆哦😋");
        // response.sendRedirect(request.getContextPath()+"/login.html");
        request.getRequestDispatcher("/login.html").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
