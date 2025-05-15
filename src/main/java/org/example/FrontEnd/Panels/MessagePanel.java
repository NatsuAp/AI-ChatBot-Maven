package org.example.FrontEnd.Panels;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

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

        public void newMessagePanel(String text, String side, String file) {
                JPanel newOuter = new JPanel(new BorderLayout());
                JPanel imgPanel = new JPanel(new BorderLayout());
                newOuter.setBackground(null);
                imgPanel.setBackground(null);
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
                JTextArea dynamicTextArea = new JTextArea(text);
                 panel.add(dynamicTextArea);
                switch (side) {
                        case "user":
                        newOuter.add(panel, BorderLayout.EAST);
                        imgPanel.add(newImagePanel(file),BorderLayout.EAST);
                        outerPanel.add(imgPanel);
                                break;
                
                        case "ia":
                        newOuter.add(panel, BorderLayout.WEST);
                                break;
                }
                
                
                
                
                
                

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
                
        
                
                outerPanel.add(newOuter);
                
                
                // refrescar el panel
                outerPanel.revalidate();
                outerPanel.repaint();

                // envia al usuario al ultimo mensaje
                // SwingUtilities.invokeLater(() -> {
                //         scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
                // });

        }
        public JPanel newImagePanel(String file){
                JPanel newOuter = new JPanel(new BorderLayout());
                newOuter.setBackground(null);
                JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING));
                
                ImageIcon userImg = new ImageIcon(file);
                Image scaledImg = userImg.getImage().getScaledInstance(400,300,Image.SCALE_SMOOTH); 
                ImageIcon newuserImg = new ImageIcon(scaledImg);
                JLabel img = new JLabel(newuserImg);
                panel.setBackground(null);
                panel.add(img);
                newOuter.add(panel);
                return newOuter;
        }
}
