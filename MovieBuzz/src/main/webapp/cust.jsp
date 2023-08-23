<%@page import="com.DBhandler.DbHandler"%>
<%@page import="com.module.Usertbl"%>
<% HttpSession ses=request.getSession(false); 
int id= (int)ses.getAttribute("id");
DbHandler db=new DbHandler();
Usertbl usr= db.gettblusrbyusrid(id);
%>
<div class="cust" id="cust">
<ul>
<li>
<h2>Hi !</h2>
<h1><%=usr.getUsernm()%></h1>
</li>
<hr>
<li>
<h4>
&#xf581;
<a >Your Id is <%=id %></a>
</h4>
</li>
<li>
<h4>
&#xf581;
<a href="YourTickets.jsp">Check Your Tickets</a>
</h4>
</li>
<li>
<h4>
&#xf581;
<a href="allmovies.jsp">See latest Movies</a>
</h4>
</li>
<li>
<h4>&#xf581;
<a href="Chat.jsp">Help and Support</a></h4>
</li>
</ul>
</div>