package org.example.FrontEnd.Panels;

import java.awt.*;
import java.io.File;

import javax.swing.*;

public class MessagePanel {
        BodyPanel bodyP = new BodyPanel();
        public static JPanel outerPanel = new JPanel();
       

        public static JScrollPane msgContainer() {
               JScrollPane scrollPane = new JScrollPane(outerPanel);
                outerPanel.setLayout(new BoxLayout(outerPanel, BoxLayout.Y_AXIS));
                // outerPanel.add(panel, BorderLayout.EAST);
                 outerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                //outerPanel.setPreferredSize(new Dimension(650, 1000));
               // outerPanel.setMaximumSize(new Dimension(300, Short.MAX_VALUE));
                outerPanel.setOpaque(true);
                outerPanel.setBackground(new Color(42, 42, 62));
               
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                scrollPane.setBackground(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.setBorder(null);
                return scrollPane;
        }

        public void newMessagePanel(String text, String side) {
                JPanel newOuter = new JPanel(new BorderLayout());

                newOuter.setBackground(null);

                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));

                switch (side) {
                        case "user":
                        newOuter.add(panel, BorderLayout.EAST);
                                break;
                
                        case "ia":
                        newOuter.add(panel, BorderLayout.WEST);
                                break;
                }
                
                JTextArea dynamicTextArea = new JTextArea(text);

                panel.setBackground(Color.BLUE);

                panel.setOpaque(false);
                dynamicTextArea.setLineWrap(true);
                dynamicTextArea.setBounds(0, 0, 400, 400);
                dynamicTextArea.setLineWrap(true);
                dynamicTextArea.setWrapStyleWord(true);
                dynamicTextArea.setEditable(false);
                dynamicTextArea.setBackground(new Color(36, 36, 53));
                dynamicTextArea.setForeground(new Color(255, 242, 241));

                dynamicTextArea.setBorder(null);
                panel.add(dynamicTextArea);
                outerPanel.add(newOuter);

                // refrescar el panel
                outerPanel.revalidate();
                outerPanel.repaint();

                // envia al usuario al ultimo mensaje
                // SwingUtilities.invokeLater(() -> {
                //         scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
                // });

        }
}
