<%@page import="com.module.Lang"%>
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

<div class="navfx">
<%@ include file="nav.jsp" %>
</div>
<%@ include file="adminlayout.jsp" %>


<div class="main">
<div class="movfom">

<div class="fm">
  <div class="form-row">
  <div class="form-group col-md-8">
  <h1>
    Enter Details For New Movie</h1>
    </div>
    </div>
  


<div class="container">
<form action="AddMovie" method="post" enctype="multipart/form-data">
<div class="col-5">
    <label for="txtAccNo" class="form-label">Movie Name</label>
    <input type="text" class="form-control" name="Movie_Name" placeholder="Enter Movie Name" >
 </div>

    <div class="col-5">
    <label for="inputState" class="form-label">Available in Language</label>
    <select id="inputState" name="lang" class="form-select">
 
      <option selected>Choose...</option>
   
    <%
      	for(Lang at:Lang.values())
      	{
      		%>
      		<option value=<%=at.name()  %>><%=at.name()%></option>
      		<%
      	}
      %>
   
   
    </select>
     
  </div>
  <div class="col-md-5">
    <label for="txtDesc" class="form-label">Rate The Movie</label>
   <div class="slidecontainer">
  <input type="range" min="1" max="5" value="3" class="slider" id="myRange" name="rate">
 <span id="demo"></span>
</div>
  </div>
   <div class="col-md-5">
    <label for="txtDesc" class="form-label">Description</label>
    <input type="text" class="form-control" name="txtDesc" placeholder="Add Description">
  </div>
  <div class="col-md-5">
    <label for="txtDesc" class="form-label">Image</label>
    <input type="file" class="form-control" name="image" placeholder="Add Image">
  </div>
   <div class="col-5">
    <label  class="form-label">Start Date</label>
    <input type="date" class="form-control" name="Start_Date" placeholder="Start Date">
  </div>
   <div class="col-5">
    <label  class="form-label">End Date</label>
    <input type="date" class="form-control" name="End_Date" placeholder="End Date">
  </div>
     <div class="col-5">
    <label  class="form-label">Gold Price</label>
    <input type="number" class="form-control" name="GoldPrize" placeholder="GoldPrice">
  </div>
     <div class="col-5">
    <label  class="form-label">Silver Price</label>
    <input type="number" class="form-control" name="SilverSeatPrize" placeholder="SilverPrice">
  </div>
  
     <div class="col-5">
    <label  class="form-label">Is Adult Movie</label>
    <br>
    <input type="radio"  name="isAdult" value="true">Yes
      <input type="radio"  name="isAdult" value="false">No
  </div>
  
  
     <div class="col-12">
  
  
    <div class="col-md-12 " >
   <h5>Select the Sloat</h5>
   
 
   <div class="checkbo" >
    <label for="txtDesc" class="form-label sl">Sloat 9 to 12 </label>
    <input type="checkbox"name="9to12" class="box" value="True" >
    </div>
 
   <div class="checkbo" >
    <label for="txtDesc" class="form-label sl">Sloat 12 to 15 </label>
    <input type="checkbox"name="12to15" class="box" value="True">
    </div>
    
    
    
   <div class="checkbo" >
    <label for="txtDesc" class="form-label sl">Sloat 15 to 18 </label>
    <input type="checkbox"name="15to18" class="box" value="True">
    </div>
    
    
    
   <div class="checkbo" >
    <label for="txtDesc" class="form-label sl">Sloat 18 to 21 </label>
    <input type="checkbox"name="18to21" class="box" value="True">
    </div>
    
    </div>
    
 
  </div>
 
  <div class="col-12">
    <button type="submit" class="btn btn-primary">Add Movie</button>
  </div>
</form>
</div>

</div>


</div>
</div>


<script>
var slider = document.getElementById("myRange");
var output = document.getElementById("demo");
output.innerHTML = slider.value;

slider.oninput = function() {
  output.innerHTML = this.value;
}
</script>

</body>
</html>