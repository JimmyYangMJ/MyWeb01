package com.sspu.servlet.requesttest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/Servlet/requesttest/Test01")
public class Test extends HttpServlet {


    /**
     * 获取客户端信息
     * @param request
     * @param response
     */
    private static void information(HttpServletRequest request, HttpServletResponse response){
        //request对象一方法
//		获得客户机信息
//		getRequestURL方法返回客户端发出请求时的完整URL。
        System.out.println("完整URL:" + request.getRequestURL());
//		getRequestURI方法返回请求行中的资源名部分。
        System.out.println("资源名URI:" + request.getRequestURI());

//		getQueryString 方法返回请求行中的参数部分。

        System.out.println("请求参数:" + request.getQueryString());

//		getRemoteAddr方法返回发出请求的客户机的IP地址
        System.out.println("客户端的IP:" + request.getRemoteAddr());
//		getRemoteHost方法返回发出请求的客户机的完整主机名
        System.out.println("客户端的主机名:" + request.getRemoteHost());

//		getRemotePort方法返回客户机所使用的网络端口号
        System.out.println("客户端的端口:" + request.getRemotePort());

//		getLocalAddr方法返回WEB服务器的IP地址。
        System.out.println("服务器的IP:" + request.getLocalAddr());

//		getLocalName方法返回WEB服务器的主机名
        System.out.println("服务器的主机:" + request.getLocalName());

//		getMethod得到客户机请求方式
        System.out.println("客户端的请求方式：" + request.getMethod());
    }

    /**
     * 获得客户端(浏览器中)请求头
     */
    private static void requestHeader(HttpServletRequest request, HttpServletResponse response) throws IOException {
           /*	request对象方法
		获得客户端请求头
		getHead(name)方法
		getHeaders(String name)方法
		getHeaderNames方法 */

        //获取请求头
		/*System.out.println(request.getHeader("User-Agent"));
		System.out.println(request.getHeader("Accept"));*/


        //获取所有请求头的名字
        /** Enumeration 集合*/

        Enumeration<String> e = request.getHeaderNames();

        //遍历元素
        while(e.hasMoreElements()){
            String headName = e.nextElement();
            System.out.println(headName + ":" + request.getHeader(headName));
        }

        response.getWriter().write("xxx");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("666");
        /** 获取客户端信息*/
        information(request, response);
        System.out.println("==================");
        /** 获取请求头*/
        requestHeader(request, response);
    }
}
