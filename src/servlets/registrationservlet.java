package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.catalina.connector.Request;

import beans.registrationBean;
import beans.sellerBean;
import beans.statebean;
import daolayers.registrationservice;
import daolayers.sellerservice;

@WebServlet("/registrationservlet")
public class registrationservlet extends HttpServlet {
	String btnview = null;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String table="registration";	
		PrintWriter out = response.getWriter();
		String chkselect[] = null;
		registrationservice rservice = new registrationservice();
		
		if (request.getParameter("btndelete") != null) {
			chkselect = request.getParameterValues("chkview");
			if (chkselect != null && chkselect.length != 0) {
				rservice.registration_delete(chkselect,table);
				
			}
					ResultSet rs1;
					rs1 = rservice.registrationSelect(table);
					try {
						List<registrationBean> viewRegistration = new ArrayList<>();
						while (rs1.next()) {
							registrationBean rbean1 = new registrationBean();
							rbean1.setReg_no(rs1.getLong(1));
							rbean1.setFname(rs1.getString(2));
							rbean1.setLname(rs1.getString(3));
							rbean1.setEmail(rs1.getString(4));
							rbean1.setMobile(rs1.getLong(5));
							rbean1.setPassword(rs1.getString(6));
							rbean1.setReg_date(rs1.getDate(7));
							viewRegistration.add(rbean1);

						}
						request.setAttribute("viewRegistrationData",
								viewRegistration);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/viewRegistration.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		
		
		if (request.getParameter("btnedit") != null) {

			chkselect = request.getParameterValues("chkview");

			if (chkselect != null && chkselect.length == 1) {
				registrationBean rbean = new registrationBean();

				String no;
				no = chkselect[0];
				registrationservice rs = new registrationservice();
				rbean = rs.registration_select_update(no,table);
				out.println("" + rbean.getFname());

				request.setAttribute("rbean", rbean);

				RequestDispatcher rd = request
						.getRequestDispatcher("Admin/registrationEdit.jsp");
				rd.forward(request, response);

				out.println("not worked");
			}
		}
		if (request.getParameter("btnupdate") != null) {
			boolean a = false;
			registrationservice rs = new registrationservice();
			try {

				registrationBean rbean = new registrationBean();
				rbean.setReg_no(Long.parseLong(request
						.getParameter("txtreg_no")));
				rbean.setFname(request.getParameter("txt_fname"));
				rbean.setLname(request.getParameter("txt_lname"));
				rbean.setMobile(Long.parseLong(request
						.getParameter("txtmobile_no")));
				a = rs.registration_update(rbean,table);
				if (a == true) {
					ResultSet rs1;
					rs1 = rs.registrationSelect(table);
					try {
						List<registrationBean> viewRegistration = new ArrayList<>();
						while (rs1.next()) {
							registrationBean rbean1 = new registrationBean();
							rbean1.setReg_no(rs1.getLong(1));
							rbean1.setFname(rs1.getString(2));
							rbean1.setLname(rs1.getString(3));
							rbean1.setEmail(rs1.getString(4));
							rbean1.setMobile(rs1.getLong(5));
							rbean1.setPassword(rs1.getString(6));
							rbean1.setReg_date(rs1.getDate(7));
							viewRegistration.add(rbean1);
						}
						request.setAttribute("viewRegistrationData",
								viewRegistration);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/viewRegistration.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else
					out.println("Can't updated");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String table="registration";
		PrintWriter out = response.getWriter();
		String fname;
		String lname;
		String email;
		long mobil;
		String password;
		btnview = request.getParameter("btnViewRegistration");
		ResultSet rs1;
		rs1 = null;
		String aa="true";
		if (request.getParameter("btnsubmit") != null) {
			fname = request.getParameter("txtfname");
			lname = request.getParameter("txtlname");
			out.println("ok"+fname);
			email = request.getParameter("txtemail");
			mobil = Long.parseLong(request.getParameter("txtmobileno"));
			password = request.getParameter("txtpass");
			beans.registrationBean rbean = new beans.registrationBean();
			rbean.setFname(fname);
			rbean.setLname(lname);
			rbean.setEmail(email);
			rbean.setMobile(mobil);
			rbean.setPassword(password);
			registrationservice rs = new registrationservice();
			rs1=rs.registrationSelect(table);
				
			try {
				while(rs1.next()){
					out.println(rs1.getString("email"));
					String em=rbean.getEmail();
					
					if(rs1.getString("email").equals(rbean.getEmail())){
						out.println("sds"+rs1.getString("email"));
						aa="false";
						RequestDispatcher rd=request.getRequestDispatcher("seller/alreadyRegister.jsp");
						rd.forward(request, response);	
					}
				}
				if(aa!="false")
				{
					boolean b = rs.insertion_registration(rbean,table,"reg_id");
					if (b == true) {
						RequestDispatcher rd=request.getRequestDispatcher("");
						rd.forward(request, response);
						//btnview = "View Registration";
					} else {
						out.print("false");
					}
					
				}
			}
			 catch (SQLException e) {
				// TODO Auto-generated catch block
			 	e.printStackTrace();
			 }

		}
		if (btnview != null) {
			registrationservice r = new registrationservice();
			rs1 = r.registrationSelect(table);
			try {
				List<registrationBean> viewRegistration = new ArrayList<>();
				while (rs1.next()) {
					registrationBean rbean1 = new registrationBean();
					rbean1.setReg_no(rs1.getLong(1));
					rbean1.setFname(rs1.getString(2));
					rbean1.setLname(rs1.getString(3));
					rbean1.setEmail(rs1.getString(4));
					rbean1.setMobile(rs1.getLong(5));
					rbean1.setPassword(rs1.getString(6));
					rbean1.setReg_date(rs1.getDate(7));
					viewRegistration.add(rbean1);

				}
				request.setAttribute("viewRegistrationData", viewRegistration);
				RequestDispatcher rd = request
						.getRequestDispatcher("Admin/viewRegistration.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
