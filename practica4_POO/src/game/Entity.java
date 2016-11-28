
class Entity  {
    protected Vec2D pos;
    protected int id;
    protected World w;
    protected boolean bCollides;
    
    public Entity( Vec2D p, World wi ) {
        w = wi;
        bCollides = false;
        pos = new Vec2D( p.getX(), p.getY());        
    }
    
    public void setCollides(boolean t) { bCollides = t; }
    public Vec2D getPos() { return pos; }
    public void setPos(Vec2D p) { pos.setX(p.getX()); pos.setY(p.getY()); }

    
    public boolean collides(Entity e) {        
        Vec2D epos = e.getPos();
        if(pos.dist(epos) < 50) return true;
        else return false;        
    }
    
    public void update() {}
}
