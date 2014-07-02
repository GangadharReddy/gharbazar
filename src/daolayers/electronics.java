package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.sellerBean;

public class electronics {
	Connection con;
	String str1, str2;
	Statement stmt;

	long homeid = 1;

	String category, productname,  details, location, city,
			imagepath1;
	double price;
	
	long contactno;

	public void insertion_electronics(sellerBean sb, String id) {
		Long regno = Long.parseLong(id);
		category = sb.getMobiletype();
		productname = sb.getProductname();
		details = sb.getDetails();
		price = sb.getPrice();
		location = sb.getLocation();
		city = sb.getCity();
		price = sb.getPrice();
		contactno = sb.getContactno();
		imagepath1 = sb.getImagepath1();
		try {
			java.sql.Date sqldate = new java.sql.Date(
					new java.util.Date().getTime());
			con = daolayers.databaseconnection.getConnection();
			stmt = con.createStatement();
			str1 = "select MAX(ele_id) from electronics";
			ResultSet rs = stmt.executeQuery(str1);
			while (rs.next()) {

				homeid = rs.getInt(1);

			}
			homeid = homeid + 1;
			str2 = "insert into electronics(ele_id,reg_date,category,title,price,detail,contact,state,city,image1,reg_id) values("
					+ homeid
					+ ",'" + sqldate + "','"
					+ category
					+ "','"
					+ productname
					+ "','"
					+ price
					+ "','"
					+ details
					+ "',"
					+ contactno
					+ ",'"
					+ location
					+ "','"
					+ city
					+ "','"
					+ imagepath1 + "'," + regno + ")";
			stmt.execute(str2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getstring() {
		return str2;
	}

	public ResultSet viewelectronics(String str) {
		ResultSet rs1 = null;
		try {
			if (str == "ITPeripherals") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics where category='ITPeripherals'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "all") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "TVCameraAndMultimedia") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics where category='TVCameraAndMultimedia'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "HomeAppliances") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics where category='HomeAppliances'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "IndustrialMachineryTools") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics where category='IndustrialMachineryTools'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "Others") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from electronics where category='Others'";

				rs1 = stmt.executeQuery(str1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return rs1;
	}

	public String getstring1() {
		return str1;
	}

	public ResultSet getstate() {
		con = databaseconnection.getConnection();
		Statement stmt = null;
		String st;
		ResultSet rs = null;

		try {
			st = "select state from state_master";
			stmt = con.createStatement();
			rs = stmt.executeQuery(st);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rs;
	}

	public ResultSet getelectronics(Long sid) {
		ResultSet rs1 = null;
		Long s_id = sid;
		try {
			con = daolayers.databaseconnection.getConnection();
			stmt = con.createStatement();
			str1 = "select * from electronics,registration where ele_id="
					+ s_id
					+ " and registration.reg_id=ele.reg_id";

			rs1 = stmt.executeQuery(str1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs1;
	}
}
