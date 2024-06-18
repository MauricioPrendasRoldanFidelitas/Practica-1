/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gestionbiblioteca;

/**
 *
 * @author Mauricio Prendas
 */
public class Usuario extends Persona {//esta clase se hereda de la clase Persona
    private String direccion;
    private String telefono;
    private String id;
    public Usuario(String nombre, String apellido, String direccion, String telefono, String id){
        super(nombre, apellido);
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = id;
    }
    @Override
    public String toString(){//despliegue de la informacion
        return "\nNombre: " + this.nombre +
                "\nApellido: " + this.apellido +
                "\nDireccion: " + this.direccion +
                "\nTelefono: " + this.telefono +
                "\nNumero de identificacion: " + this.id;
    }
}
