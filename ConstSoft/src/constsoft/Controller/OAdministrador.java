/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package constsoft.Controller;

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
            new GUIListaPerfilConst().setVisible(true);
           
        } else if(presionado == boton4){
            menu.setVisible(false);
            new GUICrearProyecto().setVisible(true);
            
        } else if(presionado == boton5){
            menu.setVisible(false);
            new GUIListaProyecto().setVisible(true);
            
        } else if(presionado == boton6){
            menu.setVisible(false);
            new GUICrearReporte().setVisible(true);         
        } else if(presionado == boton6){
            menu.setVisible(false );
            new GUICrearPerfilAdmin().setVisible(true);
            
        }
    }
    
    
}
