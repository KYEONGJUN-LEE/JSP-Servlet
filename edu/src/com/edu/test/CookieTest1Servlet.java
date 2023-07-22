package com.edu.test;
//쿠키를 전송하는 서블릿
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/cookie1")
public class CookieTest1Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        // 쿠키 생성 및 설정
        Cookie c1 = new Cookie("id", "guest"); // 이름: id, 값: guest
        c1.setPath("/"); // 경로: 전체 서버

        resp.addCookie(c1); // 클라이언트로 쿠키 전송

        Cookie c2 = new Cookie("code", "0001"); // 이름: code, 값: 0001
        c2.setMaxAge(60 * 60 * 3); // 유효 기간: 3시간 (초 단위) 초*분*시간*일수
        c2.setPath("/"); // 경로: 전체 서버
        resp.addCookie(c2); // 클라이언트로 쿠키 전송

        Cookie c3 = new Cookie("subject", "java"); // 이름: subject, 값: java
        c3.setMaxAge(60 * 60 * 24 * 10); // 유효 기간: 10일 (초 단위)
        c3.setPath("/"); // 경로: 전체 서버
        resp.addCookie(c3); // 클라이언트로 쿠키 전송

        // 응답 출력
        out.println("<html><head><title>Cookie Test</title></head>");
        out.println("<body>");
        out.println("<h2>쿠키 전송 완료.</h2>"); // 화면에 메시지 표시
        out.println("</body></html>");

        out.close();
    }
}
