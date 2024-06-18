/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author Mauricio Prendas
 */
public abstract class Persona {
    protected String nombre;
    protected String apellido;
    public Persona(String nombre, String apellido){//constructor
        this.nombre = nombre;
        this.apellido = apellido;
    }
    @Override
    public abstract String toString();
    public String getNombre(){
        return nombre;
    }
    public String getApellido(){
        return apellido;
    }
}
