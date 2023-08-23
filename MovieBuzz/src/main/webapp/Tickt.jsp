<%@page import="com.module.Ticket"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.module.Seatbooked"%>
<%@page import="com.DBhandler.DbHandler"%>
<%@page import="java.util.LinkedHashSet"%>
<%@page import="java.util.Set"%>
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

<%@include file="nav2.jsp"%>
<%@include file="cust.jsp"%>
<div class="home">
<% HttpSession s=request.getSession(false);
int tktid=(int)s.getAttribute("tktid");
Ticket t=db.getTicketbyid(tktid);
%>


<div class="ticket">
  <div class="ticket__content">
   <h2>Ticket Id :
   <%=t.getTicketid()%>
   </h2>
  <hr>
  <h2>Movie Name :
   <%=t.getSeatbookedid().getMovieid().getMoviename()%>
   </h2>
 
   <h3>
   Date of show :
   	<%=t.getSeatbookedid().getDateToShow() %>
   </h3>
   <h3>
   Timing of Show :
   	<%=t.getSeatbookedid().getSlotsOfShow() %>
   </h3>
      <h3>
   Silver Seats :
   	<%=t.getSilverSeat() %>
   </h3>
         <h3>
   Gold Seats :
   	<%=t.getGoldSeat() %>
   </h3>
         <h3>
  Total Billing Amount:
   	<%=t.getTotalPrize() %>
   </h3>
   
   
   
   
  </div>
</div>


</div>






</body>
</html>