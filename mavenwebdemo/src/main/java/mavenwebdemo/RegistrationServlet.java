package mavenwebdemo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

	public void init() {
		System.out.println("Inside HttpServlet init method");
		
	}
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doGet");
		resp.getWriter().write("<h1>Registration success: GET :</h1>");

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doPot");
		String fname = req.getParameter("fname");
		resp.getWriter().write("<h1>Registration success: POST : " + fname + " : fname</h1>");

	}

	public void destroy() {
		
	}
	
}
