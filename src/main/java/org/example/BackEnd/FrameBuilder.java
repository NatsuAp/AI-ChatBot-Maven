package org.example.BackEnd;


import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import org.example.FrontEnd.Frame;
import org.example.FrontEnd.Labels.HeaderLabel;
import org.example.FrontEnd.Panels.*;
import org.example.FrontEnd.TextArea.Searchbox;
import org.example.FrontEnd.Buttons.*;

public class FrameBuilder {
    public void frameSetup(){
        HeaderPanel headerP = new HeaderPanel();  //
        SearchboxPanel searchboxP = new SearchboxPanel();//  importacion archivos
        HeaderLabel headerL = new HeaderLabel();//
        AttachButton buttonC = new AttachButton();//
        MessageButton inButton = new MessageButton();//
        BodyPanel bodyP = new BodyPanel();
        Searchbox textA = new Searchbox();
        JFrame frame = Frame.createFrame();//
        JPanel headerPanel = headerP.createHeader();//
        JLabel headerLabel = headerL.headerLabel();//
        JPanel searchPanel =searchboxP.createSearchbox();//  importacion metodos
        JButton AttachButton = buttonC.sendButton();//
        JButton MessageButton = inButton.inputButton(); //
        JPanel bodyPanel= bodyP.Body();
        JScrollPane Searchbox = textA.SearchB();
        headerPanel.add(headerLabel);
        searchPanel.add(MessageButton, BorderLayout.EAST);
        searchPanel.add(AttachButton, BorderLayout.WEST); //Se añaden componentes como los botones y la caja de texto a los paneles
        searchPanel.add(Searchbox, BorderLayout.CENTER);

        frame.add(searchPanel, BorderLayout.SOUTH);
        frame.add(headerPanel, BorderLayout.NORTH);  //se añaden los paneles al frame
        frame.add(bodyPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
