<%@page import="modelo.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<%  
		ArrayList<Libro> listaDeLibros = null;
		listaDeLibros = Libro.buscarTodos();
    	//5
	    for(Libro libro:listaDeLibros){ %>
		<%=libro.getIsbn() %>
		<%=libro.getTitulo()%>
		<%=libro.getCategoria()%>
		<br />
		<% } %>  
	<a href="FormularioLibro01Inicio.html">Insertar Libro</a>
</body>
</html>
