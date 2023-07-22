package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/queryTest2")
public class QueryTest2Servlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();

        out.println("<html><head><title>Query 문자열테스트</title></head>");
        out.println("<body>");
        out.println("<h1>POST 방식 질의 문자열 추출</h1>");

        ServletInputStream input = req.getInputStream();
        int len = req.getContentLength();
        byte[] buf = new byte[len];
        input.readLine(buf, 0, len);

        String s = new String(buf);
        out.println("전체 문자열: " + s);
        out.println("</body></html>");
        out.close();
    }

}
