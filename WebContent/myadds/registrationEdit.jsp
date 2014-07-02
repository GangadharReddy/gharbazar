<%@page import="beans.registrationBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form name="frmregistrationedit" action="registrationservlet">
      <center>
        <table border="1" cellpadding="5" width="30%">
          <thead>
            <tr>
              <th colspan="2">Update Information Here</th>
            </tr>
          </thead>
          <tbody>
          <tr>
          <%registrationBean rbean=new registrationBean();
          rbean=(registrationBean)request.getAttribute("rbean");
          %>
          	<td>Registration No</td>
          	<td><input type="text" readonly="readonly" name="txtreg_no" value="<%= rbean.getReg_no()  %>"></td>
            <tr>
              <td>First Name</td>
              <td><input name="txt_fname" value="<%=rbean.getFname() %>" type="text"></td>
            </tr>
            <tr>
              <td>Last Name</td>
              <td><input name="txt_lname" value="<%=rbean.getLname() %>" type="text"></td>
            </tr>
            <tr>
              <td>Email</td>
              <td><input name="txt_email" value="<%=rbean.getEmail() %>" type="email" readonly="readonly"></td>
            </tr>
            <tr>
              <td>Mobile No.</td>
              <td><input name="txtmobile_no" value="<%=rbean.getMobile() %>" type="tel"></td>
            </tr>
            <tr>
              <td><input name="btnupdate" value="Update" type="submit"></td>  
            </tr>
          </tbody>
        </table>
      </center>
    </form>
</body>
</html>