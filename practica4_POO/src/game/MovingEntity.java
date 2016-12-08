package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; 

public class MovingEntity extends Entity {

    private Vec2D dir;

    private double speed;

    public MovingEntity(Vec2D p, World wi) {
        super(p, wi);
        this.speed = 1; 
        this.dir = wi.randomPointInsideWorld();       
    }

    public void setDir(Vec2D dir) {
        this.dir = dir;
    }

    public Vec2D getDir() {
        return this.dir;
    }

    public void setSpeed(double s) {
        this.speed = s; 
    }

    public double getSpeed() {
        return this.speed;
    }

    @Override
    public void update() {
        this.pos.setX(this.speed * this.dir.getX() + this.pos.getX());
        this.pos.setY(this.speed * this.dir.getY() + this.pos.getY());
    }
    
    @Override
    public void draw(Graphics g) {
        if(this.bCollides){
            g.setColor(Color.RED);
        }
        else{
            g.setColor(Color.BLACK);
        }
        g.fillOval((int)(pos.getX()-3), (int)(pos.getY()-3), 6, 6);
    }
    public void draw(Graphics g, Color c) {
        if(this.bCollides){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(c);
        }
        g.fillOval((int)(pos.getX()-3), (int)(pos.getY()-3), 6, 6);
    }
    public void addProjectile(Agent a) {
        MovingEntity m = new MovingEntity(this.dir, this.w);
        m.setSpeed(this.speed * 2);
        this.w.entities.add(m);
        this.w.N = this.w.entities.size(); 
        
    }
}
