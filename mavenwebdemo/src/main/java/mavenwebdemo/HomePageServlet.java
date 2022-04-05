package mavenwebdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomePageServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside HttpServlet init method");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doGet");
		resp.getWriter().write("<h1>Get is not supported</h1>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doPot");
		String username = req.getParameter("username");
		resp.getWriter().write("<h1>Welcome from home page " + username + " : username</h1>");

	}

	public void destroy() {
		
	}
	
}
