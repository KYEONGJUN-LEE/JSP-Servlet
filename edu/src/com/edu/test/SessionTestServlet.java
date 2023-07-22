package com.edu.test;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        PrintWriter out = resp.getWriter();

        String param = req.getParameter("p");
        String msg = null;
        HttpSession session = null;

        if (param.equals("create")) {
            session = req.getSession(); // 세션을 생성하도록 수정됨
            if (session.isNew()) {
                msg = "새로운 세션 객체가 생성되었습니다.";
            } else {
                msg = "기존의 세션 객체가 반환되었습니다.";
            }
        } else if (param.equals("delete")) {
            session = req.getSession(false);
            if (session != null) {
                session.invalidate();
                msg = "세션 객체를 삭제하였습니다.";
            } else {
                msg = "삭제할 세션 객체가 존재하지 않습니다.";
            }
        } else if (param.equals("add")) {
            session = req.getSession(true);
            session.setAttribute("msg", "메세지입니다");
            msg = "세션 객체에 데이터 등록을 완료하였습니다.";
        } else if (param.equals("get")) {
            session = req.getSession(false);
            if (session != null) {
                String str = (String) session.getAttribute("msg");
                msg = str;
            } else {
                msg = "데이터를 가져올 세션 객체가 존재하지 않습니다.";
            }
        } else if (param.equals("remove")) {
            session = req.getSession(false);
            if (session != null) {
                session.removeAttribute("msg");
                msg = "세션 객체의 데이터를 삭제하였습니다.";
            } else {
                msg = "데이터를 삭제할 세션 객체가 존재하지 않습니다.";
            }
        } else if (param.equals("replace")) {
            session = req.getSession();
            session.setAttribute("msg", "새로운 메세지입니다.");
            msg = "세션 객체의 데이터를 변경하였습니다.";
        }
        out.print("처리 결과 :"+ msg);
        out.close();
    }
}
