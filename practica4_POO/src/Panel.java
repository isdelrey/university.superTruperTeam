import game.Agent;
import game.MovingEntity;
import game.Obstacle;
import game.World;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;
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
 * @author ivo && bassagap
 */
public class Panel extends JPanel {
    private World w;
    private Timer timer;
    private TimerTask painter;
    private Boolean painting = false;
    public void initWorld(int wi, int he, int ag) {
        w = new World(wi, he, ag);
    }
    public World getWorld() {
        return w;
    }
    public void step() {
        w.run(50);
        repaint();
    }
    public void autoPaint(int animationSpeed, int rate) {
        painting = true;
        painter = new TimerTask() {
            @Override
            public void run() {
                if(painting) {
                    w.run(5*animationSpeed);
                    repaint();
                }
            }
        };
        timer = new Timer(true);
        timer.scheduleAtFixedRate(painter, 0, rate);
    }
    public void cancelAutoPaint() {
        painting = false;
        timer.cancel();
        painter.cancel();
    }
    @Override
    public void paint(Graphics g) {
        if(w != null) {
            BufferedImage image = new BufferedImage (w.getW(), w.getH(),BufferedImage.TYPE_INT_ARGB);
            Graphics b = image.getGraphics();
            b.setColor(Color.yellow);
            b.fillRect(0, 0, w.getW(), w.getH());
            float colorStep = 1f/w.getN();
            float color = 0;
            for(int i = 0; i < w.getN(); i++){
                if(w.getEntity(i) instanceof Agent){
                    Agent a = (Agent)w.getEntity(i);
                    a.update();
                    a.draw(b, Color.getHSBColor(colorStep*i, 1f, 1.5f),false);
                }
                else
                    if(w.getEntity(i) instanceof Obstacle){
                        Obstacle o = (Obstacle) w.getEntity(i);
                        o.draw(b);
                    }
                    else
                    {
                        MovingEntity me = (MovingEntity) w.getEntity(i);
                        me.update();
                        me.draw(b);
                    }

            }
            g.drawImage(image, 0, 0, null);
        }
    }
}
