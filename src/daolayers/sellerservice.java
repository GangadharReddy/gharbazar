package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.eclipse.jdt.internal.compiler.ast.ArrayAllocationExpression;

import beans.sellerBean;

public class sellerservice {
	Connection con;
	String str1,str2;
	Statement stmt;
	
	long sid=1;
	
	String mobiletype,productname,model,companyname,details,location,city,imagepath1;
	double price;
	long contactno;
	public void insertion_seller(sellerBean sb,String reg_id)
	{
		Long reg=Long.parseLong(reg_id);
		mobiletype=sb.getMobiletype();
		productname=sb.getProductname();
		model=sb.getModelname();
		companyname=sb.getCompanyname();
		details=sb.getDetails();
		location=sb.getLocation();
		city=sb.getCity();
		price=sb.getPrice();
		contactno=sb.getContactno();
		imagepath1=sb.getImagepath1();
		try
		{
		java.sql.Date sqldate = new java.sql.Date(
				new java.util.Date().getTime());
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select MAX(S_id) from mobile";
		ResultSet rs = stmt.executeQuery(str1);
		while (rs.next()) {

			sid= rs.getInt(1);

		}
		sid = sid + 1;
		str2 = "insert into mobile(S_id,reg_id,mobile_type,title,Model,Price,state,city,Selling_date,Details,Contact_No,Image1) values('"+sid+"','"+reg+"','"+mobiletype+"','"+productname+"','"+model+"','"+price+"','"+location+"','"+city+"','"+sqldate+"','"+details+"',"+contactno+",'"+imagepath1+"')";
		stmt.execute(str2);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	
	}
	public String getstring()
	{
		return str2; 
	}
	public ResultSet viewseller(){
		ResultSet rs1=null;
		try
		{
		java.sql.Date sqldate = new java.sql.Date(
				new java.util.Date().getTime());
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select * from mobile";
	    
		 rs1 = stmt.executeQuery(str1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs1;
	}
	public String getstring1(){
		return str1;
	}
	public ResultSet getstate()
	{
		con=databaseconnection.getConnection();
		Statement stmt=null;
		String st;
		ResultSet rs=null;
		
		try {
			st="select state from state_master";
			stmt=con.createStatement();
			rs=stmt.executeQuery(st);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rs;
	}public ResultSet getsellers(Long sid){
		ResultSet rs1=null;
		Long s_id=sid;
		try
		{
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select * from mobile,registration where S_id="+s_id+" and registration.reg_id=mobile.reg_id";
	    
		 rs1 = stmt.executeQuery(str1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs1;
	}
}
