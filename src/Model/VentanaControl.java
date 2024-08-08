/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;

public class VentanaControl {
    
    public void Init_window_frame(String Title, String pathicon,Frame window){
        window.setTitle(Title);        
        window.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathicon));        
        window.setIconImage(icono);
        
    }
    public void Init_window_jdialog(String Title, String pathicon, JDialog window){
        window.setTitle(Title);        
        window.setLocationRelativeTo(null);
        Image icono = Toolkit.getDefaultToolkit().getImage(getClass().getResource(pathicon));        
        window.setIconImage(icono);
        
    }   
 

}
