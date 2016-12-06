
import game.Agent;
import game.Obstacle;
import game.World;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ivo
 */
public class Panel extends JPanel {
    private World w;
    private Timer timer;
    private TimerTask painter;
    public void initWorld(int wi, int he, int ag) {
        w = new World(wi, he, ag);
        this.setSize(wi, he);
        
    }
    public World getWorld() {
        return w;
    }
    public void step() {
        w.run(50);
        repaint();
    }
    public void autoPaint(int animationSpeed, int rate) {
        painter = new TimerTask() {
            @Override
            public void run() {
                w.run(10*animationSpeed);
                repaint();
            }
        };
        timer = new Timer(true);
        timer.scheduleAtFixedRate(painter, 0, rate);
    }
    public void cancelAutoPaint() {
        painter.cancel();
    }
    @Override
    public void paint(Graphics g) {
        if(w != null) {
            BufferedImage image = new BufferedImage (w.getW(), w.getH(),BufferedImage.TYPE_INT_ARGB);
            Graphics b = image.getGraphics();
            float colorStep = 1f/w.getN();
            float color = 0;
            for(int i = 0; i < w.getN(); i++){
                if(w.getEntity(i) instanceof Agent){
                    Agent a = (Agent)w.getEntity(i);
                    a.update();
                    a.draw(g);
                }
                if(w.getEntity(i) instanceof Obstacle){
                    Obstacle o = (Obstacle) w.getEntity(i);
                    o.draw(g);
                }

            }
            g.drawImage(image, 0, 100, null);
        }
    }
}
