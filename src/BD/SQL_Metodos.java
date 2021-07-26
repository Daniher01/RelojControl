/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

/**
 *
 * @author neyra
 */

import java.io.ByteArrayInputStream;
import java.nio.charset.CharacterCodingException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class SQL_Metodos {
  //Atributos
  
    public PreparedStatement Pstmt;
    public ResultSet Rs;

    public int getIdDepartamento(String departamento){
        // Recupera el ID del departamento seleccionado
        int id=0;
        Connection Conn=null;
        String SentenciaSelect="select idDepartamento from Departamento "+
                "where NombreDepartamento='"+ departamento +"';";
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            if (Rs.next()){
                id=Rs.getInt("idDepartamento");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return id;
    }
    
    public int getIdCargo(String nombreCargo){
        // Recupera el ID del cargo seleccionado
        int idCargo=0;
        Connection Conn=null;
        String SentenciaSelect="select idCargo from Cargo "
                +"where NombreCargo='" + nombreCargo + "'";
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            if(Rs.next()){
               idCargo=Rs.getInt("idCargo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return idCargo;
    }
    
    public int getIdSupervisor(String NombreCargo, int idDepartamento){
        //Recupera el ID para el supervisor seleccionado
        int idSupervisor=0;
        Connection Conn=null;
        String SentenciaSelect="Select idCargo from Cargo " +
                "where NombreCargo='" + NombreCargo + "' " +
                "and idDepartamento=" + idDepartamento +";";
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            if(Rs.next()){
                idSupervisor=Rs.getInt("idCargo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return idSupervisor;
    }
    
    public ArrayList<String> llenaDepartamento(){
        //Completa la información de los Departamentos
        ArrayList<String> departamentos = new ArrayList<>();
        Connection Conn=null;
        String SentenciaSelect = "Select NombreDepartamento from Departamento order by NombreDepartamento asc;";
        try{
            Conn= Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            while(Rs.next()){
                departamentos.add(Rs.getString("NombreDepartamento"));
                
            }
            Pstmt.close();
            Conn.close();
        }catch(SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return departamentos;
        
    }
    
    public ArrayList<String> llenaCargo(String depto){
        //Completa la información de los cargos existentes en un Departamento
        ArrayList<String> cargo = new ArrayList<>();
        Connection Conn = null;
        String SentenciaSelect = "Select Cargo.NombreCargo from Cargo, Departamento " +
                "where Departamento.NombreDepartamento = '" + depto +"' "+
                "and Departamento.idDepartamento = Cargo.idDepartamento " +
                "order by NombreCargo asc;";
                
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            while (Rs.next()){
                cargo.add(Rs.getString("NombreCargo"));
            }
            Pstmt.close();
            Conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return cargo;
    }
    
    public ArrayList<String> llenaSupervisorGerencia(){
        //Completa la información de los Supervisores a nivel de Gerencia
        ArrayList<String> gerencia = new ArrayList<>();
        Connection Conn = null;
        String SentenciaSelect = "select NombreCargo " +
                "from Cargo " +
                "right outer join Departamento " +
                "on Cargo.idDepartamento=Departamento.idDepartamento " +
                "where Cargo.supervisor=true " +
                "and Departamento.idDepartamento=1 " +
                "order by NombreCargo asc;";
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            while (Rs.next()){
                gerencia.add(Rs.getString("NombreCargo"));
            }
            Pstmt.close();
            Conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return gerencia;
    }
    
    public ArrayList<String> llenaSupervisor (String departamento){
        //Completa la información de los supervisores a nivel de un Departamento especifico
        ArrayList<String> supervisor = new ArrayList<>();
        Connection Conn = null;
        String StentenciaSelect = "select NombreCargo " +
                "from Cargo " +
                "right outer join Departamento " +
                "on Cargo.idDepartamento=Departamento.idDepartamento " +
                "where Cargo.supervisor=true " +
                "and Departamento.NombreDepartamento = '" + departamento + "' " +
                "order by NombreCargo asc; ";
        
        if ("Dirección General".equals(departamento)) {
            supervisor=llenaSupervisorGerencia();
            return supervisor;
            
        } else {
            supervisor=llenaSupervisorGerencia();
            try {
                Conn=Conect.Conecta_BD();
                Pstmt=Conn.prepareStatement(StentenciaSelect);
                Rs=Pstmt.executeQuery();
                while (Rs.next()){
                    supervisor.add(Rs.getString("NombreCargo"));
                }
                Pstmt.close();
                Conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
        return supervisor;
    }
    
    public void insertPersona(int rut, String digito, String primerNombre, String segundoNombre, String primerApellido, 
            String segundoApellido, int supervisor, byte[] imagen1, byte[] imagen2, byte[] imagen3, int idCargo, int idDepartamento){
        //Inserta la información del empleado en la BD
        Connection Conn=null;
        String SentenciaInsert="insert into Empleado (RUT, Digito, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, Supervisor, "+
                "imagen01, imagen02, imagen03, idCargo, idDepartamento) values(?,?,?,?,?,?,?,?,?,?,?,?);";      
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaInsert);
            Pstmt.setInt(1, rut);
            Pstmt.setString(2, digito);
            Pstmt.setString(3, primerNombre);
            Pstmt.setString(4, segundoNombre);
            Pstmt.setString(5, primerApellido);
            Pstmt.setString(6, segundoApellido);
            Pstmt.setInt(7, supervisor);
            Pstmt.setBinaryStream(8,(new ByteArrayInputStream(imagen1)));
            Pstmt.setBinaryStream(9,(new ByteArrayInputStream(imagen2)));
            Pstmt.setBinaryStream(10,(new ByteArrayInputStream(imagen3)));
            Pstmt.setInt(11, idCargo);
            Pstmt.setInt(12, idDepartamento);
            Pstmt.executeUpdate();
            Pstmt.close();
            Conn.close();
            JOptionPane.showInternalMessageDialog(null, "Datos Almacenados correctamente");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public Persona consultaEmpleado(int rut){
        Persona consulta = new Persona();
        Connection Conn= null;
        String SentenciaSelect="Select RUT, Digito, PrimerNombre, SegundoNombre, PrimerApellido, SegundoApellido, Supervisor, "
                +"imagen01, imagen02, imagen03, idCargo, idDepartamento from Empleado "
                +"where RUT="+rut+";";
        
        try {
            Conn=Conect.Conecta_BD();
            Pstmt=Conn.prepareStatement(SentenciaSelect);
            Rs=Pstmt.executeQuery();
            while(Rs.next()){
                consulta.setRut(Rs.getInt(1));
                consulta.setVerificador(Rs.getString(2));
                consulta.setPrimerNombre(Rs.getString(3));
                consulta.setSegundoNombre(Rs.getString(4));
                consulta.setPrimerApellido(Rs.getString(5));
                consulta.setSegundoApellido(Rs.getString(6));
                consulta.setSupervisor(Rs.getInt(7));
                consulta.setImagen1(Rs.getBytes(8));
                consulta.setImagen2(Rs.getBytes(9));
                consulta.setImagen3(Rs.getBytes(10));
                consulta.setIdCargo(Rs.getInt(11));
                consulta.setIdDepartamento(Rs.getInt(12));                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
        return consulta;
    }
    
}
