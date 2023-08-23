<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.module.Movie"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.DBhandler.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Movies_Buzz | Book Show</title>
  <link rel="stylesheet" href="style.css">
</head>
<body> 
<%@ include file="nav.jsp" %>
<div class="home">
<div class="mov">
<%
DbHandler d=new DbHandler();
List<Movie> lst=d.getallmov();
for(Movie m : lst){
%>
<div class="onemovie">
<h1><%=m.getMoviename()%></h1>
<img alt="" src='${pageContext.request.contextPath}/images/<%=m.getImagePath()%>'>
<h3><%=m.getDescrip()%></h3>
<h4>
<%  for(int a=1;a<=5;a++){
	if(a<=m.getRating()){
	%>
	<span class="fa fa-star checked"></span>
	<%
	}
	else{	
		%>
		<span class="fa fa-star"></span>
		<% 
	}
}  %>
</h4>
<h4>
In Cinema 
</h4>
<h4>
 from
 <%=m.getSTART_DATE()%>
</h4>
</div>
<%} %>
</div>
       </div>
</body>
</html>