<%@page import="com.module.Movie"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
<link rel="stylesheet" href="style.css">
<style type="text/css">
.trailer{
	z-index: -5;
	margin-left: 50%;
}
.dtl{
position: absolute;
top: 12%;
left: 2%;
}



</style>
</head>
<body>


<%@include file="nav2.jsp"%>
<%@include file="cust.jsp"%>

<div class="home">

<div class="smov">
<% int movieid=Integer.parseInt(request.getParameter("movieid")); %>
<% DbHandler dbh= new DbHandler(); 
Movie mov = dbh.getMoviebyMovieid(movieid);
HttpSession se=request.getSession(false);
se.setAttribute("movid", movieid);

if(mov.isAdultMovie()==true){
%>
<script type="text/javascript">

function admov(){
	Swal.fire({
		  title: 'Are you sure?',
		  text: "This Movie is for 18+",
		  icon: 'warning',
			  confirmButtonText: 'Yes, I am 18+',
			  focusConfirm: false,
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		}).then((result) => {
		  if (result.isConfirmed) {
			document.getElementById("seatform").submit();
		  }
		  else{
			  window.location.href = "allmovies.jsp";
		  }
		})
	}

admov();


</script>
<%} if(mov.getTrailerUrl()!=null){%>

<iframe class="trailer"  width="50%" height="400"
src=<%=mov.getTrailerUrl() %>>
</iframe>

<%} %>
<div class="dtl">
    <h1>
        <%=mov.getMoviename() %>
    </h1>
<p>About Movie -> <%=mov.getDescrip()%></p>
<p>Rating -> <%=mov.getRating()%></p>
<p>Release Year -><%=mov.getReleaseYear()%></p>
<p>In Language -> <%=mov.getAvlLang()  %></p>
<p>Available Till -> <%=mov.getEND_DATE() %></p>
<p>Time of Show ->
<% if(mov.getSlot9to12()==null){
	
} 
else if(mov.getSlot9to12().equals("True")){
	%> 9Am<%
}
%>
<% if(mov.getSlot12to15()==null){
	
}
else if(mov.getSlot12to15().equals("True")){
	%> 12Noon<%
}
%>
<% if(mov.getSlot15to18()==null){
	
} 
else if(mov.getSlot15to18().equals("True")){
	%> 3Pm<%
}
%>
<% if(mov.getSlot18to21()==null){

}else if(mov.getSlot18to21().equals("True")){
	%>6Am<%
} %>


</p>
<div class="onemovie">
<a href="Dateslot.jsp?movieid=<%=mov.getMovieid()%>" class="btn">Book Your Show</a>
</div>
</div>
</div>





</div>








</body>
</html>