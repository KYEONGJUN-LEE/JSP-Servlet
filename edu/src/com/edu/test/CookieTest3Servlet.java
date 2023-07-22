package com.edu.test;
//방문횟수를 나타내는 서블릿

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.*;
import javax.servlet.http.*;

@WebServlet("/cookie3")
public class CookieTest3Servlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int cnt = 0; // 방문 횟수를 저장할 변수 초기화

        Cookie[] list = req.getCookies(); // 클라이언트의 쿠키 배열 가져오기

        // 클라이언트 쿠키를 검사하여 "count"라는 이름의 쿠키가 존재하는지 확인하고, 있다면 그 값을 cnt에 저장
        for (int i = 0; list != null && i < list.length; i++) {
            if (list[i].getName().equals("count")) {
                cnt = Integer.parseInt(list[i].getValue());
            }
        }

        cnt++; // 방문 횟수 증가

        // 방문 횟수를 저장하는 쿠키 생성 및 설정
        Cookie c = new Cookie("count", cnt + "");
        c.setMaxAge(60 * 60 * 24 * 10); // 유효 기간: 10일 (초 단위)
        resp.addCookie(c); // 클라이언트로 쿠키 전송

        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        out.print("<h1>방문 횟수:" + cnt); // 방문 횟수를 화면에 출력
        out.close();
    }
}
