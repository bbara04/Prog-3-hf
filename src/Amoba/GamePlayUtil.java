package Amoba;

import java.awt.*;
import java.util.ArrayList;

public class GamePlayUtil {
    private GamePanel gamePanel;
    GamePlayUtil(GamePanel gp){
        gamePanel = gp;
    }
    public ArrayList<ArrayList<Integer>> checkMultipleLines(int [][] table, Point idx, int player, int num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> temp = checkVerticalLine(table, idx, player, num);
        if(temp.size()>0){
            result.add(temp);
        }

        temp = checkHorzontalLine(table, idx, player, num);
        if(temp.size()>0){
            result.add(temp);
        }

        temp = checkCrossLines(table, idx, player, num);
        if(temp.size()>0){
            result.add(temp);
        }

        return result;
    }

    public ArrayList<Integer> checkHorzontalLine(int [][] table, Point idx, int player, int num){
        //Vizszint
        ArrayList<Integer> result = new ArrayList<>();
        int bound = num-1;
        int upperBoundX, downerBoundX;
        if(idx.x-bound < 0){
            downerBoundX = 0;
        } else {
            downerBoundX = idx.x - bound;
        }
        if(idx.x+bound >= 15){
            upperBoundX = 14;
        } else {
            upperBoundX = idx.x + bound;
        }

        int posY = idx.y;
        int maxX = 0;
        int maxXStartIdx = -1;
        int db = 0;
        int dbStartIdx = -1;
        for(int i = downerBoundX;i <= upperBoundX;i++){
            if(table[posY][i] == player){
                if(db == 0){
                    dbStartIdx = i;
                }
                db++;
            } else {
                db = 0;
            }
            if (db >= maxX) {
                maxX = db;
                maxXStartIdx = dbStartIdx;
            }
        }

        if(maxX >= num){
            result.add(maxXStartIdx);
            result.add(posY);
            result.add(maxXStartIdx+bound);
            result.add(posY);
        }
        return result;
    }
    public ArrayList<Integer> checkVerticalLine(int [][] table, Point idx, int player, int num){
        //Fuggoleges
        ArrayList<Integer> result = new ArrayList<>();
        int bound = num-1;
        int upperBoundY, downerBoundY;

        if(idx.y-bound < 0){
            downerBoundY = 0;
        } else {
            downerBoundY = idx.y - bound;
        }
        if(idx.y+bound >= 15){
            upperBoundY = 14;
        } else {
            upperBoundY = idx.y + bound;
        }

        int posX = idx.x;
        int maxY = 0;
        int maxYStartIdx = -1;
        int db = 0;
        int dbStartIdx = -1;
        for(int i = downerBoundY;i <= upperBoundY;i++){
            if(table[i][posX] == player){
                if(db == 0){
                    dbStartIdx = i;
                }
                db++;
            } else {
                db = 0;
            }
            if (db >= maxY) {
                maxY = db;
                maxYStartIdx = dbStartIdx;
            }
        }

        if(maxY >= num){
            result.add(posX);
            result.add(maxYStartIdx);
            result.add(posX);
            result.add(maxYStartIdx+bound);
        }
        return result;
    }
    public ArrayList<Integer> checkCrossLines(int [][] table, Point idx, int player, int num){
        //Kereszt 1.
        int posX = idx.x;
        int posY = idx.y;
        ArrayList<Integer> result = new ArrayList<>();

        int[] dbCrossStartIdx = new int[2];
        int maxCross = 0;
        int[] maxCrossStartIdx = new int[2];
        int db = 0;
        for (int i = -num+1 ; i < num; i++){
            if(posY+i >= 0 && posY+i < 15 && posX+i >= 0 && posX+i < 15){
                if(table[posY+i][posX+i] == player){
                    if(db == 0){
                        int[] temp = {posX+i, posY+i};
                        dbCrossStartIdx = temp;
                    }
                    db++;
                } else {
                    db = 0;
                }
                if(db > maxCross){
                    maxCross = db;
                    maxCrossStartIdx = dbCrossStartIdx;
                }
            }
        }

        if(maxCross >= num){
            result.add(maxCrossStartIdx[0]);
            result.add(maxCrossStartIdx[1]);
            result.add(maxCrossStartIdx[0]+num-1);
            result.add(maxCrossStartIdx[1]+num-1);
        }

        //Kereszt 2.

        maxCross = 0;
        maxCrossStartIdx = new int[2];
        db = 0;
        int dbStartIdx = -1;
        for (int i = -num+1 ; i<num ; i++){
            if(posY-i >= 0 && posY-i < 15 && posX+i >= 0 && posX+i < 15){
                if(table[posY-i][posX+i] == player){
                    if(db == 0){
                        int[] temp = {posX+i, posY-i};
                        dbCrossStartIdx = temp;
                    }
                    db++;
                } else {
                    db = 0;
                }
                if(db > maxCross){
                    maxCross = db;
                    maxCrossStartIdx = dbCrossStartIdx;
                }
            }
        }

        if(maxCross >= 5){
            result.add(maxCrossStartIdx[0]);
            result.add(maxCrossStartIdx[1]);
            result.add(maxCrossStartIdx[0]+(num-1));
            result.add(maxCrossStartIdx[1]-(num-1));
        }

        return result;
    }
}
