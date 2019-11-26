/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.GestorConstructor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import constsoft.Model.*;

/**
 *
 * @author bakai
 */
public class OProyecto implements ActionListener{

    JComboBox combo1,combo2,combo3,combo4;
    JTextField text1;
    JButton button1;

    public OProyecto(JComboBox combo1, JComboBox combo2, JComboBox combo3, JComboBox combo4, JTextField text1, JButton button1) {
        this.combo1 = combo1;
        this.combo2 = combo2;
        this.combo3 = combo3;
        this.combo4 = combo4;
        this.text1 = text1;
        this.button1 = button1;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        GestorProyecto gproyecto = new GestorProyecto();
        if(presionado == button1){
            gproyecto.crearProyecto(combo1, combo3, combo4, text1);
            
        }
        if(presionado == combo2){
            gproyecto.buscaridEstado(combo2.getSelectedItem().toString());
            GestorProyecto.llenarComboMunicipio(GestorProyecto.id_edo);
        }
    }
    
}
