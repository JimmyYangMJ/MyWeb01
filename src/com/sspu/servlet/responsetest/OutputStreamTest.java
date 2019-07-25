package com.sspu.servlet.responsetest;


import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/responsetest/OutputStreamTest")
public class OutputStreamTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HttpServletRequest接口，tomcat中实现类org.apache.catalina.connector.RequestFacade 在lib/catalina.jar
        //HttpServletResponse接口，tomcat中实现类org.apache.catalina.connector.ResponseFacade

        System.out.println(request);
        System.out.println(response);

        //通过response对象响应正文的两种方式
        /**
         * 1.通过PrintWriter给客户端响应数据
         * PrintWriter:操作的数据是字符
         * PrintWriter response.getWriter()
         *
         * 2.通过OutputStream给客户端响应数据
         * OutputStream:操作字节，一般可以用来下载文件
         */
        //response.getWriter().write("hello,how are you!");

        ServletOutputStream sos = response.getOutputStream();
        byte[] buf = {97,99,100};
        sos.write(buf);//写一个字节数组
    }

}
