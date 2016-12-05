package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; 

public class Agent extends MovingEntity {





    private Vec2D obj;

    private double radius;

    private double weight;

    private int id;

    private boolean collided = false;

    public Agent(Vec2D pos, Vec2D obj, double radius, int id, World wi) {
        super(pos, wi);
        this.obj = wi.randomPointInsideWorld();
        this.radius = radius;
        this.id = id;
        this.weight = this.radius * 2;
    }

    public int getID() {
        return this.id;
    }

    public double getRadius() {
        return this.radius;
    }



    public Vec2D getObj() {
        return this.obj;
    }

    public Vec2D getDirToObj() {
        Vec2D vector = new Vec2D(this.getObj().getX(), this.getObj().getY());
        vector.minus(this.pos);
        vector.normalize();
        return vector;
    }

    public void dirToObj() {
        this.getDir().rotateInDirectionOf(this.getDirToObj());
    }

    public boolean getCollided() {
        return this.collided;
    }

    public void setPos(Vec2D vector) {
        this.pos = vector;
    }

    public void setObj(Vec2D vector) {
        this.obj = vector;
    }

    public void setCollided(boolean bool) {
        this.collided = bool;
    }

    public Boolean objReached() {
        return (obj.dist(pos) < 10);
    }
    @Override
    public void update() {
        if((int) (Math.random() * 100) == 0) {
            addProjectile(this);
        }
        this.getDir().turnTo(this.getDirToObj());
        //System.out.println(this.dir.getX());
        super.update();
        
    }

    public boolean isLessThanXPixelsAway(Agent a, int X) {
        double sum = this.radius + a.getRadius() + X;
        return (this.pos.dist(a.pos) <= sum);
    }

    public boolean collisionWith(Agent a) {
        Boolean collided = false;
        if (isLessThanXPixelsAway(a, 0) && !this.getCollided()) {
            collided = true;
        }
        return collided;
    }

    public String toString() {
        return "Agent { id: " + id + ", position: {" + pos.getX() + "," + pos.getY() + "}, objective: {" + obj.getX() + "," + obj.getY() + "}";
    }
    
    public MyPolygon getShape(){
        MyPolygon polygon = new MyPolygon();
        polygon.Triangle(this.getDir());
        polygon.center();
        return polygon;        
    }
    
    @Override
    public void draw(Graphics g) {
        if(this.bCollides){
            g.setColor(Color.RED);
        }
        else{
            g.setColor(Color.BLUE);
        }
        g.drawPolygon(this.getShape());
        g.setColor(Color.BLUE);
        g.fillOval((int)(pos.getX()-2), (int)(pos.getY()-2), 4, 4);
    }
    
    @Override 
    public boolean collides(Entity ei){
        if(ei instanceof Obstacle){
            Obstacle o = (Obstacle) ei;
            MyPolygon t = this.getShape(); 
            t.intersects(o.getObstacle().getBounds2D());
            
            
            
        }
        return super.collides(ei);
    }
}
