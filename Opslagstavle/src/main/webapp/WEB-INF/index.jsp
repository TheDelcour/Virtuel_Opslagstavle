<%@page import="java.sql.Connection" %>
<%@page import="java.sql.DriverManager" %>
<%@page import="db.DBConnection" %>
<%@page import="db.DBPostsTable" %>
<%@page import="classes.Post" %>
<%@page import="java.util.LinkedList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
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

<%
  LinkedList<Post> posts = (LinkedList<Post>) request.getAttribute("posts"); 
  for (Post post: posts) {   
%>
    <a><%=post.getTitle()%></a>
    <a><%=post.getAuthor()%></a>
    <a><%=post.getMessage()%></a>
<%}%>


 <%
//DBPostsTable table = new DBPostsTable();
//table.createPost("test1", "author1", "here is a new message11");
//LinkedList<Post> posts = table.getPosts(255);
//out.print(posts.getFirst().getTitle());

//for(int i = 0; i < posts.size() ; i++){
//	out.print(posts.get(i).getTitle() + "    ");
//	out.print(posts.get(i).getAuthor() + "    ");
//	out.print(posts.get(i).getMessage() + "    ");
//}
 %>
</body>
</html>