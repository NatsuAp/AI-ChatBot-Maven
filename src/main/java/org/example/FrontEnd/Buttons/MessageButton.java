package org.example.FrontEnd.Buttons;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import org.example.BackEnd.Embeddings.*;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.UserInput.GetFinalString;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;


public class MessageButton extends EmbeddingsRequests{

    static SearchboxPanel text;

    public JButton inputButton(SearchboxPanel textParam) {
        text = textParam;
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

                sendinput(); //Esta funcion corre el proceso de creacion de embedding del input del usuario, lo compara y manda el request a la IA

            }

            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);
              

                AttachButton.setFile();  //Si el usuario adjunto una imagen, vuelve el espacio del archivo nulo nuevamente
                AttachPanel.setVisible(); //esconde otra vez el panel de attach
                
            }
        });

        return button;
    }
    public static void sendinput(){
        String input;
        String response;
        input = text.getFieldText();
        if(!input.isBlank()){
            response = GetFinalString.getPrompt(input);
            APIClient.Chat(input, response);
            System.out.println(input);
        }
    }
}
