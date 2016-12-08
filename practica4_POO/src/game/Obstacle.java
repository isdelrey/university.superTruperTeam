package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; 

public class Obstacle extends Entity {

    private MyPolygon p = new MyPolygon();

    public Obstacle(Vec2D pos, World wi) {
        super(pos, wi);
        this.p.randomPolygon();
        this.p.center();
        this.p.translate((int)pos.getX(), (int)pos.getY());
    }

    public MyPolygon getObstacle() {
        return this.p;
    }

    @Override
    public void update() {
        super.update();
    }
    @Override
    public void draw(Graphics g) {
        if(this.bCollides){
            g.setColor(Color.RED);
        }
        else{
            g.setColor(Color.ORANGE);
        }
        g.fillPolygon(this.p);
    }
    public void draw(Graphics g, Color c) {
        if(this.bCollides){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(c);
        }
        g.fillPolygon(this.p);
    }
}
