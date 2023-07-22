package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/queryTest")
public class QueryTestServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/html; charset=UTF-8");
    req.setCharacterEncoding("UTF-8");
    PrintWriter out = resp.getWriter();

    out.println("<html>");
    out.println("<head><title>GET 방식 요청 결과</title></head>");
    out.println("<body>");

    out.println("<h1>GET 방식으로 요청되었습니다.</h1>");
    String id = req.getParameter("id");
    String password = req.getParameter("pwd");
    String name = req.getParameter("name");
    String[] hobbies = req.getParameterValues("hobby");
    String gender = req.getParameter("gender");
    String religion = req.getParameter("religion");
    String intro = req.getParameter("introduction");

    out.print("ID: " + id + "<br/>");
    out.print("비밀번호: " + password + "<br/>");
    out.print("이름: " + name + "<br/>");
    out.print("취미: ");
    for (int i = 0; i < hobbies.length; i++) {
      out.print(hobbies[i] + " ");
    }
    out.print("<br/>");
    out.print("성별: " + gender + "<br/>");
    out.print("종교: " + religion + "<br/>");
    out.print("자기소개: " + intro + "<br/>");
    out.print("전체 질의 문자열: " + req.getQueryString());

    out.print("</body>");
    out.print("</html>");

    out.close();
  }
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    resp.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = resp.getWriter();
	    req.setCharacterEncoding("UTF-8");
	    out.print("<html>");
	    out.print("<head><title>POST 방식 요청 결과</title></head>");
	    out.print("<body>");

	    out.print("<h1>POST 방식으로 요청되었습니다.</h1>");
	    String id = req.getParameter("id");
	    String password = req.getParameter("pwd");
	    String name = req.getParameter("name");
	    String[] hobbies = req.getParameterValues("hobby");
	    String gender = req.getParameter("gender");
	    String religion = req.getParameter("religion");
	    String intro = req.getParameter("introduction");

	    out.print("ID: " + id + "<br/>");
	    out.print("비밀번호: " + password + "<br/>");
	    out.print("이름: " + name + "<br/>");
	    out.print("취미: ");
	    for (int i = 0; i < hobbies.length; i++) {
	        out.print(hobbies[i] + " ");
	    }
	    out.print("<br/>");
	    out.print("성별: " + gender + "<br/>");
	    out.print("종교: " + religion + "<br/>");
	    out.print("자기소개: " + intro + "<br/>");

	    out.print("</body>");
	    out.print("</html>");

	    out.close();
	}

}
