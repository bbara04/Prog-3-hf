package Amoba;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MainFrame extends JFrame{
    Game game = new Game();
    MainFrame(){
        super();
        JPanel frame = new JPanel();
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.RED);
        add(frame);
        this.pack();
        setVisible(true);
        System.out.println(getSize().width + " " + getSize().height);


        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(300, 600));
        sidebar.setBackground(new Color(171, 135, 101));
        sidebar.setVisible(true);
        frame.add(sidebar, BorderLayout.EAST);


        GamePanel gamePanel = new GamePanel(game);
        gamePanel.add(new JLabel("TEST"));
        frame.add(gamePanel, BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

}
