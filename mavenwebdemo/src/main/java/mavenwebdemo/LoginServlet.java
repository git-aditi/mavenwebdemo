package mavenwebdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -4751096228274971485L;
	int counter = 0;
	int data = 50;

	public void init() {
		System.out.println("Inside HttpServlet init method");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Inside doGet");
		String name = req.getParameter("username");
		resp.getWriter().write("<h1>Registration success: GET :</h1>" + "</br> Welcome " + name);

	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("username");

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String n = req.getParameter("username");
		String p = req.getParameter("password");

		ServletConfig sg = getServletConfig();
		String theme = sg.getInitParameter("theme");
		System.out.println("Theme is ::" + theme);

		ServletContext application = getServletContext();
		String dbURL = application.getInitParameter("dbURL");
		System.out.println("dbURL is ::" + dbURL);

		Integer counter = (Integer) application.getAttribute("counter");

		if (null != counter) {
			application.setAttribute("counter", ++counter);

		} else {
			application.setAttribute("counter", new Integer(1));

		}

		Boolean result = validateCredentials(n, p);

		if (result) {
			RequestDispatcher rd = req.getRequestDispatcher("welcome");
			rd.forward(req, resp);
			// response.sendRedirect("welcome");
		} else {
			out.print("Sorry UserName or Password Error!");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
			rd.include(req, resp);
			// response.sendRedirect("/index.jsp");

		}
	}

	public void destroy() {

	}

	private Boolean validateCredentials(String username, String password) {
		Boolean result = Boolean.FALSE;

		try {
			// write code here to create connection
			Connection conn = (Connection) getServletContext().getAttribute("dbconnection");
			/*
			 * Class.forName("com.mysql.jdbc.Driver") Connection conn =
			 * DriverManager.getConnection("jdbc:mysql://localhost:3306/new_company",
			 * "root", "A1d9i9t8i"); Statement stmt = con.createStatement(); ResultSet rs =
			 * stmt.executeQuery("select * from Employee");
			 * 
			 */

			PreparedStatement pstmt = conn.prepareStatement("select * from emp where name=?");

			// for (int i=0; i<5; i++{

			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4)
						+ " " + rs.getString(5) + " " + rs.getString(6) + " " + rs.getString(7) + " "
						+ rs.getString(8));
				if (username.equals(rs.getString(2))) {
					if (password.equals(rs.getString(4))) {
						result = Boolean.TRUE;
						break;
					}
				}
			}

		} catch (Exception e) {
			System.out.println("Exception ocured:: " + e);
		}
		return result;
	}
}
