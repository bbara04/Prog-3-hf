package Amoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MenuPanel extends JPanel {
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    SerializationUtil serializationUtil;
    MenuPanel() {
        super();
        setPreferredSize(new Dimension(300, 600));
        setBackground(new Color(11, 41, 10));

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        button1 = new JButton("RESET");
        button1.setPreferredSize(new Dimension(150,80));
        button1.addActionListener(x -> serializationUtil.getGame().reset());


        button2 = new JButton("SAVE");
        button2.setPreferredSize(new Dimension(150,80));
        button2.addActionListener(new SerializableButtonListener());


        button3 = new JButton("LOAD");
        button3.setPreferredSize(new Dimension(150,80));
        button3.addActionListener(new SerializableButtonListener());


        button4 = new JButton("EXIT");
        button4.setPreferredSize(new Dimension(150,80));
        button4.addActionListener(x -> System.exit(0));

        add(button1);
        add(button2);
        add(button3);
        add(button4);
    }

    public void setSerializationUtil(SerializationUtil serializationUtil) {
        this.serializationUtil = serializationUtil;
    }

    public SerializationUtil getSerializationUtil() {
        return serializationUtil;
    }

    public class SerializableButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(button2)){
                try {
                    serializationUtil.save(serializationUtil.getGame(), "game1.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource().equals(button3)){
                try {
                    serializationUtil.load("game1.txt");
                    serializationUtil.getGamePanel().repaint();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                } catch (ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }


}
