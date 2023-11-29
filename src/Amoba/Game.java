package Amoba;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;

public class Game implements Serializable {
    private int moveCount = 1;
    private int player = 1;
    // 0 = szabad, 1 = fekete, 2 = feher
    private int[][] table = new int[15][15];
    private Stone[][] stones = new Stone[15][15];
    private GamePanel gamePanel;
    private boolean gameEnded = false;
    Game(){

    }
    public void setGamePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public GamePanel getGamePanel(){
        return gamePanel;
    }
    public void reset(){
        player = 1;
        moveCount = 1;
        gameEnded = false;
        table = new int[15][15];
        stones = new Stone[15][15];
        gamePanel.setDrawList(new ArrayList<ArrayList<Integer>>());
        gamePanel.repaint();
    }
    public void lep(Point pos) throws GameEndException {
        if(!gameEnded && checkStonePos(pos) && !checkTaken(pos)) {
            GamePlayUtil gamePlayUtil = new GamePlayUtil(gamePanel);
            if(moveCount > 4 || moveCount == 3){
                player = player==1 ? 2 : 1;
            }
            Color color = player == 1 ? Color.BLACK : Color.WHITE;
            pos = fixStonePos(pos);
            Stone stone = new Stone(color, pos);
            Point idx = posToIntArray(stone.getPos());
            stones[idx.y][idx.x] = stone;
            table[idx.y][idx.x] = player;
            String tempPlayer = player == 2 ? "Fehér" : "Fekete";
            ArrayList<ArrayList<Integer>> drawingList = gamePlayUtil.checkMultipleLines(table, idx, player, 6);
            if (!drawingList.isEmpty() && player==1) {
                gamePanel.setDrawList(drawingList);
                gameEnded = true;
                throw new GameEndException("vesztett" ,tempPlayer, "kirakott egymás után 6 követ.");
            }
            drawingList = gamePlayUtil.checkMultipleLines(table, idx, player, 5);
            if (!drawingList.isEmpty()) {
                gamePanel.setDrawList(drawingList);
                gameEnded = true;
                throw new GameEndException("nyert" ,tempPlayer, "kirakott egymás után 5 követ.");
            }
            drawingList = gamePlayUtil.checkMultipleLines(table, idx, player, 3);
            if (drawingList.size() >= 2 && player == 1) {
                gamePanel.setDrawList(drawingList);
                gameEnded = true;
                throw new GameEndException("vesztett", tempPlayer, "dupla 3-ast rakott ki.");
            }
            drawingList = gamePlayUtil.checkMultipleLines(table, idx, player, 4);
            if (drawingList.size() >= 2 && player == 1) {
                gamePanel.setDrawList(drawingList);
                gameEnded = true;
                throw new GameEndException("vesztett", tempPlayer, "dupla 4-est rakott ki.");
            }
            moveCount++;
        }
    }
    public boolean checkTaken(Point pos){
        pos = fixStonePos(pos);
        pos = posToIntArray(pos);
        if(table[pos.y][pos.x] == 0){
            return false;
        }
        return true;
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
    public Point posToIntArray(Point pos){
        pos = fixStonePos(pos);
        int x = (pos.x-90) / 30;
        int y = (pos.y-90) / 30;

        return new Point(x, y);
    }
    public void print(){
        for(int i = 0;i < 15;i++){
            for(int k = 0;k < 15;k++){
                System.out.print(table[i][k]);
            }
            System.out.println();
        }
    }

    public Stone[][] getStones(){
        return stones;
    }

    public int[][] getTable() {
        return table;
    }
}
