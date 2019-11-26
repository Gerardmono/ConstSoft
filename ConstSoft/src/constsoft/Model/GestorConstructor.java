/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.*;

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
    
    public void visualizar_constructoras(){
        
    }
}
