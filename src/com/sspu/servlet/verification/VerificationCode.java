package com.sspu.servlet.verification;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 生成验证码
 */
@WebServlet("/Servlet/Verification/Test")
public class VerificationCode extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		BufferedImage:内存图像
//		Graphics：画笔
//		ImageIO：输出图像

        //1.创建一个图片对象【画布】
        int width = 120;
        int height = 30;
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //2.拿到画笔
        Graphics graphics = bi.getGraphics();

        //3.图个背景颜色
        graphics.setColor(Color.yellow);
        //Rectangle
        graphics.fillRect(0, 0, width, height);

        //4.画干扰线(4条)
        //重新设置画笔颜色
        graphics.setColor(Color.gray);
        Random random = new Random();
        for(int i=0;i<4;i++){

            //第一个点
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);

            //第二个点
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1, y1, x2, y2);
        }

        //5.画验证码(4个随机数)
        graphics.setColor(Color.black);
        int left = 5;
        for(int i=0;i < 4;i++){
            int r = random.nextInt(10);
            System.out.println("x=" + (left + i * 20));
            graphics.drawString(r + "", left + i * 20 ,20);
        }

        //设置响应的类型
        response.setContentType("image/png");
        //把图片输出给客户端
        ImageIO.write(bi, "PNG", response.getOutputStream());

    }
}
