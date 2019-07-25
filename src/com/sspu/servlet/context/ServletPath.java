package com.sspu.servlet.context;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@WebServlet("/Servlet/context/Path")
public class ServletPath extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {
        /** 解决乱码*/
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        //response.setContentType("text/html;charset=UTF-8;pageEncoding=UTF-8");
        /**
         * String path = "src/com/sspu/servlet/context/info.properties";
         * 如果是web项目，查找文件时，要从类路径找,WEB-INF/classes/
         */
        String path = this.getServletContext().getRealPath("WEB-INF/classes/com/sspu/servlet/context/info.properties");
        System.out.println(path);

        //在Servlet来获取info.properties数据
        //1.创建属性对象
        Properties pro = new Properties();

        //2.关连属性文件的路径
        pro.load(new FileInputStream(path));

        System.out.println(pro.getProperty("name"));

        //响应客户端
        response.getWriter().write(path);
        response.getWriter().write("-----");
        response.getWriter().write(pro.getProperty("name"));

    }
}
