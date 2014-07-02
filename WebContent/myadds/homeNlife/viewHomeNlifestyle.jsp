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
<form name="frmhealth" action="myaddservlet">
<div id="header" >
<a href="./homepage.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a>
</div>

<div id="hedderbelow"></div>
    <div id="left">
     <table width="200" border="0">
  <tr>
    <td><b>Service Type</b></td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Health-BeautyFitness">Health-BeautyFitness</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Therapy" >Therapy</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="DoctorDetails" >DoctorDetails</td>
  </tr>
  <tr>
    <td><input type="checkbox" name="chkmobile" value="Babysitter" >Babysitter</td>
  </tr>
 
  <br><br>
  <tr>
      <td><input type="checkbox" name="chkmobile" value="All">All</td>
	</tr>
<tr>
  	<td align="center"><input type="submit" value="Find" name="btnfind"></td>
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
    <td><input type="submit" name="btnpfind" value="Find"></td>
  </tr>

</table>
     </div>
     

<div id="middle">
<div style="width:890px; height:140px;margin:5px;float:left;">
	<%List<sellerBean> view=new ArrayList(); 
view=(List)request.getAttribute("viewseller");
int i;
for(i=0; i<view.size(); i++){
	sellerBean s1= new sellerBean();
	s1=view.get(i);
	%>
	<%String a=s1.getImagepath1(); %>
	<div style="width:890px; height:140px;float:left;border-bottom: 2px solid #D4DFAA;">	
	<div style="width:134px;height:134px;float:left;margin:3px;">
		<a class="example-image-link" href=<%=a%> rel="lightbox" title=<%out.println(s1.getProductname()); %>>
    	<img class="example-image" src=<%=a%> name=<%out.println(s1.getProductname()); %> width="125" height="125"/></a>
	</div>	
	<div style="width:384px; height:134px; float:left; margin:3px;">
		<div style="width:380px;height:80px;float:left; margin:2px;"><br><br>
			<h3 style="text-align: left; padding:10px;"> <a href="./productInfoservlet?productinfohealthadmin=<%=s1.getS_id()%>"><%out.println(s1.getProductname()); %></a>  </h3>
		</div>
		<div style="width:380px; height:46px; float:left; margin:2px;">
			<h4 style="text-align: left; padding:10px;"><%out.println(s1.getLocation()); %> &nbsp; |&nbsp; <% out.println(s1.getCity());%>&nbsp; | &nbsp;Home and Life Style</h4>
		</div>
	</div>
	<div style="width:136px;height:136px;float:left;margin:2px;"><br><br>
		<h3>&#x20b9;&nbsp;<%out.println(s1.getPrice()); %></h3>
	</div>
	<div style="width:174px;height:136px;float:left;margin:2px;"><br><br>
		<h3><%out.println(s1.getSelling_date()); %></h3>
	</div>
	<div style="width:40px; height:136px; float:left;text-align: left;"><br><br>
		<input type="checkbox" name="chkview" value=<%=s1.getS_id()%>>
	</div>
	</div>
	<%}%>
</div>

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
<tr>
  	<td></td>
  	</tr>
<div id="right"><br><br><input type="submit" value="Delete" name="btndelete" style="background:blue;border-radius:5px; height:30px;width:80px; color:white;border:2px solid blue;"> </div>
V<div id="footerup"></div>
<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>



</form>
</body>
</html>