package org.example.FrontEnd.TextArea;

import javax.swing.*;

import org.example.BackEnd.Requests.APIClient;
import org.example.BackEnd.UserInput.GetFinalString;
import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.MessageButton;
import org.example.FrontEnd.Panels.AttachPanel;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Searchbox {
    private JTextField searchField;
    GetFinalString request = new GetFinalString();

    public JTextField textField() {
        String input;
        String response;
        searchField = new JTextField(20);

        searchField.setFont(new Font("Segoe UI", Font.BOLD, 20));
        searchField.setBackground(new Color(53, 59, 78));
        searchField.setForeground(Color.WHITE);
        searchField.setBorder(null);

        // Captura de texto cuando se presiona ENTER
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String input;
                String response;
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {

                    MessageButton.sendinput();
                    AttachButton.setFile(); // Si el usuario adjunto una imagen, vuelve el espacio del archivo nulo nuevamente
                    AttachPanel.setVisible(); // esconde otra vez el panel de attach
                }
            }
        });

        return searchField;
    }

}
