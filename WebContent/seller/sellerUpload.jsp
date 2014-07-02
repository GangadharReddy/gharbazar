<%@page import="org.apache.catalina.tribes.membership.StaticMember"%>
<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="daolayers.databaseconnection"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="beans.statebean"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="daolayers.sellerservice"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%ResultSet cityresult=null; %>
<%sellerservice service=new sellerservice(); %>
<%statebean state=new statebean();%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/formstyle.css" />
<script type="text/javascript">
	function city() {
		<%cityresult=(ResultSet)request.getAttribute("city");%>
		alert("k");
		alert("ok");
		
		
		//while(cityresult.next()){
				
			//	}
		
		//document.getElementById('txtproductname').value=document.getElementById('txtlocation').value;
		//var x=document.getElementById('txtcity');
		//var option=document.createElement("option");
		//option.text=document.getElementById('txtproductname').value;
		//x.add(option);
//	var state=document.getElementById('txtlocation').value;
	
}
</script>
</head>
<body>
<div style="margin: 30px;">
<form action="./fileuploadservlet" method="post" enctype="multipart/form-data">
	<table width="400px" align="center" border=0>	
		
    <%List<statebean> l1=new ArrayList();
    l1=(List)request.getAttribute("state"); %>
   
    <tr>
    <td>Select Mobile Type</td>
    
           
    <td><select name="sltmodel" >
        <option>select your choice</option>
   
  
 <option>AndroidPhones</option>
  <option>SmartPhones</option>
  <option>DualSimPhones</option>
  <option>ValuePhones</option>
  <option>BussinessPhones</option>
  <option>Tablets</option>
  <option>WindowPhones</option>
  <option>Other</option>
  </select></td>
    </tr>
     <tr>
    <td>Product Name</td>
    <td><input type="text" id="txtproductname" name="txtproductname" /></td>
  </tr>
  <tr>
    <td>Model</td>
    <td><input type="text" id="txtmodelname" name="txtmodelname" /></td>
  </tr>
  <tr>
  
  </tr>
  <tr>
    <td>Company Name</td>
    <td><input type="text" id="txtcompanyname" name="txtcompanynname" /></td>
  </tr>
  <tr>
    <td>Price</td>
    <td><input type="text" id="txtprice" name="txtprice" /></td>
  </tr>
  <tr>
    <td>Details</td>
    <td><input type="text" id="txtdetails" name="txtdetails" /></td>
  </tr>
  <tr>
    <td>Contact No.</td>
    <td><input type="text" id="txtcontactno" name="txtcontactno" /></td>
  </tr>
  <tr>
  	<td>Location</td>
	<td>
	<select name="txtlocation" id="txtlocation">
	 <option selected="selected">Select State</option>
	 <%
	 int i;
    for(i=0;i<l1.size();i++)
    {
    	statebean c1=new statebean();
		c1=l1.get(i);  
	%>
		<option><%=c1.getState() %></option>
		
	<%}%>
	</select></td>
  
  </tr>
  <tr>
  <td>City:</td>
  <td>
  <input type="text" name="txtcity">
  </td>
  
  </tr>
       <tr>
           <td>Image Link: </td>
           <td>
               <input type="file" name="file">
           </td>
       </tr>
       <tr>
           <td><input type="submit" name="btnsubmit" value="Submit"></td>
              <td><input type="submit" name="btnviewmobile" value="viewmobile"/></td>
       </tr>
   </table>
</form>
</div>
</body>
</html>