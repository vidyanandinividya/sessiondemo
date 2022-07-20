

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Register
 */
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		String name=request.getParameter("uname");
		String email=request.getParameter("email");
		String pass=request.getParameter("pwd");
		try
		{
			//loading drivers for mysql
			Class.forName("com.mysql.jdbc.Driver");
			//Creating connection with the database
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiprofsd",
					"root","rootroot");
			//Prepare the statement to execute sql query
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?)");
			ps.setString(1,name);
			ps.setString(2, email);
			ps.setString(3, pass);
			int i=ps.executeUpdate();
			if(i>0)
			{
				response.getWriter().println("You are sucessfully registered");
				response.sendRedirect("login.html");
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
