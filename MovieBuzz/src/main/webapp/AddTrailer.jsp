<%@page import="com.module.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.DBhandler.DbHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">

</head>
<body>
<%@ include file="nav.jsp" %>
<%@ include file="adminlayout.jsp" %>
<% DbHandler db=new DbHandler(); 
List<Movie> lst=db.getallmov();
%>
<div class="main">
<div class="movfom">
<div class="fm">
  <div class="form-row">
<form action="SaveUrl">
 <div class="col-5">
    <label for="inputState" class="form-label">Select Movie</label>
    <select id="inputState" name="movie" class="form-select">
 
      <option selected>Choose...</option>
   
    <%
      	for(Movie at:lst)
      	{
      		%>
      		<option value=<%=at.getMovieid()  %>><%=at.getMoviename()%></option>
      		<%
      	}
      %>
   
   
    </select>
     
  </div>
 <div class="col-5">
    <label for="txtAccNo" class="form-label">Url</label>
    <input type="text" class="form-control" name="Movie_Url" placeholder="Enter Url Name" >
 </div>
<div class="col-5">
   <button type="submit">Submit</button>
 </div>
</form>
</div>
</div>
</div>
</div>
</body>
</html>