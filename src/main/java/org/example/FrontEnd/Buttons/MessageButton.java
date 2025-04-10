package org.example.FrontEnd.Buttons;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import org.apache.commons.io.FileUtils;
import org.example.BackEnd.Embeddings.*;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Requests.azureOCR;
import org.example.BackEnd.UserInput.GetFinalString;
import org.example.FrontEnd.Panels.AttachPanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class MessageButton extends EmbeddingsRequests {

    static SearchboxPanel text;
    JButton button;
    public JButton inputButton(SearchboxPanel textParam) {
        text = textParam;
        ImageIcon arrow = new ImageIcon("src\\main\\resources\\Images\\Send.png");
        button = new JButton(arrow);
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

                button.setVisible(false);  
                SearchboxPanel.setLoadingVisible(true);
                

                worker.execute(); //Se ejecuta en un thread distinto para que no se congela la UI mientras hace el llamado a la API

            }

            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);

                AttachButton.setFile(); // Si el usuario adjunto una imagen, vuelve el espacio del archivo nulo
                                        // nuevamente
                AttachPanel.setVisible(); // esconde otra vez el panel de attach

            }
        });

        return button;
    }

    public static void sendinput() {
        String input;
        String results;
        String file;
        String imgStr;
        String answer;
        byte[] fileContent;
        String encodedImg = null;

        input = text.getFieldText();
        file = AttachButton.getFile();
        if (input.isBlank() && file == null) {
            return;
        }
        if (!input.isBlank() & file == null) {

            results = GetFinalString.getPrompt(input);

            answer = APIClient.Chat(input, results, encodedImg);
            APIClient.addMesaggeHistory(input, answer);

        } else {

            try {
                fileContent = FileUtils.readFileToByteArray(new File(file));

                encodedImg = Base64.getEncoder().encodeToString(fileContent);

                imgStr = azureOCR.AzureRequest(file);

                results = GetFinalString.getPrompt(imgStr);

                if (input.isBlank()) {

                    input = "Help me";

                }

                answer = APIClient.Chat(input, results, encodedImg);

                APIClient.addMesaggeHistory(input, answer);

            } catch (IOException e) {

                e.printStackTrace();
            }

        }
    }

    SwingWorker<String, Void> worker = new SwingWorker<>() {
        @Override
        protected String doInBackground() throws Exception {
           
            sendinput(); // Esta funcion corre el proceso de creacion de embedding del input del usuario,
                             // lo compara y manda el request a la IA

                       
            return "Response from API";
        }

        @Override
        protected void done() {
            // After API call finishes
            button.setVisible(true);  
                SearchboxPanel.setLoadingVisible(false);

           
        }
    };
}
