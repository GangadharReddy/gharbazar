package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daolayers.databaseconnection;

/**
 * Servlet implementation class upadatePassword
 */
@WebServlet("/upadatePassword")
public class upadatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public upadatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("get");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String newpassword=request.getParameter("txtnewpassword");
		PrintWriter out=response.getWriter();
		out.println("post");
		Connection con;
		databaseconnection dc=new databaseconnection();
		
		try {
			con=dc.getConnection();
			Statement stmt=con.createStatement();
			out.println(newpassword);
			out.println(email);
			String st="update registration set password='"+newpassword+"' where email='"+email+"'";
			out.println(st);
			stmt.executeUpdate(st);
			RequestDispatcher rd=request.getRequestDispatcher("seller/loginSeller.jsp");
					if(rd!=null){
							rd.forward(request, response);
					}
			 out.println("password changed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
