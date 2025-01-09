package org.example.FrontEnd.Panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class SearchboxPanel {
    public JPanel createSearchbox(){
        Border border = BorderFactory.createEmptyBorder(10,10,20,20); //Para darle padding
        JPanel searchbox = new JPanel();
        JPanel OuterPanel = new JPanel(); //Para poder darle pading al panel y no a los componentes
        OuterPanel.setLayout(new BorderLayout());//para dividir la barra inferior en LEFT, RIGHT, CENTER, BOTTOM, TOP
        OuterPanel.setBackground(new Color(42, 42, 62));
        OuterPanel.setBorder(border);
        OuterPanel.setPreferredSize(new Dimension(0, 70));//tamaño preferible
        OuterPanel.add(searchbox);
        return OuterPanel;
    }
}
