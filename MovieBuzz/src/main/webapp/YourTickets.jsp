<%@page import="com.module.Ticket"%>
<%@page import="java.util.List"%>
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

<%@ include file="nav2.jsp" %>
<%@ include file="cust.jsp" %>

<div class="home">
<div class="mov">
<%
int custid=(int)session.getAttribute("id");

List<Ticket> lst=db.getticketbycustid(id);

for(Ticket tkt : lst){
%>


<div class="onemovie">
<h3>TicketId</h3>
<h1>
<%=tkt.getTicketid()%>
</h1>

<h3><%=tkt.getGoldSeat()%></h3>

<h3><%=tkt.getSilverSeat()%></h3>

</div>


<%} %>

</div>
</div>
</body>
</html>