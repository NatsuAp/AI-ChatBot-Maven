package org.example.FrontEnd.Panels;
import javax.swing.*;
import java.awt.*;

public class BodyPanel extends JPanel{
    public JPanel Body(){
        JPanel body = new JPanel();
        body.setBackground(new Color(42, 42, 62));   //Cuerpo del frame, donde van los mensajes
        body.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        body.setLayout(new BorderLayout());
        //TODO: Interfraz mas o menos, revisar la posibilidad de integrar "MARKDOWN" para las respuestas de la IA
        body.add(MessagePanel.msgContainer(), BorderLayout.CENTER);
      
        return body;
    }
}
