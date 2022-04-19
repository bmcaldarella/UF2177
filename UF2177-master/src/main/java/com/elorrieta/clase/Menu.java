package com.elorrieta.clase;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		 Menu();
		
	}

	final static int LISTAR = 1;
	final static int BUSQUEDA = 2;
	final static int MODIFICAR = 3;
	final static int ISBN =4;
	final static int SALIR = 0;

	public static void Menu() {

		 


Scanner sn = new Scanner(System.in);
boolean salir = false;
int opcion; //Guardaremos la opcion del usuario

while (!salir) {
	System.out.println("------------------");
	System.out.println("BIENVENIDO AL MENU");
	System.out.println("------------------");
	System.out.println("1.Listado de libros");
	System.out.println("2.Busqueda de libro por autor");
	System.out.println("3.Modificar un libro ");
	System.out.println("4.Busqueda por isbn de un libro");
	System.out.println("0.Salir");
	System.out.println("");


    try {

        System.out.println("Escoje una de las opciones");
        opcion = sn.nextInt();

        switch (opcion) {
            case LISTAR:
        
         ListarLibros listar = new ListarLibros();
         listar.listar();
                break;
            case BUSQUEDA:
          Autor autor = new Autor();
          autor.listadoAutor();
          autor.autor();
                break;
            case MODIFICAR:
            	Modificar modificar = new Modificar ();
            	Modificar.modificar();
              
                break;
            case ISBN :
            	Isbn isbn = new Isbn();
            isbn.isbn();
              
                break;
            case SALIR:
                salir = true;
                System.out.println("-----------------");
                System.out.println("FIN DEL PROGRAMA");
                System.out.println("-----------------");
                break;
            default:
                System.out.println("Solo números entre 1 y 4");
        }
    } catch (InputMismatchException e) {
        System.out.println("Debes insertar un número");
        sn.next();
    }
}

}

}