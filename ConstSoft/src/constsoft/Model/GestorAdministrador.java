    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.Statement;
import javax.swing.*;
/**
 *
 * @author Gerardo Ramirez
 */
public class GestorAdministrador {
    
    public void crearAdministrador(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, JPasswordField pass1, JPasswordField pass2){
        String name,app,apm,correo,pass,conpass;
        name=texto1.getText();
        app=texto2.getText();
        apm=texto3.getText();
        correo=texto4.getText();
        pass=pass1.getText();
        conpass=pass2.getText();
        if(pass.equals(conpass)){
            insertarAdministrador(name,app,apm,correo,pass);
        }else{
            JOptionPane.showMessageDialog(null,"Las Contraseñas no coinciden","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public void insertarAdministrador(String name,String app,String apm,String correo,String pass){
         MySQLDB.conectar();
         int decision;
         Statement st = MySQLDB.conexion();
         String query;
         query="begin";
         MySQLDB.consultaActualiza(st, query);
         query="insert into administrador values('0','"+name+"','"+app+"','"+apm+"','"+correo+"','"+pass+"')";
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
}
