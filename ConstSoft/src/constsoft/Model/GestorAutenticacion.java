/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Model;

import javax.swing.*;

/**
 *
 * @author smart
 */
public class GestorAutenticacion {
    JTextField entrada1;
    JPasswordField entrada2;
    JRadioButton opcion1, opcion2;

    public GestorAutenticacion(JTextField entrada1, JPasswordField entrada2, JRadioButton opcion1, JRadioButton opcion2) {
        this.entrada1 = entrada1;
        this.entrada2 = entrada2;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
    }
    
    public void loguea(){
        
    }
}
