package com.sspu.servlet.responsetest;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet/responsetest/DownLoadTest")
public class DownLoadTest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("下载文件");
        //处理文件下载【把文件的数据(二进制)响应客户端】

        //1.文件名
        String fileName = "开班内容.txt";

        String path = "C:/Users/dell/Desktop/" + fileName;

        /**
         * 注意：如果是文件下载，需要设置响应头Content-disposition
         * 		 如果文件名有中文，下载时为了解决乱码问题，需要对文本进行URLEncode,把中文变成%号形式
         "开班内容.txt" = %E5%BC%80%E7%8F%AD%E5%86%85%E5%AE%B9.txt
         一个中文会对象3个%的号数据
         */
        fileName = URLEncoder.encode(fileName, "utf-8");
        System.out.println(fileName);
        response.setHeader("Content-disposition", "attachment;filename=" + fileName);

        //2.获取文件输入流
        FileInputStream fis = new FileInputStream(path);

        //3.获取输出流
        ServletOutputStream sos = response.getOutputStream();

        //4.从文件中读取数据，响应给客户端
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1){
            sos.write(buf, 0, len);
        }

        //输入流关闭,输出流会自动关闭
        fis.close();
    }
}
