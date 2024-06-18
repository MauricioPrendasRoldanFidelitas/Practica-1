/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author Mauricio Prendas
 */
public class Autor extends Persona {//esta clase se hereda de la clase persona
    private String nacionalidad;
    private String fechaNacimiento;
    public Autor(String nombre, String apellido, String nacionalidad, String fechaNacimiento){
        super(nombre, apellido);
        this.nacionalidad = nacionalidad;
        this.fechaNacimiento = fechaNacimiento;
    }
    @Override
    public String toString(){
        return "\nNombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nNacionalidad: " + this.nacionalidad +
                "\nFecha de nacimiento: " + this.fechaNacimiento;
    }
}
