<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.menuH {
	/* You will get totally diffrent menu alignment and layout by setting following margin, width, and float with different values.
    For detailed instruction please visit www.menucool.com/horizontal/change-menu-alignment  */
	margin: 0;
	width: 100%;
	float: none;
	/*following "behavior" works for IE6, IE7, and IE8. Other browsers will ignore it.*/
	/*Note: Unlike image file, htc file path is relative to the page, not this CSS file.*/
	behavior: url("/horizontal/menuh/cssmenu.htc");
	height: 36px;
	background: #D4D4D4 url(bg.gif) repeat-x 0 0;
	border: 1px solid #BBB;
	position: relative; /*! for IE htc*/
	z-index: 4; /*H2*/
	font-family: Arial, Helvetica, sans-serif;
	list-style: none;
	padding: 0;
}

.menuH li {
	padding: 0;
	/*margin: 0;
    display: block; TODO: I am testing them if they can be removed. If can, remove them.*/
	float: left;
	height: 36px;
	position: relative;
	/*move it into .menuH if you want submenu to be positioned relative to the whole menu instead of this li element*/
}

.menuH li:hover,.menuH li.onhover {
	background: white url(bg.gif) repeat-x 0 -48px;
}

ul.menuH a {
	padding: 0 30px;
	line-height: 36px;
	/*Note: keep this value the same as the height of .menuH and .menuH li */
	font-size: 12px;
	font-weight: bold;
	color: black;
	display: block;
	outline: 0;
	text-decoration: none;
}

.menuH a:hover {
	color: red;
}



/*Used to align a top-level item to the right*/
.menuH .menuRight {
	float: right;
	margin-right: 0px;
}

/*for the top-level separators*/
.menuH li.separator {
	font-size: 0;
	overflow: hidden;
	border-left: 1px solid #F7F7F7;
	border-right: 1px solid #BBBBBB;
}

/*######sub level###########*/
ul.menuH ul {
	width: 200px;
	position: absolute;
	left: -9999px;
	border: 1px solid #DDD;
	border-top: 0;
	background: #FFF;
	text-align: left;
	list-style: none;
	margin: 0;
	/*Following 1px(padding-right) will determine how much it is overlapped by the sub-sub-menu */
	padding: 0 1px 10px 0;
}

.menuH li li {
	float: none;
	white-space: nowrap;
	height: 26px;
}

.menuH li li:hover,.menuH li li.onhover {
	background: #f7f7f7;
}

.menuH ul a {
	padding: 0 20px;
	line-height: 26px;
	font-size: 0.9em;
	font-weight: normal;
	color: blue;
	text-align: left;
}

.menuH ul a:hover {
	color: red;
}

.menuH li:hover ul,.menuH li.onhover ul {
	left: -1px; /*Use this property to change offset of the dropdown*/
	top: auto;
}

.menuH li:hover .dropToLeft,.menuH li.onhover .dropToLeft {
	left: auto;
	right: -1px;
	top: auto;
}

.menuH ul ul {
	border-top: 1px solid #DDD;
}

.menuH li:hover ul ul,.menuH li:hover ul ul ul,.menuH li:hover ul ul ul ul,.menuH li.onhover ul ul,.menuH li.onhover ul ul ul,.menuH li.onhover ul ul ul ul
	{
	left: -9999px;
	top: 0;
}

.menuH li li:hover ul,.menuH li li li:hover ul,.menuH li li li li:hover ul,.menuH li li.onhover ul,.menuH li li li.onhover ul,.menuH li li li li.onhover ul
	{
	left: 200px;
}

/*####### special effects ##########*/
.decor1 {
	-moz-border-radius: 3px; /* Firefox */
	-webkit-border-radius: 3px; /* Safari and Chrome */
	border-radius: 3px;
	/* Opera 10.5+, future browsers, and now also our behavior htc file */
	-moz-box-shadow: 0px 1px 4px #eee; /* Firefox */
	-webkit-box-shadow: 0px 1px 4px #eee; /* Safari and Chrome */
	box-shadow: 0px 1px 4px #eee;
	/* Opera 10.5+, future browsers and IE6+ using our behavior htc file */
}

