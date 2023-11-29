package Amoba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * SerializationUtil osztály függvényeinek tesztje.
 */
class SerializationUtilTest {

    static private Game game;
    static private GamePanel gamePanel;
    static private SerializationUtil serializationUtil;

    /**
     * Változók inicializáslása.
     */
    @BeforeAll
    static void init(){
        game = new Game();
        gamePanel = new GamePanel(game);
        game.setGamePanel(gamePanel);
        serializationUtil = new SerializationUtil(game, gamePanel);
    }

    /**
     * Save függvény tesztje.
     */
    @Test
    void save() {
        try {
            serializationUtil.save(game, "test.txt");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    /**
     * Load függvény tesztje.
     */
    @Test
    void load() {
        try {
            serializationUtil.load("test.txt");
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
        Assertions.assertArrayEquals(new int[15][15], game.getTable());
    }
}