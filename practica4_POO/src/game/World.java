import java.util.*;
import java.awt.Color; 


public class World {
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
        for(int i=0; i<N; i++) {            
            Entity e = new Entity( randomPointInsideWorld(), this );
            entities.add( e );
        }
    }
    
    int getW() { return W; }
    int getH() { return H; }
    
    Vec2D randomPointInsideWorld() {        
        double x = margin + Math.random() * (W - 2*margin);
        double y = margin + Math.random() * (H - 2*margin); 
        Vec2D p = new Vec2D(x,y);
        return p;
    }
    
    void processCollisions() {        
          for(int i=0; i<N; i++) {
              Entity ei = (Entity) entities.get(i);
              ei.setCollides(false);
          }
          
          for(int i=0; i<N; i++) {
              Entity ei = (Entity) entities.get(i);
              ei.setCollides(false);
              for(int j=0; j<N; j++) {  
                  if(i == j) continue;
                  Entity ej = (Entity) entities.get(j);
                  if(ei.collides(ej)) {
                      ei.setCollides(true);
                  }
              }
          }
    }
    
    
    void removeOutsiders() {
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
    
    
    void update() {              
        removeOutsiders();
        processCollisions();
        
        for(int i=0; i<N; i++) {
            Entity ei = (Entity) entities.get(i);
            ei.update();    
        }
    }
        
    public void run(int steps) {
        for(int i = 0; i<steps; i++) update();
    }
    
    public void draw( java.awt.Graphics g ) {
         for(int i=0; i<N; i++) {
            Entity ei = (Entity) entities.get(i);
            Vec2D p = ei.getPos();
            double wa = 2;
            g.setColor(Color.BLACK);    
            g.fillOval((int)(p.getX() - wa), (int)(p.getY() - wa), 2*(int)wa, 2*(int)wa);  
         }        
    }
    
}
