package Amoba;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * GamePlayUtil függvényeinek tesztjei.
 * @author Balogh Barnabás
 */
class GamePlayUtilTest {
    private int [][] palya= {
            {1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1},
    };
    private GamePlayUtil gamePlayUtil = new GamePlayUtil();

    /**
     * A GamePlayUtil checkMultipleLines függvényének különböző eseteinek tesztelése.
     */
    @Test
    void checkMultipleLines() {
        Assertions.assertEquals(4, gamePlayUtil.checkMultipleLines(palya, new Point(7, 7), 1, 5).size());
        Assertions.assertEquals(3, gamePlayUtil.checkMultipleLines(palya, new Point(0, 0), 1, 5).size());
        Assertions.assertEquals(3, gamePlayUtil.checkMultipleLines(palya, new Point(0, 14), 1, 5).size());
        Assertions.assertEquals(3, gamePlayUtil.checkMultipleLines(palya, new Point(14, 0), 1, 5).size());
        Assertions.assertEquals(3, gamePlayUtil.checkMultipleLines(palya, new Point(14, 14), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(7, 0), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(7, 14), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(0, 7), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(14, 7), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(1, 1), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(1, 13), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(13, 1), 1, 5).size());
        Assertions.assertEquals(1, gamePlayUtil.checkMultipleLines(palya, new Point(13, 13), 1, 5).size());
        Assertions.assertEquals(0, gamePlayUtil.checkMultipleLines(palya, new Point(2, 3), 1, 5).size());
    }

    /**
     * A GamePlayUtil checkHorizontalLine függvényének különböző eseteinek tesztelése.
     */
    @Test
    void checkHorzontalLine() {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(0);
        coords.add(0);
        coords.add(4);
        coords.add(0);
        Assertions.assertEquals(coords, gamePlayUtil.checkHorzontalLine(palya, new Point(2, 0), 1, 5));

        coords.clear();
        coords.add(0);
        coords.add(7);
        coords.add(4);
        coords.add(7);
        Assertions.assertEquals(coords, gamePlayUtil.checkHorzontalLine(palya, new Point(0, 7), 1, 5));

        coords.clear();
        coords.add(10);
        coords.add(0);
        coords.add(14);
        coords.add(0);
        Assertions.assertEquals(coords, gamePlayUtil.checkHorzontalLine(palya, new Point(14, 0), 1, 5));
    }

    /**
     * A GamePlayUtil checkVerticalLine függvényének különböző eseteinek tesztelése.
     */
    @Test
    void checkVerticalLine() {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(7);
        coords.add(0);
        coords.add(7);
        coords.add(4);
        Assertions.assertEquals(coords, gamePlayUtil.checkVerticalLine(palya, new Point(7, 0), 1, 5));

        coords.clear();
        coords.add(7);
        coords.add(3);
        coords.add(7);
        coords.add(7);
        Assertions.assertEquals(coords, gamePlayUtil.checkVerticalLine(palya, new Point(7, 7), 1, 5));

        coords.clear();
        coords.add(14);
        coords.add(0);
        coords.add(14);
        coords.add(4);
        Assertions.assertEquals(coords, gamePlayUtil.checkVerticalLine(palya, new Point(14, 0), 1, 5));
    }

    /**
     * A GamePlayUtil checkCrossLine függvényének különböző eseteinek tesztelése.
     */
    @Test
    void checkCrossLine() {
        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(0);
        coords.add(0);
        coords.add(4);
        coords.add(4);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLine(palya, new Point(0, 0), 1, 5));

        coords.clear();
        coords.add(10);
        coords.add(10);
        coords.add(14);
        coords.add(14);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLine(palya, new Point(14, 14), 1, 5));

        coords.clear();
        coords.add(3);
        coords.add(3);
        coords.add(7);
        coords.add(7);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLine(palya, new Point(7, 7), 1, 5));
    }

    /**
     * A GamePlayUtil checkCrossLineInverted függvényének különböző eseteinek tesztelése.
     */
    @Test
    void checkCrossLineInverted() {

        ArrayList<Integer> coords = new ArrayList<>();
        coords.add(10);
        coords.add(4);
        coords.add(14);
        coords.add(0);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLineInverted(palya, new Point(14, 0), 1, 5));

        coords.clear();
        coords.add(0);
        coords.add(14);
        coords.add(4);
        coords.add(10);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLineInverted(palya, new Point(0, 14), 1, 5));

        coords.clear();
        coords.add(3);
        coords.add(11);
        coords.add(7);
        coords.add(7);
        Assertions.assertEquals(coords, gamePlayUtil.checkCrossLineInverted(palya, new Point(7, 7), 1, 5));
    }
}