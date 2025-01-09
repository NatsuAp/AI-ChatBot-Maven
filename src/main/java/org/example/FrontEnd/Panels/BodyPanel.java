package org.example.FrontEnd.Panels;

import javax.swing.*;
import java.awt.*;

public class BodyPanel extends JPanel{
    public JPanel Body(){
        JPanel body = new JPanel();
        body.setBackground(new Color(42, 42, 62));   //Cuerpo del frame, donde van los mensajes
        //FALTA AÑADIR LAYOUT PARA LOS MENSAJES

        return body;
    }
}
