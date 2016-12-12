package game;
 
import java.awt.Color;
import java.awt.Graphics;

public class Obstacle extends Entity {

    private MyPolygon p = new MyPolygon();
    /**
     * Builds a new Obstacle and places it at a position in a World
     * @param pos position
     * @param wi world
     */
    public Obstacle(Vec2D pos, World wi) {
        super(pos, wi);
        this.p.randomPolygon();
        this.p.center();
        this.p.translate((int)pos.getX(), (int)pos.getY());
        this.energy = 0;
        this.hasEnergy = false;
    }
    /**
     * Returns the polygon associated with the Obstacle
     * @return polygon
     */
    public MyPolygon getPolygon() {
        return this.p;
    }
    /**
     * Updates the Polygon state
     */
    @Override
    public void update() {
        super.update();
    }
    /**
     * Basic Obstacle drawing
     * @param g Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.ORANGE);
        g.fillPolygon(this.p);
    }
    /**
     * Customizable Obstacle drawing
     * @param g Graphics
     * @param c Obstacle color
     * @param collides whether the obstacle collides
     */
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
