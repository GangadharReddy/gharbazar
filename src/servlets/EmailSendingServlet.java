package servlets;
import utility.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import daolayers.databaseconnection;
import daolayers.onvert;

/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 * 
 * @author www.codejava.net
 * 
 */
@WebServlet("/EmailSendingServlet")
public class EmailSendingServlet extends HttpServlet {
	private String host;
	private String port;
	private String user;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		/*ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		user = context.getInitParameter("user");
		pass = context.getInitParameter("pass");*/
		host="smtp.gmail.com";
		port="587";
		user="info.gharbazar@gmail.com";
		pass="info123@";
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// reads form fields
		PrintWriter out=response.getWriter();
		String recipient = request.getParameter("txtemailid");
		databaseconnection dc=new databaseconnection();
		int flag=0;
		Connection con=dc.getConnection();
		try {
			Statement stmt=con.createStatement();
			String st="select email from registration";
			ResultSet rs=stmt.executeQuery(st);
			while(rs.next())
			{
				if(recipient.equals(rs.getString("email")))
				{
					flag=1;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(flag==1)
		{
		
		
		String subject = "Change password Request";
		String content = "http://localhost:80/gharbazar/resetPassword.jsp?email="+recipient+"";
		out.println(recipient);
		out.println(subject);
		out.println(content);
		out.println(host);
		out.println(port);
		out.println(user);
		out.println(pass);

		String resultMessage = "";

		try {
			EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
					content);
			resultMessage = "The e-mail was sent successfully";
		} catch (Exception ex) {
			ex.printStackTrace();
			resultMessage = "There were an error: " + ex.getMessage();
		} finally {
			request.setAttribute("Message", resultMessage);
			//getServletContext().getRequestDispatcher("/Result.jsp").forward(request, response);
		}
		}
		else
		{
			 RequestDispatcher rd = getServletContext().getRequestDispatcher("/emailSend.jsp");
	            
	            out.println("<font color=red>The email id does not exist.</font>");
	       //     rd.include(request, response);
		}
	}
}