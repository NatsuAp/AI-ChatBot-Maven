package org.example.FrontEnd.Buttons;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.example.Main;
import org.example.BackEnd.Embeddings.*;
import org.example.BackEnd.Requests.APIClient;
import org.example.FrontEnd.Panels.SearchboxPanel;
import org.example.FrontEnd.TextArea.Searchbox;

public class MessageButton extends EmbeddingsRequests{
    CompareEmb comparition = new CompareEmb();
    SearchboxPanel text;
    
    public JButton inputButton(SearchboxPanel textParam) {
        this.text = textParam;
        APIClient api = new APIClient();
        Searchbox Searchbox = new Searchbox();
        ImageIcon arrow = new ImageIcon("src\\main\\resources\\Images\\Send.png");
        JButton button = new JButton(arrow);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
        button.addMouseListener(new MouseAdapter() { // Detector de eventos
            @Override

            public void mouseEntered(MouseEvent e) { // si pasas el mouse por el boton
                button.setFocusPainted(true);
                button.setBorder(BorderFactory.createEmptyBorder(0, 7, 4, 0));
                
            }

            @Override
            public void mouseExited(MouseEvent e) { // Cuando quitas el mouse del boton
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setBorder(null);
                button.setOpaque(false);
                button.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
            }

            @Override
            public void mousePressed(MouseEvent e) { // Cuando clickeas
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);
        
               // api.Chat(str);
                
                // Aqui falta la funcion que llame a la API
            }

            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);
                System.out.println(text.getFieldText());
            
                
            }
        });

        return button;
    }
}
