package org.example.FrontEnd;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import org.example.FrontEnd.Labels.HeaderLabel;
import org.example.FrontEnd.Panels.*;
;

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

        JPanel bodyPanel = bodyP.Body();

        headerPanel.add(headerLabel);

        frame.add(searchPanel, BorderLayout.SOUTH);
        frame.add(headerPanel, BorderLayout.NORTH); // se añaden los paneles al frame
        frame.add(bodyPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

}
