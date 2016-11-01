/*
┌──────────────────────────────────────────────────────────────────────────────────┐
│                  Pràctica 2 - Programació Orientada a Objectes                   │
└──────────────────────────────────────────────────────────────────────────────────┘

Paula Bassagañas Odena, NIA: 158710
Ivo Sequeros del Rey, NIA: 183711

 */
package world;
import java.util.HashMap;
import java.util.Random;
/**
 *
 * @author u124308
 */
public class World {
    private int width, height, screenMargin, numAgents,updateN=0; 
    Agent[] agents;
    
    // Constructor:
    public World(int nagents,int w,int h) {
        width = w;
        height = h;
        screenMargin = 30;
        numAgents = nagents;
        agents = new Agent[numAgents];
        for ( int i = 0; i < numAgents; i++){
            double randRad = 5 + Math.random()*(this.screenMargin/2); 
            this.agents[i] = new Agent(this.randomPointInsideWorld(),this.randomPointInsideWorld(), randRad, i);
            this.agents[i].dirToObj();
        };
    }
    
    //Public methods 
    public int getW() {
        return this.width;
    }
    public int getH() {
        return this.height;
    }
    public int getNumAgents() {
        return this.numAgents;
    }
    public Agent getAgent(int i){
        return this.agents[i]; 
    }
    public int processCollisions(){
        int coll = 0;
        for(Agent a:agents) {
            for(Agent b:agents) {
                Boolean itCollides = a.collisionWith(b);
                Boolean inCollision = a.getCollided();
                if(itCollides && !inCollision) {
                    a.setCollided(true);
                    Vec2D av = a.getDir();
                    Vec2D bv = b.getDir();

                    // Rotation
                    int aAngleCoeff = (av.angle(bv)>bv.angle(bv))?-1:1;
                    double aRadiusCoeff = (a.getRadius()/b.getRadius());
                    double angle = (av.angle(bv)+bv.angle(bv))/2;
                    av.rotate(aAngleCoeff*(angle*aRadiusCoeff+180));
                    bv.rotate((-1*aAngleCoeff)*(aRadiusCoeff+180));
                    
                    coll++;
                }
                if(!itCollides && inCollision) a.setCollided(false);
            }
        }
        return coll/2;
    }
    public void run(int steps) {
        for(int i=0;i<steps;i++) update();
    }
    
    //Methods only used on World class and that will be by definition only used by World class therefore private. 
    private void update() {
        for(Agent a:agents) {
            a.update();
            // Reset Objective if met
            if(a.objReached()) {
                a.setObj(this.randomPointInsideWorld());
            }
            for(Agent b:agents) {
                if(!a.isLessThanXPixelsAway(b, 20)) a.dirToObj();
            }
        }
    }
    private Vec2D randomPointInsideWorld() {
        Random random = new Random();
        return new Vec2D(random.nextInt(width-screenMargin/2)+screenMargin,random.nextInt(height-screenMargin/2)+screenMargin); 
    }
    
}
