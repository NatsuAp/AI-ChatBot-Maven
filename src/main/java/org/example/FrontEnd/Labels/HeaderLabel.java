package org.example.FrontEnd.Labels;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
public class HeaderLabel {
    public JLabel headerLabel(){
        JLabel headerLabel = new JLabel();
        ImageIcon OGlogo = new ImageIcon("src\\main\\resources\\Images\\logo.png"); //Imagen tamaño original
        Image img = OGlogo.getImage().getScaledInstance(100,99,Image.SCALE_SMOOTH); //Imagen Nueva de menor tamaño
        ImageIcon newlogo = new ImageIcon(img);  //declaracion
        headerLabel.setText("AP Classroom ChatBot"); //se afirma el texto del label, que ira en el panel superior
        headerLabel.setIcon(newlogo);  //Se coloca la Imagen en el label, panel superior
        headerLabel.setHorizontalTextPosition(JLabel.RIGHT);  //Texto a la derecha de la imagen
        headerLabel.setVerticalTextPosition(JLabel.CENTER);            //En la mitad de la imagen
        headerLabel.setForeground(new Color(211, 211, 211)); //Color del texto
        headerLabel.setFont(new Font("Arial", Font.BOLD,30));     //Font y tamaño del texto
        headerLabel.setVerticalAlignment(JLabel.CENTER);      //posicion vertical de la imagen (Dentro del panel)
        headerLabel.setHorizontalAlignment(JLabel.CENTER);   //posicion horizontal de la imagen (Dentro del panel)
        headerLabel.setAlignmentY(JLabel.NORTH);
        return headerLabel;

    }
}
