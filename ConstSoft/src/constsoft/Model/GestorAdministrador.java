    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gerardo Ramirez
 */
public class GestorAdministrador {
    
    
    public void insertarAdministrador(String name,String telefono,String direccion,String correo,String pass){
         MySQLDB.conectar();
         int decision;
         Statement st = MySQLDB.conexion();
         String query;
         query="begin";
         MySQLDB.consultaActualiza(st, query);
         query="insert into administrador values('0','"+name+"','"+telefono+"','"+direccion+"','"+correo+"','"+pass+"')";
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
