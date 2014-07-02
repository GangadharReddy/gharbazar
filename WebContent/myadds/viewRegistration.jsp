<%@page import="sun.awt.SunHints.Value"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.registrationBean" %>
<%@page import="java.util.List" %>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form name="viewForm" action="registrationservlet">
<table align="center" border="4">

<%List<registrationBean> listview= new ArrayList(); %>
<%listview=(List)request.getAttribute("viewRegistrationData"); %>
<tr>
	<th>Registration No</th>
	<th>Registration Date</th>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Email</th>
	<th>Contact No</th>
	<th>Last Logged-In</th>
</tr>
		
<%for( int i=0;i<listview.size();i++){
	%><tr><%
	registrationBean rbean=new registrationBean();
	rbean=listview.get(i);
	long a=rbean.getReg_no();
	%>
	<td><input type="checkbox" name="chkview" value=<%=a%>><%out.println(a);%></td>
	<td><%out.println(rbean.getReg_date()); %></td>
	<td><%out.println(rbean.getFname());%></td>
	<td><%out.println(rbean.getLname()); %></td>
	<td><%out.println(rbean.getEmail()); %></td>
	<td><%out.println(rbean.getMobile()); %></td>
	<td><%out.println(rbean.getLast_modified()); %></td>
	</tr><%
}	
%>
<tr>
<td colspan="4"><input type="submit" name="btndelete" value="Delete"></input></td>

</tr> 	    

</table>
</form>
</body>
</html>		