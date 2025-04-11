package org.example.FrontEnd.Panels;

import javax.swing.*;
import javax.swing.border.Border;

import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.MessageButton;
import org.example.FrontEnd.Labels.LoadingLabel;
import org.example.FrontEnd.TextArea.Searchbox;

import java.awt.*;

public class SearchboxPanel {
    public AttachButton buttonC;
    public MessageButton inButton;
    public JButton AttachButton;
    
    public JTextField textArea;
    public Searchbox textA;
    public AttachPanel atc;
    public JPanel attach;

    public SearchboxPanel() {
        this.buttonC = new AttachButton();//
        
        this.AttachButton = this.buttonC.sendButton();//
        this.textA = new Searchbox();
        
        this.atc = new AttachPanel();
        this.attach = atc.Outer();
    }

  

    public JPanel createSearchbox() {
        Border border = BorderFactory.createEmptyBorder(10, 10, 30, 20); // Para darle padding
        JPanel inner = innerbox();
        JPanel OuterPanel = new JPanel(); // Para poder darle pading al panel y no a los componentes

        OuterPanel.setLayout(new BorderLayout());// para dividir la barra inferior en LEFT, RIGHT, CENTER, BOTTOM, TOP
        OuterPanel.setBackground(new Color(32, 50, 100));
        OuterPanel.setOpaque(false);
        OuterPanel.setBorder(border);
        OuterPanel.setPreferredSize(new Dimension(0, 160));// tamaño preferible
        OuterPanel.add(inner, BorderLayout.SOUTH);
        OuterPanel.add(attach, BorderLayout.NORTH);
       
        return OuterPanel;
    }
    static JButton MessageB = MessageButton.inputButton();
    public JPanel innerbox() {

        JPanel inner = new JPanel();
        Border border = BorderFactory.createEmptyBorder(0, 0, 0, 0);

        inner.setLayout(new BorderLayout());
        inner.setBackground(new Color(48, 52, 63));
        inner.setBorder(border);
        textArea = textA.textField();
        inner.add(MessageB, BorderLayout.EAST);
        inner.add(AttachButton, BorderLayout.WEST);
        inner.add(textArea, BorderLayout.CENTER);
       
        return inner;

    }
    static ImageIcon arrow = new ImageIcon("src\\main\\resources\\Images\\Send.png");
    public static void buttonSet(){
        MessageB.setOpaque(false);
        MessageB.setIcon(arrow);
        MessageB.setEnabled(true);
    }
    // funcion que captura el texto del textfield
    public String getFieldText() {
        String str = textArea.getText();
        textArea.setText("");
        return str;
    }

   
}
