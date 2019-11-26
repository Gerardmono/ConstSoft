/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.*;
import constsoft.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bakai
 */
public class OConstructor implements ActionListener{
    GUIMenuConstructor menu;
    JTextField texto1, texto2, texto4;
    JComboBox texto3;
    JPasswordField pass1, pass2;
    JButton boton1, boton2, boton3, boton4;
    JTable tabla;
    GUIListaPerfilConst lista;
    JButton boton5,boton6,boton7,boton8,boton9,boton10,boton11;

    public OConstructor(JTextField texto1, JTextField texto2, JComboBox texto3, 
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

    public OConstructor(GUIMenuConstructor menu,JButton boton5, JButton boton6, JButton boton7, JButton boton8, JButton boton9, JButton boton10,JButton boton11) {
        this.menu=menu;
        this.boton5 = boton5;
        this.boton6 = boton6;
        this.boton7 = boton7;
        this.boton8 = boton8;
        this.boton9 = boton9;
        this.boton10 = boton10;
        this.boton11 = boton11;
        
    }
    

    public OConstructor(JButton boton2, JButton boton3, JButton boton4, JTable tabla, GUIListaPerfilConst lista) {
        this.boton2 = boton2;
        this.boton3 = boton3;
        this.boton4 = boton4;
        this.tabla = tabla;
        this.lista = lista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        
        if(presionado == boton1){
            GestorConstructor cons =new GestorConstructor();
            cons.insertarConst(texto1, texto2, texto3, texto4, pass1);
        } else if (presionado == boton2) {
            //regresar
        }else if (presionado == boton3) {
            //editar
            GestorConstructor con=new GestorConstructor();
            
            
        }else if (presionado == boton4) {
            //eliminar
            GestorConstructor con=new GestorConstructor();
            con.eliminarConst(tabla);
        }else if (presionado == boton5) {
            menu.setVisible(false);
            
        }else if (presionado == boton6) {
            menu.setVisible(false);
            new GUICrearProyecto().setVisible(true);
            
        }else if (presionado == boton7) {
             menu.setVisible(false);
             GUIListaModelo lisp=new GUIListaModelo();
             new GestorModelo().llenaTabla(lisp.modeloTable);             
            lisp.setVisible(true);
        }else if (presionado == boton8) {
             menu.setVisible(false);
            new GUICrearModelo().setVisible(true);
        }else if (presionado == boton9) {
             menu.setVisible(false);
            
            GUIListaModelo lism=new GUIListaModelo();
            new GestorModelo().llenaTabla(lism.modeloTable);
            lism.setVisible(true);
        }else if (presionado == boton10) {
             menu.setVisible(false);
            new GUICrearCitaConst().setVisible(true);
        }else if (presionado == boton11) {
             
        }
    }
    
    
}
