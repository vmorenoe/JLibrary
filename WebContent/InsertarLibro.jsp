<%@page import="modelo.Libro"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--  sentencias de import necesarias para jdbc-->
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>
<%@ page import="coms.DataBaseHelper"%>
<%
	//1
	String isbn = request.getParameter("isbn");
	String titulo = request.getParameter("titulo");
	String categoria = request.getParameter("categoria");
	//realizo la consulta usando el DBHelper y el codigo queda simplificado
	Libro libro = new Libro(isbn,titulo,categoria);
	libro.insertar(); 
	response.sendRedirect("MostrarLibros.jsp");
%>