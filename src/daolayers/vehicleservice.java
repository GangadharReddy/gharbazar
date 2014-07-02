package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.sellerBean;

public class vehicleservice {
	Connection con;
	String str1, str2;
	Statement stmt;

	long homeid = 1;

	String category, subcategory, productname, model, details, location, city,
			imagepath1;
	double price;
	int year;
	long contactno;

	public void insertion_vehicle(sellerBean sb, String id) {
		Long regno = Long.parseLong(id);
		category = sb.getMobiletype();
		subcategory = sb.getSubcategory();
		productname = sb.getProductname();
		details = sb.getDetails();
		price = sb.getPrice();
		model=sb.getModelname();
		year=sb.getYear();
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
			str1 = "select MAX(vehicle_id) from vehicle";
			ResultSet rs = stmt.executeQuery(str1);
			while (rs.next()) {

				homeid = rs.getInt(1);

			}
			homeid = homeid + 1;
			str2 = "insert into vehicle(vehicle_id,category,subcategory,title,model,year,price,detail,contact,state,city,image1,reg_date,reg_id) values("
					+ homeid
					+ ",'"
					+ category
					+ "','"
					+ subcategory
					+ "','"
					+ productname
					+ "','"+model+"','"+year+"','"
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
					+ imagepath1 + "','" + sqldate + "'," + regno + ")";
			stmt.execute(str2);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public String getstring() {
		return str2;
	}

	public ResultSet viewvehicle(String str) {
		ResultSet rs1 = null;
		try {
			if (str == "vehicle") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from vehicle where category='Vehicles'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "all") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from vehicle";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "vehicleaccessories") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from vehicle where category='VehicleAccessories'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "rent") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from vehicle where subcategory='Rent'";

				rs1 = stmt.executeQuery(str1);
			}
			if (str == "buy") {
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				str1 = "select * from vehicle where subcategory='Sell'";

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

	public ResultSet getvehicle(Long sid) {
		ResultSet rs1 = null;
		Long s_id = sid;
		try {
			con = daolayers.databaseconnection.getConnection();
			stmt = con.createStatement();
			str1 = "select * from vehicle,registration where vehicle_id="
					+ s_id
					+ " and registration.reg_id=vehicle.reg_id";

			rs1 = stmt.executeQuery(str1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs1;
	}

}
