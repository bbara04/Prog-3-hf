package Amoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    Game game;
    GamePanel(Game game){
        super();
        this.game = game;
        setBackground(new Color(115, 84, 34));
        setSize(new Dimension(600, 600));
        addMouseListener(new GameMouseListener());
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
        for (Stone stone : game.getStoneS()){
            g2d.fillOval(stone.getPos().x-10, stone.getPos().y-10, 20, 20);
        }
    }

    public class GameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX() + " " + e.getY());
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
