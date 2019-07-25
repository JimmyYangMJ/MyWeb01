package com.sspu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 第三种实现Servlet方法，工作中常 用的..
 *
 * Servlet【接口】
 * GenericServlet【是Servlet实现类】
 * HttpServlet 【是GenericServlet的子类】
 * HelloServlet 【是HttpServlet的子类】
 */
// @WebServlet("/Servlet/HttpServletTest")  // 可以不用在 xml写 servlet的映射
public class HttpServletTest extends HttpServlet {
    private int money = 100;
    /**
     * doGet请求
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** 防止乱码*/
        response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
        System.out.println("响应服务Service...");
        //返回结果给客户端-----
        response.getWriter().write("hello Servlet 明");
        System.out.println(this);
        System.out.println(Thread.currentThread());
    }

    /**
     * doPost请求
     * @param request
     * @param response
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
