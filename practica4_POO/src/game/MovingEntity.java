package game;
 
import java.awt.Color;
import java.awt.Graphics;

public class MovingEntity extends Entity {

    private Vec2D dir;

    private double speed;
    
    /**
     * Builds a new MovingEntity and places it at a position in a World
     * @param p position
     * @param wi world
     */
    public MovingEntity(Vec2D p, World wi) {
        super(p, wi);
        this.speed = 1; 
        this.dir = wi.randomPointInsideWorld();
        this.energy = 1;
    }
    /**
     * Sets MovingEntity's direction
     * @param dir direction
     */
    public void setDir(Vec2D dir) {
        this.dir = dir;
    }
    /**
     * Returns MovingEntity's direction
     * @return direction
     */
    public Vec2D getDir() {
        return this.dir;
    }
    /**
     * Sets MovingEntity's speed
     * @param s speed
     */
    public void setSpeed(double s) {
        this.speed = s; 
    }
    /**
     * Returns MovingEntity's speed
     * @return speed
     */
    public double getSpeed() {
        return this.speed;
    }
    /**
     * Updates the position of this Moving Entity
     */
    @Override
    public void update() {
        this.pos.setX(this.speed * this.dir.getX() + this.pos.getX());
        this.pos.setY(this.speed * this.dir.getY() + this.pos.getY());
    }
    /**
     * Basic MovingEntity drawing
     * @param g Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillOval((int)(pos.getX()-3), (int)(pos.getY()-3), 6, 6);
    }
    /**
     * Customizable MovingEntity drawing
     * @param g Graphics
     * @param c Agent color
     * @param collides whether it collides
     */
    public void draw(Graphics g, Color c, boolean collides) {
        if(collides){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(c);
        }
        g.fillOval((int)(pos.getX()-3), (int)(pos.getY()-3), 6, 6);
    }
}
