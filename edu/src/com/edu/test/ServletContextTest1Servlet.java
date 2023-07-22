package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/context1")
public class ServletContextTest1Servlet extends HttpServlet {
	ServletContext sc;

//    @Override
//    public void init(ServletConfig config) throws ServletException {
//        // 초기화 작업 수행 (필요한 경우)
//    	sc = config.getServletContext(); // ServletContext 객체를 가져와서 변수에 저장합니다.
//    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();
        
        ServletContext sc = this.getServletContext(); // this는 현재 객체 자신을 가리키는 키워드로서 ServletContextTest1Servlet객체를 가리킨다.
        String location = sc.getInitParameter("contextConfig");
        out.print("location : " + location); // 저장된 ServletContext 객체를 출력합니다. 올바르게 주솟값이 출력되었다면 객체의 ID가 출력되고 , 그렇지 않다면 null값이 나온다.
        out.close();
    }
}                                  
