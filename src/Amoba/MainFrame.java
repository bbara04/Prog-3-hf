package Amoba;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    public SerializationUtil serializationUtil;
    MainFrame(){
        super();
        JPanel frame = new JPanel();
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(900, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(frame);
        this.pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        Game game = new Game();
        GamePanel gamePanel = new GamePanel(game);
        game.setGamePanel(gamePanel);
        frame.add(gamePanel, BorderLayout.CENTER);

        serializationUtil = new SerializationUtil(game, gamePanel);

        MenuPanel menuPanel = new MenuPanel();
        menuPanel.setSerializationUtil(serializationUtil);
        frame.add(menuPanel, BorderLayout.EAST);


    }
    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }

}
