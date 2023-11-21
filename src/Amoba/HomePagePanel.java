package Amoba;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class HomePagePanel extends JPanel {
    private JButton button;
    Image bg;
    HomePagePanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER, 20, 250));
        setPreferredSize(new Dimension(900, 600));
        try {
            bg = ImageIO.read(new File("forest.png"));
        } catch (IOException e) {

        }
        button = new JButton("New Game");
        button.setPreferredSize(new Dimension(140, 80));
        button.setBackground(new Color(41, 30, 19));
        button.setForeground(Color.LIGHT_GRAY);
        button.setFocusPainted(false);
        add(button);
    }
    @Override
    public void paintComponent(Graphics g){
        g.drawImage(bg, 0, 0, this);
    }
    public JButton getButton(){
        return button;
    }
}
