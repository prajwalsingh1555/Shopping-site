import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class redirect extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String UserName = request.getParameter("name");
		String UserPsw = request.getParameter("psw");
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prajwal","root","root");
			
			String qr = "select * from loginEntry";
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(qr);
			int count = 0;
				
			if(rs.next())
			{	
				do
				{
					
					if(rs.getString("name").equals(UserName) && rs.getString("psw").equals(UserPsw) )
					{
						count = 1;
						response.sendRedirect("https://morre.netlify.app");
					}
				}while(rs.next());
			}
			if(count == 0)
			{
				response.sendRedirect("https://tse4.mm.bing.net/th?id=OIP.2wnSK0iYRdPj0j4_CzP-CQHaFB&pid=Api&P=0");
			}
			 
			
		}
		catch(Exception e)
		{
			out.println(e);
		}
	}

}

