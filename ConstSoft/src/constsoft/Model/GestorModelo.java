/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import constsoft.View.*;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author Gerardo Ramirez
 */
public class GestorModelo {
    int id_pago,id_propiedad,id_proyecto;
    public void crearModelo(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, 
            JTextField texto5, JComboBox combo1, JComboBox combo2, JComboBox comb3){
        String name,pago,propiedad,proyecto;
        Double mcons,mter;
        
    }
    public static void llenarComboPropiedad(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion();
 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select name from tipo_propiedad";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {
           
              try {
                   
                   GUICrearModelo.propiedadCombo.addItem("Seleccione tipo de propiedad");
                  while (rs1.next()) {
                            GUICrearModelo.propiedadCombo.addItem(rs1.getString("name"));
                  } 
              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            
        }   
    }
    public static void llenarComboPago(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion();
 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select name,descripcion from formapago";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {
           
              try {
                   
                   GUICrearModelo.pagoComb.addItem("Seleccione una forma de pago");
                  while (rs1.next()) {
                            GUICrearModelo.pagoComb.addItem(rs1.getString("name"));
                  } 
              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            
        }   
    }
    
    public static void llenarComboProyecto(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion();
 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select nombre from proyecto";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {
           
              try {
                   
                   GUICrearModelo.proyectoComb.addItem("Seleccione un proyecto");
                  while (rs1.next()) {
                            GUICrearModelo.proyectoComb.addItem(rs1.getString("nombre"));
                  } 
              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            
        }   
    }
    public void buscaridPago(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_formaP from formapago where name = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_pago=Integer.parseInt(rs.getString("id_formaP"));    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    public void buscaridProyecto(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_proyecto from proyecto where name = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_pago=Integer.parseInt(rs.getString("id_formaP"));    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    
    
}
