package com.sspu.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * 第二种 （少用）
 * 继承 GenericServlet
 */
public class GenericServletTest extends GenericServlet {

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        response.getWriter().write("hello servlet....");
    }
}
