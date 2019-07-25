package com.sspu.servlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/context/Servlet02")
public class Servlet02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        /** 1.获取一个应用的servlet上下文
         * 单例 对象
         */
        ServletContext context = this.getServletContext();

        /** 2.获取Servlet上下文的数据 */
        String name = (String)context.getAttribute("name");  // Object 强制转为 String类
        System.out.println(name);

    }
}
