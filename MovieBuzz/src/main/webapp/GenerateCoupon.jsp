<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Generate Coupon</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<%@ include file="nav.jsp" %>
<%@ include file="adminlayout.jsp" %>



<div class="main">
<div class="movfom">
<div class="container">
<form  action="Generatecoupon" method="post">
  <h1>Enter Discount %</h1>
   <div>
  <input type="number" min="1" max="100" name="discount" class="typenumber" required>
  </div>
  <button type="Submit">Generate Coupon</button>
  
  </form>

</div>
</div>
</div>






</body>
</html>