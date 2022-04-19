package com.elorrieta.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Isbn {

	public static void isbn() {
		// TODO Auto-generated method stub
	
		
		try {
		
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gravity_books", "root", "rosario9");
			String sql = "select\n"
					+ "\n"
					+ "isbn13,\n"
					+ "b.book_id,\n"
					+ "b.title,\n"
					+ "num_pages,\n"
					+ "\n"
					+ "a.author_name,\n"
					+ "publication_date\n"
					+ "from book b join book_author ba on b.book_id=ba.book_id\n"
					+ "join author a on a.author_id= ba.author_id\n"
					+ "WHERE isbn13 = ? \n"
					+ ";";
			
			Scanner sc = new Scanner (System.in);
			
			System.out.println("Introduce el isbn del libro");
		long respuesta = sc.nextLong();
			
			
			
			System.out.println("ISBN" + "                "+"ID " + "            " + " TITULO" + "                          " + "       NUM-PAGINAS" +  "  "+ "AUTOR");
			System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
			PreparedStatement pst = conexion.prepareStatement(sql);
		pst.setLong(1, respuesta);
			ResultSet rs = pst.executeQuery(); // ejecuto como si pulsara el rayo en workbench y recibo unos resultados "rs"
			while( rs.next() ) {
				
				int isbn = (int) rs.getLong("isbn13");
				String id = rs.getString("b.book_id");	
				String titulo = rs.getString("b.title");
				int paginas= rs.getInt("num_pages");
				String autor = rs.getString("a.author_name");
				System.out.println( isbn +"         "+ id +"           "+titulo+  "              "+paginas+ "     "+autor);				
				
			}// while
			
	
		}catch (Exception e) {
			
			System.out.println("Hemos tenido un problema");
			e.printStackTrace();
		}	
		


		
	}

	}


