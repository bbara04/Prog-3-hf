package Amoba;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MenuPanel extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private SerializationUtil serializationUtil;
    private Image bg;
    MenuPanel() {
        super();
        setPreferredSize(new Dimension(300, 600));
        try {
            bg = ImageIO.read(new File("forest.png"));
        } catch (IOException e) {
            setBackground(new Color(11, 41, 10));
        }

        setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));

        button1 = new JButton("RESET");
        button1.setPreferredSize(new Dimension(150,80));
        button1.setBackground(new Color(46, 29, 13));
        button1.setForeground(Color.LIGHT_GRAY);
        button1.setFocusPainted(false);
        button1.addActionListener(x -> serializationUtil.getGame().reset());


        button2 = new JButton("SAVE");
        button2.setPreferredSize(new Dimension(150,80));
        button2.setBackground(new Color(46, 29, 13));
        button2.setForeground(Color.LIGHT_GRAY);
        button2.setFocusPainted(false);
        button2.addActionListener(new SerializableButtonListener());


        button3 = new JButton("LOAD");
        button3.setPreferredSize(new Dimension(150,80));
        button3.setBackground(new Color(46, 29, 13));
        button3.setForeground(Color.LIGHT_GRAY);
        button3.setFocusPainted(false);
        button3.addActionListener(new SerializableButtonListener());


        button4 = new JButton("EXIT");
        button4.setPreferredSize(new Dimension(150,80));
        button4.setBackground(new Color(46, 29, 13));
        button4.setForeground(Color.LIGHT_GRAY);
        button4.setFocusPainted(false);
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
    public void paintComponent(Graphics g){
        g.drawImage(bg, 0, 0, this);
    }
    public class SerializableButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource().equals(button2)){
                try {
                    serializationUtil.save(serializationUtil.getGame(), "game.txt");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if(e.getSource().equals(button3)){
                try {
                    serializationUtil.load("game.txt");
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
