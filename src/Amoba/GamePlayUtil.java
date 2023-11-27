package Amoba;

import java.util.ArrayList;

public class GamePlayUtil {
    private GamePanel gamePanel;
    GamePlayUtil(GamePanel gp){
        gamePanel = gp;
    }
    public ArrayList<ArrayList<Integer>> checkWin(int [][] table, int[] idx, int player, int num){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
         result.add(checkVertical(table, idx, player, num));
         result.add(checkHorzontal(table, idx, player, num));
         result.add(checkCross(table, idx, player, num));

        return result;
    }

    public ArrayList<Integer> checkHorzontal(int [][] table, int[] idx, int player, int num){
        //Vizszint
        ArrayList<Integer> result = new ArrayList<>();
        int bound = num-1;
        int upperBoundX, downerBoundX;
        if(idx[0]-bound < 0){
            downerBoundX = 0;
        } else {
            downerBoundX = idx[0] - bound;
        }
        if(idx[0]+bound >= 15){
            upperBoundX = 14;
        } else {
            upperBoundX = idx[0] + bound;
        }

        int posY = idx[1];
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
            System.out.println(maxXStartIdx+ "," + posY + " " + (maxXStartIdx + maxX-1) + "," + posY);
            result.add(maxXStartIdx);
            result.add(posY);
            result.add(maxXStartIdx+bound);
            result.add(posY);
        }
        return result;
    }
    public ArrayList<Integer> checkVertical(int [][] table, int[] idx, int player, int num){
        //Fuggoleges
        ArrayList<Integer> result = new ArrayList<>();
        int bound = num-1;
        int upperBoundY, downerBoundY;

        if(idx[1]-bound < 0){
            downerBoundY = 0;
        } else {
            downerBoundY = idx[1] - bound;
        }
        if(idx[1]+bound >= 15){
            upperBoundY = 14;
        } else {
            upperBoundY = idx[1] + bound;
        }

        int posX = idx[0];
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
            System.out.println(maxYStartIdx+ "," + posX + " " + (maxYStartIdx + bound) + "," + posX);
            result.add(posX);
            result.add(maxYStartIdx);
            result.add(posX);
            result.add(maxYStartIdx+bound);
        }
        return result;
    }
    public ArrayList<Integer> checkCross(int [][] table, int[] idx, int player, int num){
        //Kereszt 1.
        int posX = idx[0];
        int posY = idx[1];
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
            System.out.println(maxCrossStartIdx[0] + "," + maxCrossStartIdx[1] + " " + (maxCrossStartIdx[0] + 4) + "," + (maxCrossStartIdx[1]+4));
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
            System.out.println(maxCrossStartIdx[0] + "," + maxCrossStartIdx[1] + " " + (maxCrossStartIdx[0] + 4) + "," + (maxCrossStartIdx[1]-4));
            result.add(maxCrossStartIdx[0]);
            result.add(maxCrossStartIdx[1]);
            result.add(maxCrossStartIdx[0]+(num-1));
            result.add(maxCrossStartIdx[1]-(num-1));
        }

        return result;
    }
}
