package daolayers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.sellerBean;

public class healthNlifestyleservice {
	Connection con;
	String str1,str2;
	Statement stmt;
	
	long homeid=1;
	
	String category,productname,details,location,city,imagepath1;
	double price;
	long contactno;
	public void insertion_health(sellerBean sb,String id)
	{
		Long regno=Long.parseLong(id);
		category=sb.getMobiletype();
		productname=sb.getProductname();
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
	    str1 = "select MAX(home_id) from homenlifestyle";
		ResultSet rs = stmt.executeQuery(str1);
		while (rs.next()) {

			homeid= rs.getInt(1);

		}
		homeid = homeid + 1;
		str2 = "insert into homenlifestyle(home_id,category,title,detail,price,contact,state,city,image1,reg_date,reg_id) values("+homeid+",'"+category+"','"+productname+"','"+details+"','"+price+"',"+contactno+",'"+location+"','"+city+"','"+imagepath1+"','"+sqldate+"',"+regno+")";
		stmt.executeUpdate(str2);
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
	public ResultSet viewhealth(String str){
		ResultSet rs1=null;
		try
		{
			if(str=="health"){
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
			    str1 = "select * from homenlifestyle where category='Health-BeautyFitness'";
			    
				 rs1 = stmt.executeQuery(str1);
				}
			if(str=="all"){
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
			    str1 = "select * from homenlifestyle";
			    
				 rs1 = stmt.executeQuery(str1);
			}
			if(str=="therapy"){
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
			    str1 = "select * from homenlifestyle where category='Therapy'";
			    
				 rs1 = stmt.executeQuery(str1);	
			}
			if(str=="doctor"){
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
			    str1 = "select * from homenlifestyle where category='DoctorDetails'";
			    
				 rs1 = stmt.executeQuery(str1);	
			}
			if(str=="babysitter"){
				con = daolayers.databaseconnection.getConnection();
				stmt = con.createStatement();
			    str1 = "select * from homenlifestyle where category='Babysitter'";
			    
				 rs1 = stmt.executeQuery(str1);	
			}
			}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return rs1;
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
	}public ResultSet gethealth(Long sid){
		ResultSet rs1=null;
		Long s_id=sid;
		try
		{
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select * from homenlifestyle,registration where home_id="+s_id+" and registration.reg_id=select * from homenlifestyle,registration where home_id=1 and registration.reg_id=homenlifestyle.reg_id";
	    
		 rs1 = stmt.executeQuery(str1);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return rs1;
	}
	public ResultSet gethealthreg(Long sid){
		ResultSet rs1=null;
		Long s_id=sid;
		try
		{
		con = daolayers.databaseconnection.getConnection();
		stmt = con.createStatement();
	    str1 = "select * from homenlifestyle,registration where homenlifestyle.reg_id="+s_id+" and registration.reg_id=homenlifestyle.reg_id";
	    
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

}
