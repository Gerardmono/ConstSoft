/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.GestorAutenticacion;
import constsoft.View.GUILogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventListener;
import javax.swing.*;

/**
 *
 * @author bakai
 */
public class OAutenticacion implements ActionListener{
    GUILogin login;
    JButton jButton1;
    JTextField campo1;
    JPasswordField campo2;
    JRadioButton opcion1, opcion2;

    public OAutenticacion(GUILogin login, JButton jButton1, JTextField campo1, 
            JPasswordField campo2, JRadioButton opcion1, JRadioButton opcion2) {
        this.login = login;
        this.jButton1 = jButton1;
        this.campo1 = campo1;
        this.campo2 = campo2;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Object botonPresionado = ae.getSource();
        if(botonPresionado==jButton1){
            new GestorAutenticacion(campo1, campo2, opcion1, opcion2 );
        }
    }
    
}
