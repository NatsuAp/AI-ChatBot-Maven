package org.example.FrontEnd.TextArea;

import javax.swing.*;
import java.awt.*;

public class Searchbox {
    public JScrollPane SearchB(){
        JTextArea Searchbox = new JTextArea();
        Searchbox.setLineWrap(true);
        Searchbox.setWrapStyleWord(true);
        Searchbox.setBackground(new Color(53, 59, 78));

        Searchbox.setFont(new Font("Segoe UI", Font.BOLD, 20));
        Searchbox.setForeground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(Searchbox);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); //Si el texto es demasiado largo se habilita para
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // scrollear
        scrollPane.setBorder(null);
        scrollPane.setOpaque(false);
        scrollPane.setBackground(new Color(53, 59, 78));
        return scrollPane;

    }
}
