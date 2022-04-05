 package mavenwebdemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	private Connection con;
	
	 public void contextInitialized(ServletContextEvent sce) {
		 System.out.println("Inside ContextInitialized::");
		 
		 try {
			 String dbusername = sce.getServletContext().getInitParameter("dbusername");
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_company", "root"
			 		, "A1d9i9t8i");
			
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
		 
	 }

	 public void contextDestroyed(ServletContextEvent sce) {
		 System.out.println("Inside ContextDestroyed::");
		 
		 try {
			 con.close();
		 } catch (SQLException e) {
			 e.printStackTrace();  
		 }
		 
	 }
	
}
