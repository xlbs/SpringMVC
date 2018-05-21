package com.springmvc.spring;

import com.springmvc.controller.ViewControllerTest;
import com.springmvc.utils.JSONUtils;
import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInteceptor implements HandlerInterceptor {

    private Logger log = Logger.getLogger(MyInteceptor.class);

    /**
     * 在请求处理之前进行调用
     * 每个Interceptor的调用会依据它的声明顺序依次执行preHandle方法(与postHandle刚好相反)
     * 当它返回为false时，表示请求结束，后续的Interceptor和Controller都不会再执行；
     * 当返回值为true 时就会继续调用下一个Interceptor的preHandle方法，如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("request: "+ httpServletRequest.getRequestURL());
        return true;
    }

    /**
     * 当前对应的Interceptor的preHandle方法的返回值为true时才会执行
     * 在当前请求进行处理之后，进行视图返回渲染之前调用
     * 先声明的Interceptor的postHandle方法后执行(与preHandle刚好相反)
     * 该方法主要用于对Controller处理之后的ModelAndView对象进行操作
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 当前对应的Interceptor的preHandle方法的返回值为true时才会执行
     * 在整个请求结束之后,对应的视图之后执行
     * 该方法的主要作用是用于进行资源清理工作的。
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
