package org.example.FrontEnd.TextArea;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

import org.example.FrontEnd.Buttons.MessageButton;

public class Searchbox {
    private JTextField searchField;
    

    public JTextField textField() {

        searchField = new JTextField(20);

        searchField.setFont(new Font("Segoe UI", Font.BOLD, 20));
        searchField.setBackground(new Color(53, 59, 78));
        searchField.setForeground(Color.WHITE);
        searchField.setBorder(null);

        // Inicia el proceso con tecla ENTER
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
              
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    MessageButton.startProcess();
    
                }
            }
        });

        return searchField;
    }

}
