package org.example.FrontEnd;

import javax.swing.*;
import java.awt.*;

public class Frame {
    public static JFrame createFrame() {
        JFrame frame = new JFrame();
        frame.setTitle("ChatBot"); //Titulo Programa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cuando cierras la ventana cierra el programa
        frame.setResizable(true); //Se puede editar el tamaño
        frame.setSize(650, 1000); //Tamaño del frame
        ImageIcon logo = new ImageIcon("src/main/resources/logo.png"); //directorio de imagen
        frame.setIconImage(logo.getImage());  //Imagen
        frame.setLayout(new BorderLayout());  //para posicionar los futuros paneles
        frame.getContentPane().setBackground(new Color(42, 42, 62));  //fondo del frame

        return frame;
    }
}
