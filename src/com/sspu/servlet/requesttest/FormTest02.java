package com.sspu.servlet.requesttest;

import com.sspu.servlet.requesttest.javabean.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 未完善，可以通过第三方包实现JavaBean的封装
 */
@WebServlet("/Servlet/requesttest/FormTest02")
public class FormTest02 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        //post请求时，中文会乱码,解决方法setCharacterEncoding,只针对post请求有效
        request.setCharacterEncoding("UTF-8");

        //创建用户对象
        User user = new User();

        //获取请求参数
        /**
         * key			value
         * username		{"gyf"};
         * password     {"123"};
         * hobby		{"studying","money"}
         */
        Map<String, String[]> map = request.getParameterMap();
        try {
            for(Map.Entry<String, String[]> entry : map.entrySet()){
                String pname = entry.getKey();

                /** 反射 ,获取对象的属性和方法*/
                //创建属性描述器

                PropertyDescriptor pd = new PropertyDescriptor(entry.getKey(), User.class);

                //获取写入方法对象

                Method method = pd.getWriteMethod();

                //通过反射调用方法【怎么获取方法的参数类型】
                Class[] clzs = method.getParameterTypes();
                if(clzs.length == 0){
                    return;
                }

                String clzName = clzs[0].toString();
                String[] values = entry.getValue();
                if(clzName.contains("[Ljava.lang.String")){
                    System.out.println("数组...");
                    method.invoke(user, (Object)values);
                }else{
                    System.out.println("非数组...");
                    method.invoke(user, values[0]);
                }

				/*String[] values = entry.getValue(); 这种方式有bug
				if(values.length == 1){
					method.invoke(user, values[0]);
				}else{
					method.invoke(user, (Object)values);
				}
				*/
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(user);
    }
}
