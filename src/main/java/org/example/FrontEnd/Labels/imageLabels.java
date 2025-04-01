package org.example.FrontEnd.Labels;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class imageLabels extends JLabel{
    static JLabel headerLabel = new JLabel();
    public static JLabel imgLabel(){
       
        //headerLabel.setText("AP Classroom ChatBot"); 
        
        headerLabel.setHorizontalTextPosition(JLabel.RIGHT);  //Texto a la derecha de la imagen
        headerLabel.setVerticalTextPosition(JLabel.CENTER);            //En la mitad de la imagen
       // headerLabel.setForeground(new Color(211, 211, 211)); //Color del texto
       // headerLabel.setFont(new Font("Arial", Font.BOLD,30));     //Font y tamaño del texto
        headerLabel.setVerticalAlignment(JLabel.CENTER);      //posicion vertical de la imagen (Dentro del panel)
        headerLabel.setHorizontalAlignment(JLabel.CENTER);   //posicion horizontal de la imagen (Dentro del panel)
        headerLabel.setAlignmentY(JLabel.NORTH);
        return headerLabel;
    }
    public static void setImage(String imgPath){
         
        ImageIcon OGlogo = new ImageIcon(imgPath); //Imagen tamaño original
        Image img = OGlogo.getImage().getScaledInstance(50,60,Image.SCALE_SMOOTH); //Imagen Nueva de menor tamaño
        ImageIcon newlogo = new ImageIcon(img);  //declaracion
        headerLabel.setIcon(newlogo);  //Se coloca la Imagen en el label, panel superior
    }

}
