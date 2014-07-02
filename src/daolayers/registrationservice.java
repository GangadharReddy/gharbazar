package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.registrationBean;

public class registrationservice {
	Connection con = null;
	String str = null;
	Statement st = null;
	String table;
	public String fname, lname, email, password;
	public long mobile;
	long regno = 1;

	public boolean register() {
		return false;

	}

	public Boolean insertion_registration(registrationBean rbean,String table,String rid) {
		fname = rbean.getFname();
		lname = rbean.getLname();
		email = rbean.getEmail();
		mobile = rbean.getMobile();
		password = rbean.getPassword();

		try {
			this.table=table;

			java.sql.Date sqldate = new java.sql.Date(
					new java.util.Date().getTime());
			con = daolayers.databaseconnection.getConnection();
			st = con.createStatement();
			String str1 = "select MAX("+rid+") from "+table+"";
			ResultSet rs = st.executeQuery(str1);
			while (rs.next()) {

				regno = rs.getInt(1);

			}
			regno = regno + 1;
			str = "insert into "+table+" values('" + regno + "','" + fname
					+ "','" + lname + "','" + email + "','" + mobile + "','"
					+ password + "','" + sqldate + "','"+ sqldate  +"')";
			if (st.executeUpdate(str) > 0) {
				return true;

			} else {
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public ResultSet registrationSelect(String table) {
		ResultSet rs = null;
		this.table=table;
		try {
			con = daolayers.databaseconnection.getConnection();

			st = con.createStatement();
			rs = st.executeQuery("select * from "+table+"");
			/*
			 * if(rs){ return rs; }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public boolean registration_delete(String chkselect[],String table) {
		long reg_no[]=new long[20];
		int a=0,i;
		this.table=table;
		boolean result = false;
		try {
			for (i = 0; i < chkselect.length + 1; i++) {

				reg_no[i] = Long.parseLong(chkselect[i]);

				con = daolayers.databaseconnection.getConnection();
				st = con.createStatement();
				a = st.executeUpdate("delete from "+table+" where reg_id='"
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

	public registrationBean registration_select_update(String no,String table) {
		long reg_no;
		registrationBean rbean=new registrationBean();
		try {
			java.sql.Date curdate=new java.sql.Date(new java.util.Date().getTime());
			reg_no = Long.parseLong(no);
			con = daolayers.databaseconnection.getConnection();
			st = con.createStatement();
			
			ResultSet rs=st.executeQuery("select * from "+table+" where reg_id='"+reg_no+"'");
			while(rs.next()){
				rbean.setReg_no(reg_no);
				rbean.setFname(rs.getString("fname"));
				rbean.setLname(rs.getString("lname"));
				rbean.setMobile(rs.getLong("mobile"));
				rbean.setLast_modified(curdate);
				rbean.setEmail(rs.getString("email"));
				rbean.setReg_date(rs.getDate("reg_date"));
				rbean.setPassword(rs.getString("password"));
			}
		}catch(Exception e){
				e.printStackTrace();
		}
		return rbean;
	}
	public boolean registration_update(registrationBean rbean,String table){

		boolean result=false;
		try{
			
			con = daolayers.databaseconnection.getConnection();
			st = con.createStatement();
			

			java.sql.Date curdate=new java.sql.Date(new java.util.Date().getTime());
			int a = st.executeUpdate("update "+table+" set fname='"
					+ rbean.getFname() + "', lname='" + rbean.getLname()
					+ "',mobile='" + rbean.getMobile() + "',last_modified='"
					+ curdate + "' where reg_id='" + rbean.getReg_no()
					+ "'");
			if(a>0)
				result=true;
			else
				result=false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}

