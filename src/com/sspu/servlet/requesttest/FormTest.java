package com.sspu.servlet.requesttest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/Servlet/requesttest/FormTest")
public class FormTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String remark = request.getParameter("remark");
        String [] hobbies = request.getParameterValues("hobby");

        System.out.println(username);
        System.out.println(password);
        System.out.println(gender);
        System.out.println(remark);
        System.out.println(Arrays.toString(hobbies));
    }
}
