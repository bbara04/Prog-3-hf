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
    private Game game;
    private ArrayList<ArrayList<Integer>> drawList = new ArrayList<>();
    GamePanel(Game game){
        super();
        this.game = game;
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

        try {
            Image bg;
            bg = ImageIO.read(new File("woodtexture.jpg"));
            g2d.drawImage(bg, 0, 0, this);
        } catch (IOException e) {
            setBackground(new Color(186, 142, 101));
        }

        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(2));

        for(int i = 0; i<15; i++){
            g2d.drawLine(i*30+90, 90, i*30+90, 510);
        }
        for(int i = 0; i<15; i++){
            g2d.drawLine(90, i*30+90, 510, i*30+90);
        }

        Font font = new Font("Ariel", Font.BOLD, 18);
        g2d.setFont(font);
        FontMetrics metrics = g.getFontMetrics(font);
        String letters = new String("ABCDEFGHIJKLMNO");
        int db = 0;
        for(int i = 90;i<=510;i+=30){
            int x = i - (metrics.stringWidth(String.valueOf(letters.charAt(db)))/2);
            g2d.drawString(String.valueOf(letters.charAt(db++)), x, 70);
        }
        db = 1;
        for(int i = 95; i<=520;i+=30){
            if(db>=10){
                g2d.drawString(String.valueOf(db++), 50, i);
            } else {
                g2d.drawString(String.valueOf(db++), 60, i);
            }
        }

        for (Stone[] line : game.getStones()){
            for (Stone stone : line){
                if(stone != null){
                    g2d.setColor(stone.getColor());
                    g2d.fillOval(stone.getPos().x-10, stone.getPos().y-10, 20, 20);
                }
            }
        }
        if(!drawList.isEmpty()){
            for (ArrayList<Integer> coords : drawList){
                for(int i = 0;i<coords.size();i+=4){
                    int x1 = (coords.get(i)*30)+90;
                    int y1 = (coords.get(i+1)*30)+90;
                    int x2 = (coords.get(i+2)*30)+90;
                    int y2 = (coords.get(i+3)*30)+90;
                    g2d.setStroke(new BasicStroke(5));
                    g2d.setColor(Color.GREEN);
                    g2d.drawLine(x1, y1, x2, y2);
                }
            }
        }
    }
    public void EndGameHandler(String text){
        paintComponent(getGraphics());
        JOptionPane.showMessageDialog(null, text, "Játék vége", JOptionPane.YES_NO_OPTION);
    }

    public class GameMouseListener implements MouseListener {
        @Override
        public void mouseClicked(MouseEvent e) {
            try{
                game.lep(new Point(e.getX(), e.getY()));
            } catch (GameEndException exception){
                EndGameHandler(exception.getText());
            }
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
