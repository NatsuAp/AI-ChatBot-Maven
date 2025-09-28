package org.example.FrontEnd.Buttons;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.example.FrontEnd.Panels.AttachPanel;


public class RemoveImgButton {
    static JButton button;
public static JButton removeButton(){
    ImageIcon tempImg = new ImageIcon("src/main/resources/Images/cancel.png");
    Image img = tempImg.getImage().getScaledInstance(15,15,Image.SCALE_SMOOTH); //Imagen Nueva de menor tamaño
    ImageIcon cancel = new ImageIcon(img);
    button = new JButton(cancel);
    button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
        button.addMouseListener(new MouseAdapter() { // Detector de eventos
            @Override

            public void mouseEntered(MouseEvent e) { // si pasas el mouse por el boton
                button.setOpaque(true);
                button.setBackground(new Color(255, 255, 255, 30));
                button.setBorder(BorderFactory.createLineBorder(new Color(255, 255, 255, 40), 1));
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) { // Cuando quitas el mouse del boton
                button.setOpaque(false);
                button.setBackground(null);
                button.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
            }

            @Override
            public void mousePressed(MouseEvent e) { // Cuando clickeas
                
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);
                
            }

            public void mouseReleased(MouseEvent e) {
                if(!button.isEnabled()){
                    return;
                }
                button.setOpaque(false);
                AttachButton.setFile();
                AttachPanel.setVisible();
               
                
            }

            

           
        });
        return button;
}
public static void EnableButton(){
    button.setEnabled(true);
 }
 public static void disableButton(){
    button.setEnabled(false);
 }
}
