<%@page import="com.module.Seatbooked"%>
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
width:50vw;
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
List<Seatbooked> Seatboklist = db.getseatbookedbymovieid(Integer.parseInt(request.getParameter("id")));
%>


<center>
<table class="zigzag">
  <thead>
    <tr>
      <th class="header">SBid</th>
      <th class="header">DateToShow</th>
      <th class="header">SlotsOfShow</th>
      <th class="header">SilverSeatsBooked</th>
      <th class="header">GoldSeatsBooked</th>
      <th class="header">SlverAvlSeats</th>
      <th class="header">GoldAvlSeats</th>
    </tr>
  </thead>
  <tbody>
  <% for(Seatbooked movie:Seatboklist){ %>
    <tr>
      <td><%=movie.getSeatBookedid()%></td>
      <td><%=movie.getDateToShow() %></td>
      <td><%= movie.getSlotsOfShow() %></td>
      <td><%=movie.getSilverSeatsBooked() %></td>
      <td><%=movie.getGoldSeatsBooked() %></td>
      <td><%=movie.getSlverAvlSeats() %></td>
<td><%=movie.getGoldAvlSeats() %></td>   
 </tr>
   </tbody>
   <%} %>
   
</table>
</center>

</div>
</body>
</html>