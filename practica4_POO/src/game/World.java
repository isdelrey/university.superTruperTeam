package game;

import java.util.*;
import java.awt.Color; 


public class World implements Drawable {
    int W,H;
    int margin;
    int process;

    LinkedList entities;
        
    public World() {
        W = 800;
        H = 600;
        margin = 50;
        process = 0;
        entities = new LinkedList();
        
        Random r = new Random();
        int N = 10;            
        for(int i=0; i<N/2; i++) {            
            Entity e = new Agent( randomPointInsideWorld(), randomPointInsideWorld(), r.nextInt(30)+10, 6, this );
            entities.add( e );
        }
        for(int i=N/2; i<N; i++) {            
            Entity e = new Obstacle( randomPointInsideWorld(), this );
            entities.add( e );
        }
        
    }
    public World(int w, int h, int a) {
        W = w;
        H = h;
        margin = 50;
        process = 0;
        entities = new LinkedList();
        
        Random r = new Random();
        int N = a;            
        for(int i=0; i<N/2; i++) {            
            Entity e = new Agent( randomPointInsideWorld(), randomPointInsideWorld(), r.nextInt(30)+5, 6, this );
            entities.add( e );
        }
        for(int i=N/2; i<N; i++) {            
            Entity e = new Obstacle( randomPointInsideWorld(), this );
            entities.add( e );
        }
        
    }
    public int getW() { return W; }
    public int getH() { return H; }
    public int getN() { return entities.size();}
    
    public Entity getEntity(int i) {
        return (Entity) this.entities.get(i);
    }
    
    public Vec2D randomPointInsideWorld() {        
        double x = margin + Math.random() * (W - 2*margin);
        double y = margin + Math.random() * (H - 2*margin); 
        Vec2D p = new Vec2D(x,y);
        return p;
    }
    public void removeEntity(Entity e) {
        entities.remove(e);
    }
    public void processCollisions() {
        process++;
        for(int i = 0; i < getN(); i++) {
            Entity ei = (Entity)entities.get(i);
            if(process < ei.getCollision() + 25) continue;
            int energyi = ei.getEnergy();
            for(int j = 0; j < getN(); j++) {  
                if(i == j) continue;
                Entity ej = (Entity)entities.get(j);
                if(!ei.collides(ej)) continue;
                
                ei.setCollision(process);
                ej.setCollision(process);
                ei.setAnimationStage(15);
                
                
                int energyj = ej.getEnergy();
                if(ei.hasEnergy()) ei.substractEnergy(1);
                if(ej.hasEnergy()) ej.substractEnergy(1);
                if(ei instanceof MovingEntity) {
                    MovingEntity a = (MovingEntity) ei;
                    Vec2D av = a.getDir();
                    Vec2D bv = a.getDir();
                    // Rotation
                    int aAngleCoeff = (av.angle(bv)>bv.angle(bv))?-1:1;
                    double angle = (av.angle(bv)+bv.angle(bv))/2;
                    av.rotate(180+(Math.random()-0.5)*90);
                    bv.rotate(180+(Math.random()-0.5)*90);
                }
            }
        }
        int length = entities.size();
        int i = 0;
        while(i < length) {
            length += ((Entity)entities.get(i)).liveOrDie();
            i++;
        }
    }
    
    
    public void removeOutsiders() {
        for(int i=0; i<entities.size(); i++) {
            Entity ei = (Entity) entities.get(i);            
            if((ei.getPos().getX() < 0) ||
               (ei.getPos().getX() > W) ||
               (ei.getPos().getY() < 0) ||
               (ei.getPos().getY() > H))
            {
                entities.remove(ei);
            }
        }
    }
    
    
    public void update() {              
        removeOutsiders();
        processCollisions();       
        for(int i=0; i<getN(); i++) {
            Entity ei = (Entity) entities.get(i);
            ei.update();
            if(ei instanceof Agent){
                if(((Agent) ei).objReached()){
                    ((Agent) ei).setObj(this.randomPointInsideWorld());
                }
            }
        }
    }
        
    public void run(int steps) {
        for(int i = 0; i<steps; i++) update();
    }
    
    public void draw( java.awt.Graphics g ) {
         for(int i=0; i<getN(); i++) {
            Entity ei = (Entity) entities.get(i);
            Vec2D p = ei.getPos();
            ei.draw(g);
            double wa = 2;
            g.setColor(Color.BLACK);    
            g.fillOval((int)(p.getX() - wa), (int)(p.getY() - wa), 2*(int)wa, 2*(int)wa);  
         }        
    }
    
}
