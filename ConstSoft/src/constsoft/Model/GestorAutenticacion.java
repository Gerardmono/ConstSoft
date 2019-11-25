/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import constsoft.View.*;
import constsoft.View.GUIMenuAdmin;

/**
 *
 * @author smart
 */
public class GestorAutenticacion {

    

    public GestorAutenticacion(JTextField entrada1, JPasswordField entrada2, JRadioButton opcion1, JRadioButton opcion2) {
        String user,pass;
        int opcion = 0;
        user=entrada1.getText();
        pass=entrada2.getText();
        if(opcion1.isSelected()){
            opcion=1;
        }
        if(opcion2.isSelected()){
            opcion=2;
        }
        loguea(user,pass,opcion);
    }
    
    public void loguea(String mail,String pass,int usuario){
            MySQLDB.conectar();
        Statement st = MySQLDB.conexion();
        String query="";
        String correo,password;
        
        if(usuario==1){
            query = "SELECT correo,pass FROM `administrador` WHERE `correo`= '"+mail+"' AND `pass` = '"+pass+"'";
            ResultSet rs = MySQLDB.consultaQuery(st, query);
            try {
                if (rs.next()) {
                    
                    new GUIMenuAdmin().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Datos incorrectos","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestorAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            query = "SELECT correo,pass FROM `constructor` WHERE `correo`= '"+mail+"' AND `pass` = '"+pass+"'";
            ResultSet rs = MySQLDB.consultaQuery(st, query);
            try {
                if (rs.next()) {
                    new GUIMenuConstructor().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Datos incorrectos","Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                Logger.getLogger(GestorAutenticacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        MySQLDB.cerrar(st);
    }
}
