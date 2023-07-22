package com.edu.test;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest reg, HttpServletResponse resp) throws ServletException,IOException{
		System.out.println("SecondServlet!!");
		PrintWriter out = resp.getWriter();
		  out.print("<html>");
	      out.print("<head>");
	      out.print("<title>First Servlet</title>");
	      out.print("</head>");
	      out.print("<body>");
	      out.print("<h1>Have a nice day!!</h1>");
	      out.print("</body>");
	      out.print("</html>");
	   }
		
	}
	

