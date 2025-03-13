package org.example.FrontEnd.Panels;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AttachPanel {
 public JPanel attach() {
        JPanel attach = new JPanel();
        Border border = BorderFactory.createEmptyBorder();           
        attach.setBackground(new Color(51, 0, 0));       
        attach.setBorder(border);                                   
        attach.setLayout(new BorderLayout());                        
        attach.setPreferredSize(new Dimension(0, 90)); 
        
        return attach;
    }
}
