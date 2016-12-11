package game;
 
import java.awt.Color;
import java.awt.Graphics;

public class Agent extends MovingEntity {





    private Vec2D obj;

    private int radius;

    private double weight;

    private int id;

    private int collision = 0;

    public Agent(Vec2D pos, Vec2D obj, int radius, int id, World wi) {
        super(pos, wi);
        this.obj = wi.randomPointInsideWorld();
        this.radius = radius;
        this.id = id;
        this.weight = this.radius * 2;
        this.energy = (int) Math.round(500*Math.random());
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

    public int getCollision() {
        return this.collision;
    }

    public void setPos(Vec2D vector) {
        this.pos = vector;
    }

    public void setObj(Vec2D vector) {
        this.obj = vector;
    }

    public void setCollision(int process) {
        this.collision = process;
    }

    public Boolean objReached() {
        return (obj.dist(pos) < 10);
    }
    @Override
    public void update() {
        super.update();
        if(Math.random() < 0.001) {
            fireProjectile();
        }
        this.getDir().turnTo(this.getDirToObj());
        //System.out.println(this.dir.getX());        
    }
    public boolean isMoreThanXPixelsAway(Agent a, int X) {
        double sum = this.radius + a.getRadius() + X;
        return (this.pos.dist(a.pos) > sum);
    }
    public boolean isLessThanXPixelsAway(Agent a, int X) {
        double sum = this.radius + a.getRadius() + X;
        return (this.pos.dist(a.pos) < sum);
    }

    public boolean collisionWith(Agent a) {
        Boolean collided = false;
        if (isLessThanXPixelsAway(a, 1) && isMoreThanXPixelsAway(a,0)) {
            collided = true;
        }
        return collided;
    }

    public String toString() {
        return "Agent { id: " + id + ", position: {" + pos.getX() + "," + pos.getY() + "}, objective: {" + obj.getX() + "," + obj.getY() + "}";
    }
    
    public MyPolygon getPolygon(){
        MyPolygon polygon = new MyPolygon();
        polygon.Triangle(this.getDir());
        polygon.center();
        polygon.translate((int)(pos.getX()-2), (int)(pos.getY()-2));
        return polygon;        
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        //g.setColor(Color.BLUE);
        //g.fillOval((int)(pos.getX()-2), (int)(pos.getY()-2), radius, radius);
        g.fillPolygon(this.getPolygon());
    }
    public void draw(Graphics g, Color c, boolean collides) {
        if(collides){
            g.setColor(Color.RED);
        }
        else {
            g.setColor(c);
        }
        g.fillPolygon(this.getPolygon());
        Vec2D center = this.getPolygon().getCentroid();
        g.drawString(String.valueOf(this.getEnergy()), (int)center.getX()+20, (int)center.getY());
        int effectRadius = this.getAnimationStage()*5;
        this.animationStageDecrease();
        g.drawOval((int)center.getX()-effectRadius/2, (int)center.getY()-effectRadius/2, effectRadius, effectRadius);
    }
    @Override 
    public boolean collides(Entity ei){
        if(ei instanceof Obstacle) {
            Obstacle o = (Obstacle) ei;
            MyPolygon t = this.getPolygon(); 
            return t.intersects(o.getPolygon().getBounds2D());
        }
        else if(ei instanceof Agent) {
                Agent a = (Agent)ei;
                return this.getPolygon().intersects(a.getPolygon().getBounds2D());
             }
             else return ei.collides(this);
    }
    public void fireProjectile() {
        MovingEntity m = new MovingEntity(this.getDir(), this.w);
        m.setSpeed(0.001);
        m.setPos(this.getPos());
        this.w.entities.add(m);
    }
}
