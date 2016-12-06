package game;

import java.util.*;
import java.awt.Color; 


public class World implements Drawable {
    int W,H;
    int margin;
    
    int N;

    LinkedList entities;
        
    public World() {
        W = 800;
        H = 600;
        margin = 50;
        
        entities = new LinkedList();
        
        N = 10;            
        for(int i=0; i<N/2; i++) {            
            Entity e = new Agent( randomPointInsideWorld(), randomPointInsideWorld(), 5, 6, this );
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
        
        entities = new LinkedList();
        
        N = a;            
        for(int i=0; i<N/2; i++) {            
            Entity e = new Agent( randomPointInsideWorld(), randomPointInsideWorld(), 5, 6, this );
            entities.add( e );
        }
        for(int i=N/2; i<N; i++) {            
            Entity e = new Obstacle( randomPointInsideWorld(), this );
            entities.add( e );
        }
        
    }
    public int getW() { return W; }
    public int getH() { return H; }
    public int getN() { return this.N;}
    
    public Entity getEntity(int i) {
        return (Entity) this.entities.get(i);
    }
    
    public Vec2D randomPointInsideWorld() {        
        double x = margin + Math.random() * (W - 2*margin);
        double y = margin + Math.random() * (H - 2*margin); 
        Vec2D p = new Vec2D(x,y);
        return p;
    }
    
    public void processCollisions() {        
          for(int i=0; i<N; i++) {
              Entity ei = (Entity) entities.get(i);
              ei.setCollides(false);
          }
          
          for(int i=0; i<N; i++) {
              Entity ei = (Entity) entities.get(i);
              ei.setCollides(false);
              for(int j=0; j<N; j++) {  
                  if(i == j){
                      continue;
                  }
                  Entity ej = (Entity) entities.get(j);
                  if(ei.collides(ej)) {
                    ei.setCollides(true);
                    if(ei instanceof Agent) {
                    Agent a = (Agent) ei;
                    Vec2D av = a.getDir();
                    Vec2D bv = a.getDir();

                    // Rotation
                    int aAngleCoeff = (av.angle(bv)>bv.angle(bv))?-1:1;
                    double aRadiusCoeff = (a.getRadius());
                    double angle = (av.angle(bv)+bv.angle(bv))/2;
                    av.rotate(aAngleCoeff*(angle*aRadiusCoeff+180));
                    bv.rotate((-1*aAngleCoeff)*(aRadiusCoeff+180));
                    }

                  }
              }
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
        N = entities.size();
    }
    
    
    public void update() {              
        removeOutsiders();
        processCollisions();       
        for(int i=0; i<N; i++) {
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
         for(int i=0; i<N; i++) {
            Entity ei = (Entity) entities.get(i);
            Vec2D p = ei.getPos();
            ei.draw(g);
            double wa = 2;
            g.setColor(Color.BLACK);    
            g.fillOval((int)(p.getX() - wa), (int)(p.getY() - wa), 2*(int)wa, 2*(int)wa);  
         }        
    }
    
}
