/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author Mauricio Prendas
 */
public class Libro {
    private String titulo;
    private Autor autor;
    private String fechaPublicacion;
    private String genero;
    private boolean disponibilidad;
    private String tipo;
    public Libro(String titulo, Autor autor, String fechaPublicacion, String genero, boolean disponibilidad, String tipo){
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.genero = genero;
        this.disponibilidad = disponibilidad;
        this.tipo = tipo;
    }
    public String toString(){
        return "\nTitulo: " + this.titulo +
                "\nAutor: " + this.autor +
                "\nFecha de publicacion: " + this.fechaPublicacion +
                "\nGenero: " + this.genero + 
                "\nDisponibilidad: " + this.disponibilidad +
                "\nTipo: " + this.tipo;    
    }
    public String getTitulo(){//setters y getters
        return this.titulo;
    }
    public boolean getDisponibilidad(){
        return this.disponibilidad;
    }
    public void setDisponibilidad(boolean disponibilidad){
        this.disponibilidad = disponibilidad;
    }
    public String librosDisponibles(){
        if (this.disponibilidad) {
            return "\nTitulo: " + this.titulo +
            "\nAutor: " + this.autor +
            "\nFecha de publicacion: " + this.fechaPublicacion +
            "\nGenero: " + this.genero + 
            "\nTipo: " + this.tipo;  
        } else {
            return "";
        }
    }
}
