package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.*;
import daolayers.healthNlifestyleservice;
import daolayers.realestateservice;
import daolayers.sellerservice;
import daolayers.vehicleservice;

/**
 * Servlet implementation class productInfoservlet
 */
@WebServlet("/productInfoservlet")
public class productInfoservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productInfoservlet() {
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
		Long sno;
		if(request.getParameter("productinfo")!=null){
			sno=Long.parseLong(request.getParameter("productinfo"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			sellerservice service=new sellerservice();
			rs1=service.getsellers(sno);
			try {
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("mobile_type"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("S_id"));
					bean.setMobiletype(rs1.getString("mobile_type"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("Price"));
					bean.setCity(rs1.getString("city"));
					bean.setModelname(rs1.getString("Model"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("Selling_date"));
					bean.setDetails(rs1.getString("Details"));
					bean.setContactno(rs1.getLong("Contact_No"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("Image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("productInfo.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("productinfoadmin")!=null){
			sno=Long.parseLong(request.getParameter("productinfoadmin"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			sellerservice service=new sellerservice();
			rs1=service.getsellers(sno);
			try {
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("mobile_type"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("S_id"));
					bean.setMobiletype(rs1.getString("mobile_type"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("Price"));
					bean.setCity(rs1.getString("city"));
					bean.setModelname(rs1.getString("Model"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("Selling_date"));
					bean.setDetails(rs1.getString("Details"));
					bean.setContactno(rs1.getLong("Contact_No"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("Image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Admin/mobile/productInfo.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
			if(request.getParameter("next")!=null){
				Long no=Long.parseLong(request.getParameter("next"));
				no=no+1;
				ResultSet rs1=null;
				sellerservice service=new sellerservice();
				rs1=service.getsellers(no);
				try {
					int count=0;
					List<sellerBean> viewdata=new ArrayList<>();
					while(rs1.next()){
						sellerBean bean=new sellerBean();
						out.println(rs1.getString("mobile_type"));
						out.println(rs1.getString("title"));
						bean.setS_id(rs1.getLong("S_id"));
						bean.setMobiletype(rs1.getString("mobile_type"));
						bean.setProductname(rs1.getString("title"));
						bean.setPrice(rs1.getDouble("Price"));
						bean.setCity(rs1.getString("city"));
						bean.setModelname(rs1.getString("Model"));
						
						bean.setLocation(rs1.getString("state"));
						bean.setSelling_date(rs1.getDate("Selling_date"));
						bean.setDetails(rs1.getString("Details"));
						bean.setContactno(rs1.getLong("Contact_No"));
						String image=null;
						image = "./mobile/images/" + rs1.getString("Image1");
						bean.setImagepath1(image);
						bean.setEmail(rs1.getString("email"));
						bean.setFname(rs1.getString("fname"));
						bean.setLname(rs1.getString("lname"));
						viewdata.add(bean);
						count++;
					}
					if(count>0){
						request.setAttribute("product", viewdata);
						RequestDispatcher rd=request.getRequestDispatcher("productInfo.jsp");
						if(rd!=null){
							rd.forward(request, response);
						}
					}
					else{
						
						out.println("No record is available");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(request.getParameter("prev")!=null){
				Long no=Long.parseLong(request.getParameter("prev"));
				no=no-1;
				ResultSet rs1=null;
				sellerservice service=new sellerservice();
				rs1=service.getsellers(no);
				try {
					int count=0;
					List<sellerBean> viewdata=new ArrayList<>();
					while(rs1.next()){
						sellerBean bean=new sellerBean();
						out.println(rs1.getString("mobile_type"));
						out.println(rs1.getString("title"));
						bean.setS_id(rs1.getLong("S_id"));
						bean.setMobiletype(rs1.getString("mobile_type"));
						bean.setProductname(rs1.getString("title"));
						bean.setPrice(rs1.getDouble("Price"));
						bean.setCity(rs1.getString("city"));
						bean.setModelname(rs1.getString("Model"));
						
						bean.setLocation(rs1.getString("state"));
						bean.setSelling_date(rs1.getDate("Selling_date"));
						bean.setDetails(rs1.getString("Details"));
						bean.setContactno(rs1.getLong("Contact_No"));
						String image=null;
						image = "./mobile/images/" + rs1.getString("Image1");
						bean.setImagepath1(image);
						bean.setEmail(rs1.getString("email"));
						bean.setFname(rs1.getString("fname"));
						bean.setLname(rs1.getString("lname"));
						viewdata.add(bean);
						count++;
					}
					if(count>0){
						request.setAttribute("product", viewdata);
						RequestDispatcher rd=request.getRequestDispatcher("productInfo.jsp");
						if(rd!=null){
							rd.forward(request, response);
						}
					}
					else{
						
						out.println("No record is available");
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		
		if(request.getParameter("productinfohealth")!=null){
			sno=Long.parseLong(request.getParameter("productinfohealth"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			healthNlifestyleservice service=new healthNlifestyleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from homenlifestyle,registration where home_id="+sno+" and registration.reg_id=homenlifestyle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("home_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Home_and_Life/productinfohealth.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("productinfohealthadmin")!=null){
			sno=Long.parseLong(request.getParameter("productinfohealthadmin"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			healthNlifestyleservice service=new healthNlifestyleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from homenlifestyle,registration where home_id="+sno+" and registration.reg_id=homenlifestyle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("home_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Admin/homeNlife/productinfohealth.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("nexthealth")!=null){
			Long no=Long.parseLong(request.getParameter("nexthealth"));
			no=no+1;
			ResultSet rs1=null;
			healthNlifestyleservice service=new healthNlifestyleservice();
			//rs1=service.gethealth(no);
			try {
				int count=0;
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from homenlifestyle,registration where home_id="+no+" and registration.reg_id=homenlifestyle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("home_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("Home_and_Life/productinfohealth.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("prevhealth")!=null){
			Long no=Long.parseLong(request.getParameter("prevhealth"));
			no=no-1;
			ResultSet rs1=null;
			sellerservice service=new sellerservice();
			rs1=service.getsellers(no);
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from homenlifestyle,registration where home_id="+no+" and registration.reg_id=homenlifestyle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				int count=0;
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("home_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("Home_and_Life/productinfohealth.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("productinfovehicle")!=null){
			sno=Long.parseLong(request.getParameter("productinfovehicle"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from vehicle,registration where vehicle_id="+sno+" and registration.reg_id=vehicle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("vehicle_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setSubcategory(rs1.getString("subcategory"));
					bean.setModelname(rs1.getString("model"));
					out.println("model==="+bean.getModelname());
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setYear(rs1.getInt("year"));
					bean.setLocation(rs1.getString("state"));
					out.println("state="+bean.getLocation());
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("vehicles/productinfovehicle.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("productinfovehiadmin")!=null){
			sno=Long.parseLong(request.getParameter("productinfovehiadmin"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from vehicle,registration where vehicle_id="+sno+" and registration.reg_id=vehicle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("vehicle_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setSubcategory(rs1.getString("subcategory"));
					bean.setModelname(rs1.getString("model"));
					out.println("model==="+bean.getModelname());
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setYear(rs1.getInt("year"));
					bean.setLocation(rs1.getString("state"));
					out.println("state="+bean.getLocation());
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Admin/vehicles/productinfovehicle.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("nextvehicle")!=null){
			Long no=Long.parseLong(request.getParameter("nextvehicle"));
			no=no+1;
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(no);
			try {
				int count=0;
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from vehicle,registration where vehicle_id="+no+" and registration.reg_id=vehicle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("vehicle_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setSubcategory(rs1.getString("subcategory"));
					bean.setModelname(rs1.getString("model"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setYear(rs1.getInt("year"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("vehicles/productinfovehicle.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("prevvehicle")!=null){
			Long no=Long.parseLong(request.getParameter("prevvehicle"));
			no=no-1;
			ResultSet rs1=null;	
			sellerservice service=new sellerservice();
			//rs1=service.getsellers(no);
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from vehicle,registration where vehicle_id="+no+" and registration.reg_id=vehicle.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				int count=0;
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("vehicle_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setSubcategory(rs1.getString("subcategory"));
					bean.setModelname(rs1.getString("model"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("vehicles/productinfovehicle.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("productinfoelectronics")!=null){
			sno=Long.parseLong(request.getParameter("productinfoelectronics"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from electronics,registration where ele_id="+sno+" and registration.reg_id=electronics.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					bean.setS_id(rs1.getLong("ele_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("electronics/productinfoelectronics.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("productinfoeleadmin")!=null){
			sno=Long.parseLong(request.getParameter("productinfoeleadmin"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from electronics,registration where ele_id="+sno+" and registration.reg_id=electronics.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					bean.setS_id(rs1.getLong("ele_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Admin/electronics/productinfoelectronics.jsp");
				if(rd!=null){
				rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("nextele")!=null){
			Long no=Long.parseLong(request.getParameter("nextele"));
			no=no+1;
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(no);
			try {
				int count=0;
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from electronics,registration where ele_id="+no+" and registration.reg_id=electronics.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("ele_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("electronics/productinfoelectronics.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("prevele")!=null){
			Long no=Long.parseLong(request.getParameter("prevele"));
			no=no-1;
			ResultSet rs1=null;	
			sellerservice service=new sellerservice();
			//rs1=service.getsellers(no);
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from electronics,registration where ele_id="+no+" and registration.reg_id=electronics.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				int count=0;
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("ele_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("detail"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("electronics/productinfoelectronics.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("productinforealestate")!=null){
			sno=Long.parseLong(request.getParameter("productinforealestate"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from realestate,registration where real_id="+sno+" and registration.reg_id=realestate.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					bean.setS_id(rs1.getLong("real_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("details"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("realestate/productinforeal.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("productinforealadmin")!=null){
			sno=Long.parseLong(request.getParameter("productinforealadmin"));
			out.println("sno="+sno);
			ResultSet rs1=null;
			
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(sno);
			
			try {
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from realestate,registration where real_id="+sno+" and registration.reg_id=realestate.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					bean.setS_id(rs1.getLong("real_id"));
					
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("details"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
				}
				request.setAttribute("product", viewdata);
				RequestDispatcher rd=request.getRequestDispatcher("Admin/realestate/productinforeal.jsp");
				if(rd!=null){
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}
		else{
			out.println("ok");
		}
		if(request.getParameter("nextreal")!=null){
			Long no=Long.parseLong(request.getParameter("nextreal"));
			no=no+1;
			ResultSet rs1=null;
			vehicleservice service=new vehicleservice();
			//rs1=service.gethealth(no);
			try {
				int count=0;
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from realestate,registration where real_id="+no+" and registration.reg_id=realestate.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("real_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("details"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("realestate/productinforeal.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(request.getParameter("prevreal")!=null){
			Long no=Long.parseLong(request.getParameter("prevreal"));
			no=no-1;
			ResultSet rs1=null;	
			try {
				int count=0;
				Connection con = daolayers.databaseconnection.getConnection();
				Statement stmt = con.createStatement();
			   String str1 = "select * from realestate,registration where real_id="+no+" and registration.reg_id=realestate.reg_id";
			    out.println(str1);
				 rs1 = stmt.executeQuery(str1);
				List<sellerBean> viewdata=new ArrayList<>();
				while(rs1.next()){
					sellerBean bean=new sellerBean();
					out.println(rs1.getString("category"));
					out.println(rs1.getString("title"));
					bean.setS_id(rs1.getLong("real_id"));
					bean.setMobiletype(rs1.getString("category"));
					bean.setProductname(rs1.getString("title"));
					bean.setPrice(rs1.getDouble("price"));
					bean.setCity(rs1.getString("city"));
					bean.setLocation(rs1.getString("state"));
					bean.setSelling_date(rs1.getDate("reg_date"));
					bean.setDetails(rs1.getString("details"));
					bean.setContactno(rs1.getLong("contact"));
					String image=null;
					image = "./mobile/images/" + rs1.getString("image1");
					bean.setImagepath1(image);
					bean.setEmail(rs1.getString("email"));
					bean.setFname(rs1.getString("fname"));
					bean.setLname(rs1.getString("lname"));
					viewdata.add(bean);
					count++;
				}
				if(count>0){
					request.setAttribute("product", viewdata);
					RequestDispatcher rd=request.getRequestDispatcher("realestate/productinforeal.jsp");
					if(rd!=null){
						rd.forward(request, response);
					}
				}
				else{
					
					out.println("No record is available");
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		}
	
	
		
			
				
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		out.println("post");
	}

}
