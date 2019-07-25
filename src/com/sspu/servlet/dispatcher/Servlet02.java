package com.sspu.servlet.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/Servlet/dispatcher/Servlet02")
public class Servlet02 extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");//给客户端返回网页
        //response.setContentType("text/json");//给客户端返回网页
        /**
         * request:请求
         * response:响应
         */

        response.getWriter().write("data from servlet2");
        //给客户端面返回一个html文件
        //给客户端面返回一个xml文件
        //给客户端面返回一个json数据
        //给客户端面返回一个图片数据

    }

}
