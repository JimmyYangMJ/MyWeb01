package com.sspu.servlet.requesttest;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Arrays;

@WebServlet("/Servlet/requesttest/FormTest01")
public class FormTest01 extends HttpServlet {

    /**
     * 处理表单数据推荐使用doPost 方法，更加安全
     * 表单数据不会再URL后面显示
     */
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

    /**
     * 1.post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效
     * 2.get和post请求的一个区别
     * 	 get请求：是把请求参数放在url？后面进行拼接
     *   post请求：在url中是看不到参数
     *   post请求比较安全点
     * 3.getInputStream 【获取不到参数】-针对post请求效
     *   使用inputStream读取数据时，发送中文变成%号形式
     *   username=gyf&password=qwer&gender=male&hobby=%E8%B5%9A%E9%92%B1&hobby=%E6%B8%B8%E6%88%8F&remark=werwerw
     *   post请求会对中文进行URL编码【什么URL编码-把中文转成%形式】【URL解码-把%形式的内容转回中文】
     *   URL编码解决乱码问题
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效
        request.setCharacterEncoding("UTF-8");

        System.out.println(".....");
        ServletInputStream is = request.getInputStream();
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = is.read(buf)) != -1){
            //把buf转成字符串

            /** 字节转成字符串时，要以utf-8编码表 */
            String s1 = new String(buf, 0, len,"gbk");
            // 或者   String s = new String(buf, 0, len);
            System.out.println("s1:" + s1);
            /**
             * URL解码·····················
             */
            String s2 = URLDecoder.decode(s1, "utf-8");
            System.out.println("s2:" + s2);
        }
    }
}
