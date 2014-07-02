package servlets;

import java.io.File;
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
import javax.servlet.http.Part;

import beans.sellerBean;
import beans.statebean;
import daolayers.healthNlifestyleservice;
import daolayers.registrationservice;
import daolayers.sellerservice;

/**
 * Servlet implementation class addPostservlet
 */
@WebServlet("/addPostservlet")
public class addPostservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String view = null;
	private static final String SAVE_DIR = "F:/workspace/gharbazar/WebContent/Home_and_Life/images/";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPostservlet() {
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
		if(request.getParameter("post")!=null){
			HttpSession session=request.getSession();
			session.setAttribute("uname", request.getParameter("post"));
			session.setAttribute("reg_id", request.getParameter("reg_id"));
			RequestDispatcher rd=request.getRequestDispatcher("seller/addPost.jsp");
			if(rd!=null){
			rd.forward(request, response);
			}
		}
		if(request.getParameter("logout")!=null){
			HttpSession session=request.getSession(true);
			session.setAttribute("username", null);
			RequestDispatcher rd=request.getRequestDispatcher("homepage.jsp");
			if(rd!=null){
				rd.forward(request, response);
			}
				
		}
		if(request.getParameter("adminlogout")!=null){
			HttpSession session=request.getSession(true);
			session.setAttribute("username", null);
			RequestDispatcher rd=request.getRequestDispatcher("Admin/maruLogintaru.jsp");
			if(rd!=null){
				rd.forward(request, response);
			}
				
		}
		if (request.getParameter("health") != null) {

			sellerservice s2 = new sellerservice();
			ResultSet rs;
			rs = s2.getstate();

			try {
				List<statebean> l1 = new ArrayList<>();

				while (rs.next()) {

					statebean c1 = new statebean();
					c1.setState(rs.getString("state"));

					l1.add(c1);
					out.println("in  " + request.getParameter("btnsell"));

				}
				request.setAttribute("state", l1);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("/Home_and_Life/homeNlifestyleUpload.jsp");
				out.println("inn  " + rd1.toString());
				if (rd1 != null) {
					
					rd1.forward(request, response);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.println("dsascsscssdain  " + request.getParameter("btnsell"));
		}
		
		if (request.getParameter("vehicle") != null) {

			sellerservice s2 = new sellerservice();
			ResultSet rs;
			rs = s2.getstate();

			try {
				List<statebean> l1 = new ArrayList<>();

				while (rs.next()) {

					statebean c1 = new statebean();
					c1.setState(rs.getString("state"));

					l1.add(c1);
					out.println("in  " + request.getParameter("btnsell"));

				}
				request.setAttribute("state", l1);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("/vehicles/vehicleUpload.jsp");
				out.println("inn  " + rd1.toString());
				if (rd1 != null) {
					
					rd1.forward(request, response);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.println("dsascsscssdain  " + request.getParameter("btnsell"));
		}
		if (request.getParameter("mobile") != null) {

			sellerservice s2 = new sellerservice();
			ResultSet rs;
			rs = s2.getstate();

			try {
				List<statebean> l1 = new ArrayList<>();

				while (rs.next()) {

					statebean c1 = new statebean();
					c1.setState(rs.getString("state"));

					l1.add(c1);
					out.println("in  " + request.getParameter("btnsell"));

				}
				request.setAttribute("state", l1);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("/mobile/mobileSellerUpload.jsp");
				out.println("inn  " + rd1.toString());
				if (rd1 != null) {
					
					rd1.forward(request, response);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.println("dsascsscssdain  " + request.getParameter("btnsell"));
		}
		if (request.getParameter("electronics") != null) {

			sellerservice s2 = new sellerservice();
			ResultSet rs;
			rs = s2.getstate();

			try {
				List<statebean> l1 = new ArrayList<>();

				while (rs.next()) {

					statebean c1 = new statebean();
					c1.setState(rs.getString("state"));

					l1.add(c1);
					out.println("in  " + request.getParameter("btnsell"));

				}
				request.setAttribute("state", l1);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("/electronics/electronicsUpload.jsp");
				out.println("inn  " + rd1.toString());
				if (rd1 != null) {
					
					rd1.forward(request, response);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (request.getParameter("realestate") != null) {

			sellerservice s2 = new sellerservice();
			ResultSet rs;
			rs = s2.getstate();

			try {
				List<statebean> l1 = new ArrayList<>();

				while (rs.next()) {

					statebean c1 = new statebean();
					c1.setState(rs.getString("state"));

					l1.add(c1);
					out.println("in  " + request.getParameter("btnsell"));

				}
				request.setAttribute("state", l1);
				RequestDispatcher rd1 = request
						.getRequestDispatcher("/realestate/realEstateUpload.jsp");
				out.println("inn  " + rd1.toString());
				if (rd1 != null) {
					
					rd1.forward(request, response);
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
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
	
	if(request.getParameter("btnlogin")!=null){
		ResultSet rs1;
		HttpSession session=request.getSession(true);
		int flag=0;
		String uname = "";
		registrationservice rservice=new registrationservice();
		rs1=rservice.registrationSelect("registration");
		try {
			while(rs1.next()){
				if(request.getParameter("txtemail").equals(rs1.getString("email"))){
					if(request.getParameter("txtpassword").equals(rs1.getString("password"))){
						flag=1;
						try{
							
							Connection con = daolayers.databaseconnection.getConnection();
							Statement st = con.createStatement();
							sellerBean s1=new sellerBean();
							s1.setS_id(rs1.getLong("reg_id"));

							java.sql.Date curdate=new java.sql.Date(new java.util.Date().getTime());
							int a = st.executeUpdate("update registration set last_modified='"
									+ curdate + "' where reg_id='" + s1.getS_id()
									+ "'");
							
						} catch (Exception e) {
							e.printStackTrace();
						}
						uname=rs1.getString("fname")+" "+rs1.getString("lname");
						session.setAttribute("username", uname);
						Long a=rs1.getLong("reg_id");
						session.setAttribute("reg_id",a.toString());
					out.println(rs1.getInt("reg_id"));
					}
				}
			
				
			}
			if(flag==1){
				RequestDispatcher rd=request.getRequestDispatcher("seller/addPost.jsp");
				if(rd!=null){
				rd.forward(request, response);
				}
			}
			else
				out.println("no");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	healthNlifestyleservice h1=new healthNlifestyleservice();
	String savePath = SAVE_DIR;
	File fileSaveDir = new File(savePath);
	if (!fileSaveDir.exists()) {
		fileSaveDir.mkdir();
	}
	if (request.getParameter("btnvi") != null) {
		view = "view";
	}
	if (request.getParameter("health") != null) {
		Part part = request.getPart("file");
		String fileName = extractFileName(part);

		part.write(savePath + fileName);
		String filePath = savePath + fileName;

		String category[], title, modelname, details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
		Long contactno;
		double price, regno;

		category = request.getParameterValues("sltmodel");
		out.println("mobile type==" + category[0]);
		title = request.getParameter("txttitle");
		price = Double.parseDouble(request.getParameter("txtprice"));
		details = request.getParameter("txtdetails");
		contactno = Long.parseLong(request.getParameter("txtcontactno"));
		location = request.getParameter("txtState");
		city = request.getParameter("txtcity");
		sellerBean sb = new sellerBean();
		sb.setMobiletype(category[0]);
		sb.setProductname(title);
		
		sb.setPrice(price);
		sb.setLocation(location);
		sb.setCity(city);
		sb.setDetails(details);
		sb.setContactno(contactno);
		sb.setImagepath1(fileName);
		sb.setImagepath2(imagepath2);
		sb.setImagepath3(imagepath3);

		out.println("mobile type=" + sb.getMobiletype());
		h1.insertion_health(sb,request.getParameter("health"));
		out.println(h1.getstring());
		view = "insert";
		if (view != null) {
			ResultSet res = h1.viewhealth("all");
			try {
				List<sellerBean> viewseller = new ArrayList<>();

				while (res.next()) {
					sellerBean sb1 = new sellerBean();
					String a;
					sb1.setProductname(res.getString("title"));
					a = "./Home_and_Life/images/" + res.getString("Image1");

					sb1.setImagepath1(a);
					sb1.setLocation(res.getString("state"));
					sb1.setCity(res.getString("city"));
					sb1.setPrice(res.getDouble("price"));
					sb1.setSelling_date(res.getDate("reg_date"));

					viewseller.add(sb1);

				}
				request.setAttribute("viewseller", viewseller);
				RequestDispatcher rd = request
						.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}


}
