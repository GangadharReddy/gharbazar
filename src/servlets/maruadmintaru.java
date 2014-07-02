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

import beans.maruadmintarubean;
import beans.registrationBean;
import beans.sellerBean;
import daolayers.electronics;
import daolayers.healthNlifestyleservice;
import daolayers.maruadmintaruservice;
import daolayers.realestateservice;
import daolayers.registrationservice;
import daolayers.sellerservice;
import daolayers.vehicleservice;

/**
 * Servlet implementation class maruadmintaru
 */
@WebServlet("/maruadmintaru")
public class maruadmintaru extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public maruadmintaru() {
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
			
			if (request.getParameter("view") != null) {
				
				registrationservice r = new registrationservice();
				ResultSet rs1 = r.registrationSelect("registration");
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
						rbean1.setLast_modified(rs1.getDate(8));
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
			if ((request.getParameter("health")!=null&&(request.getParameter("uname")) != null) ) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
				ResultSet res = h1.viewhealth("health");
				try {
					List<sellerBean> viewseller = new ArrayList<>();
					if (res != null) {
						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(res.getLong("home_id"));
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(res.getString("state"));
							sb1.setCity(res.getString("city"));
							sb1.setPrice(res.getDouble("price"));
							sb1.setSelling_date(res.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			maruadmintaruservice rservice=new maruadmintaruservice();
			String chkselect[];
			if (request.getParameter("btndelete") != null) {
				chkselect = request.getParameterValues("chkview");
				if (chkselect != null && chkselect.length != 0) {
					rservice.health_delete(chkselect);
					
				}
				healthNlifestyleservice h1=new healthNlifestyleservice();
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
						sb1.setS_id(res.getLong("home_id"));
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
							.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (request.getParameter("btndeletemobile") != null) {
				chkselect = request.getParameterValues("chkview");
				if (chkselect != null && chkselect.length != 0) {
					rservice.mobile_delete(chkselect);
					
				}
				sellerservice s1=new sellerservice();
				
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
							sb1.setS_id(res.getLong("S_id"));
							sb1.setCity(res.getString("city"));
							sb1.setPrice(res.getDouble("Price"));
							sb1.setSelling_date(res.getDate("Selling_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
			if ( (request.getParameter("back") != null)) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
				ResultSet res = h1.viewhealth("all");
				try {
					List<sellerBean> viewseller = new ArrayList<>();
					if (res != null) {
						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(res.getLong("home_id"));
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(res.getString("state"));
							sb1.setCity(res.getString("city"));
							sb1.setPrice(res.getDouble("price"));
							sb1.setSelling_date(res.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			if ((request.getParameter("therapy") != null)) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
				ResultSet res = h1.viewhealth("therapy");
				try {
					List<sellerBean> viewseller = new ArrayList<>();
					if (res != null) {
						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(res.getLong("home_id"));
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(res.getString("state"));
							sb1.setPrice(res.getDouble("price"));
							sb1.setCity(res.getString("city"));
							sb1.setSelling_date(res.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if ((request.getParameter("doctor") != null)) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
				ResultSet res = h1.viewhealth("doctor");
				try {
					List<sellerBean> viewseller = new ArrayList<>();
					if (res != null) {
						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(res.getLong("home_id"));
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(res.getString("state"));
							sb1.setCity(res.getString("city"));
							sb1.setPrice(res.getDouble("price"));
							sb1.setSelling_date(res.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if ((request.getParameter("babysitter") != null)) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
				ResultSet res = h1.viewhealth("babysitter");
				try {
					List<sellerBean> viewseller = new ArrayList<>();
					if (res != null) {
						while (res.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(res.getLong("home_id"));
							sb1.setProductname(res.getString("title"));
							a = "./mobile/images/" + res.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(res.getString("state"));
							sb1.setCity(res.getString("city"));
							sb1.setPrice(res.getDouble("price"));
							sb1.setSelling_date(res.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int flag = 0;
			
		
			healthNlifestyleservice ser = new healthNlifestyleservice();
			Statement st = null;
			Connection con = null;
			if (request.getParameter("category") != null) {
			}
			ResultSet rs1 = null;
			int i;
			if (request.getParameter("btnfind") != null) {
				healthNlifestyleservice h1 = new healthNlifestyleservice();
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
							arr = arr + " OR " + "category='" + chkselect[i]
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
						qry = "select * from homenlifestyle where category="+ arr + "";
						
					}
					else
						qry = "select * from homenlifestyle";
				
					rs1 = st.executeQuery(qry);
					out.println("qry=" + qry);
					// rs1 = ser.mobile_selection(chkselect);
					List<sellerBean> viewseller = new ArrayList<>();
					if (rs1 != null) {
						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("home_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("image1");

							sb1.setImagepath1(a);
							sb1.setLocation(rs1.getString("state"));
							sb1.setCity(rs1.getString("city"));
							sb1.setPrice(rs1.getDouble("price"));
							sb1.setSelling_date(rs1.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

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
							arr = arr + "OR" + "price<2000";
						} else if (chkselect[i].equals("2001")) {
							arr = arr + "OR" + "(price>=2001 and Price<=5000)";
						} else if (chkselect[i].equals("5001")) {
							arr = arr + "OR" + "(price>=5001 and Price<=10000)";
						} else if (chkselect[i].equals("10001")) {
							arr = arr + "OR" + "(price>=10001 and Price<=18000)";
						} else if (chkselect[i].equals("18001")) {
							arr = arr + "OR" + "(price>=18001 and Price<=250000)";
						} else if (chkselect[i].equals("25001")) {
							arr = arr + "OR" + "(price>=25001 and Price<=35000)";
						} else if (chkselect[i].equals("35000")) {
							arr = arr + "OR" + "(price>=35000)";
						}
					} else {
						if (chkselect[i].equals("2000")) {
							out.println("2000==" + chkselect[i]);
							arr = "<2000)";
						} else if (chkselect[i].equals("2001")) {
							arr = ">=2001 and price<=5000)";
						} else if (chkselect[i].equals("5001")) {
							arr = ">=5001 and price<=10000)";
						} else if (chkselect[i].equals("10001")) {
							arr = ">=10001 and price<=18000)";
						} else if (chkselect[i].equals("18001")) {
							arr = ">=18001 and price<=250000)";
						} else if (chkselect[i].equals("25001")) {
							arr = ">=25001 and price<=35000)";
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
							qry = "select * from homenlifestyle";
						} else
							qry = "select * from homenlifestyle where (price"
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
								sb1.setS_id(rs1.getLong("home_id"));
								sb1.setProductname(rs1.getString("title"));
								a = "./mobile/images/" + rs1.getString("image1");

								sb1.setImagepath1(a);
								sb1.setLocation(rs1.getString("state"));
								sb1.setCity(rs1.getString("city"));
								sb1.setPrice(rs1.getDouble("price"));
								sb1.setSelling_date(rs1.getDate("reg_date"));
								out.println(sb1.getImagepath1());
								viewseller.add(sb1);
								
							}

							request.setAttribute("viewseller", viewseller);
							RequestDispatcher rd = request
									.getRequestDispatcher("Admin/homeNlife/viewHomeNlifestyle.jsp");
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
			if ((request.getParameter("mobile") != null)) {
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
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
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
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
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
			if (request.getParameter("btnmfind") != null) {
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
									.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
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
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
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
			if (request.getParameter("btnpmfind") != null) {
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
									.getRequestDispatcher("Admin/mobile/mobileimages.jsp");
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
			if (request.getParameter("btndeleteele") != null) {
				chkselect = request.getParameterValues("chkview");
				if (chkselect != null && chkselect.length != 0) {
					rservice.ele_delete(chkselect);
					
				}
				electronics e1=new electronics();
				ResultSet res = e1.viewelectronics("all");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			if(request.getParameter("itperipherals")!=null){
				electronics v1 = new electronics();
				ResultSet res = v1.viewelectronics("ITPeripherals");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			
			if(request.getParameter("tcm")!=null){
				electronics v1 = new electronics();
				ResultSet res = v1.viewelectronics("TVCameraAndMultimedia");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if(request.getParameter("homeapp")!=null){
				electronics v1 = new electronics();
				ResultSet res = v1.viewelectronics("HomeAppliances");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if(request.getParameter("industrial")!=null){
				electronics v1 = new electronics();
				ResultSet res = v1.viewelectronics("IndustrialMachineryTools");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if(request.getParameter("ele_others")!=null){
				electronics v1 = new electronics();
				ResultSet res = v1.viewelectronics("Others");
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
							.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if (request.getParameter("btnefind") != null) {
				vehicleservice h1 = new vehicleservice();
				chkselect = request.getParameterValues("chkele");
				
				con = daolayers.databaseconnection.getConnection();
				try {
					st = con.createStatement();
					String qry = null;
					out.println("length" + chkselect.length);
					String arr = "";
					int j = 0;
					for (i = 0; i < chkselect.length; i++) {
						if (i != 0) {
							arr = arr + " OR " + "category='" + chkselect[i] + "'";
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
						qry = "select * from electronics where category="+ arr + "" ;
						out.println(qry);
					}
					else
						qry = "select * from electronics";
				
					rs1 = st.executeQuery(qry);
					out.println("qry=" + qry);
					// rs1 = ser.mobile_selection(chkselect);
					List<sellerBean> viewseller = new ArrayList<>();
					if (rs1 != null) {
						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("ele_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("image1");
							sb1.setImagepath1(a);
							sb1.setLocation(rs1.getString("state"));
							sb1.setCity(rs1.getString("city"));
							sb1.setPrice(rs1.getDouble("price"));
							sb1.setSelling_date(rs1.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			if (request.getParameter("btnpefind") != null) {
				chkselect = request.getParameterValues("chkeprice");
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
						if (chkselect[i].equals("all")) {
							qry = "select * from electronics";
						} else
							qry = "select * from electronics where (price"
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
								sb1.setS_id(rs1.getLong("ele_id"));
								sb1.setProductname(rs1.getString("title"));
								a = "./mobile/images/" + rs1.getString("image1");
								sb1.setImagepath1(a);
								sb1.setLocation(rs1.getString("state"));
								sb1.setCity(rs1.getString("city"));
								sb1.setPrice(rs1.getDouble("price"));
								sb1.setSelling_date(rs1.getDate("reg_date"));

								viewseller.add(sb1);

							}
							request.setAttribute("viewseller", viewseller);
							RequestDispatcher rd = request
									.getRequestDispatcher("Admin/electronics/viewElectronics.jsp");
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

			if (request.getParameter("btndeletereal") != null) {
				chkselect = request.getParameterValues("chkview");
				if (chkselect != null && chkselect.length != 0) {
					rservice.real_delete(chkselect);
					
				}
				realestateservice real=new realestateservice();
				ResultSet res = real.viewrealestate("all");
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
							.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(request.getParameter("rrent")!=null){
				realestateservice v1 = new realestateservice();
				ResultSet res = v1.viewrealestate("rent");
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
							.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			
			if(request.getParameter("rbuy")!=null){
				realestateservice v1 = new realestateservice();
				ResultSet res = v1.viewrealestate("buy");
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
							.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if(request.getParameter("all")!=null){
				realestateservice v1 = new realestateservice();
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
							.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}		
			if (request.getParameter("btnrfind") != null) {
				realestateservice h1 = new realestateservice();
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
							arr = arr + " OR " + "category='" + chkselect[i] + "'  OR " + "subcategory='" + chkselect[i] + "'";
						} else
							arr = "'" + chkselect[i] + "' OR " + "subcategory='" + chkselect[i] + "'";
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
						qry = "select * from realestate where category="+ arr + " OR subcategory="+ arr  +"" ;
						out.println(qry);
					}
					else
						qry = "select * from realestate";
				
					rs1 = st.executeQuery(qry);
					out.println("qry=" + qry);
					// rs1 = ser.mobile_selection(chkselect);
					List<sellerBean> viewseller = new ArrayList<>();
					if (rs1 != null) {
						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("real_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("image1");
							sb1.setImagepath1(a);
							sb1.setLocation(rs1.getString("state"));
							sb1.setCity(rs1.getString("city"));
							sb1.setPrice(rs1.getDouble("price"));
							sb1.setSelling_date(rs1.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			if (request.getParameter("btnprfind") != null) {
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
							qry = "select * from realestate";
						} else
							qry = "select * from realestate where (price"
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
								sb1.setS_id(rs1.getLong("real_id"));
								sb1.setProductname(rs1.getString("title"));
								a = "./mobile/images/" + rs1.getString("image1");
								sb1.setImagepath1(a);
								sb1.setLocation(rs1.getString("state"));
								sb1.setCity(rs1.getString("city"));
								sb1.setPrice(rs1.getDouble("price"));
								sb1.setSelling_date(rs1.getDate("reg_date"));

								viewseller.add(sb1);

							}
							request.setAttribute("viewseller", viewseller);
							RequestDispatcher rd = request
									.getRequestDispatcher("Admin/realestate/viewRealEstate.jsp");
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
			if(request.getParameter("vehicles")!=null){
				vehicleservice v1= new vehicleservice();
				ResultSet res = v1.viewvehicle("vehicle");
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
							.getRequestDispatcher("Admin/vehicles/viewVehicle.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(request.getParameter("vehicleaccessories")!=null){
				vehicleservice v1= new vehicleservice();
				ResultSet res = v1.viewvehicle("vehicleaccessories");
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
							.getRequestDispatcher("Admin/vehicles/viewVehicle.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (request.getParameter("btndeletevehicle") != null) {
				chkselect = request.getParameterValues("chkview");
				if (chkselect != null && chkselect.length != 0) {
					rservice.vehicle_delete(chkselect);
					
				}
				vehicleservice real=new vehicleservice();
				ResultSet res = real.viewvehicle("all");
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
							.getRequestDispatcher("Admin/vehicles/viewVehicle.jsp");
					if (rd != null) {
						rd.forward(request, response);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
			if (request.getParameter("btnvfind") != null) {
				vehicleservice h1 = new vehicleservice();
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
							arr = arr + " OR " + "category='" + chkselect[i] + "'  OR " + "subcategory='" + chkselect[i] + "'";
						} else
							arr = "'" + chkselect[i] + "' OR " + "subcategory='" + chkselect[i] + "'";
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
						qry = "select * from vehicle where category="+ arr + " OR subcategory="+ arr  +"" ;
						out.println(qry);
					}
					else
						qry = "select * from vehicle";
				
					rs1 = st.executeQuery(qry);
					out.println("qry=" + qry);
					// rs1 = ser.mobile_selection(chkselect);
					List<sellerBean> viewseller = new ArrayList<>();
					if (rs1 != null) {
						while (rs1.next()) {
							sellerBean sb1 = new sellerBean();
							String a;
							sb1.setS_id(rs1.getLong("vehicle_id"));
							sb1.setProductname(rs1.getString("title"));
							a = "./mobile/images/" + rs1.getString("image1");
							sb1.setImagepath1(a);
							sb1.setYear(rs1.getInt("year"));
							sb1.setModelname(rs1.getString("model"));
							sb1.setLocation(rs1.getString("state"));
							sb1.setCity(rs1.getString("city"));
							sb1.setPrice(rs1.getDouble("price"));
							sb1.setSelling_date(rs1.getDate("reg_date"));

							viewseller.add(sb1);

						}
						request.setAttribute("viewseller", viewseller);
						RequestDispatcher rd = request
								.getRequestDispatcher("Admin/vehicles/viewVehicle.jsp");
						if (rd != null) {
							rd.forward(request, response);
						}
					} else
						out.println("ok" + h1.getstring());

						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			if (request.getParameter("btnpvfind") != null) {
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
							qry = "select * from vehicle";
						} else
							qry = "select * from vehicle where (price"
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
								sb1.setS_id(rs1.getLong("vehicle_id"));
								sb1.setProductname(rs1.getString("title"));
								a = "./mobile/images/" + rs1.getString("image1");
								sb1.setImagepath1(a);
								sb1.setYear(rs1.getInt("year"));
								sb1.setModelname(rs1.getString("model"));
								sb1.setLocation(rs1.getString("state"));
								sb1.setCity(rs1.getString("city"));
								sb1.setPrice(rs1.getDouble("price"));
								sb1.setSelling_date(rs1.getDate("reg_date"));

								viewseller.add(sb1);

							}
							request.setAttribute("viewseller", viewseller);
							RequestDispatcher rd = request
									.getRequestDispatcher("Admin/vehicles/viewVehicle.jsp");
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
			maruadmintaruservice rservice=new maruadmintaruservice();
			rs1=rservice.viewseller();
			try {
				while(rs1.next()){
					if(request.getParameter("txtemail").equals(rs1.getString("email"))){
						if(request.getParameter("txtpassword").equals(rs1.getString("password"))){
							flag=1;
							
							session.setAttribute("username", request.getParameter("txtemail"));
						}
					}
				
					
				}
				if(flag==1){
					RequestDispatcher rd=request.getRequestDispatcher("Admin/homeadmin.jsp");
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
	}
}
