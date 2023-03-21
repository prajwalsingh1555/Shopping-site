
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Login")
public class Login extends HttpServlet {
	
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}
	
	
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String name = request.getParameter("name");
		String phone_number = request.getParameter("phone_number");
		String email = request.getParameter("email");
		String pass = request.getParameter("psw");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prajwal","root","root");
			
			String qr = "insert into loginEntry values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(qr);
			
			ps.setString(1, name);
			ps.setString(2, phone_number);
			ps.setString(3, email);
			ps.setString(4, pass);
			
			int x = ps.executeUpdate();
			
			getServletContext().getRequestDispatcher("/log.jsp").forward(request, response);
			
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
		
	}
	

}
