<%@page import="classes.Post" %>
<%@page import="java.util.LinkedList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
 <link href="styling/style.css" rel="stylesheet" type="text/css" />
<head>
<meta charset="ISO-8859-1">
<title>Digital Opslagstavle</title>
</head>
<body>
 <h1>Digital Opslagstavle</h1>
 <h2>Kodetest Nordiske Medier 2020</h2>
 <form action="OpslagstavleServlet" method="post">
		<table>
			<tr>
				<td>Dit navn</td>
				<td><input name="author" /></td>
			</tr>
			<tr>
				<td>Titel på opslag</td>
				<td><input name="title" /></td>
			</tr>
			<tr>
				<td>Besked tekst</td>
				<td><input name="message" /></td>
			</tr>
		</table>
		<input type="submit" />
	</form>
<div class="posts">
<%
  LinkedList<Post> posts = (LinkedList<Post>) request.getAttribute("posts"); 
  for (Post post: posts) {   
%>
	<div class="post">
	    <%if(post.isNew() == true){%>
    <a>NYT OPSLAG!</a>
    <%}%>
    <a><%=post.getTitle()%></a>
    <a><%=post.getAuthor()%></a>
    <a><%=post.getMessage()%></a>
    <a><%=post.getCreated()%></a>
    </div>
<%}%>
</div>
</body>
</html>