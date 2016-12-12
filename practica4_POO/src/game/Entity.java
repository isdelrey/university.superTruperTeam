package game;


abstract class Entity implements Drawable{

    protected Vec2D pos;

    protected int id;

    protected World w;

    protected int energy;
    
    protected boolean hasEnergy = true;
    
    protected int collision;
    
    protected int animationStage;
    
    /**
     * Builds a new Entity and places it at a position in a World
     */
    public Entity(Vec2D p, World wi) {
        this.w = wi;
        this.collision = 0;
        //pos = new Vec2D(p.getX(), p.getY());
        //this.pos = wi.randomPointInsideWorld();
        this.pos = new Vec2D (1,1);
        animationStage = 0;
    }
    /**
     * Sets Entity's energy
     */
    public boolean hasEnergy() {
        return hasEnergy;
    }
    /**
     * Returns the animation stage of this Entity - used when drawn
     */
    public int getAnimationStage() {
        return animationStage;
    }
    /**
     * Decreases by 1 the animation stage of this Entity - used when drawn
     */
    public void animationStageDecrease() {
        if(animationStage > 0) this.animationStage--;
    }
    /**
     * Increases by 1 the animation stage of this Entity - used when drawn
     */
    public void animationStageIncrease() {
        this.animationStage++;
    }
    /**
     * Sets the animation stage of this Entity - used when drawn
     */
    public void setAnimationStage(int animationStage) {
        if(animationStage >= 0) this.animationStage = animationStage;
    }
    /**
     * Sets last loop iteration where the Agent collided - used in World's processCollisions
     */
    public void setCollision(int c) {
        collision = c;
    }
    /**
     * Returns last loop iteration where the Entity collided - used in World's processCollisions
     */
    public int getCollision() {
        return collision;
    }
    /**
     * Returns Entity's position
     */
    public Vec2D getPos() {
        return pos;
    }
    /**
     * Sets Entity's energy
     */
    public int getEnergy() {
        return energy;
    }
    /**
     * Sets Entity's energy
     */
    public void setEnergy(int energy) {
        if(hasEnergy) this.energy = energy;
    }
    /**
     * Subtracts an amount from Entity's energy if the Entity has Energy
     */
    public void substractEnergy(int energy) {
        if(hasEnergy) this.energy -= energy;
    }
    /**
     * Checks if the Entity has Energy and if the Energy has an amount that's equal or below 0, if so, it self-removes from its World
     */
    public int liveOrDie() {
        if(energy <= 0 && hasEnergy) {
            w.removeEntity(this);
            return -1;
        }
        else {
            return 0;
        }
    }
    /**
     * Sets Entity's position
     */
    public void setPos(Vec2D p) {
        pos.setX(p.getX());
        pos.setY(p.getY());
    }
    /**
     * Check if this Entity collides with another Entity
     */
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
