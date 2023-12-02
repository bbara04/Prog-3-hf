package Amoba;

import java.io.*;
import java.util.ArrayList;

/**
 * A Game osztály szerializációjáért felelős osztály, ez végzi az osztály kiírását és beolvasását.
 */
public class SerializationUtil {
    private GamePanel gamePanel;
    private Game game;
    SerializationUtil(Game g, GamePanel gp){
        game = g;
        gamePanel = gp;
    }

    /**
     * Kiírja a kapott objektumot a kapott file-ba.
     * @param o kiírandó osztály.
     * @param file a fájl amibe kiírunk.
     * @throws IOException
     */
    public void save(Object o, String file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(o);
        oos.close();
    }

    /**
     * Beolvassa az objektumot a kapott file-ból.
     * @param file a fájl amiből olvasunk.
     * @throws IOException
     */
    public Object load(String file) throws IOException, ClassNotFoundException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        ois.close();
        game = (Game) o;
        game.setGamePanel(gamePanel);
        gamePanel.setGame(game);
        gamePanel.setDrawList(new ArrayList<ArrayList<Integer>>());
        return o;
    }

    /**
     * Game getter-e.
     * @return
     */
    public Game getGame() {
        return game;
    }

    /**
     * Game setter-e.
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     * GamePanel getter-e.
     * @return
     */
    public GamePanel getGamePanel() {
        return gamePanel;
    }

    /**
     * GamePanel setter-e.
     * @param gamePanel
     */
    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }
}
