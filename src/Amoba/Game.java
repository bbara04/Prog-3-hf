package Amoba;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    private int moveCount = 0;
    private int nextPlayer = 1;
    // 0 = szabad, 1 = fehér, 2 = fekete
    private int[][] table = new int[15][15];
    private ArrayList<Stone> stones = new ArrayList<>();
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
        stones.clear();
        table = new int[15][15];
        gamePanel.repaint();
    }
    public void lep(int x, int y){
        try{
            Stone stone = new Stone(Color.BLACK, new Point(x, y));
            stones.add(stone);
            int idx[] = stone.posToIntArray(stone.getPos());
            table[idx[0]][idx[1]] = nextPlayer;
            //print();
            moveCount++;
        } catch (NotFoundPoint e){
            System.out.println(e.getMessage());
        }
    }
    public void print(){
        for(int i = 0;i < 15;i++){
            for(int k = 0;k < 15;k++){
                System.out.print(table[k][i]);
            }
            System.out.println();
        }
    }

    public List<Stone> getStoneS(){
        return stones;
    }
}
