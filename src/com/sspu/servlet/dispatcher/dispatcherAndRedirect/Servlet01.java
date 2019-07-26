package com.sspu.servlet.dispatcher.dispatcherAndRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/dispatcherAndRedirect/Servlet01")
public class Servlet01 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
       /*
		   转发和重定向的作用域区别
		    转发：以前的request中存放的变量不会失效，就像把两个页面拼到了一起。
		重定向：以前的request中存放的变量全部失效，并进入一个新的request作用域。*/
        response.getWriter().println("servlet01 11111111");
        //1.往请求域存一个数据
        request.setAttribute("name", "sanguo");
        //2.转发给Servlet02
        request.getRequestDispatcher("/Servlet/dispatcherAndRedirect/Servlet02").forward(request, response);

        response.getWriter().println("servlet01 222222222");

        /** 2.重定向， request的数据会丢失  （即Attribute的值）*/
        //response.sendRedirect(request.getContextPath() + "/Lesson07Servlet02");
    }
}
