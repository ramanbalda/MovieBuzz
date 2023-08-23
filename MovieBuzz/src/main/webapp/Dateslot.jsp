<%@page import="com.Serv.AddMovie"%>
<%@page import="com.module.Movie"%>
<%@page import="com.module.Seatbooked"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.Date"
import="java.util.concurrent.TimeUnit"%>
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
<div class="mov">
<form action="Getseatbooked" method="post">
<h2>Select Date Of Show</h2>
<div class="datesel">
<select onchange="Time()" name="dt">
<option >Choose..</option>

<%
int mid=Integer.parseInt(request.getParameter("movieid"));

Movie mov= db.getMoviebyMovieid(mid);




long days = AddMovie.getDateDiff (mov.getSTART_DATE(), mov.getEND_DATE(), TimeUnit.DAYS);
int j;
Date DateToShow=mov.getSTART_DATE();
for(j=0;j<=days;j++)
{
	

 
%>

<option value=<%=DateToShow%>>
<%=DateToShow%>
</option>
<% 	 DateToShow = AddMovie.addDays(mov.getSTART_DATE(),1);
}  %>
</select>
</div>
<div class="timeofshow" id="time">
<h2>Select Sloat for Show</h2>

<select onchange="fun()" name="time">

<% if(mov.getSlot9to12()==null){
	
} 
else if(mov.getSlot9to12().equals("True")){
	%> <option>9Am</option> <%
}
%>
<% if(mov.getSlot12to15()==null){
	
}
else if(mov.getSlot12to15().equals("True")){
	%>  <option>12Noon</option> <%
}
%>
<% if(mov.getSlot15to18()==null){
	
} 
else if(mov.getSlot15to18().equals("True")){
	%> <option>3Pm</option><%
}
%>
<% if(mov.getSlot18to21()==null){

}else if(mov.getSlot18to21().equals("True")){
	%> <option>6Pm</option><%
} %>

</select>

<br>
<br>

<div class="onemovie">
<input type="submit" class="btn">
</div>

</div>

</form>
</div>
</div>
<script type="text/javascript">
function Time() {
	 document.getElementById("time").style.display = "block";
}
function fun() {
	// document.getElementById("time").style.display = "block";

}


</script>



</body>
</html>