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

import beans.sellerBean;
import daolayers.healthNlifestyleservice;
import daolayers.sellerservice;

/**
 * Servlet implementation class healthservlet
 */
@WebServlet("/healthservlet")
public class healthservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String view=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public healthservlet() {
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
		if ((request.getParameter("health") != null) ) {
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
								.getRequestDispatcher("Home_and_Life/viewHomeNlifestyle.jsp");
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
	}

}
