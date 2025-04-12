package org.example.FrontEnd.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import org.example.FrontEnd.Buttons.AttachButton;
import org.example.FrontEnd.Buttons.RemoveImgButton;
import org.example.FrontEnd.Labels.imageLabels;

public class AttachPanel {
    static JPanel attach = new JPanel();
    static JPanel outer = new JPanel();

    // contenedor vacio que contiene el panel de attach
    public JPanel Outer() {

        Border border = BorderFactory.createEmptyBorder(0, 50, 20, 0);
        outer.setOpaque(false);
        outer.setLayout(new BorderLayout());
        outer.setPreferredSize(new Dimension(0, 100));
        outer.setBorder(border);
        outer.add(attach(), BorderLayout.WEST);

        return outer;
    }

    public JPanel attach() {

        Border border = BorderFactory.createEmptyBorder(0, 0, 10, 0);
        attach.setBackground(new Color(53, 59, 78));
        attach.setBorder(border);
        attach.setLayout(new BorderLayout());
        attach.setPreferredSize(new Dimension(90, 150));
        attach.setVisible(false);
        attach.add(imageLabels.imgLabel(), BorderLayout.CENTER);
        attach.add(OuterButton(), BorderLayout.NORTH);
        return attach;
    }

    public static JPanel outerButonPanel;
    static JButton removeBut = RemoveImgButton.removeButton();
    public JPanel OuterButton() {
        outerButonPanel = new JPanel();
        Border border = BorderFactory.createEmptyBorder(0, 38, 0, 0);
        outerButonPanel.setBorder(border);
        outerButonPanel.setLayout(new BorderLayout());
        outerButonPanel.add(removeBut, BorderLayout.NORTH);
        outerButonPanel.setOpaque(false);
        return outerButonPanel;
    }

    public static void setVisible() {
        if (AttachButton.getFile() == null) {
            attach.setVisible(false);
            outer.revalidate();
        } else {
            attach.setVisible(true);
            outer.revalidate();
        }
    }
    
}
