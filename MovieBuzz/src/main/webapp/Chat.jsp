<%@page import="com.module.QuestionAns"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <link rel="stylesheet" href="style.css">
  <style type="text/css">
  
.chat-container {
    width: 80%;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
}

.message-container {
    height: 70vh;
    overflow-y: scroll;
    border: 1px solid #ccc;
    padding: 10px;
}

.message-input {
    width: 100%;
    padding: 10px;
    margin-top: 10px;
}

.send-button {
    padding: 10px 20px;
    margin-top: 10px;
}
.left{
left: 10px;
color: white;
}
.right{
right: 10px;
color: white;
}
  </style>
</head>
<body>
<%@ include file="nav2.jsp" %>
<%@ include file="cust.jsp" %>
<div class="home">
<div class="chat-container">
<form action="SaveChat">

        <div class="message-container">
                <% List<QuestionAns> lst=db.getAllQNAByuserid(id);
for(QuestionAns questionAns :lst){
	if(questionAns.getAdmin()==1){
		
		%>
		
		<div class="left"><p>MovieBuzz</p><h3><%=questionAns.getMessage() %></h3></div>
		<% 
	}
	else{
		%>
		
		<div class="right"><p>You</p><h3><%=questionAns.getMessage() %></h3></div><%
				}
}
%>
        </div>
        <input type="text" class="message-input" name="message" placeholder="Type your message...">
        <input id="send-button" type="submit" value="Send Message">
         </form>
    </div>
   
</div>


</body>
</html>