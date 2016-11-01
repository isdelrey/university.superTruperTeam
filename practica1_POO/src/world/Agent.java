/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package world;

/**
 *
 * @author u124308
 */
public class Agent {
    // Properties:
    
    private Vec2D speed;
    private Vec2D maxSpeed;
    private Vec2D pos;
    private Vec2D dir;
    private Vec2D obj;
    private double radius;
    private double weight;
    private int id;
    private boolean collided = false;

    //Contructor

    /**
     *
     * @param pos
     * @param obj
     * @param radius
     * @param id
     */
    public Agent (Vec2D pos, Vec2D obj, double radius, int id){
        this.pos = pos;
        this.obj = obj;
        this.radius = radius;
        this.id = id;
        this.speed = new Vec2D (1,1);
        this.weight = this.radius * 2;
        this.maxSpeed = new Vec2D (2,2);
        this.dir = new Vec2D (0,0);
    }
    // Methods:
    /**
     *
     * @return
     */
    public int getID() {
        return this.id;
    }
    public double getRadius() {
        return this.radius;
    }

    /**
     *
     * @return
     */
    public Vec2D getPos(){
        return this.pos;
    }

    /**
     *
     * @return
     */
    public Vec2D getDir(){
        return this.dir;
    }

    /**
     *
     * @return
     */
    public Vec2D getObj(){
        return this.obj;
    }
 /**
     *
     * @return
     */
    public Vec2D getDirToObj(){
        Vec2D vector = new Vec2D(this.getObj().getX(), this.getObj().getY());
        vector.minus(this.getPos());
        vector.normalize();
        return vector; 
    }
    public void dirToObj() {
        this.getDir().rotateInDirectionOf(this.getDirToObj());
    }
    public boolean getCollided(){
        return this.collided; 
    }
    /**
     *
     * @param vector
     */
    public void setPos (Vec2D vector){
        this.pos=vector;
    }

    /**
     *
     * @param vector
     */
    public void setObj (Vec2D vector){
        this.obj=vector;
    }

    /**
     *
     * @param vector
     */
    public void setDir (Vec2D vector){
        this.dir=vector;
    }
    public void setCollided (boolean bool){
        this.collided = bool; 
    }
   

    /**
     *
     * @return
     */
    public Boolean objReached() {
        return (obj.dist(pos) < 10);
    }

    /**
     *
     */
    public void update() {
        System.out.println(this.dir.getX());
        this.pos.setX(this.pos.getX() + this.speed.getX()*this.dir.getX());
        this.pos.setY(this.pos.getY() + this.speed.getY()*this.dir.getY());
    }

    /**
     *
     * @param a
     * @return
     */
    public Boolean isLessThanXPixelsAway(Agent a,int X) {
        double sum = this.radius + a.getRadius() + X;  
        return (this.pos.dist(a.pos) <= sum);
    }
    public Boolean collisionWith(Agent a) {
        Boolean collided = false;
        if(isLessThanXPixelsAway(a,0) && !this.getCollided()) {
            collided = true;
        }
        return collided;
    }

    /**
     *
     * @return
     */
    public String toString(){
        return "Agent { id: " + id + ", position: {" + pos.getX() + "," + pos.getY() + "}, objective: {" + obj.getX() + "," + obj.getY() + "}";   
    }
}
