package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import beans.registrationBean;
import beans.sellerBean;
import beans.statebean;
import daolayers.electronics;
import daolayers.healthNlifestyleservice;
import daolayers.realestateservice;
import daolayers.sellerservice;
import daolayers.vehicleservice;

@WebServlet("/fileuploadservlet")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
public class fileuploadservlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String view = null;
	private static final String SAVE_DIR = "F:/workspace/gharbazar/WebContent/mobile/images/";

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("get11");
		view = "0";

		int flag = 0;
		String sell = request.getParameter("btnsell");
		view = request.getParameter("mobile");
		sellerservice ser = new sellerservice();
		String chkselect[];
		Statement st = null;
		Connection con = null;
		if (request.getParameter("category") != null) {
			view = null;
		}
		ResultSet rs1 = null;
		int i;
		if (request.getParameter("btnfind") != null) {
			view = null;
			chkselect = request.getParameterValues("chkmobile");
			
			con = daolayers.databaseconnection.getConnection();
			try {
				st = con.createStatement();
				String qry = null;
				out.println("length" + chkselect.length);
				String arr = "";
				int j = 0;
				for (i = 0; i < chkselect.length; i++) {
					if (i != 0) {
						arr = arr + " OR " + "mobile_type='" + chkselect[i]
								+ "'";
					} else
						arr = "'" + chkselect[i] + "'";
				}
				String flag1="true";
				out.println("aaaa=" + arr);
				for (i = 0; i < chkselect.length; i++) {
					if (chkselect[i].equals("All")) {
						
						flag1="false";
					} 
					out.println(flag1);
					}
				if(flag1=="true"){
					qry = "select * from mobile where mobile_type="+ arr + "";
					
				}
				else
					qry = "select * from mobile";
			
				rs1 = st.executeQuery(qry);
				out.println("qry=" + qry);
				// rs1 = ser.mobile_selection(chkselect);

				if (rs1 != null) {
					try {
						List<sellerBean> viewseller = new ArrayList<>();

						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("S_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("Image1");

							sb1.setImagepath1(a);
							sb1.setLocation(rs1.getString("state"));
							sb1.setPrice(rs1.getDouble("Price"));
							sb1.setSelling_date(rs1.getDate("Selling_date"));
							sb1.setModelname(rs1.getString("Model"));
							out.println(sb1.getImagepath1());
							viewseller.add(sb1);
							out.println("model name=" + sb1.getModelname());
						}

						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("mobile/mobileimages.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}
		if(request.getParameter("regid")!=null){
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		if (request.getParameter("btnpfind") != null) {
			chkselect = request.getParameterValues("chkprice");
			String arr = "";
			for (i = 0; i < chkselect.length; i++) {
				if (i != 0) {
					if (chkselect[i].equals("2000")) {
						out.println("2000==" + chkselect[i]);
						arr = arr + "OR" + "Price<2000";
					} else if (chkselect[i].equals("2001")) {
						arr = arr + "OR" + "(Price>=2001 and Price<=5000)";
					} else if (chkselect[i].equals("5001")) {
						arr = arr + "OR" + "(Price>=5001 and Price<=10000)";
					} else if (chkselect[i].equals("10001")) {
						arr = arr + "OR" + "(Price>=10001 and Price<=18000)";
					} else if (chkselect[i].equals("18001")) {
						arr = arr + "OR" + "(Price>=18001 and Price<=250000)";
					} else if (chkselect[i].equals("25001")) {
						arr = arr + "OR" + "(Price>=25001 and Price<=35000)";
					} else if (chkselect[i].equals("35000")) {
						arr = arr + "OR" + "(Price>=35000)";
					}
				} else {
					if (chkselect[i].equals("2000")) {
						out.println("2000==" + chkselect[i]);
						arr = "<2000)";
					} else if (chkselect[i].equals("2001")) {
						arr = ">=2001 and Price<=5000)";
					} else if (chkselect[i].equals("5001")) {
						arr = ">=5001 and Price<=10000)";
					} else if (chkselect[i].equals("10001")) {
						arr = ">=10001 and Price<=18000)";
					} else if (chkselect[i].equals("18001")) {
						arr = ">=18001 and Price<=250000)";
					} else if (chkselect[i].equals("25001")) {
						arr = ">=25001 and Price<=35000)";
					} else if (chkselect[i].equals("35000")) {
						arr = ">=35000)";
					}

				}

			}
			out.println("arr=" + arr + chkselect[0]);
			con = daolayers.databaseconnection.getConnection();
			try {
				st = con.createStatement();
				String qry = null;
				out.println("length" + chkselect.length);
				for (i = 0; i < chkselect.length; i++) {
					if (chkselect[i].equals("All")) {
						qry = "select * from mobile";
					} else
						qry = "select * from mobile where (Price"
								+ arr + "";
				}

				out.println("qry==" + qry);
				rs1 = st.executeQuery(qry);
				
				// rs1 = ser.mobile_selection(chkselect);

				if (rs1 != null) {
					try {
						List<sellerBean> viewseller = new ArrayList<>();

						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("S_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("Image1");

							sb1.setImagepath1(a);
							sb1.setLocation(rs1.getString("state"));
							sb1.setPrice(rs1.getDouble("Price"));
							sb1.setSelling_date(rs1.getDate("Selling_date"));
							sb1.setModelname(rs1.getString("Model"));
							out.println(sb1.getImagepath1());
							viewseller.add(sb1);
							out.println("model name=" + sb1.getModelname());
						}

						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("mobile/mobileimages.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if ((request.getParameter("mobile") != null) || (request.getParameter("back") != null)) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("mobileaccessories") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("health") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("Therapy") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("doctor") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("babysitter") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("jobseeker") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("emprectuiter") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (request.getParameter("services") != null) {
			sellerservice s1 = new sellerservice();
			ResultSet res = s1.viewseller();
			try {
				List<sellerBean> viewseller = new ArrayList<>();
				if (res != null) {
					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setS_id(res.getLong("S_id"));
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));

						viewseller.add(sb1);

					}
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} else
					out.println("ok" + s1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if (request.getParameter("btnsell") != null
				|| request.getParameter("regi") != null
				|| request.getParameter("category") != null) {

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

	}

	// TODO Auto-generated method stub

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("post");
		sellerservice s1 = new sellerservice();
		if (request.getParameter("btnsubmit") != null) {
		
		String savePath = SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		if (request.getParameter("btnviewmobile") != null) {
			view = "view";
		}
	
			Part part = request.getPart("file");
			String fileName = extractFileName(part);

			part.write(savePath + fileName);
			String filePath = savePath + fileName;

			String mobiletype[], productname, modelname, details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
			Long contactno;
			double price, regno;

			mobiletype = request.getParameterValues("sltmodel");
			out.println("mobile type==" + mobiletype[0]);
			productname = request.getParameter("txttitle");
			modelname = request.getParameter("txtmodelname");
			price = Double.parseDouble(request.getParameter("txtprice"));
			details = request.getParameter("txtdetails");
			contactno = Long.parseLong(request.getParameter("txtcontactno"));
			location = request.getParameter("txtState");
			city = request.getParameter("txtcity");
			sellerBean sb = new sellerBean();
			sb.setMobiletype(mobiletype[0]);
			sb.setProductname(productname);
			sb.setModelname(modelname);
			sb.setPrice(price);
			sb.setLocation(location);
			sb.setCity(city);
			sb.setDetails(details);
			sb.setContactno(contactno);
			sb.setImagepath1(fileName);
			sb.setImagepath2(imagepath2);
			sb.setImagepath3(imagepath3);

			out.println("mobile type=" + sb.getMobiletype());
			s1.insertion_seller(sb,request.getParameter("mobile"));
			out.println(s1.getstring());
			view = "insert";
			if (view != null) {
				ResultSet res = s1.viewseller();
				try {
					List<sellerBean> viewseller = new ArrayList<>();

					while (res.next()) {
						sellerBean sb1 = new sellerBean();
						String a;
						sb1.setProductname(res.getString("title"));
						a = "./mobile/images/" + res.getString("Image1");

						sb1.setImagepath1(a);
						sb1.setLocation(res.getString("state"));
						sb1.setCity(res.getString("city"));
						sb1.setPrice(res.getDouble("Price"));
						sb1.setSelling_date(res.getDate("Selling_date"));
						sb1.setS_id(res.getLong("S_id"));
						viewseller.add(sb1);

					}
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("mobile/mobileimages.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		/*
		 * String firstName=request.getParameter("firstname"); String
		 * lastName=request.getParameter("lastname");
		 */
		
		String view1=null;
		healthNlifestyleservice h1 = new healthNlifestyleservice();
		if (request.getParameter("btnhealth") != null) {
		
		String savePath = SAVE_DIR;
		File fileSaveDir = new File(savePath);
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdir();
		}
		if (request.getParameter("btnviewmobile") != null) {
			view = "view";
		}
	
			Part part = request.getPart("file");
			String fileName = extractFileName(part);

			part.write(savePath + fileName);
			String filePath = savePath + fileName;

			String mobiletype[], productname, modelname, details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
			Long contactno;
			double price, regno;

			mobiletype = request.getParameterValues("sltmodel");
			out.println("mobile type==" + mobiletype[0]);
			productname = request.getParameter("txttitle");
			price = Double.parseDouble(request.getParameter("txtprice"));
			details = request.getParameter("txtdetails");
			contactno = Long.parseLong(request.getParameter("txtcontactno"));
			location = request.getParameter("txtstate");
			city = request.getParameter("txtcity");
			sellerBean sb = new sellerBean();
			sb.setMobiletype(mobiletype[0]);
			sb.setProductname(productname);
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
						a = "./mobile/images/" + res.getString("image1");
						out.println("ok");
						sb1.setImagepath1(a);
						out.println(a);
						sb1.setLocation(res.getString("state"));
						out.println("location"+sb1.getLocation());
						sb1.setCity("city="+res.getString("city"));
						out.println(sb1.getCity());
						sb1.setPrice(res.getInt("price"));
						out.println("price="+sb1.getPrice());
						sb1.setSelling_date(res.getDate("reg_date"));
						out.println("date="+sb1.getSelling_date());
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
		
		if (request.getParameter("btnvehicle") != null) {
			
			String savePath = SAVE_DIR;
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
		
				Part part = request.getPart("file");
				String fileName = extractFileName(part);

				part.write(savePath + fileName);
				String filePath = savePath + fileName;

				String mobiletype[],subcategory[], productname, modelname, details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
				Long contactno;
				double price, regno;
				int year;

				mobiletype = request.getParameterValues("sltmodel");
				out.println("mobile type==" + mobiletype[0]);
				subcategory=request.getParameterValues("rentsell");
				year=Integer.parseInt(request.getParameter("txtprice"));
				productname = request.getParameter("txttitle");
				modelname=request.getParameter("txtmodelname");
			
				price = Double.parseDouble(request.getParameter("txtprice"));
				details = request.getParameter("txtdetails");
				contactno = Long.parseLong(request.getParameter("txtcontactno"));
				location = request.getParameter("txtstate");
				city = request.getParameter("txtcity");
				sellerBean sb = new sellerBean();
				sb.setMobiletype(mobiletype[0]);
				sb.setModelname(modelname);
				out.println("Model="+sb.getModelname());
				sb.setSubcategory(subcategory[0]);
				sb.setProductname(productname);
				sb.setYear(year);
				sb.setPrice(price);
				sb.setLocation(location);
				sb.setCity(city);
				sb.setDetails(details);
				sb.setContactno(contactno);
				sb.setImagepath1(fileName);
				sb.setImagepath2(imagepath2);
				sb.setImagepath3(imagepath3);
				vehicleservice v1=new vehicleservice();
				out.println("vehicle type=" + sb.getMobiletype());
				v1.insertion_vehicle(sb,request.getParameter("vehicle"));
				out.println(h1.getstring());
				view = "insert";
				if (view != null) {
					
					ResultSet res = v1.viewvehicle("all");
					try {
						List<sellerBean> viewseller = new ArrayList<>();

						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");
							out.println("ok");
							sb1.setImagepath1(a);
							out.println(a);
							sb1.setLocation(res.getString("state"));
							sb1.setS_id(res.getLong("vehicle_id"));
							sb1.setYear(res.getInt("year"));
							sb1.setModelname(res.getString("model"));
							out.println("location"+sb1.getLocation());
							sb1.setCity("city="+res.getString("city"));
							out.println(sb1.getCity());
							sb1.setPrice(res.getInt("price"));
							out.println("price="+sb1.getPrice());
							sb1.setSelling_date(res.getDate("reg_date"));
							out.println("date="+sb1.getSelling_date());
							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("vehicles/viewVehicle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
if (request.getParameter("btnelectro") != null) {
			
			String savePath = SAVE_DIR;
			File fileSaveDir = new File(savePath);
			if (!fileSaveDir.exists()) {
				fileSaveDir.mkdir();
			}
			
		
				Part part = request.getPart("file");
				String fileName = extractFileName(part);

				part.write(savePath + fileName);
				String filePath = savePath + fileName;

				String mobiletype[],subcategory[], productname, modelname, details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
				Long contactno;
				double price, regno;
				int year;

				mobiletype = request.getParameterValues("sltmodel");
				out.println("mobile type==" + mobiletype[0]);
				year=Integer.parseInt(request.getParameter("txtprice"));
				productname = request.getParameter("txttitle");
			
				price = Double.parseDouble(request.getParameter("txtprice"));
				details = request.getParameter("txtdetails");
				contactno = Long.parseLong(request.getParameter("txtcontactno"));
				location = request.getParameter("txtstate");
				city = request.getParameter("txtcity");
				sellerBean sb = new sellerBean();
				sb.setMobiletype(mobiletype[0]);
				out.println("Model="+sb.getModelname());
				sb.setProductname(productname);
				sb.setYear(year);
				sb.setPrice(price);
				sb.setLocation(location);
				sb.setCity(city);
				sb.setDetails(details);
				sb.setContactno(contactno);
				sb.setImagepath1(fileName);
				sb.setImagepath2(imagepath2);
				sb.setImagepath3(imagepath3);
				electronics v1=new electronics();
				out.println("vehicle type=" + sb.getMobiletype());
				v1.insertion_electronics(sb,request.getParameter("electro"));
				out.println(v1.getstring());
				view = "insert";
				if (view != null) {
					
					ResultSet res = v1.viewelectronics("all");
					try {
						List<sellerBean> viewseller = new ArrayList<>();

						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");
							out.println("ok");
							sb1.setImagepath1(a);
							out.println(a);
							sb1.setLocation(res.getString("state"));
							sb1.setS_id(res.getLong("ele_id"));
							out.println("location"+sb1.getLocation());
							sb1.setCity(res.getString("city"));
							out.println(sb1.getCity());
							sb1.setPrice(res.getInt("price"));
							out.println("price="+sb1.getPrice());
							sb1.setSelling_date(res.getDate("reg_date"));
							out.println("date="+sb1.getSelling_date());
							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("electronics/viewElectronics.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
if (request.getParameter("btnrealestate") != null) {
	
	String savePath = SAVE_DIR;
	File fileSaveDir = new File(savePath);
	if (!fileSaveDir.exists()) {
		fileSaveDir.mkdir();
	}
	

		Part part = request.getPart("file");
		String fileName = extractFileName(part);

		part.write(savePath + fileName);
		String filePath = savePath + fileName;

		String mobiletype[],subcategory[], productname,details, location, city, imagepath1, imagepath2 = null, imagepath3 = null;
		Long contactno;
		double price, regno;

		mobiletype = request.getParameterValues("sltmodel");
		productname = request.getParameter("txttitle");
		out.println("title"+productname);
	subcategory=request.getParameterValues("sltsub");
		price = Double.parseDouble(request.getParameter("txtprice"));
		details = request.getParameter("txtdetails");
		contactno = Long.parseLong(request.getParameter("txtcontactno"));
		location = request.getParameter("txtlocation");
		city = request.getParameter("txtcity");
		sellerBean sb = new sellerBean();
		sb.setMobiletype(mobiletype[0]);
		sb.setSubcategory(subcategory[0]);
		sb.setProductname(productname);
		sb.setPrice(price);
		sb.setLocation(location);
		sb.setCity(city);
		sb.setDetails(details);
		sb.setContactno(contactno);
		sb.setImagepath1(fileName);
		sb.setImagepath2(imagepath2);
		sb.setImagepath3(imagepath3);
		realestateservice v1=new realestateservice();
		v1.insertion_realestate(sb,request.getParameter("realestate"));
		out.println(v1.getstring());
		view = "insert";
		if (view != null) {
			
			ResultSet res = v1.viewrealestate("all");
			try {
				List<sellerBean> viewseller = new ArrayList<>();

				while (res.next()) {
					sellerBean sb1 = new sellerBean();
					String a;
					sb1.setProductname(res.getString("title"));
					a = "./mobile/images/" + res.getString("image1");
					out.println("ok");
					sb1.setImagepath1(a);
					out.println(a);
					sb1.setLocation(res.getString("state"));
					sb1.setS_id(res.getLong("real_id"));
					out.println("location"+sb1.getLocation());
					sb1.setCity(res.getString("city"));
					out.println(sb1.getCity());
					sb1.setPrice(res.getInt("price"));
					out.println("price="+sb1.getPrice());
					sb1.setSelling_date(res.getDate("reg_date"));
					out.println("date="+sb1.getSelling_date());
					viewseller.add(sb1);

				}
				request.setAttribute("viewseller", viewseller);
				RequestDispatcher rd = request
						.getRequestDispatcher("/realestate/viewRealEstate.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		/*
		 * String firstName=request.getParameter("firstname"); String
		 * lastName=request.getParameter("lastname");
		 */
		

	}

	// file name of the upload file is included in content-disposition header
	// like this:
	// form-data; name="dataFile"; filename="PHOTO.JPG"
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