.menuH ul {
	-moz-border-radius: 0px 0px 4px 4px;
	-webkit-border-radius: 0px 0px 4px 4px;
	border-radius: 0px 0px 4px 4px;
	-moz-box-shadow: 0px 6px 6px #CCC;
	-webkit-box-shadow: 0px 6px 6px #CCC;
	box-shadow: 0px 6px 6px #CCC;
	/*for older IE browsers, the htc file fix will disable this feature when box-shadow was also applied.*/
	filter: alpha(opacity = 90);
	opacity: 0.90;
	/* Gradient background */
	background: -moz-linear-gradient(top, #FFFFFF, #EEEEEE);
	background: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FFFFFF),
		to(#EEEEEE));
}

.submit:HOVER {
	background-color: blue;
	color: red;
}

span{
	    border: 0px none;
    outline: 0px none;
    font-weight: inherit;
    font-style: inherit;
    font-size: 100%;
    
    vertical-align: baseline;
    margin: 0px;
    padding: 0px;
}

#logo {
	height: 160px;
	width: 509px;
	float: left;
	margin-left: 170px;
	margin-top: 10px;
}




#indexleftcolumn {
	height: 400px; width :200px;
	float: left;
	background: #39F;
}

#maindiv {
	width:1300;
	min-height: 100%;
	position: relative;
}

#header {
	height: 175px;
	width: 1300px;
	background: #0CF;
}
#hedderbelow {
	height:5px;
	background: #38F;
}


#left {
	height: 500px;
	width: 200px;
	float: left;
	background: white;
}

body {
	width: 1300px;
	text-align: center;
	margin: 10px auto;
	background-color: lightblue;
}
#middle1{
	width: auto;
	height: 500px;
	background: white;
}
#right {
	height: 500px;
	width: 200px;
	float: right;
	background: white;
}

#middle {
	height: 500px;
	width: 900px;
	float:left;
	background: #FFF;
	overflow: auto;
}
#footerup {
	height:5px;
	background: #38F;
	clear:left;
}
#footer {
	background: #0CF;
	height: 40px;
	clear: left;
}
#left1{
	height:500px;
	width:652px;
	float:left;
	background:white;
}
#leftcontainer{
	width:100px;
	float:left;
	height:500px;
	background: white;
}
#leftcontainer1{
	width:100px;
	float:left;
	height:500px;
	background:lightblue;
}

