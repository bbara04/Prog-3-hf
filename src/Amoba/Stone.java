package Amoba;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Stone implements Serializable {
    private Point pos;
    private Color color;
    Stone(Color color, Point pos) {
        this.color = color;
        this.pos = pos;
    }
    public Point getPos(){
        return pos;
    }
    public Color getColor(){
        return color;
    }

}
