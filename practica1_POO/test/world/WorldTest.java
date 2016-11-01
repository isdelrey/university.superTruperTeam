/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package world;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bassagap
 */
public class WorldTest {
    
    public WorldTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getW method, of class World.
     */
    @Test
    public void testGetW() {
        System.out.println("getW");
        World fakeWorld = new World(10, 600, 200);
        int expResult = 600;
        int result = fakeWorld.getW();
        assertEquals(expResult, result);
    }

    /**
     * Test of getH method, of class World.
     */
    @Test
    public void testGetH() {
        System.out.println("getH");
        World fakeWorld = new World(10, 600, 200);
        int expResult = 200;
        int result = fakeWorld.getH();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumAgents method, of class World.
     */
    @Test
    public void testGetNumAgents() {
        System.out.println("getNumAgents");
        World fakeWorld = new World(10, 600, 200);
        int expResult = 10;
        int result = fakeWorld.getNumAgents();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAgent method, of class World.
     */
    @Test
    public void testGetAgent() {
        System.out.println("getAgent");
        int i = 0;
        World fakeWorld = new World(10, 600, 200);
        Agent agentsList[] = fakeWorld.agents; 
        Agent agent = fakeWorld.getAgent(i);
        assertEquals(agentsList[i].getPos().getX(), agent.getPos().getX(), 0.0);
        assertEquals(agentsList[i].getPos().getY(), agent.getPos().getY(), 0.0);
    }

    /**
     * Test of processCollisions method, of class World.
     */
    @Test
    public void testProcessCollisions() {
        System.out.println("processCollisions");
        World fakeWorld = new World(10, 600, 200);
        Agent fakeAgent = fakeWorld.getAgent(0);
        Vec2D fakeVector = fakeAgent.getDir();
        fakeWorld.processCollisions();
        Vec2D expVector = fakeWorld.getAgent(0).getDir();
        assertNotEquals(fakeVector.getX(), expVector.getY()); 
    }

    /**
     * Test of run method, of class World.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        int steps = 10;
        World fakeWorld = new World(10, 600, 200);
        Vec2D initVector = new Vec2D(2, 2);
        fakeWorld.getAgent(0).setPos(new Vec2D(2, 2));
        fakeWorld.getAgent(0).setObj(new Vec2D(2, 2));
        
        //fakeWorld.getAgent(0).setPos(new Vec2D(1,33));
        fakeWorld.run(steps);
        Vec2D expVector = fakeWorld.getAgent(0).getObj();
        assertNotEquals(expVector.getX(), initVector.getX()); 

    }
        @Test
        public void testNotRun() {
        System.out.println("run");
        int steps = 0;
        World fakeWorld = new World(10, 600, 200);
        Vec2D fakeVector = fakeWorld.getAgent(0).getPos();
        fakeWorld.run(steps);
        Vec2D expVector = fakeWorld.getAgent(0).getPos();
        assertEquals(fakeVector.getX(), expVector.getX(), 0.0); 

    }
    
}
