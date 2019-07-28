package com.sspu.servlet.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet/cookie/Test01")
public class Test01  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

        //1.创建一个Cookie对象
        Cookie ck = new Cookie("lastAccessTime", System.currentTimeMillis()+"");

        //2.设置cookie的存活时间【单位是秒】
        ck.setMaxAge(60*60);

        //3.把Cookie返回给客户端【通过响应头传给客户端】
        response.addCookie(ck);

        //Cookie应用场景 :记录上次访问时间
        //设置响应时乱码问题
        response.setHeader("content-type", "text/html;charset=utf-8");
        //获取请求头的Cookie
        Cookie[] cks = request.getCookies();

        if(cks != null){
            for(Cookie c : cks){
                System.out.println(c.getName() + ":" + c.getValue());
                response.getWriter().write("上次访问的时间:" + c.getValue());

                c.setMaxAge(0);//删除cookie
                //response.addCookie(c);
            }
        }





    }
}
