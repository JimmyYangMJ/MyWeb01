package com.sspu.servlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/context/Param")
public class ServletParam extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        /** 掌握通过上下文对象从web.xml中获取全局配置信息*/
        /**
         * 注意：在web.xml中 context-param配置的信息不是通过getAttribute方法获取，而是通过getInitParameter方法
         * String str = (String) this.getServletContext().getAttribute("encoding");
         * */

        String str = (String) this.getServletContext().getInitParameter("name");
        System.out.println("web.xml中获取的name值:" + str);

    }
}
