/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GuillermoAugusto
 */
public class GestorConstructor {
    
    
    
    public void insertarConst(JTextField texto1, JTextField texto2,JTextField texto3,JTextField texto4, JPasswordField pass1){
        String name, telefono,direccion,correo, contraseña;
        name=texto1.getText();
        telefono = texto2.getText();
        direccion = texto3.getText();
        correo = texto4.getText();
        contraseña = pass1.getText();
        insertarConstructor(name, telefono, direccion, correo, contraseña);
    }
    
    public void insertarConstructor(String name,String telefono,String direccion,String correo,String pass){
         MySQLDB.conectar();
         int decision;
         Statement st = MySQLDB.conexion();
         String query;
         query="begin";
         MySQLDB.consultaActualiza(st, query);
         query="insert into constructores values('0','"+name+"','"+telefono+"','"+direccion+"','"+correo+"','"+pass+"')";
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
    
    public void llenaTabla(JTable tabla){
        MySQLDB.conectar();
        String cadena="Select id_constructor, nombre, constructor.telefono, "
                + "correo, nombre_completo from constructor join constructora "
                + "on constructor.id_constructora = constructora.id_constructora";
        Statement st = MySQLDB.conexion();
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID constructor");
        model.addColumn("Nombre");
        model.addColumn("Telefono");
        model.addColumn("Correo");
        model.addColumn("constructora");
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
    
    public void eliminarConst(JTable tabla){ 
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        int id = (int) tm.getValueAt(tabla.getSelectedRow(),0);
        MySQLDB.conectar();
        String cadena="delete from constructor where id_constructor="+id;
        Statement st = MySQLDB.conexion();
    }
    
    public void visualizar_constructoras(){
        
    }
}
