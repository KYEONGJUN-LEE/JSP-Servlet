package com.edu.test;

import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/bookOutput")
public class BookTest2Servlet extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        Book book = (Book) req.getAttribute("book");

        out.print("<h3>책 제목 :" + book.getTitle() + "</h3>");
        out.print("<h3>저자 : " + book.getAuthor() + "</h3>");
        out.print("<h3>출판사 : " + book.getPublisher() + "</h3>");

        out.close();
    }
}
