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
public class OModelo implements ActionListener{
    JTextField texto1,texto2,texto3,texto4,texto5;
    JComboBox combo1,combo2,comb3;
    JButton boton;

    public OModelo(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, 
            JTextField texto5, JComboBox combo1, JComboBox combo2, JComboBox comb3, JButton boton) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.texto5 = texto5;
        this.combo1 = combo1;
        this.combo2 = combo2;
        this.comb3 = comb3;
        this.boton = boton;
    }
   
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        
        if(presionado == boton){
            GestorModelo modelo =new GestorModelo();
           
        }
    }
    
    
}
