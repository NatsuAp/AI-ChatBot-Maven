package org.example.FrontEnd.Buttons;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class AttachButton {
    public JButton sendButton() {

        ImageIcon clip = new ImageIcon("src/main/resources/Clip.png"); // imagen
        JButton button = new JButton(clip); // Recibe como parametro la imagen
        Border border = BorderFactory.createEmptyBorder(0, 0, 4, 0); // Declaracion parametros de borde invisible
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false); // Para quitar los bordes, rellenos usuales del boton y dejar solo la imagen
        button.setBorder(null);
        button.setOpaque(false);

        button.addMouseListener(new MouseAdapter() { // Detector de eventos
            @Override
            public void mouseEntered(MouseEvent e) { // si pasas el mouse por el boton
                button.setFocusPainted(true);
                button.setBorder(border);
            }

            @Override
            public void mouseExited(MouseEvent e) { // Cuando quitas el mouse del boton
                button.setBorderPainted(false);
                button.setContentAreaFilled(false);
                button.setFocusPainted(false);
                button.setBorder(null);
                button.setOpaque(false);
            }

            @Override
            public void mousePressed(MouseEvent e) { // Cuando clickeas
                button.setBackground(Color.LIGHT_GRAY);
                button.setOpaque(true);

                // Aqui falta la funcion que llame a enviar cualquier imagen
            }
        });

        return button;
    }
}
