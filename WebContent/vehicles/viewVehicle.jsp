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
<script type="text/javascript">
function validate()
{
	
	var chk1=document.getElementById("chk1").checked;
	var chk2=document.getElementById("chk2").checked;
	var chk3=document.getElementById("chk3").checked;
	var chk4=document.getElementById("chk4").checked;
	var chk5=document.getElementById("chk5").checked;
	var chk6=document.getElementById("chk6").checked;
	var chk7=document.getElementById("chk7").checked;
	var chk8=document.getElementById("chk8").checked;
	var chk9=document.getElementById("chk9").checked;
	var chk10=document.getElementById("chk10").checked;
	var chk11=document.getElementById("chk11").checked;
	var chk12=document.getElementById("chk12").checked;
	var chk13=document.getElementById("chk13").checked;
	
	
	
		
		if(chk1||chk2||chk3||chk4||chk5||chk6||chk7||chk8||chk9||chk10||chk11||chk12||chk13)
			
		{
			
			return true;
		}
	else
		{
		document.getElementById("warning").innerHTML="please select any value";
		return false;
		}
}
</script>
</head>

<body>

<div style="text-align: right;margin-right: 20px;">
<% 
	String uname="";
	String reg;
	uname=(String)session.getAttribute("username");
	reg=(String)session.getAttribute("reg_id");
	if(uname!=null){
		%><a href="myaddservlet?myadd=true&regid=<%=reg%>">My Adds</a><%
		out.println(" Welcome   "+uname);%><a href="addPostservlet?logout=true"> Logout</a><% 	
				
	}
	else{
		
		out.println("Welcome Guest");%><a href="seller/loginSeller.jsp"> Login </a>
		
		<% }%>  
</div>

<script type="text/javascript" src="lightbox.js"></script>
<form name="frmvehicle" action="vehicleservlet">
<div id="header" >
<a href="Admin/homeadmin.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a>


<%
    if(uname!=null){%>
    	<a href="addPostservlet?post=<%=uname%>
    	" class="myButton">Post Your Ads Here
    		     <span class="ina-free-flag">Free</span>
    		     </a> <%    
    		     	
    }
    else{
    	%>
    	<a href="seller/loginSeller.jsp" class="myButton">Post Your Ads Here
    		     <span class="ina-free-flag">Free</span>
    		     </a> <%   
    }
    %>
     </div>
     <div id="hedderbelow"></div>
     <div id="left">
     <table width="200" border="0">
      <tr>
     <td><a id="warning"></a></td>
     </tr>
  <tr>
    <td><b>Vehicle</b></td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk1" name="chkmobile" value="Buy">Buy</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk2" name="chkmobile" value="Sell" >Sell</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk3" name="chkmobile" value="Vehicles" >Vehicles</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk4" name="chkmobile" value="VehicleAccessories" >Vehicle Accessories</td>
  </tr>
 
  
  <tr>
      <td><input type="checkbox" id="chk5" name="chkmobile" value="All">All</td>
	</tr>
<tr>
  	<td align="center"><input type="submit" value="Find" name="btnfind" onclick="return validate();"></td>
  </tr>
  
<tr>
<td><hr size="3" color="black"></td>
</tr>
	<tr>
	
    <td>PRICE RANGE</td>
  </tr>
    <tr>
    <td><input type="checkbox" id="chk6" name="chkprice" value="2000">&#x20b9;&nbsp;2000 and Below</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk7" name="chkprice" value="2001">&#x20b9;&nbsp;2001 - &#x20b9;&nbsp;5000</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk8" name="chkprice" value="5001">&#x20b9;&nbsp;5001 - &#x20b9;&nbsp;10000</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk9" name="chkprice" value="10001">&#x20b9;&nbsp;10001 - &#x20b9;&nbsp;18000</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk10" name="chkprice" value="18001">&#x20b9;&nbsp;18001 - &#x20b9;&nbsp;25000</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk11" name="chkprice" value="25001">&#x20b9;&nbsp;25001 - &#x20b9;&nbsp;35000</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk12" name="chkprice" value="35001">&#x20b9;&nbsp;35001 and Above</td>
  </tr>
  <tr>
    <td><input type="checkbox" id="chk13" name="chkpriceall" value="all">ALL</td>
  </tr>
  <tr>
    <td><input type="submit" name="btnpfind" value="Find" onclick="return validate();"></td>
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
			<h3 style="text-align: left; padding:10px;">  <a href="./productInfoservlet?productinfovehicle=<%=s1.getS_id()%>"><%out.println(s1.getProductname()); %></a>  </h3>
		</div>
		<div style="width:380px; height:46px; float:left; margin:2px;">
			<h4 style="text-align: left; padding:10px;"><%out.println(s1.getLocation()); %> &nbsp; |&nbsp; <% out.println(s1.getCity());%>&nbsp; | &nbsp;Vehicles</h4>
		</div>
	</div>
	<div style="width:156px;height:136px;float:left;margin:2px;"><br><br>
		<h3>&#x20b9;&nbsp;<%out.println(s1.getPrice()); %></h3>
	</div>
	<div style="width:194px;height:136px;float:left;margin:2px;"><br><br>
		<h3><%out.println(s1.getSelling_date()); %></h3>
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

<div id="right"></div>
<div id="footerup"></div>
<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>	



</form>
</body>
</html>