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
<link rel="stylesheet" type="text/css" href="css_files/productInfo.css" />
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
<%List<sellerBean> viewdata=new ArrayList();
viewdata=(List)request.getAttribute("product");
%>

<form>
<div id="header">
<a href="#"><img src="#" id="logo" alt="Affable Bean logo"></a>
<img src="#" id="logoText" alt="GharBazaar.com">
</form>
<input type="button"   id="btnpostyouradds" value="post your adds here" style="font-size:24px;"/>
</div>
 <div id="left" >
     
     </div>
     
<%
int i;
for(i=0;i<viewdata.size();i++){
	sellerBean bean=new sellerBean();
	bean=viewdata.get(i);
%>
<div id="middle">
<a href="productinfoservlet?back=1">Back
	<div id="middleupper"><div id="middleupperleft"></div></a><div id="middleuppermiddle"><a href="homeadmin.jsp">Home > </a><a href="./maruadmintaru?mobile=1">Mobiles > </a><a href="#"><%out.println(bean.getProductname()); %></a></div><div id="middleupperright"><a href="./productInfoservlet?prev=<%=bean.getS_id()%>">Prev. Ad  </a>  <a href="./productInfoservlet?next=<%=bean.getS_id()%>">   Next Ad</a></div></div>
	<div id="productinfo" style="background: gray;">
		<div id="productname" ><%out.println(bean.getProductname());%><br><br><% out.println(bean.getLocation()); %>  |  <%out.println(bean.getDetails());%>  |  <%out.println(bean.getMobiletype()); %></div>
		<div id="price"><%out.println(bean.getPrice()); %></div>
	</div>
	<div id="image"><img src=<%=bean.getImagepath1() %> style="height: 300px;width: 600px;"></div>
	<div id="information">
		<div id="informationleft"></div>
		<div id="informationmiddle">
			<div align="left">
				<ul id="olinfo">
					<li><%out.println(bean.getFname());%>  <%out.println(bean.getLname()); %></li>
					<li><%out.println(bean.getContactno()); %></li>
					<li><%out.println(bean.getEmail()); %></li>
					
				</ul>
			</div>
		</div>
			
		<div id="informationright"></div>
	</div>
	
  

</div>
<% } %>
<div id="right"></div>
<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>	




</body>
</html>