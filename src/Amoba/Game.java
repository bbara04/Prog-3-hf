package Amoba;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Game implements Serializable {
    private int moveCount = 0;
    private int nextPlayer = 1;
    // 0 = szabad, 1 = fekete, 2 = feher
    private int[][] table = new int[15][15];
    private Stone[][] stones = new Stone[15][15];
    private GamePanel gamePanel;
    Game(){

    }
    public void setGamePanel(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    public GamePanel getGamePanel(){
        return gamePanel;
    }
    public void reset(){
        table = new int[15][15];
        stones = new Stone[15][15];
        gamePanel.setDrawList(new ArrayList<ArrayList<Integer>>());
        gamePanel.repaint();
    }
    public void lep(int x, int y){
        Color color = nextPlayer==1 ? Color.BLACK : Color.WHITE;
        GamePlayUtil gamePlayUtil = new GamePlayUtil(gamePanel);
        try{
            Stone stone = new Stone(color, new Point(x, y));
            int idx[] = stone.posToIntArray(stone.getPos());
            stones[idx[1]][idx[0]] = stone;
            table[idx[1]][idx[0]] = nextPlayer;
            ArrayList<ArrayList<Integer>> drawingList = gamePlayUtil.checkWin(table, idx, nextPlayer, 5);
            gamePanel.setDrawList(drawingList);
            //nextPlayer = nextPlayer==1 ? 2 : 1;
            moveCount++;
        } catch (NotFoundPoint e){
            System.out.println(e.getMessage());
        }
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
