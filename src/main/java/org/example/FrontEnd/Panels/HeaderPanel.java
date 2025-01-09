package org.example.FrontEnd.Panels;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class HeaderPanel {
    public JPanel createHeader() {
        JPanel header = new JPanel();
        Border border = BorderFactory.createEmptyBorder();           //
        header.setBackground(new Color(18,24,38,255));       //
        header.setBorder(border);                                   //    creacion del Panel donde esta el header
        header.setLayout(new BorderLayout());                        //
        header.setPreferredSize(new Dimension(0, 90)); //

        return header;
    }
}
