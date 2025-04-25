package org.example.FrontEnd.Panels;

import java.awt.*;
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
                outerPanel.setBackground(Color.BLUE);
               
                scrollPane.getVerticalScrollBar().setUnitIncrement(16);
                scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
                scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                scrollPane.setBackground(null);
                scrollPane.setOpaque(false);
                scrollPane.getViewport().setOpaque(false);
                scrollPane.setBorder(null);
                return scrollPane;
        }

        public void newMessagePanel(String text) {
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
                JTextArea dynamicTextArea = new JTextArea(text);
                panel.setBackground(null);
                panel.setOpaque(false);
                dynamicTextArea.setLineWrap(true);
                dynamicTextArea.setBounds(0, 0, 400, 400);
                dynamicTextArea.setLineWrap(true);
                dynamicTextArea.setWrapStyleWord(true);
                dynamicTextArea.setEditable(false);
                dynamicTextArea.setBackground(null);
                dynamicTextArea.setForeground(new Color(12, 223, 233));

                dynamicTextArea.setBorder(null);
                panel.add(dynamicTextArea);
                outerPanel.add(panel);

                // refrescar el panel
                outerPanel.revalidate();
                outerPanel.repaint();

                // envia al usuario al ultimo mensaje
                // SwingUtilities.invokeLater(() -> {
                //         scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
                // });

        }
}
