package org.example.FrontEnd.Buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.example.BackEnd.Helpers.Base64Coder;
import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.Requests.azureOCR;

import org.example.BackEnd.UserInput.GetFinalString;
import org.example.FrontEnd.Async.Worker;
import org.example.FrontEnd.Labels.LoadingLabel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class MessageButton {
    static ImageIcon load = LoadingLabel.loading();

    public static JButton button = new JButton();
    static ImageIcon arrow = new ImageIcon("src\\main\\resources\\Images\\Send.png");
    static String input;
    static String file;

    public static JButton inputButton() {

        
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        button.setIcon(arrow);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);
        button.setBorder(BorderFactory.createEmptyBorder(0, 7, 0, 0));
        // listener si el usuario presiona la tecla ENTER, hace lo mismo que si el
        // usuario presiona el boton
        
        button.addMouseListener(new MouseAdapter() { // Listener para el boton
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
                if (!button.isEnabled()) {
                    return;
                }
                startProcess();
            }

            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);

            }
        });
        

        return button;
    }
    //Inicia el proceso y controla los inputs
    public static void startProcess() {
        button.setBackground(Color.LIGHT_GRAY);
        button.setOpaque(true);

        input = SearchboxPanel.getFieldText();
        file = AttachButton.getFile();
        if ((!input.isEmpty() && file != null) ||
                (input.isEmpty() && file != null) ||
                (!input.isEmpty() && file == null)) {

            System.out.println("entro");
            SearchboxPanel.buttonSet(false);

            Worker.createWorker().execute();

            // Se ejecuta en un thread distinto para que no se congela la UI mientras hace
            // el llamado a la API
        } else {
            System.out.println("no entro");
        }

    }

    public static void sendinput() { // TODO: Modificar esta funcion para que reciba la respuesta de la IA, Y eventualmente la retorne.
                                     

        String results;
        String imgStr;
        String answer;
        String encodedImg = null;

        if (!input.isBlank() & file == null) {

            results = GetFinalString.getPrompt(input);

            answer = APIClient.Chat(input, results, encodedImg);

            APIClient.addMesaggeHistory(input, answer);

        } else {

            encodedImg = Base64Coder.encode(file);

            imgStr = azureOCR.AzureRequest(file);

            results = GetFinalString.getPrompt(imgStr);

            if (input.isBlank()) {

                input = "Help me";

            }

            answer = APIClient.Chat(input, results, encodedImg);

            APIClient.addMesaggeHistory(input, answer);

        }
    }

    public static void disableButton() {
        button.setEnabled(false);
    }

    public static void EnableButton() {
        button.setEnabled(true);
    }
}
