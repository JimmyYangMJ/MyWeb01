package com.sspu.servlet.responsetest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/responsetest/Test01")
public class Test extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("666");
        //案例：自动刷新到另一个html页面
        //设置响应内容类型和编码
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        //设置刷新响应头
        response.setHeader("Refresh", "1");//每隔一秒刷新一次
        response.setHeader("Refresh", "15;URL=index.html");//5秒后转到另一页面

        //自动刷新
        response.getWriter().write("登录成功,5秒后会自动进入index.html页面");
    }
}
