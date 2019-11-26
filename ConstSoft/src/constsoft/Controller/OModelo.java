/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.*;
import constsoft.View.GUIListaModelo;
import constsoft.View.GUIVerModelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author bakai
 */
public class OModelo implements ActionListener {
    JTextField texto1,texto2,texto3,texto4,texto5,texto6;
    JComboBox combo2,combo3;
    JButton boton,button1,button2,button3;
    GUIListaModelo menu;
    JTable tabla;

    public OModelo(JTextField texto1, JTextField texto2, JTextField texto3, JTextField texto4, 
            JTextField texto5, JComboBox combo2, JComboBox comb3, JButton boton) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.texto5 = texto5;
        this.combo2 = combo2;
        this.combo3 = comb3;
        this.boton = boton;
    }

    public OModelo(JButton button1, JButton button2, JButton button3,JTable tabla, GUIListaModelo menu) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
        this.menu = menu;
        this.tabla=tabla;
    }
   
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        GestorModelo modelo =new GestorModelo();
        if(presionado == boton){
            
            modelo.crearModelo(texto1, texto2, texto3, texto4, texto5, combo2, combo3);  
        }else if(presionado == button1){
            new GUIVerModelo().setVisible(true);
            modelo.verModelo(tabla);
            
        }else if(presionado == button2){
            
        }else if(presionado == button3){
            modelo.eliminarModelo(tabla);
        }
    }
    
    
}
