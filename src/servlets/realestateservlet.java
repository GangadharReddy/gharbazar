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
import daolayers.electronics;
import daolayers.realestateservice;
import daolayers.vehicleservice;

/**
 * Servlet implementation class realestateservlet
 */
@WebServlet("/realestateservlet")
public class realestateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realestateservlet() {
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
		if ( (request.getParameter("all") != null)) {
			realestateservice v1=new realestateservice();
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
		
		
		if(request.getParameter("rent")!=null){
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
						.getRequestDispatcher("realestate/viewRealEstate.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
		
		if(request.getParameter("buy")!=null){
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
						.getRequestDispatcher("realestate/viewRealEstate.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
		String chkselect[];
		Statement st = null;
		Connection con = null;
		ResultSet rs1 = null;
		int i;
		if (request.getParameter("btnfind") != null) {
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
							.getRequestDispatcher("realestate/viewRealEstate.jsp");
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
								.getRequestDispatcher("realestate/viewRealEstate.jsp");
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
