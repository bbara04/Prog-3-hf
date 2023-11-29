package Amoba;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Stone osztály függvényeinek tesztjei.
 */
class StoneTest {
    static private Color color;
    static private Point pos;
    static private Stone stone;

    /**
     * Változók inicializálása.
     */
    @BeforeAll
    static void init(){
        color = Color.LIGHT_GRAY;
        pos = new Point(9, 9);
        stone = new Stone(color, pos);
    }

    /**
     * getPos függvény tesztje.
     */
    @Test
    void getPos() {
        assertEquals(pos, stone.getPos());
    }

    /**
     * getColor függvény tesztje.
     */
    @Test
    void getColor() {
        assertEquals(color, stone.getColor());
    }
}