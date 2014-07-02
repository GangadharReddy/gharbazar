<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.util.List" %>
<%@page import="beans.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css_files/productview.css" />
<link rel="stylesheet" href="css_files/colorbox.css" />
<script src="js_files/jquery.min.js"></script>
<script src="js_files/jquery.colorbox.js"></script>
<script>
	$(document)
			.ready(
					function() {
						//Examples of how to assign the Colorbox event to elements

						$(".ajax").colorbox();
		});
</script>
</head>
<body>
<div id="maindiv">
<%List<sellerBean> viewdata=new ArrayList();
viewdata=(List)request.getAttribute("product");
%>
<div id="header">
<a href="homepage.jsp"><img src="images/logo1.gif" id="logo" alt="GharBazar.com"></a>
<a href="seller/loginSeller.jsp" class="myButton">Post Your Ads Here
     <span class="ina-free-flag">Free</span>
     </a>   
</div>
<div id="hedderbelow"></div>
<div id="middle">
<%
int i;
for(i=0;i<viewdata.size();i++){
	sellerBean bean=new sellerBean();
	bean=viewdata.get(i);
%>
<div id="leftcon"></div>
	<div id="container">
		<div id="link">
			<div id="linkleft"><a href="homepage.jsp">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Home &nbsp; <b>&gt;</b> &nbsp; </a><a href="./vehicleservlet?back=1">Vehicles &nbsp;<b> &gt;</b> &nbsp; </a><a href="#"><%out.println(bean.getProductname()); %></a></div>
			<div id="linkright"><a href="./productInfoservlet?prevvehicle=<%=bean.getS_id()%>"><b>&lt;</b> &nbsp;Previous Ad &nbsp;&nbsp; </a>  <a href="./productInfoservlet?nextvehicle=<%=bean.getS_id()%>">  &nbsp; Next Ad &nbsp;<b>&gt;</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a></div>
						
		</div>
		<br>
		<div id="titleprice">
		
			<div id="details">
				<div id="title">
					<h1><%out.println(bean.getProductname());%>
					</h1>
				</div>
				<div id="det">
					<h3><% out.println(bean.getLocation()); %> &nbsp; | &nbsp;  <%out.println(bean.getDetails());%> &nbsp;  | &nbsp;  <%out.println(bean.getMobiletype()); %> &nbsp; | &nbsp;<%out.println(bean.getYear()); %> &nbsp; | &nbsp;<%out.println(bean.getModelname()); %></h3>
				</div>
			</div>
			<div id="price">
				<h1><div style="margin:5px;background: #F00;color: #FFF;">&#x20b9;&nbsp;<%out.println(bean.getPrice()); %></div></h1>
			</div>
		</div>
		<div id="image">
			<img src=<%=bean.getImagepath1() %>>
		</div>
		<div id="contact">
			<div id="name"><h2><img src="./images/icon1.gif"/><%out.println(bean.getFname());%>  <%out.println(bean.getLname()); %></h2></div>
			<div id="con"><h2><img src="./images/Phone.png"/><%out.println(bean.getContactno()); %></h2></div>
			<div id="email"><h3><img src="./images/email.png"/><%out.println(bean.getEmail()); %></h3></div>
		</div>
	</div>
	<div id="rightcon"></div>
	<% } %>
</div>
<div id="footerup"></div>
<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>
</div>

</body>
</html>