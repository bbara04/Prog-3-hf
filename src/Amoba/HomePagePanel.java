package Amoba;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * A játék megkezdése előtti kezdőpanel.
 * @author Balogh Barnabás
 */
public class HomePagePanel extends JPanel {
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private Image bg;
    private SerializationUtil serializationUtil;
    private MainFrame mainFrame;
    HomePagePanel(MainFrame mainFrame) {
        super();
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout(FlowLayout.CENTER, 70, 250));
        setPreferredSize(new Dimension(900, 600));
        try {
            bg = ImageIO.read(new File("forest.png"));
        } catch (IOException e) {

        }
        button1 = new JButton("NEW GAME");
        button1.setPreferredSize(new Dimension(140, 80));
        button1.setBackground(new Color(46, 29, 13));
        button1.setForeground(Color.LIGHT_GRAY);
        button1.setFocusPainted(false);
        add(button1);

        button2 = new JButton("LOAD GAME");
        button2.setPreferredSize(new Dimension(140, 80));
        button2.setBackground(new Color(46, 29, 13));
        button2.setForeground(Color.LIGHT_GRAY);
        button2.setFocusPainted(false);
        add(button2);

        button3 = new JButton("EXIT");
        button3.setPreferredSize(new Dimension(140, 80));
        button3.setBackground(new Color(46, 29, 13));
        button3.setForeground(Color.LIGHT_GRAY);
        button3.setFocusPainted(false);
        button3.addActionListener(x -> System.exit(0));
        add(button3);
    }

    /**
     * A panelre kirajzolt elemekért felelős függvény jelen esetben a háttér kirajzolásáért.
     * @param g the <code>Graphics</code> object to protect
     */
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(bg, 0, 0, this);
    }

    /**
     * NewGameButton getter-e.
     * @return
     */
    public JButton getNewGameButton(){
        return button1;
    }

    /**
     * LoadGameButton getter-e.
     * @return
     */
    public JButton getLoadGameButton(){ return button2; }
}
