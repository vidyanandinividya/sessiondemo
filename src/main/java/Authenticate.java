import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Authenticate {
public static boolean checkUser(String email,String pass)
{
	boolean st=false;
	try
	{
		//loading drivers for mysql
		Class.forName("com.mysql.jdbc.Driver");
		//Creating connection with the database
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wiprofsd",
				"root","rootroot");
		//Prepare the statement to execute sql query
		PreparedStatement ps=con.prepareStatement("select * from Employee where email=? and pass=?");
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs=ps.executeQuery();
		st=rs.next();
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return st;
	
}
}
