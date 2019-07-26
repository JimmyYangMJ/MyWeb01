package com.sspu.servlet.requesttest;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

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

    /**
     * 获取URL 参数
     */
    private static void parameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /** 获得客户端请求参数(客户端提交的数据) */
        /**
         * 1.getParameter(name)方法
         */

        /** http://localhost:8080/MyWeb01_war_exploded/
         * Servlet/requesttest/Test01?username=gyf&passowrd=123 */
		String username = request.getParameter("username");
		String password = request.getParameter("passowrd");
		String gender = request.getParameter("gender");
		System.out.println("客户端浏览器发送来的请求参数?username=gyf&passowrd=123：");
		System.out.println(username);
		System.out.println(password);
		System.out.println(gender);

        /**
         * 2.getParameterValues（String name）方法 【获取一个参数的多个值】
         */
        /** ?hobby=studying & hobby=money */
		String[] hobbies = request.getParameterValues("hobby");
		System.out.println("获取一个参数的多个值");
		System.out.println(Arrays.toString(hobbies));

        /**
         * 3.getParameterNames方法 【获取所有参数】
         */
        /** ?username=gyf&passowrd=123 */
        /** Enumeration当成集合来用*/
        System.out.println("获取 所有 参数");
		Enumeration<String> names = request.getParameterNames();
		//遍历
		while(names.hasMoreElements()){
			System.out.println(names.nextElement());
		}

        /**
         *4.getParameterMap方法   【把所有请求参数存在一个map中】//做框架用，非常实用
         */
        /** ?username=gyf&passowrd=123&hobby=studing&hobby=money */
        /**
         * key			value
         * username		{"gyf"};
         * password     {"123"};
         * hobby		{"studying","money"}
         */
		Map<String, String[]> map = request.getParameterMap();
		for(Map.Entry<String, String[]> entry : map.entrySet()){
			System.out.println("参数名字:" + entry.getKey());

			System.out.println("参数的值:");
			for(String value : entry.getValue()){
				System.out.println(value);
			}
		}


        /**
         * 5.getInputStream 【以字节读请求参数】
         */
        System.out.println(".....");
        ServletInputStream is = request.getInputStream();
        byte[] buf = new byte[1024];
        int len ;
        while((len = is.read(buf)) != -1){
            //把buf转成字符串
            String s = new String(buf, 0, len);
            System.out.println(s);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("666");
        /** 获取客户端信息*/
        information(request, response);
        System.out.println("==================");
        /** 获取请求头*/
        requestHeader(request, response);
        System.out.println("==================");
        /** 获取URL 参数 */
        parameter(request, response);
    }
}
