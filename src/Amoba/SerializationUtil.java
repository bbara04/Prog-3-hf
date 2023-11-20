package Amoba;

import java.io.*;

public class SerializationUtil {
    private GamePanel gamePanel;
    private Game game;
    SerializationUtil(Game g, GamePanel gp){
        game = g;
        gamePanel = gp;
    }
    public void save(Object o, String file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        oos.close();
    }
    public Object load(String file) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        game = (Game) o;
        game.setGamePanel(gamePanel);
        gamePanel.setGame(game);
        return o;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
