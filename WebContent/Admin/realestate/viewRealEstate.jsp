             <%@page import="servlets.fileuploadservlet"%>
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

	
	<link rel="stylesheet" href="css_files/screen.css" media="screen"/>
	<link rel="stylesheet" href="css_files/lightbox.css" media="screen"/>

<link rel="stylesheet" type="text/css" href="css_files/drop_down_menu.css" />
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

<script type="text/javascript" src="lightbox.js"></script>
<form name="frmrealestate" action="./maruadmintaru">
<div id="header" ><input type="submit" value="Delete" name="btndeletereal">
<a href="Admin/homeadmin.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a>
<a href="seller/loginSeller.jsp" class="myButton">Post Your Ads Here
     <span class="ina-free-flag">Free</span>
     </a>  
</div>
<div id="hedderbelow"></div>
     <div id="left">
     <table width="200" border="0">
  <tr>
    <td><b>Real-Estate TYPES</b></td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Sell">Sell</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Rent" >Rent</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Residential" >Residential</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Commercial" >Commercial</td>
  </tr>
  
  <br><br>
  <tr>
      <td><input type="checkbox" name="chkmobile" value="All">All</td>
	</tr>
<tr>
  	<td align="center"><input type="submit" value="Find" name="btnrfind"></td>
  </tr>
  
<tr>
<td><hr size="3" color="black"></td>
</tr>
	<tr>
	
    <td>PRICE RANGE</td>
  </tr>
    <tr>
    <td><input type="checkbox" name="chkprice" value="2000">Rs. 2000 and Below</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="2001">Rs. 2001 - Rs. 5000</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="5001">Rs. 5001 - Rs. 10000</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="10001">Rs. 10001 - Rs. 18000</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="18001">Rs. 18001 - Rs. 25000</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="25001">Rs. 25001 - Rs. 35000</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkprice" value="35001">Rs. 35001 and Above</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkpriceall" value="all">ALL</td>
  </tr>
  <tr>
    <td><input type="submit" name="btnprfind" value="Find"></td>
  </tr>

</table>
     </div>
     

<div id="middle">
Content goes here
<table width="883" border="1" >
<%List<sellerBean> view=new ArrayList(); 
view=(List)request.getAttribute("viewseller");
int i;
for(i=0; i<view.size(); i++){
	sellerBean s1= new sellerBean();
	s1=view.get(i);
	%>
	<%String a=s1.getImagepath1(); %>
	<tr>
    <td width="162">
    
    
    <a class="example-image-link" href=<%=a%> rel="lightbox" title=<%out.println(s1.getProductname()); %>>
    <img class="example-image" src=<%=a%> name=<%out.println(s1.getProductname()); %> width="150" height="150"/></a>
    
    
    
    
     </td>
    <td width="400">&nbsp;
      <table width="400" height="137" border="1">
  <tr>
    <td height="57"><h3>  <a href="./productInfoservlet?productinforealadmin=<%=s1.getS_id()%>"><%out.println(s1.getProductname()); %></a>  </h3></td>
  </tr>
  <tr>
    <td><%out.println(s1.getLocation()); %>  | <% out.println(s1.getCity());%> | Real Estate</td>
  </tr>
</table>
</td>
    <td width="171"><%out.println(s1.getPrice()); %></td>
    <td width="40"><%out.println(s1.getSelling_date()); %></td>
     <td width="20"><input type="checkbox" name="chkview" value=<%=s1.getS_id()%>></td>
  </tr>
  	<%
}
%>
  
</table>
<script src="jquery-1.10.2.min.js"></script>
	<script src="lightbox-2.6.min.js"></script>

	<script>
	var _gaq = _gaq || [];
	_gaq.push(['_setAccount', 'UA-2196019-1']);
	_gaq.push(['_trackPageview']);

	(function() {
		var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	})();
	</script>
</div>

<div id="right"></div>
<div id="footerup"></div>
<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a><input type="submit" value="Delete" name="btndeletereal"></div>	



</form>
</body>
</html>