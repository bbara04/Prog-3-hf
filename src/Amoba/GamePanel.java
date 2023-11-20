package Amoba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GamePanel extends JPanel{
    Game game;
    ArrayList<Stone> stones = new ArrayList<>();
    GamePanel(Game game){
        super();
        this.game = game;
        setBackground(Color.BLUE);
        setSize(new Dimension(600, 600));
        addMouseListener(new GameMouseListener());
        System.out.println(getSize().width + " " + getSize().height);
    }

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i<15; i++){
            g2d.drawLine(i*30+90, 90, i*30+90, 510);
        }
        for(int i = 0; i<15; i++){
            g2d.drawLine(90, i*30+90, 510, i*30+90);
        }
        for (Stone stone : stones){
            g2d.fillOval(stone.pos.x-10, stone.pos.y-10, 20, 20);
        }
    }

    public Stone fixStonePos(Stone stone){
        int modX = stone.pos.x % 30;
        int modY = stone.pos.y % 30;

        //X cord
        if(modX > 15){
            stone.pos.x += 30-modX;
        } else {
            stone.pos.x -= modX;
        }

        //Y cord
        if(modY > 15){
            stone.pos.y += 30-modY;
        } else {
            stone.pos.y -= modY;
        }

        return stone;
    }

    public boolean checkStonePos(Stone stone){
        int stonePosX = stone.pos.x;
        int stonePosY = stone.pos.y;
        int modX = stonePosX % 30;
        int modY = stonePosY % 30;

        if((stonePosX<85 || stonePosX > 515 || stonePosY<85 || stonePosY>515) || (modX > 5 && modX < 25) || (modY > 5 && modY < 25)){
            return false;
        }
        return true;
    }


    public int[] posToIntArray(Stone stone){
        stone = fixStonePos(stone);
        int x = (stone.pos.x-90) / 30;
        int y = (stone.pos.y-90) / 30;
        int[] idx = {x, y};

        return idx;
    }

    public class GameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(e.getX() + " " + e.getY());
            Stone stone = new Stone(Color.BLACK, new Point(e.getX(), e.getY()));
            if(checkStonePos(stone)){
                stones.add(fixStonePos(stone));
                game.lep(posToIntArray(stone)[0],posToIntArray(stone)[1] );
                game.print();
                repaint();
            }
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
