package org.example.FrontEnd.Buttons;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.example.FrontEnd.Async.Worker;
import org.example.FrontEnd.Helper.addNewMessage;
import org.example.FrontEnd.Panels.MessagePanel;
import org.example.FrontEnd.Panels.SearchboxPanel;

public class MessageButton {

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
                startProcess();
             

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setOpaque(false);

            }
        });

        return button;
    }
    public static void startProcess(){
        if (!button.isEnabled() || !isValid()) {
            return;
        }

        SearchboxPanel.buttonSet(false);

        // Se ejecuta en un thread distinto para que no se congela la UI mientras hace
        // el llamado a la API
        Worker.createWorker(input, file).execute();
    }
    public static boolean isValid() {
        input = SearchboxPanel.getFieldText();
        file = AttachButton.getFile();
        if (input.isBlank() && file == null) {
            System.out.println("no entro");
            return false;
        }
        return true;
    }

}
