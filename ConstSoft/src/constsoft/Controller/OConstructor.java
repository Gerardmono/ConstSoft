/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bakai
 */
public class OConstructor implements ActionListener{
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        
        if(presionado == boton1){
            GestorConstructor cons =new GestorConstructor();
            cons.insertarConst(texto1, texto2, texto3, texto4, pass1);
        }
    }
    
    
    
   
 
    
  
}
