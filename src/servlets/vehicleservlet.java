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
import daolayers.healthNlifestyleservice;
import daolayers.sellerservice;
import daolayers.vehicleservice;

/**
 * Servlet implementation class vehicleservlet
 */
@WebServlet("/vehicleservlet")
public class vehicleservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       String view=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vehicleservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		if ( (request.getParameter("back") != null)) {
			vehicleservice h1 = new vehicleservice();
			ResultSet res = h1.viewvehicle("all");
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
					sb1.setS_id(res.getLong("vehicle_id"));
					sb1.setLocation(res.getString("state"));
					out.println("location"+sb1.getLocation());
					sb1.setCity("city="+res.getString("city"));
					sb1.setYear(res.getInt("year"));
					sb1.setModelname(res.getString("model"));
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
				 else
					out.println("ok" + h1.getstring());

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
						.getRequestDispatcher("vehicles/viewVehicle.jsp");
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
						.getRequestDispatcher("vehicles/viewVehicle.jsp");
				if (rd != null) {
					rd.forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if ( (request.getParameter("backk") != null)) {
			electronics v1 = new electronics();
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
						.getRequestDispatcher("electronics/viewElectronics.jsp");
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
						.getRequestDispatcher("electronics/viewElectronics.jsp");
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
						.getRequestDispatcher("electronics/viewElectronics.jsp");
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
						.getRequestDispatcher("electronics/viewElectronics.jsp");
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
						.getRequestDispatcher("electronics/viewElectronics.jsp");
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
			view = null;
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("vehicles/viewVehicle.jsp");
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
						view = "1";
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
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (request.getParameter("btnefind") != null) {
			view = null;
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
					view = "1";
					request.setAttribute("viewseller", viewseller);
					RequestDispatcher rd = request
							.getRequestDispatcher("electronics/viewElectronics.jsp");
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
						view = "1";
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
	}

}
