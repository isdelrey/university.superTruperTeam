package game;
 
import java.awt.Color;
import java.awt.Graphics;

public class Agent extends MovingEntity {





    private Vec2D obj;

    private final int radius;

    private final double weight;

    private final int id;

    private int collision;
    /**
     * Sets up an agent given a position, objective, radius, agent id and world.
     * @param pos position
     * @param obj objective
     * @param radius radius
     * @param id agent id
     * @param wi world
     */
    public Agent(Vec2D pos, Vec2D obj, int radius, int id, World wi) {
        super(pos, wi);
        this.collision = 0;
        this.obj = wi.randomPointInsideWorld();
        this.radius = radius;
        this.id = id;
        this.weight = this.radius * 2;
        this.energy = (int) Math.round(500*Math.random());
    }
    /**
     * Returns agent's id
     * @return agent id
     */
    public int getID() {
        return this.id;
    }
    /**
     * Returns agent's radius
     * @return radius
     */
    public double getRadius() {
        return this.radius;
    }
    /**
     * Returns agent's objective
     * @return objective
     */
    public Vec2D getObj() {
        return this.obj;
    }
    /**
     * Returns direction to the objective
     * @return direction to objective
     */
    public Vec2D getDirToObj() {
        Vec2D vector = new Vec2D(this.getObj().getX(), this.getObj().getY());
        vector.minus(this.pos);
        vector.normalize();
        return vector;
    }
    /**
     * Directs Agent towards objective
     */
    public void dirToObj() {
        this.getDir().rotateInDirectionOf(this.getDirToObj());
    }
    /**
     * Returns last loop iteration where the Agent collided - used in World's processCollisions
     * @return last loop iteration number
     */
    public int getCollision() {
        return this.collision;
    }
    /**
     * Sets the agent's position
     * @param vector position
     */
    @Override
    public void setPos(Vec2D vector) {
        this.pos = vector;
    }
    /**
     * Sets the agent's objective
     * @param vector objective
     */
    public void setObj(Vec2D vector) {
        this.obj = vector;
    }
    /**
     * Sets last loop iteration where the Agent collided - used in World's processCollisions
     * @param process last loop iteration number
     */
    @Override
    public void setCollision(int process) {
        this.collision = process;
    }
    /**
     * Returns whether the Agent's objective has been reached
     * @return whether it has been reached
     */
    public Boolean objReached() {
        return (obj.dist(pos) < 10);
    }
    /**
     * Turns Agent towards its objective, maybe fires a projectile
     */
    @Override
    public void update() {
        super.update();
        if(Math.random() < 0.007) {
            fireProjectile();
        }
        this.getDir().turnTo(this.getDirToObj());
        //System.out.println(this.dir.getX());        
    }
    /**
     * Checks if an Agent is more than X pixels away from this Agent
     * @param a Agent
     * @param X distance in pixels
     * @return whether they are more than X pixels away
     */
    public boolean isMoreThanXPixelsAway(Agent a, int X) {
        double sum = this.radius + a.getRadius() + X;
        return (this.pos.dist(a.pos) > sum);
    }
    /**
     * Checks if an Agent is less than X pixels away from this Agent
     * @param a Agent
     * @param X distance in pixels
     * @return whether they are less than X pixels away
     */
    public boolean isLessThanXPixelsAway(Agent a, int X) {
        double sum = this.radius + a.getRadius() + X;
        return (this.pos.dist(a.pos) < sum);
    }
    /**
     * Checks if an Agent collides with another Agent
     * @param a Agent
     * @return whether they collide
     */
    public boolean collisionWith(Agent a) {
        Boolean collided = false;
        if (isLessThanXPixelsAway(a, 1) && isMoreThanXPixelsAway(a,0)) {
            collided = true;
        }
        return collided;
    }
    /**
     * Returns a String with a quick overview of the main properties of the Agent
     * @return main properties
     */
    public String toString() {
        return "Agent { id: " + id + ", position: {" + pos.getX() + "," + pos.getY() + "}, objective: {" + obj.getX() + "," + obj.getY() + "}";
    }
    /**
     * Gets the Agent polygonal shape
     * @return polygon
     */
    public MyPolygon getPolygon(){
        MyPolygon polygon = new MyPolygon();
        polygon.Triangle(this.getDir());
        polygon.center();
        polygon.translate((int)(pos.getX()-2), (int)(pos.getY()-2));
        return polygon;        
    }
    /**
     * Basic Agent drawing
     * @param g Graphics
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillPolygon(this.getPolygon());
    }
    /**
     * Customizable Agent drawing
     * @param g Graphics
     * @param c Agent color
     * @param collides whether it collides
     */
    @Override
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
    /**
     * Check if Agent collides with an Entity
     * @param ei Entity
     * @return whether it collides
     */
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
    /**
     * Fire a projectile - add it to the World
     */
    public void fireProjectile() {
        MovingEntity m = new MovingEntity(this.getDir(), this.w);
        m.setSpeed(0.005);
        m.setPos(this.getPos());
        this.w.entities.add(m);
    }
}
