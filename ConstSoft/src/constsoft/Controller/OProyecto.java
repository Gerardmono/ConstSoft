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
import constsoft.View.*;

/**
 *
 * @author bakai
 */
public class OProyecto implements ActionListener{

    JComboBox combo1,combo2,combo3,combo4;
    JTextField text1;
    JButton button1,button2,button3,button4;
     JTable tabla;
    GUIListaProyecto lista;

    public OProyecto(JComboBox combo1, JComboBox combo2, JComboBox combo3, JComboBox combo4, JTextField text1, JButton button1) {
        this.combo1 = combo1;
        this.combo2 = combo2;
        this.combo3 = combo3;
        this.combo4 = combo4;
        this.text1 = text1;
        this.button1 = button1;
    }

    public OProyecto(JButton button2, JButton button3, JButton button4, JTable tabla, GUIListaProyecto lista) {
        this.button2 = button2;
        this.button3 = button3;
        this.button4 = button4;
        this.tabla = tabla;
        this.lista = lista;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        GestorProyecto gproyecto = new GestorProyecto();
        if(presionado == button1){
            gproyecto.crearProyecto(combo1, combo3, combo4, text1);
            
        }
        else if(presionado == combo2){
            gproyecto.buscaridEstado(combo2.getSelectedItem().toString());
            GestorProyecto.llenarComboMunicipio(GestorProyecto.id_edo);
        }
        else if(presionado==button2){
             
             gproyecto.eliminarProyecto(tabla);
        }
    }
    
}
