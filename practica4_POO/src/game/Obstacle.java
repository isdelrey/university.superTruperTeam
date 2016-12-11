package game;
 
import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends Entity {

    private MyPolygon p = new MyPolygon();

    public Obstacle(Vec2D pos, World wi) {
        super(pos, wi);
        this.p.randomPolygon();
        this.p.center();
        this.p.translate((int)pos.getX(), (int)pos.getY());
        this.energy = 0;
        this.hasEnergy = false;
    }

    public MyPolygon getPolygon() {
        return this.p;
    }

    @Override
    public void update() {
        super.update();
    }
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillPolygon(this.p);
    }
    public void draw(Graphics g, Color c, boolean collides) {
        if(collides){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(c);
        }
        g.fillPolygon(this.p);
    }
}
