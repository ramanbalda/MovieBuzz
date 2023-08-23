<%@page import="com.module.Usertbl"%>
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


<%
DbHandler dbHandler =new DbHandler();
List<Usertbl> lst=dbHandler.getalluser();

%>


<center>
<h1>All Chat</h1>
<table class="zigzag">

  <thead>
    <tr>
      <th class="header">User Name</th>
    </tr>
  </thead>
  <tbody>
  <% for(Usertbl movie:lst){ %>
    <tr>
      <td><%=movie.getUsernm()%></td>
    <td>  <button><a href="ChatAdmin.jsp?id=<%=movie.getUserid()%>">Let's Chat</a> </button></td>
    </tr>
   </tbody>
   <%} %>
   
</table>
</center>

</div>
</body>
</html>