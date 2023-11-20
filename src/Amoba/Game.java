package Amoba;

public class Game {
    private int moveCount = 0;
    private int nextPlayer = 1;
    // 0 = szabad, 1 = fehér, 2 = fekete
    private int[][] table = new int[15][15];
    Game(){/*
        for(int i = 0;i<10;i++)
            for(int k = 0;k<10;i++)
                table[i][k] = 0;*/
    }
    void lep(int x, int y){
            table[x][y] = nextPlayer;
    }
    void print(){
        for(int i = 0;i < 15;i++){
            for(int k = 0;k < 15;k++){
                System.out.print(table[k][i]);
            }
            System.out.println();
        }
    }
}
