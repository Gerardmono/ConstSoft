/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import constsoft.View.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GuillermoAugusto
 */
public class GestorProyecto {
    public static String id_edo;
    String id_muni,id_pago,id_cons;
    public void crearProyecto(JComboBox combo1,JComboBox combo3, JComboBox combo4, JTextField text1){
        String nombre,pago,municipio,constructor;
        nombre=text1.getText();
        pago=combo1.getSelectedItem().toString();
        municipio=combo3.getSelectedItem().toString();
        constructor=combo4.getSelectedItem().toString();
        buscaridPago(pago);
        buscaridMuni(municipio);
        buscaridConstructor(constructor);
        guardarProyecto(nombre,id_pago,id_muni,id_cons);
        
    }
    public void guardarProyecto(String nombre,String id_pago,String id_municipio,String id_cons){
        MySQLDB.conectar();
         int decision;
         Statement st = MySQLDB.conexion();
         String query;
         query="begin";
         MySQLDB.consultaActualiza(st, query);
         query="insert into proyecto values('0','"+nombre+"','"+id_pago+"','"+id_cons+"','"+id_municipio+"')";
         MySQLDB.consultaActualiza(st, query);
         decision=JOptionPane.showConfirmDialog(null,"Desea guardar los datos los datos");
         if(decision==0){
             query="commit;";
             JOptionPane.showMessageDialog(null,"Datos guardados");
         }else{
             query="rollback";
             JOptionPane.showMessageDialog(null,"Datos no guardados");
         }
         MySQLDB.consultaActualiza(st, query);
         MySQLDB.cerrar(st);
    }
    public static void llenarComboPago(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion(); 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select name from formapago";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {          
              try {                  
                   GUICrearProyecto.pagoCombo.addItem("Seleccione formapago");
                  while (rs1.next()) {
                            GUICrearProyecto.pagoCombo.addItem(rs1.getString("name"));
                  }              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }            
        }   
    }
    public static void llenarComboEstado(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion(); 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select estado from estados";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {          
              try {                  
                   GUICrearProyecto.edoCombo.addItem("Seleccione estado");
                  while (rs1.next()) {
                            GUICrearProyecto.edoCombo.addItem(rs1.getString("estado"));
                  }              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }            
        }   
    }
    public static void llenarComboMunicipio(String id){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion();
        GUICrearProyecto.muniCombo.removeAllItems();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select municipio from municipios where id_estado='"+id+"'";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {          
              try {                  
                   GUICrearProyecto.muniCombo.addItem("Seleccione municipio");
                  while (rs1.next()) {
                            GUICrearProyecto.muniCombo.addItem(rs1.getString("municipio"));
                  }              
              } catch (SQLException ex) {
                  //Logger.getLogger(I_Medicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }            
        }   
    }
    public static void llenarComboConstructor(){
          MySQLDB.conectar();
        Statement st1 = MySQLDB.conexion(); 
        // Se elimina la tabla "personal" en caso de existir.
        String cadena1="Select nombre from constructor";
        ResultSet rs1 = MySQLDB.consultaQuery(st1, cadena1);
         if (rs1 != null) {          
              try {                  
                   GUICrearProyecto.consCombo.addItem("Seleccione Constructor");
                  while (rs1.next()) {
                            GUICrearProyecto.consCombo.addItem(rs1.getString("nombre"));
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
                    id_pago=rs.getString("id_formaP");    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    public void buscaridMuni(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_municipio from municipios where municipio = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_muni=rs.getString("id_municipio");    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    public void buscaridEstado(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_estado from estados where estado = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_edo=rs.getString("id_estado");    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    public void buscaridConstructor(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_constructor from constructor where nombre = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_cons=rs.getString("id_constructor");    
                  }
              } catch (SQLException ex) {
                  //Logger.getLogger(I_VMedicamentos.class.getName()).log(Level.SEVERE, null, ex);
                  System.out.println(ex);
              }
            MySQLDB.cerrar1(rs);
        }
        MySQLDB.cerrar(st);
    }
    
    
    public void llenaTabla(JTable tabla){
        MySQLDB.conectar();
        String cadena="Select id_proyecto, proyecto.nombre, name, "
                + "constructor.nombre,municipios.municipio,estado from proyecto join constructor "
                + "on constructor.id_constructor = proyecto.id_constructor join municipios on "
                + "proyecto.id_municipio = municipios.id_municipio join estados on "
                + "municipios.id_estado=estados.id_estado";
        Statement st = MySQLDB.conexion();
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Proyecto");
        model.addColumn("Constructor");
        model.addColumn("municipio");
        model.addColumn("estado");
        if (rs!=null) {
            try {
                while (rs.next()) {
                    Object dato[]=new Object[5];
                    for(int i=0;i<5;i++){
                        dato[i]=rs.getString(i+1);
                    }
                    model.addRow(dato);
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
        tabla.setModel(model);
        MySQLDB.cerrar1(rs);
        MySQLDB.cerrar(st);
    }
}
