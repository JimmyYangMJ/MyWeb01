package com.sspu.servlet;

import javax.servlet.*;
import java.io.IOException;

/**
 * 第一种 （少用）
 * Servlet 接口
 * <br>执行方法的顺序如下所示<br/>
 * @author YMj
 * @date 20190724
 */
public class ServletTest implements Servlet {

    public ServletTest(){
        System.out.println("Servlet构造函数");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("初始化Servlet");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 服务，做出响应，每次访问都会调用 service 方法
     * @param servletRequest
     * @param servletResponse 回应给客户端 B
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        /** 防止乱码*/
        servletResponse.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
        System.out.println("响应服务Service...");
        //返回结果给客户端-----
        servletResponse.getWriter().write("hello Servlet 杨明杰");
    }

    /**
     * @return Servlet 的信息
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("执行了destroy");
    }
}
