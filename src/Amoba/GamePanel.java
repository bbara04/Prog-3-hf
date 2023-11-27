package Amoba;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    Game game;
    ArrayList<ArrayList<Integer>> drawList = new ArrayList<>();
    GamePanel(Game game){
        super();
        this.game = game;
        setBackground(new Color(186, 142, 101));
        setSize(new Dimension(600, 600));
        addMouseListener(new GameMouseListener());
    }

    public void setDrawList(ArrayList<ArrayList<Integer>> drawList) {
        this.drawList = drawList;
    }

    public void setGame(Game g){
        game = g;
    }
    public Game getGame(){
        return game;
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g);

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        for(int i = 0; i<15; i++){
            g2d.drawLine(i*30+90, 90, i*30+90, 510);
        }
        for(int i = 0; i<15; i++){
            g2d.drawLine(90, i*30+90, 510, i*30+90);
        }
        for (Stone[] line : game.getStones()){
            for (Stone stone : line){
                if(stone != null){
                    g2d.setColor(stone.getColor());
                    g2d.fillOval(stone.getPos().x-10, stone.getPos().y-10, 20, 20);
                }
            }
        }
        for (ArrayList<Integer> coords : drawList){
            for(int i = 0;i<coords.size();i+=4){
                int x1 = (coords.get(i)*30)+90;
                int y1 = (coords.get(i+1)*30)+90;
                int x2 = (coords.get(i+2)*30)+90;
                int y2 = (coords.get(i+3)*30)+90;
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(Color.GREEN);
                System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
                g2d.drawLine(x1, y1, x2, y2);
            }
        }
    }

    public class GameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            //System.out.println(e.getX() + " " + e.getY());
            game.lep(e.getX(), e.getY());
            repaint();
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
