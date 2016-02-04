package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import coms.DataBaseHelper;

public class Libro {
	private String isbn;
	private String titulo;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Libro(String isbn, String titulo, String categoria) {
		super();
		this.isbn = isbn;
		this.titulo = titulo;
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	private String categoria;

	public static List<String> buscarTodasLasCategorias() {
		String consultaSQL = "select distinct(categoria) from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		ArrayList<String> listaCategorias = new ArrayList<String>();
		String categoria = null;
		try {
			while (rs.next()){
				categoria = rs.getString("categoria");
				listaCategorias.add(categoria);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaCategorias;
	}

	public void insertar() {
		String consultaSQL = "insert into Libros (isbn,titulo,categoria) values ";
		consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
		DataBaseHelper helper = new DataBaseHelper();
		helper.modificarRegistro(consultaSQL);
	}


	public static  List<Libro> buscarTodos(){
		String consultaSQL = "select isbn,titulo,categoria from Libros";
		DataBaseHelper helper = new DataBaseHelper();
		ResultSet rs = helper.seleccionarRegistros(consultaSQL);
		ArrayList<Libro> listaDeLibros= new ArrayList<Libro>();
		try {
			while (rs.next()) {
				listaDeLibros.add(new Libro(rs.getString("isbn"),rs.getString("titulo"),rs.getString("categoria"))); 
				}
			}catch (SQLException e) {
				System.out.println(e.getMessage());   }
		return listaDeLibros;  
	}
	
	

}
