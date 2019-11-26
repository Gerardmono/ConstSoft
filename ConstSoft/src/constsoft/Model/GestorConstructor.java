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
    
    
    
    
    public void insertarConst(JTextField texto1, JTextField texto2,JComboBox texto3,JTextField texto4, JPasswordField pass1){
        String name, telefono,constructora,correo, contraseña, id="";
        name=texto1.getText();
        telefono = texto2.getText();
        constructora = (String) texto3.getSelectedItem();
        correo = texto4.getText();
        contraseña = pass1.getText();
        MySQLDB.conectar();
        String cadena="select id_constructora from constructora "
                + "where nombre_completo='"+constructora+"'";
        Statement st = MySQLDB.conexion();
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);
        if (rs!=null) {
            try {
                while (rs.next()) {
                    id=rs.getString(1);
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            System.out.println(id);
        }
        String query="begin";
        MySQLDB.consultaActualiza(st, query);
        query="insert into constructor values(NULL,'"+name+"','"+telefono+"','"+correo+"','"+contraseña+"',"+id+")";
        MySQLDB.consultaActualiza(st, query);
        int decision=JOptionPane.showConfirmDialog(null,"Desea guardar los datos los datos");
        if(decision==0){
             query="commit;";
             JOptionPane.showMessageDialog(null,"Datos guardados");
        }else{
             query="rollback";
             JOptionPane.showMessageDialog(null,"Datos no guardados");
        }
        MySQLDB.consultaActualiza(st, query);
        MySQLDB.cerrar(st);
        //insertarConstructor(name, telefono, direccion, correo, contraseña);
    }
    
    public void llenaConstructoras(JComboBox combo){
        MySQLDB.conectar();
        String cadena = "select nombre_completo from constructora";
        Statement st = MySQLDB.conexion();
        ResultSet rs = MySQLDB.consultaQuery(st, cadena);
        if (rs!=null) {
            try {
                while (rs.next()) {
                    combo.addItem(rs.getString(1));
                } 
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
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
    
    public void llena(){
        
    }
    
    public void eliminarConst(JTable tabla){ 
        DefaultTableModel tm = (DefaultTableModel) tabla.getModel();
        String dato=(String) tm.getValueAt(tabla.getSelectedRow(),0);
        int id = Integer.parseInt(dato);
        MySQLDB.conectar();
        String cadena="delete from constructor where id_constructor="+id;
        Statement st = MySQLDB.conexion();
        MySQLDB.consultaActualiza(st, cadena);
        MySQLDB.cerrar(st);
        tm.removeRow(tabla.getSelectedRow());
    }
    
    public void visualizar_constructoras(){
        
    }
}
