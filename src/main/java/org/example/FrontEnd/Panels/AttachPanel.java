package org.example.FrontEnd.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import org.example.Main;
import org.example.FrontEnd.Buttons.AttachButton;

public class AttachPanel {
    JPanel attach = new JPanel();
    JPanel outer = new JPanel();

    
    public JPanel Outer() {
        
        Border border = BorderFactory.createEmptyBorder(0,50,0,0);
        outer.setOpaque(false);
        outer.setLayout(new BorderLayout());
        outer.setPreferredSize(new Dimension(0,100));
        outer.setBorder(border);
        outer.add(attach(), BorderLayout.WEST);
        
        return outer;
    }

    public JPanel attach() {
        
        Border border = BorderFactory.createEmptyBorder(0,0,0,0);
        attach.setBackground(new Color(53, 59, 78));
        attach.setBorder(border);
        attach.setLayout(new BorderLayout());
        attach.setPreferredSize(new Dimension(200, 300));
        attach.setVisible(setVisible());
        
        return attach;
    }
   Main main = new Main();
    public Boolean setVisible(){
        if(main.sendFile()==null){
            return false;
        }else{
           return true;
        }
        
    }
}
