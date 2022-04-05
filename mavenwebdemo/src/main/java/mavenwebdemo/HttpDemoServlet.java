package mavenwebdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/demoHttp")
public class HttpDemoServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside HttpServlet init method");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doGet");
		resp.getWriter().write("From doGet Method in HttpDemoServlet - First Http Servlet");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doPot");
		resp.getWriter().write("From doPost Method in HttpDemoServlet - First Http Servlet");

	}

	public void destroy() {
		
	}
	
}
