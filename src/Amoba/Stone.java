package Amoba;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Kő osztály ezeket helyezzük, fel a grafikus táblára.
 */
public class Stone implements Serializable {
    private Point pos;
    private Color color;
    Stone(Color color, Point pos) {
        this.color = color;
        this.pos = pos;
    }

    /**
     * Pos getter-e.
     * @return
     */
    public Point getPos(){
        return pos;
    }

    /**
     * Color getter-e.
     * @return
     */
    public Color getColor(){
        return color;
    }

}
