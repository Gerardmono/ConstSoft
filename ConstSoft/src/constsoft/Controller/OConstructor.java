/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.GestorConstructor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author bakai
 */
public class OConstructor {
      JTextField texto1, texto2, texto3, texto4;
    JPasswordField pass1, pass2;
    JButton boton1;

    public OConstructor(JTextField texto1, JTextField texto2, JTextField texto3, 
            JTextField texto4, JPasswordField pass1, JPasswordField pass2, 
            JButton boton1) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.pass1 = pass1;
        this.pass2 = pass2;
        this.boton1 = boton1;
    }
    
    
   
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Object presionado = e.getSource();
        
        if(presionado == boton1){
            GestorConstructor cons =new GestorConstructor();
            cons.insertarConst(texto1, texto2, texto3, texto4, pass1);
        }
    }
}
