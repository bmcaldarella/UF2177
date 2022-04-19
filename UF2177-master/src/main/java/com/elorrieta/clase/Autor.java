package com.elorrieta.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Autor {
	
	public void listadoAutor() {
		
		
	try {
		
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gravity_books", "root", "rosario9");
			String sql = "SELECT \n"
					+ "author_id,\n"
					+ "author_name\n"
					+ "\n"
					+ "FROM gravity_books.author;";
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println("AUTORES");
			
			
			
			
			PreparedStatement pst = conexion.prepareStatement(sql);

			ResultSet rs = pst.executeQuery(); 
			System.out.println("--------------------------------------");
			System.out.println("ID" + "  " + "AUTOR");
			System.out.println("--------------------------------------");
			while( rs.next() ) {
				
				int id = rs.getInt("author_id");
				String nombre = rs.getString("author_name");	
				
				System.out.println( id +"  "+nombre);				
				
			}// while
			
	
		}catch (Exception e) {
			
			System.out.println("Hemos tenido un problema");
		
		
		
		
	}
	}

	public void autor() {
		// TODO Auto-generated method stub


		
		try {
		
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gravity_books", "root", "rosario9");
			String sql = "select "
					+ " "
					+ "b.book_id id, "
					+ "title, "
					+ "author_name, "
					+ "ba.author_id "
					+ "from book b join book_author ba on b.book_id=ba.book_id "
					+ "join author a on a.author_id= ba.author_id "
					+ "where author_name like ? "
					+ "order by author_id asc "
					+ " "
					+ ";";
			
			Scanner sc = new Scanner (System.in);
			System.out.println("-------------------------------------------------------------");
			System.out.println("INTRODUCE EL NOMBRE DEL ESCRITOR QUE DESEE CONOCER SUS LIBROS");
			System.out.println("-------------------------------------------------------------");
			String respuesta = sc.next();
			
			
			
			System.out.println("ID" + "                "+"TITULO " + "                " + "        AUTOR" + "                                   " + "              ID AUTOR");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			PreparedStatement pst = conexion.prepareStatement(sql);
			pst.setString(1, respuesta);
			ResultSet rs = pst.executeQuery(); // ejecuto como si pulsara el rayo en workbench y recibo unos resultados "rs"
			while( rs.next() ) {
				
				int id = rs.getInt("id");
				String titulo = rs.getString("title");	
				String nombre = rs.getString("author_name");
				int autor= rs.getInt("ba.author_id");
				System.out.println( id +"         "+ titulo +"                                  "+nombre+  "                 "+autor);				
				
			}// while
			
	
		}catch (Exception e) {
			
			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}	
		

		
	}

}
