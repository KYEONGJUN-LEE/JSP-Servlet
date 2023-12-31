package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatcher1")
public class DispatcherTest1Servlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("<h3>Dispatcher Test 1의 수행결과</h3>");

        // 서블릿 컨텍스트를 가져옵니다.
        ServletContext sc = this.getServletContext();

        // dispatcher2 서블릿으로 요청을 포워딩합니다.
        // 요청과 응답 객체를 그대로 전달합니다.
        RequestDispatcher rd = sc.getRequestDispatcher("/dispatcher2");
        rd.include(req, resp);

        out.close();
    }
}
