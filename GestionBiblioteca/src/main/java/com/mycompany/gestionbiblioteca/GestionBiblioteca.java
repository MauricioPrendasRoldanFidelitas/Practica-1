/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.gestionbiblioteca;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Mauricio Prendas
 */
public class GestionBiblioteca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //esto escanea strings del teclado
        boolean salir = false;
        //creamos varias colecciones para nuestra administracion
        List listaLibros = new ArrayList();
        List listaAutores = new ArrayList();
        List listaUsuarios = new ArrayList();
        List listaPrestamos = new ArrayList();
        while(!salir){
        //Lo siguiente es el menu
        System.out.print("\033[H\033[2J"); //Esto refresca la consola cada vez que se lee 
        System.out.flush(); //Esto refresca el puntero de la consola
        System.out.println("-----Bienvenido al sistema de Gestion de Biblioteca!------");
        System.out.println("---------Menu---------");
        System.out.println("1. Agregar libro");
        System.out.println("2. Listado de los libros");
        System.out.println("3. Registrar autor");
        System.out.println("4. Listar autores");
        System.out.println("5. Registrar usuario");
        System.out.println("6. Listar usuarios");
        System.out.println("7. Registrar prestamo");
        System.out.println("8. Consultar prestamos actuales");
        System.out.println("9. Salir del programa");
        try {
            String opcion = scanner.nextLine(); //ingresamos string desde el teclado
            switch (opcion){
                case "1": //si la coleccion de autores está vacía no ejecuta el codigo para prevenir errores
                    if (listaAutores.isEmpty()) {
                        System.out.println("Lo sentimos, pero no hay autores de momento registrados");
                        System.out.println("Ingrese un autor e intentelo de nuevo");
                        scanner.nextLine(); //esto detiene el programa por un momento para que el usuario pueda ver la informacion
                        break;
                    }
                    listaLibros.add(CrearLibro(listaAutores)); //aqui se crea un libro
                    break;
                case "2": //se despliega la lista de los libros
                    System.out.println("-----Lista de los libros-----");
                    System.out.println(listaLibros);
                    scanner.nextLine();
                    break;
                case "3": //se crea un autor
                    listaAutores.add(CrearAutor());
                    break;
                case "4": //se despliega la lista de los autores
                    System.out.println("------Lista de los autores-------");
                    System.out.println(listaAutores);
                    scanner.nextLine();
                    break;
                case "5": //se crea un usuario
                    listaUsuarios.add(CrearUsuario());
                    break;
                case "6": //se despliega la lista de los usuarios
                    System.out.println("-----Lista de usuarios------");
                    System.out.println(listaUsuarios);
                    scanner.nextLine();
                    break;
                case "7":
                    if (listaLibros.isEmpty() || listaUsuarios.isEmpty()) { //si alguna de las dos listas están vacías, el programa no sigue
                        System.out.println("Lo sentimos pero no hay o usuarios o libros, por lo que no se podra concretar el prestamo");
                        scanner.nextLine();
                    }
                    listaPrestamos.add(CrearPrestamo(listaLibros, listaUsuarios)); //se crea un prestamo
                    break;
                case "8": //se despliega la lista de prestamos
                    System.out.println("-------Lista de prestamos--------");
                    System.out.println(listaPrestamos);
                    scanner.nextLine();
                    break;
                case "9":
                    salir = true; //se cierra el bucle while del menu
                    System.out.println("Saliendo del programa...");
                    scanner.nextLine();
                    break;
            }
          }
        catch (Exception e) {
                System.out.println("Error al ingresar la opcion. Por favor, intente nuevamente.");
            }
        }
    }
    public static Autor CrearAutor() { //para crear un autor se ingresan sus parametros por teclado
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del autor:");
        String nombreAutor = scanner.nextLine();
        System.out.println("Ingrese el apellido del autor:");
        String apellidoAutor = scanner.nextLine();
        System.out.println("Ingrese la nacionalidad del autor:");
        String nacionalidadAutor = scanner.nextLine();
        System.out.println("Ingrese la fecha de nacimiento del autor:");
        String fechaNacimientoAutor = scanner.nextLine();
        return new Autor(nombreAutor, apellidoAutor, nacionalidadAutor, fechaNacimientoAutor);
    }
    public static Libro CrearLibro(List listaAutores){
        Scanner scanner = new Scanner(System.in);
        if (listaAutores.isEmpty()) {
            return null; //si listaAutores esta vacia se retorna un null para terminar esta parte de la ejecucion
        } else {
            boolean disponibilidadL;
            Autor autorBueno = null;
            System.out.println("Ingrese el titulo del libro:");
            String titulo = scanner.nextLine();
            boolean autorEncontrado = false;
            while (!autorEncontrado) {
                System.out.println("Escoja el autor de entre los disponibles: (Digite primero el solo el nombre)");
                System.out.println(listaAutores); //se despliegan los autores a elegir
                String nombreAutorcito = scanner.nextLine();
                System.out.println("Digite el apellido del autor:");
                String apellidoAutorcito = scanner.nextLine();
                for (Object i : listaAutores) {//esto lo encontre en internet, es para hacer un loop por la coleccion
                    Autor a = (Autor)i; //convertimos el objecto en autor
                    if (nombreAutorcito.equals(a.getNombre()) && apellidoAutorcito.equals(a.getApellido())) {
                        autorBueno = a;
                        autorEncontrado = true;
                    }
                }
                if (!autorEncontrado) {
                    System.out.println("Hubo un error con la seleccion de autor, por favor intentelo de nuevo");
                }
            }
            System.out.println("Ingrese la fecha de publicacion del libro:");
            String fechaPublicacionLibro = scanner.nextLine();
            System.out.println("Ingrese el genero del libro:");
            String generoLibro = scanner.nextLine();
            System.out.println("Ingrese la disponibilidad del libro (Poner solo si o no)");
            String disponibilidadLibro = scanner.nextLine();
            if(disponibilidadLibro.equals("si")){//se define la disponibilidad
            disponibilidadL = true;
            } else 
                disponibilidadL = false;
            System.out.println("Ingrese el tipo del libro: (Revistas, Mangas, Libros de literatura, Libros de ciencia, Comics, entre otros.)");
            String tipo = scanner.nextLine();
            return new Libro(titulo, autorBueno, fechaPublicacionLibro, generoLibro, disponibilidadL, tipo);
            }
        }
    public static Usuario CrearUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el apellido del usuario:");
        String apellido = scanner.nextLine();
        System.out.println("Ingrese la direccion del usuario:");
        String direccion = scanner.nextLine();
        System.out.println("Ingrese el numero de telefono del usuario:");
        String telefono = scanner.nextLine();
        System.out.println("Ingrese el numero de identificacion del usuario:");
        String id = scanner.nextLine();
        return new Usuario(nombre, apellido, direccion, telefono, id);
        }
        
    public static Prestamo CrearPrestamo(List listaLibros, List listaUsuarios){
        Scanner scanner = new Scanner(System.in);
        if (listaLibros.isEmpty() || listaUsuarios.isEmpty()) {
            return null; //si alguna de las dos listas están vacías, el programa no sigue
        } 
        boolean libroEncontrado = false;
        Libro libroBueno = null;
        while (!libroEncontrado) {
            System.out.println("Ingrese el titulo del libro (que este disponible) del cual desea prestar:");
            System.out.println(listaLibros);
            String nombreLibrito = scanner.nextLine();
            for (Object i : listaLibros) {
                Libro a = (Libro)i;
                if (nombreLibrito.equals(a.getTitulo()) && a.getDisponibilidad()) {//se escoge el libro si está disponible
                    a.setDisponibilidad(false);
                    libroBueno = a;
                    libroEncontrado = true;
                } 
            }
            if (!libroEncontrado) {
                System.out.println("Hubo un error con la seleccion de libro. Intentelo de nuevo");
            }
        }
        boolean usuarioEncontrado = false;
        Usuario usuarioBueno = null;
        while (!usuarioEncontrado) {
            System.out.println("Escoja un usuario de entre los disponibles: (Solo el nombre)");
            System.out.println(listaUsuarios);
            String nombreUsuarito = scanner.nextLine();
            System.out.println("Ahora digite el apellido del usuario:");
            String apellidoUsuarito = scanner.nextLine();
            for (Object i : listaUsuarios) {
                Usuario a = (Usuario)i;
                if (nombreUsuarito.equals(a.getNombre()) && apellidoUsuarito.equals(a.getApellido())) {//se escoge el usuario si el nombre y apellido coinciden
                    usuarioBueno = a;
                    usuarioEncontrado = true;
                }
            }
            if (!usuarioEncontrado) {
                System.out.println("Hubo un error con la seleccion de usuario, intentelo de nuevo");
            }
        }
        System.out.println("Digite la fecha del prestamo: ");
        String fechaPrestamo = scanner.nextLine();
        System.out.println("Digite la fecha de la devolucion");
        String fechaDevolucion = scanner.nextLine();
        return new Prestamo(libroBueno, usuarioBueno, fechaPrestamo, fechaDevolucion);
    }
}