#rightcontainer{
	width:652px;
	float:left;
	height:500px;
	
}
#right1{
	height:500px;
	width:648px;
	float:left;
	background:white;
}
.menuH ul input:HOVER {
	color: red;
}
.myButton {
	-moz-box-shadow:inset -1px 1px 17px 1px #54a3f7;
	-webkit-box-shadow:inset -1px 1px 17px 1px #54a3f7;
	box-shadow:inset -1px 1px 17px 1px #54a3f7;
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #007dc1), color-stop(1, #0061a7));
	background:-moz-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background:-webkit-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background:-o-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background:-ms-linear-gradient(top, #007dc1 5%, #0061a7 100%);
	background:linear-gradient(to bottom, #007dc1 5%, #0061a7 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#007dc1', endColorstr='#0061a7',GradientType=0);
	background-color:#007dc1;
	-moz-border-radius:7px;
	-webkit-border-radius:7px;
	border-radius:1px;
	border:1px solid #124d77;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:arial;
	font-size:27px;
	font-weight:bold;
	padding:15px 40px;
	text-decoration:none;
	text-shadow:1px 0px 12px #154682;
	margin-top:75px;
	margin-right:100px;
	float:right;
}
.myButton:hover {
	background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #0061a7), color-stop(1, #007dc1));
	background:-moz-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background:-webkit-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background:-o-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background:-ms-linear-gradient(top, #0061a7 5%, #007dc1 100%);
	background:linear-gradient(to bottom, #0061a7 5%, #007dc1 100%);
	filter:progid:DXImageTransform.Microsoft.gradient(startColorstr='#0061a7', endColorstr='#007dc1',GradientType=0);
	background-color:#0061a7;
}
.myButton:active {
	position:relative;
	top:1px;
}
.ina-free-flag {
    text-indent: -9999px;
    background: url('free.png') no-repeat scroll center bottom transparent;
    position: absolute;
    margin-top: -20px;
    width: 60px;
    height: 61px;
    margin-left: -14px;
}

.btnlogin {
  -webkit-border-radius: 0;
  -moz-border-radius: 0;
  border-radius: 0px;
  font-family: Arial;
  color: #ffffff;
  font-size: 19px;
  background: #3498db;
  padding: 10px 20px 12px 20px;
  text-decoration: none;
}

.btnlogin:hover {
  background: #3cb0fd;
  text-decoration: none;
}


</style>
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
<title>Untitled Document</title>
</head>
<body>
<div id="maindiv">
<form name="main" action="fileuploadservlet">
<div style="text-align: right; margin-right: 20px;">
<% 
	String uname="";
	String reg;
	uname=(String)session.getAttribute("username");
	reg=(String)session.getAttribute("reg_id");
	if(uname!=null){
		%><a href="fileuploadservlet?btnmobile=true&regid=<%=reg%>">My Adds</a><%
		out.println(" Welcome   "+uname);%><a href="addPostservlet?adminlogout=true"> Logout</a><% 	
				
	}
	else{
		
		out.println("Welcome Guest");%><a href="meruLogintaru.jsp"> Login </a>
		
		<% }%>    
		</div>
    <div id="header" ><a href="Admin/homeadmin.jsp"><img src="./images/logo1.gif" id="logo" alt="GharBazar.com"></a> 
    <% 

	if(uname!=null){
		%><a href="Admin/homeadmin.jsp" class="myButton">Post Your Ads Here<span class="ina-free-flag">Free</span></a><% 	
				
	}
	else{
		%>
		<a href="marulogintaru.jsp" class="myButton">Post Your Ads Here<span class="ina-free-flag">Free</span></a><% 	
		
	 }%>   
     
     
     </a>     
     </div>
<div id="hedderbelow"></div>
     <div id="left"></div>
     <div id="middle">
     <br><br>
     <table cellpadding="8" vspace="2%" align="center"  width="200" border="0" cellspacing="0" >
  <tr>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Home and Life Sytle</a>
        <ul>
            <li><a href="./maruadmintaru?health=true&uname=<%=uname %>" >Health and Beauty Fitness</a></li>
            <li><a href="./maruadmintaru?therapy=true&uname=<%=uname%>">Therapy</a></li>
            <li><a href="./maruadmintaru?doctor=true&uname=<%=uname%> ">Doctor's Details</a></li>
            <li><a href="./maruadmintaru?babysitter=true&uname=<%=uname%>">Babysitter</a></li>
            
        </ul>
    </li>
</ul>
  <img src="images/electronics and technology/images.jpg" height="150" width="200" /> </td>
    <td>
	<ul class="menuH decor1">

    <li><a href="#2" class="arrow">Mobiles</a>
        <ul>
        	
            <li><a href="./maruadmintaru?mobile=true&uname=<%=uname%>">Mobiles</a></li>
            <li><a href="./maruadmintaru?mobileaccessories=true&uname=<%=uname%>">Mobile Accessories</a></ul>
            
    </li>
    
</ul>
  <img src="images/mobile/1.jpg" height="150" width="200" /> </ul></td>
    <td><ul class="menuH decor1">

    <li><a href="./maruadmintaru?view=1" class="arrow" >View Users</a>
   
    </li>
</ul>
  <img src="images/jobs/images (3).jpg" height="150" width="200" /> </ul></td>
  </tr>
  <tr>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Vehicles</a>
        <ul>
            <li><a href="./maruadmintaru?vehicles=true&uname=<%=uname%>">Vehicles</a></li>
            <li><a href="./maruadmintaru?vehicleaccessories=true&uname=<%=uname%>">Vehicle Accessories</a></li>
        </ul>
    </li>
</ul>
  <img src="images/vehicles/images (2).jpg" height="150" width="200" /></td>
    <td>
	<ul class="menuH decor1">

    <li><a href="#2" class="arrow">Electronics</a>
        <ul>
            <li><a href="./maruadmintaru?itperipherals=true&uname=<%=uname%>">IT Peripherals</a></li>
            <li><a href="./maruadmintaru?tcm=true&uname=<%=uname%>">TV, Camera & Multimedia</a></li>
            <li><a href="./maruadmintaru?homeapp=true&uname=<%=uname%>">Home Appliances</a></li>
            <li><a href="./maruadmintaru?industrial=true&uname=<%=uname%>">Industrial Machinery Tools</a></li>
            <li><a href="./maruadmintaru?ele_others=true&uname=<%=uname%>">Others</a></li>
        </ul>
    </li>
</ul>
  <img src="images/electronics and technology/images (5).jpg" height="150" width="200" /> </td>
    <td><ul class="menuH decor1">

    <li><a href="#2" class="arrow">Real Estate</a>
        <ul>
            <li><a href="./maruadmintaru?rrent=true&uname=<%=uname%>">Rent</a></li>
            <li><a href="./maruadmintaru?rbuy=true&uname=<%=uname%>">Buy</a></li>
        </ul>
    </li>
</ul>
  <img src="images/real estate/images (3).jpg" height="150" width="200" /></td>
  </tr>
</table>
     
     </div>
	<div id="right"></div>
	<div id="footerup"></div>
	<div id="footer">All Rights Reserved &copy;&nbsp;2014&nbsp;|&nbsp;<a class='ajax'  class="ahover" href="aboutUs.jsp" title="GharBazar" style="text-decoration: none;">About Us</a>&nbsp;|&nbsp;
	<a class='ajax'  class="ahover" href="privacyPolicy.jsp" title="GharBazar" style="text-decoration: none;">Privacy Policy</a></div>
  
</form>
</div>
</body>
</html>