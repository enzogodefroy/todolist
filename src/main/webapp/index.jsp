<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="modele.Status, modele.Task, modele.ToDoList" %>
<jsp:useBean id="toDo" class="modele.ToDoList" scope="application" />
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pense-bête</title>
	</head>
	<body>
        <p>Les choses à faire.</p>
        <table border="0">
        	<thead>
	        	<tr>
	        		<th>Nom</th>
	        		<th>Description</th>
	        		<th>Etat</th>
        		</tr>
        	</thead>
        	<tbody>
        	<% for(Task task : toDo) { %>
	        	<tr>
	        		<td><%= task.getName() %></td>
	        		<td><%= task.getComment() %></td>
	        		<td><%= task.getStatus() %></td>
         		</tr>
        	<% } %>
        	</tbody>
        </table>
        <p>
        <a href="ajoute?nom=une chose&description=la description d'une chose">ajouter</a>
        </p>
	</body>
</html>