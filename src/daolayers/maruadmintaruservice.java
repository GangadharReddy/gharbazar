package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class maruadmintaruservice {
	Connection con;
	String str1,str2;
	Statement stmt;
	
	long sid=1;
	ResultSet rs1=null;
	String mobiletype,productname,model,companyname,details,location,city,imagepath1;
	double price;
	long contactno;
	public ResultSet viewseller(){
		
		try
		{
	
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select * from maruadmintaru";
	    
		 rs1 = stmt.executeQuery(str1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs1;
	}
	public boolean health_delete(String chkselect[]) {
		long reg_no[]=new long[20];
		int a=0,i;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				a = stmt.executeUpdate("delete from  homenlifestyle where home_id='"
								+ reg_no[i] + "'");
			}

			if (a > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public boolean mobile_delete(String chkselect[]) {
		long reg_no[]=new long[20];
		int a=0,i;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				a = stmt.executeUpdate("delete from  mobile where S_id='"
								+ reg_no[i] + "'");
			}

			if (a > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public boolean ele_delete(String chkselect[]) {
		long reg_no[]=new long[20];
		int a=0,i;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				a = stmt.executeUpdate("delete from  electronics where ele_id='"
								+ reg_no[i] + "'");
			}

			if (a > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public boolean vehicle_delete(String chkselect[]) {
		long reg_no[]=new long[20];
		int a=0,i;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				a = stmt.executeUpdate("delete from  vehicle where vehicle_id='"
								+ reg_no[i] + "'");
			}

			if (a > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public boolean real_delete(String chkselect[]) {
		long reg_no[]=new long[20];
		int a=0,i;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
				a = stmt.executeUpdate("delete from  realestate where real_id='"
								+ reg_no[i] + "'");
			}

			if (a > 0) {
				result = true;
			} else {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public String getstring(){
		return str1;
	}
}
