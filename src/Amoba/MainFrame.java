package Amoba;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A fő panel. Ez tárolja a program által használt paneleket. Ez végzi a panelek cseréjét is.
 * @author Balogh Barnabás
 */
public class MainFrame extends JFrame {
    private HomePagePanel homePagePanel;
    private JPanel frame;
    private GamePanel gamePanel;
    private MenuPanel menuPanel;
    public SerializationUtil serializationUtil;

    MainFrame() {
        super();
        homePagePanel = new HomePagePanel(this);
        add(homePagePanel);
        homePagePanel.getNewGameButton().addActionListener(x -> {
            this.getContentPane().removeAll();
            this.add(frame);
            revalidate();
        });
        homePagePanel.getLoadGameButton().addActionListener(x -> {
            this.getContentPane().removeAll();
            try {
                serializationUtil.load("game.txt");
            } catch (Exception e) {
                System.out.println("A megadott fileból nem lehet beolvasni.");
            }
            this.add(frame);
            revalidate();
        });
        this.pack();

        frame = new JPanel();
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(900, 600));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.revalidate();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

        Game game = new Game();
        gamePanel = new GamePanel(game);
        game.setGamePanel(gamePanel);
        frame.add(gamePanel, BorderLayout.CENTER);

        serializationUtil = new SerializationUtil(game, gamePanel);

        menuPanel = new MenuPanel();
        menuPanel.setSerializationUtil(serializationUtil);
        frame.add(menuPanel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
    }
}