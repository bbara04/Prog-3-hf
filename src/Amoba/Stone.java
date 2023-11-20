package Amoba;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Stone implements Serializable {
    private Point pos;
    private Color color;
    Stone(Color color, Point pos) throws NotFoundPoint {
        this.color = color;
        if(checkStonePos(pos)){
            this.pos = fixStonePos(pos);
        } else {
            throw new NotFoundPoint("Nem talalhato mezo");
        }
    }
    public Point getPos(){
        return pos;
    }
    public Color getColor(){
        return color;
    }
    public Point fixStonePos(Point pos){
        int modX = pos.x % 30;
        int modY = pos.y % 30;

        //X cord
        if(modX > 15){
            pos.x += 30-modX;
        } else {
            pos.x -= modX;
        }

        //Y cord
        if(modY > 15){
            pos.y += 30-modY;
        } else {
            pos.y -= modY;
        }

        return pos;
    }

    public boolean checkStonePos(Point pos){
        int stonePosX = pos.x;
        int stonePosY = pos.y;
        int modX = stonePosX % 30;
        int modY = stonePosY % 30;

        if((stonePosX<82 || stonePosX > 518 || stonePosY<82 || stonePosY>518) || (modX > 8 && modX < 22) || (modY > 8 && modY < 22)){
            return false;
        }
        return true;
    }

    public int[] posToIntArray(Point pos){
        pos = fixStonePos(pos);
        int x = (pos.x-90) / 30;
        int y = (pos.y-90) / 30;
        int[] idx = {x, y};

        return idx;
    }

}
