package com.elorrieta.clase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Modificar {


		public static void modificar()  {
			
			boolean salir= false;

			
		do {
				try {
					
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gravity_books", "root", "rosario9");
				String sql = "insert into book (book_id,title,isbn13,language_id,num_pages,publisher_id) values(?,?,?,?,?,?);";
				

				Scanner sc = new Scanner(System.in);
				
				System.out.println("Ingrese el ID del libro");
				int idLibro = sc.nextInt();
				
				System.out.println("Inserte el titulo del libro");
				String titulo = sc.next();
				
				System.out.println("ingrese el Isbn del libro");
				long isbn = sc.nextLong();
			
			System.out.println("----------------------------------------------");
				System.out.println("Ingrese el Id del lenguaje");
			System.out.println("----------------------------------------------");
				System.out.println("1 English\n"
						+ "2 United States English'\n"
						+ "3 French\n"
						+ "4 Spanish\n"
						+ "5 British English\n"
						+ "6 Multiple Languages\n"
						+ "7 Greek\n"
						+ "8 Middle English\n"
						+ "9 Canadian English\n"
						+ "10 German\n"
						+ "11 Japanese\n"
						+ "12 Arabic\n"
						+ "13 Dutc\n"
						+ "14 Chinese'\n"
						+ "15 Latin\n"
						+ "16 Portuguese\n"
						+ "17 Serbian\n"
						+ "18'Italian\n"
						+ "19 Russian\n"
						+ "20 Malaysian\n"
						+ "21 Galician\n"
						+ "22 Welsh\n"
						+ "23 Swedish \n"
						+ "24 Norwegian'\n"
						+ "25 Turkish\n"
						+ "26 Gaelic\n"
						+ "27  Aleut\n"
						+ "");
				System.out.println("----------------------------------------------");
			int lenguaje= sc.nextInt();
				
				System.out.println("Numero de paginas");
				int paginas= sc.nextInt();
				
				System.out.println("ID Publicacion");
				int idPublicacion= sc.nextInt();
			
				PreparedStatement pst = conexion.prepareStatement(sql);
				

				pst.setInt( 1, idLibro);
				pst.setString( 2,titulo);
				pst.setLong( 3,  isbn);
				pst.setInt(4,lenguaje);
				pst.setInt(5,paginas);
				pst.setInt(6,idPublicacion);
				int affectedRows = pst.executeUpdate();
				
				System.out.println( "DATOS INGRESADOS CORRECTAMENTE");
				
					
		
			

		
			
		

	}catch (Exception e) {
		salir=true;
	System.out.println("----------------------------------------------------------");
	System.out.println("ERROR INTRODUZCA DATOS VALIDOS QUE NO ESTEN DUPLICADOS");
	System.out.println("VUELVA A INTRODUCIR LOS DATOS");
	System.out.println("-----------------------------------------------------------");
	}
}while(salir);
}
}


