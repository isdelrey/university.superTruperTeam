package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; 

abstract class Entity implements Drawable{

    protected Vec2D pos;

    protected int id;

    protected World w;

    protected int energy;
    
    protected boolean hasEnergy = true;
    
    protected int collision;
    
    protected int animationStage;
    public Entity(Vec2D p, World wi) {
        this.w = wi;
        this.collision = 0;
        //pos = new Vec2D(p.getX(), p.getY());
        //this.pos = wi.randomPointInsideWorld();
        this.pos = new Vec2D (1,1);
        animationStage = 0;
    }

    public boolean hasEnergy() {
        return hasEnergy;
    }

    public int getAnimationStage() {
        return animationStage;
    }

    public void animationStageDecrease() {
        if(animationStage > 0) this.animationStage--;
    }
    public void animationStageIncrease() {
        this.animationStage++;
    }
    public void setAnimationStage(int animationStage) {
        if(animationStage >= 0) this.animationStage = animationStage;
    }
    public void setCollision(int c) {
        collision = c;
    }
    public int getCollision() {
        return collision;
    }

    public Vec2D getPos() {
        return pos;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        if(hasEnergy) this.energy = energy;
    }
    public void substractEnergy(int energy) {
        if(hasEnergy) this.energy -= energy;
    }
    public int liveOrDie() {
        if(energy <= 0 && hasEnergy) {
            w.removeEntity(this);
            return -1;
        }
        else {
            return 0;
        }
    }
    public void setPos(Vec2D p) {
        pos.setX(p.getX());
        pos.setY(p.getY());
    }

    public boolean collides(Entity e) {
        Vec2D epos = e.getPos();
        if (pos.dist(epos) < 5)
            return true;
        else
            return false;
    }

    public void update() {
    }
}
