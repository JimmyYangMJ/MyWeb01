package com.sspu.servlet.dispatcher.dispatcherAndRedirect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/dispatcherAndRedirect/Servlet02")
public class Servlet02 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = (String) request.getAttribute("name");
        response.getWriter().write(name);
        response.getWriter().println("servlet02 AAAAAAAAAA");

    }
}
