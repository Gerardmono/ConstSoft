/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

import constsoft.Model.GestorAdministrador;
import constsoft.Model.*;
import constsoft.View.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author bakai
 */
public class OAdministrador implements ActionListener{
    GUIMenuAdmin menu;
    JButton boton1, boton2, boton3, boton4, boton5, boton6, boton7;
    JTextField texto1, texto2, texto3, texto4;
    JPasswordField pass1, pass2;
    JButton guardar;

    public OAdministrador(GUIMenuAdmin menu, JButton boton1, JButton boton2, 
            JButton boton3, JButton boton4, JButton boton5, JButton boton6, JButton boton7) {
        this.menu = menu;
        this.boton1 = boton1;
        this.boton2 = boton2;
        this.boton3 = boton3;
        this.boton4 = boton4;
        this.boton5 = boton5;
        this.boton6 = boton6;
        this.boton7 = boton7; 
    }

    public OAdministrador(JTextField texto1, JTextField texto2, JTextField texto3, 
            JTextField texto4, JPasswordField pass1, JPasswordField pass2, JButton guardar) {
        this.texto1 = texto1;
        this.texto2 = texto2;
        this.texto3 = texto3;
        this.texto4 = texto4;
        this.pass1 = pass1;
        this.pass2 = pass2;
        this.guardar = guardar;
    }

  

    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object presionado = e.getSource();
        if(presionado == boton1){
             menu.setVisible(false);
            new GUIVerPerfilAdmin().setVisible(true);
           
        } else if(presionado == boton2){
            menu.setVisible(false);
            new GUICrearPerfilContructor().setVisible(true);
            
        } else if(presionado == boton3){
            menu.setVisible(false);
            GUIListaPerfilConst lisC=new GUIListaPerfilConst();
            new GestorConstructor().llenaTabla(lisC.jTable1);
            lisC.setVisible(true);
           
        } else if(presionado == boton4){
            menu.setVisible(false);
            new GUICrearProyecto().setVisible(true);
            
        } else if(presionado == boton5){
            menu.setVisible(false);
            //new GUIListaProyecto().setVisible(true);
            GUIListaProyecto lisP=new GUIListaProyecto();
            new GestorProyecto().llenaTabla(lisP.proyectoTabla);
            lisP.setVisible(true);
            
        } else if(presionado == boton6){
            menu.setVisible(false);
            new GUICrearReporte().setVisible(true);         
        } else if(presionado == boton6){
            menu.setVisible(false );
            new GUICrearPerfilAdmin().setVisible(true);   
        }else if(presionado == guardar){
            GestorAdministrador admin= new GestorAdministrador();
            admin.crearAdministrador(texto1, texto2, texto3, texto4, pass1, pass2);
        }
    }
    
    
}
