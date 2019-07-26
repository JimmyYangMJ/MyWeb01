package com.sspu.servlet.dispatcher.dispatcherAndRedirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/dispatcherAndRedirect/IncludeServlet")
public class IncludeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        /**
         * include()、forward()、sendRedirect()的区别【面试题】
         *
         * 1.sendRedirect是请求重定向，它会向服务器发送2次请求
         *
         * 2.forward是请求转发
         *   假设是Servlet1 转发给 Servlet2 ，只有Servlet2的数据可以响应给客户端(浏览器)
         *
         * 3.include是请求转发
         *   假设是Servlet1 转发给 Servlet2 ，Servlet1和Servlet2的数据都可以响应给客户端(浏览器)
         4.转发地址栏不变，重定向地址栏改变
         */
        request.setAttribute("name", "yang");
        //1.获取一个请求转发对象
        RequestDispatcher rd = request.getRequestDispatcher("/Servlet/dispatcherAndRedirect/Servlet02");

        response.getWriter().write("Servlet01 AAAAAAAAAAAAAAA");

        //2.执行转发
        rd.forward(request, response);
        //rd.include(request, response);//include:包含

        response.getWriter().write("Servlet01 BBBBBBBBBBBBBBB");


    }
}
