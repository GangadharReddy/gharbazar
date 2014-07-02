<%@page import="beans.sellerBean"%>
<%@page import="beans.registrationBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><table>
<%List<sellerBean> view=new ArrayList(); 
view=(List)request.getAttribute("viewseller");
int i;
for(i=0; i<view.size(); i++){
	sellerBean s1= new sellerBean();
	s1=view.get(i);
	%><tr>
	<td align="center"><%out.println(s1.getProductname()); %></td>
	</tr>
	<tr>
	<%String a=s1.getImagepath1(); %>
	<td><img src=<%=a %> height="500" width="500"></td>
	</tr>
	<%
}
%>
</table>
</body>
</html>