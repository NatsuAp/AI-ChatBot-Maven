package org.example.FrontEnd.Labels;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LoadingLabel {

    public static ImageIcon loading() {
        ImageIcon loadingIcon = new ImageIcon("src\\main\\resources\\Images\\loading (2).gif"); 
        //Image img = loadingIcon.getImage().getScaledInstance(110,1000,Image.SCALE_SMOOTH); //Imagen Nueva de menor tamaño
        //ImageIcon newLoading = new ImageIcon(img);  //declaracion
        return loadingIcon;
    }
}
