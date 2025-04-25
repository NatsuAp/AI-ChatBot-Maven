package org.example.FrontEnd.Frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

import org.example.FrontEnd.Labels.HeaderLabel;
import org.example.FrontEnd.Panels.*;;

public class FrameBuilder {
    // public JTextField textArea;
    public void frameSetup() {
        HeaderPanel headerP = new HeaderPanel(); //

        SearchboxPanel searchboxP = new SearchboxPanel();// importacion archivos

        HeaderLabel headerL = new HeaderLabel();//

        BodyPanel bodyP = new BodyPanel();

        JFrame frame = Frame.createFrame();//

        JPanel headerPanel = headerP.createHeader();//

        JLabel headerLabel = headerL.headerLabel();//

        JPanel searchPanel = searchboxP.createSearchbox();// importacion metodos
        MessagePanel mp = new MessagePanel();
        
        JScrollPane msg = MessagePanel.msgContainer();
        JPanel bodyPanel = bodyP.Body();

        bodyPanel.add(msg, BorderLayout.CENTER);

        headerPanel.add(headerLabel);

        frame.add(searchPanel, BorderLayout.SOUTH);

        frame.add(headerPanel, BorderLayout.NORTH); // se añaden los paneles al frame

        frame.add(bodyPanel, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);

    }

}
