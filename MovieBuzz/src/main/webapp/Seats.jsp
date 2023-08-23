<%@page import="com.module.Movie"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="java.sql.Date"%>
<%@page import="javax.xml.crypto.Data"%>
<%@page import="com.module.Seatbooked"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="style.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script src="sweetalert2.min.js"></script>
<link rel="stylesheet" href="sweetalert2.min.css">
</head>
<body>
<%@include file="nav2.jsp"%>
<%@include file="cust.jsp"%>
<%
HttpSession se=request.getSession(false);
int sbid=(int)se.getAttribute("sbid");
Seatbooked sb=db.getSeatBookedbyid(sbid);
String Gseat=sb.getGoldSeatsBooked();
String Sseat=sb.getSilverSeatsBooked();
String[] arrOfGol=null;
String[] arrOfSil=null;
Movie m=sb.getMovieid();
%>
<div class="screen">
    <img src="images/scr.jpg" alt="">
</div>
<div class="home">
<form action="TicketBook" method="post" id="seatform">
<div class="singlr">
<%for(int a=1;a<=20;a++){ %>
<label class="check">
 <input type='checkbox'  name='Silver' class="Silver"  value="S<%=a%>" id="S<%=a%>">
 <span>S<%=a  %></span>
 </label>
 <%} %>
 </div>
 <div class="singlr">
<%for(int a=21;a<=40;a++){ %>
<label class="check">
 <input type='checkbox'  name='Silver' class="Silver" value="S<%=a%>" id="S<%=a%>">
 <span>S<%=a  %></span>
 </label>
 <%} %>
 </div><div class="singlr">
<%for(int a=41;a<=60;a++){ %>
<label class="check">
 <input type='checkbox'  name='Silver' class="Silver" value="S<%=a%>" id="S<%=a%>">
 <span>S<%=a  %></span>
 </label>
 <%} %>
  </div>
 <div class="singlr">
<%for(int a=1;a<=20;a++){ %>
<label class="check2">
 <input type='checkbox'  name='Gold'  value="G<%=a%>"  class="Gold" id="G<%=a%>">
 <span>G<%=a  %></span>
 </label>
 <%} %>
 </div>
 <div class="singlr">
<%for(int a=21;a<=40;a++){ %>
<label class="check2">
 <input type='checkbox'  name='Gold' value="G<%=a%>" class="Gold" id="G<%=a%>">
 <span>G<%=a  %></span>
 </label>
 <%} %>
 </div><div class="singlr">
<%for(int a=41;a<=60;a++){ %>
<label class="check2">
 <input type='checkbox'  name='Gold'  value="G<%=a%>" class="Gold" id="G<%=a%>">
 <span>G<%=a  %></span>
 </label>
 <%} %>
 </div>
 <div class="singlr">
<label class="check2">
 <input type='checkbox'>
 <span>Gold Prize :<%=m.getGold_PRIZE() %></span>
 </label>
 <label class="check">
 <input type='checkbox'>
 <span>Silver Prize :<%=m.getSILVER_PRIZE()%></span>
 </label>
 </div>
<div class="button2">
<input type="text" class='left' placeholder="IF Discount Coupen" name="discount">
<input type="reset" class='sbm right' value="Reset your Seats">
 </div>
</form>
<div class="button2">
 <button class="sbm  right"  onclick="hello()">Scan & Pay</button>
 <button class="sbm  right"  onclick="hello2()">Credit / Debit Card</button>
</div>
</div>
<script type="text/javascript">
function hello(){
	    var checkboxes = document.querySelectorAll('input[class="Gold"]:checked');
	    var checkbox = document.querySelectorAll('input[class="Silver"]:checked');
	Swal.fire({
	  title: 'Pay Rs'+((checkboxes.length)*(<%=m.getGold_PRIZE()%>)+(checkbox.length)*(<%=m.getSILVER_PRIZE()%>)),
	  text: "Pay Your Bill Here",
	  icon: 'warning',
	  imageUrl: 'images/payment.jpg',
	  showCancelButton: true,
	  confirmButtonColor: '#3085d6',
	  cancelButtonColor: '#d33',
	  confirmButtonText: 'Payment Submited'
	}).then((result) => {
	  if (result.isConfirmed) {
		document.getElementById("seatform").submit();
	  }
	})    
}
function hello2(){
	Swal.fire({
		  title: 'Are you sure?',
		  text: "Pay Your Bill Here",
		  icon: 'warning',
		  html: `<input type="Text"  class="swal2-input" placeholder="Name" required>
			  <input type="number"  class="swal2-input" placeholder="Card Number" required>
			  <input type="number" max=3 class="swal2-input" placeholder="CVV Number" required>`,
			  confirmButtonText: 'Submit',
			  focusConfirm: false,
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		}).then((result) => {
		  if (result.isConfirmed) {
			document.getElementById("seatform").submit();
		  }
		})
	}
<%
if(Sseat!=null) {
	arrOfSil = Sseat.split("[-]+"); 
for(String a:arrOfSil) {
%>
document.getElementById("<%=a%>").disabled=true;
<%
}
}
%>
<%
if(Gseat!=null) {
	arrOfGol = Gseat.split("[-]+"); 
for(String b:arrOfGol) {
%>
document.getElementById("<%=b%>").disabled=true;
<%
}
}
%>
</script>
</body>
</html>