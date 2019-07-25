package com.sspu.servlet.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/context/Servlet03")
public class Servlet03 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest requst,
                         HttpServletResponse response)
            throws ServletException, IOException {
        /** 1.获取一个应用的servlet上下文
         * 单例 对象
         */
        ServletContext context = this.getServletContext();

        /** 2.移除ServletContext 中name的数据 */
        context.removeAttribute("name");

        String name = (String)context.getAttribute("name");  // Object 强制转为 String类
        System.out.println(name);

    }
}
