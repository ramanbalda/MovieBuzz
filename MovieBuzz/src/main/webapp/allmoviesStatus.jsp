<%@page import="com.module.Movie"%>
<%@page import="java.util.List"%>
<%@page import="com.DBhandler.DbHandler"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Movies</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<%@ include file="adminlayout.jsp" %>
<style>
table h1 {
  color:#c00;
  font-family:sans-serif;
  font-size:2em;
  margin-bottom:0;
}

table {  
  font-family:sans-serif;
}
  th, td {
    padding:.25em .5em;
    text-align:left;
  }
    table  th,td:nth-child(2) {
      text-align:right;
    }
 
  table td {
    background-color:#eee;    
  }
 table  th {
    background-color:#009;
    color:#fff;
  }

.zigzag {
  border-collapse:separate;
  border-spacing:.25em 1em;
}

button a{
text-decoration: none;
color:#000;
}

button{
border:none;
width: max-width;
}


</style>

<div class="home">


<%DbHandler db=new DbHandler();
List<Movie> movielist = db.getallmov();
%>


<center>
<h1>All Movies Status</h1>
<table class="zigzag">

  <thead>
    <tr>
      <th class="header">movieid</th>
      <th class="header">moviename</th>
      <th class="header">Rating</th>
      <th class="header">START_DATE</th>
      <th class="header">End_Date</th>
      <th class="header">AvlLang</th>
    </tr>
  </thead>
  <tbody>
  <% for(Movie movie:movielist){ %>
    <tr>
      <td><%=movie.getMovieid()%></td>
      <td><%=movie.getMoviename() %></td>
      <td><%= movie.getRating() %></td>
      <td><%=movie.getSTART_DATE() %></td>
      <td><%=movie.getEND_DATE() %></td>
      <td><%=movie.getAvlLang() %></td>
    <td>  <button><a href="totalSeats.jsp?id=<%=movie.getMovieid()%>">  Check Status</a> </button></td>
    </tr>
   </tbody>
   <%} %>
   
</table>
</center>

</div>
</body>
</html>