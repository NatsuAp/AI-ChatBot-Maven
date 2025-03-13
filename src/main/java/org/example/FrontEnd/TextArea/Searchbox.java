package org.example.FrontEnd.TextArea;

import javax.swing.*;



import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Searchbox {
    private JTextField searchField;

    public JTextField textField() {
       
        searchField = new JTextField(20);


        searchField.setFont(new Font("Segoe UI", Font.BOLD, 20));
        searchField.setBackground(new Color(53, 59, 78));
        searchField.setForeground(Color.WHITE);
        searchField.setBorder(null);

        //Captura de texto cuando se presiona ENTER
        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    System.out.println(searchField.getText());
                    searchField.setText("");
                }
            }
        });
       
        
      
        return searchField;
    }
    
    
    
}
