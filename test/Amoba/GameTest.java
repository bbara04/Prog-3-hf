package Amoba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Game osztály függvényeinek tesztje.
 */
class GameTest {

    private Game game = new Game();

    /**
     * Game osztály checkTaken függvényének tesztje.
     */
    @Test
    void checkTaken() {
        try {
            game.lep(new Point(300, 300));
        } catch (GameEndException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(true, game.checkTaken(new Point(300, 300)));
        Assertions.assertEquals(false, game.checkTaken(new Point(270, 300)));
    }

    /**
     * Game osztály fixStonePos függvényének tesztje.
     */
    @Test
    void fixStonePos() {
        Assertions.assertEquals(new Point(300, 300), game.fixStonePos(new Point(290, 290)));
        Assertions.assertEquals(new Point(300, 300), game.fixStonePos(new Point(310, 310)));
    }

    /**
     * Game osztály checkStonePos függvényének tesztje.
     */
    @Test
    void checkStonePos() {
        Assertions.assertTrue(game.checkStonePos(new Point(295, 295)));
        Assertions.assertEquals(false, game.checkStonePos(new Point(290, 290)));
        Assertions.assertTrue(game.checkStonePos(new Point(305, 305)));
        Assertions.assertEquals(false, game.checkStonePos(new Point(310, 310)));
    }

    /**
     * Game osztály posToIntArray függvényének tesztje.
     */
    @Test
    void posToIntArray() {
        assertEquals(new Point(5, 5), game.posToIntArray(new Point(240, 240)));
        assertEquals(new Point(8, 8), game.posToIntArray(new Point(330, 330)));
    }
}