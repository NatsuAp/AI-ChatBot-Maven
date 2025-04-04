package org.example.FrontEnd;

import javax.swing.*;

public class ScrollPane {

    public static JScrollPane scrolling(){
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        return scrollPane;
    }
}
