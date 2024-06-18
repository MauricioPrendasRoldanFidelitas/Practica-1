/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author Mauricio Prendas
 */
public class Prestamo {
    private Libro libro;
    private Usuario usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;
    public Prestamo(Libro libro, Usuario usuario, String fechaPrestamo, String fechaDevolucion) {//constructor
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
    public String toString(){ //despliega la informacion del prestamo
        return "\nLibro: " + libro.toString() +
        "\nUsuario: " + usuario.toString() + 
        "\nFecha del prestamo: " + fechaPrestamo +
        "\nFecha de devolucion: " + fechaDevolucion; 
    }
}
