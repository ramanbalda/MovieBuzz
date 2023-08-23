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
<%DbHandler db=new DbHandler();
int movieeid=Integer.parseInt(request.getParameter("movid"));
System.out.println("movie id is "+movieeid);
db.removemovie(movieeid); %>


<div class="home">
<center>
<h1>Movie Deleted Successfully</h1>
</center>
</div>
</body>
</html>