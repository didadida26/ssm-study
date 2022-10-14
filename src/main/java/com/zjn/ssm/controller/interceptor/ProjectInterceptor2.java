package com.zjn.ssm.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component //注意当前类必须受Spring容器控制
// 拦截器的运行顺序按照添加的顺序
// 第二个拦截器 preHandle1 -> preHandle2 -> postHandle2 -> postHandle1 -> afterCompletion2 -> afterCompletion1
public class ProjectInterceptor2 implements HandlerInterceptor {
    //原始方法调用前执行的内容
    //返回值类型可以拦截控制的执行，true放行，false终止
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle...222");
        return true;
    }

    // 方法调用后
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle...222");
    }

    // 方法执行完
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion...222");
    }
}
