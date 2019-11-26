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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Gerardo Ramirez
 */
public class GestorModelo {
    String id_pago,id_propiedad,id_proyecto;
    
    
    public void crearModelo(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, 
            JTextField texto5, JComboBox combo2, JComboBox comb3){
        String name,mcons,mter,nivel,precio,pago,propiedad,proyecto;
        name=texto1.getText();
        mcons=texto2.getText();
        mter=texto3.getText();
        nivel=texto4.getText();
        precio=texto5.getText();
        propiedad=combo2.getSelectedItem().toString();
        proyecto=comb3.getSelectedItem().toString();
        buscaridPropiedad(propiedad);
        buscaridProyecto(proyecto);
        guardarModelo(name,mcons,mter,nivel,precio,id_propiedad,id_proyecto);
    }
    public void guardarModelo(String name,String mcons,String mter,String nivel,String precio,String propiedad,String proyecto){
        MySQLDB.conectar();
         int decision;
         Statement st = MySQLDB.conexion();
         String query;
         query="begin";
         MySQLDB.consultaActualiza(st, query);
         query="insert into modelos values('0','"+name+"','"+mcons+"','"+mter+"','"+nivel+"','"+precio+"','"+propiedad+"','"+proyecto+"')";
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
  
      public void buscaridPropiedad(String name){
          MySQLDB mysql = new MySQLDB();
        System.out.println("INICIO DE EJECUCIÓN.");
        MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        // Se elimina la tabla "personal" en caso de existir.
        String cadena="Select id_tipo_propiedad from tipo_propiedad where name = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_propiedad=rs.getString("id_tipo_propiedad");    
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
        String cadena="Select id_proyecto from proyecto where nombre = '"+name+"'";
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);     
         if (rs != null) {          
              try {
                  while (rs.next()) {
                    Object dato[]=new Object[4];
                    id_proyecto=rs.getString("id_proyecto");    
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
        String cadena1="Select id_modelo, modelos.name,mconstruccion,mterreno,niveles,precio, "
                + "tipo_propiedad.name,proyecto.nombre from modelos join tipo_propiedad "
                + "on modelos.id_tipopropiedad = tipo_propiedad.id_tipo_propiedad join proyecto on "
                + "proyecto.id_proyecto = modelos.id_proyecto";
        Statement st = MySQLDB.conexion();
        ResultSet rs = MySQLDB.consultaQuery(st, cadena1);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("modelo");
        model.addColumn("M Construccion");
        model.addColumn("M terreno");
        model.addColumn("Niveles");
        model.addColumn("precio");
        model.addColumn("tipo propiedad");
        model.addColumn("proyecto");
        
        if (rs!=null) {
            try {
                while (rs.next()) {
                    Object dato[]=new Object[8];
                    for(int i=0;i<8;i++){
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
    
    public void eliminarProyecto(JTable tabla){ 
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        String dato=(String) tm.getValueAt(tabla.getSelectedRow(),0);
        int id = Integer.parseInt(dato);
        MySQLDB.conectar();
        String cadena="delete from proyecto where id_proyecto="+id;
        Statement st = MySQLDB.conexion();
        MySQLDB.consultaActualiza(st, cadena);
        MySQLDB.cerrar(st);
        tm.removeRow(tabla.getSelectedRow());
    }
    
}
