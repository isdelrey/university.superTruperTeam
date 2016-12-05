package game;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon; 

abstract class Entity implements Drawable{

    protected Vec2D pos;

    protected int id;

    protected World w;

    protected boolean bCollides;

    public Entity(Vec2D p, World wi) {
        this.w = wi;
        this.bCollides = false;
        //pos = new Vec2D(p.getX(), p.getY());
        //this.pos = wi.randomPointInsideWorld();
        this.pos = new Vec2D (1,1);
    }

    public void setCollides(boolean t) {
        bCollides = t;
    }

    public Vec2D getPos() {
        return pos;
    }

    public void setPos(Vec2D p) {
        pos.setX(p.getX());
        pos.setY(p.getY());
    }

    public boolean collides(Entity e) {
        Vec2D epos = e.getPos();
        if (pos.dist(epos) < 50)
            return true;
        else
            return false;
    }

    public void update() {
    }
}
