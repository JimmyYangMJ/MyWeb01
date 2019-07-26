package com.sspu.servlet.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/dispatcher/Servlet01")
public class Servlet01 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /** 防止乱码*/
        response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
        /**
         * request:请求
         * response:响应,给客户端响应数据
         * URL 不会变
         */

        //1.获取请求转发的对象
        RequestDispatcher rd = request.getRequestDispatcher("/Servlet/dispatcher/Servlet02");

        //2.执行转发
        rd.forward(request, response);

    }

}
