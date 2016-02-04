package coms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DataBaseHelper {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/arquitecturajava?useSSL=false";
	private static final String USUARIO = "root";
	private static final String CLAVE = "j223c9!99avZ8";

	public int modificarRegistro(String consultaSQL) {  
		  Connection conexion = null;   
		  Statement sentencia = null;   
		  int filasAfectadas = 0;
		  
		  try{
			  Class.forName(DRIVER);
			  conexion = DriverManager.getConnection(URL,USUARIO,CLAVE);
			  
			  sentencia = conexion.createStatement();
			  filasAfectadas = sentencia.executeUpdate(consultaSQL);
		  } catch ( ClassNotFoundException e){
			  System.out.println("Error driver: " + e);
		  }catch (SQLException e) {
			System.out.println("Erro de SQL: " + e);
		}finally{
			if (sentencia!=null){
				try{
					sentencia.close();
				}catch(SQLException e){}}
			if (conexion!=null) {
				try {
					conexion.close();}catch (SQLException e){}
				}
			}
		  return filasAfectadas;
			}
		
	public ResultSet seleccionarRegistros(String consultaSQL) {  
		  Connection conexion = null;
		  Statement sentencia = null;
		  ResultSet filas = null;
		  try {
			  Class.forName(DRIVER);  
			  conexion = DriverManager.getConnection(URL, USUARIO,CLAVE);  
			  sentencia = conexion.createStatement();  
			  filas = sentencia.executeQuery(consultaSQL);   
			  } catch (ClassNotFoundException e) {
				  System.out.println("Error Driver" + e.getMessage());
				  } catch (SQLException e) {
					  System.out.println("Error de SQL " + e.getMessage());
					  }
		  return filas;
		  }
} 
		  
		 

