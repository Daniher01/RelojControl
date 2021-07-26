/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import java.io.Serializable;

/**
 *
 * @author danih
 */
public class Persona implements Serializable{
    public  static int Rut;
    public  static String verificador;
    public  static String primerNombre ;
    public  static String segundoNombre ;
    public  static String primerApellido;
    public  static String segundoApellido;
    public  static int supervisor;
    public  static byte[] manipular_byte;
    public  static byte[] imagen1; 
    public  static byte[] imagen2;
    public  static byte[] imagen3;
    public  static int idCargo;
    public  static int idDepartamento;

   

    public Persona() {
    }
    public int getRut() {
        return Rut;
    }

    public void setRut(int Rut) {
        Persona.Rut = Rut;
    }

    public String getVerificador() {
        return verificador;
    }

    public void setVerificador(String verificador) {
        Persona.verificador = verificador;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String nombre) {
        Persona.primerNombre = nombre;
    }
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String nombre) {
        Persona.segundoNombre = nombre;
    }
    
    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String apellido) {
        Persona.primerApellido = apellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String apellido) {
        Persona.segundoApellido = apellido;
    }
    
    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        Persona.supervisor = supervisor;
    }

    public byte[] getImagen1() {
        return imagen1;
    }

    public void setImagen1(byte[] imagen1) {
        Persona.imagen1 = imagen1;
    }

    public byte[] getImagen2() {
        return imagen2;
    }

    public void setImagen2(byte[] imagen2) {
        Persona.imagen2 = imagen2;
    }

    public byte[] getImagen3() {
        return imagen3;
    }

    public void setImagen3(byte[] imagen3) {
        Persona.imagen3 = imagen3;
    }

    public int getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(int idCargo) {
        Persona.idCargo = idCargo;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        Persona.idDepartamento = idDepartamento;
    }
    
    
    
}
