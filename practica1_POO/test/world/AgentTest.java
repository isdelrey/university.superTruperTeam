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
public class AgentTest {
    
    public AgentTest() {
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
     * Test of getRadius method, of class Agent.
     */
    @Test
    public void testGetRadius() {
        System.out.println("getRadius");
        Agent fakeAgent = new Agent (new Vec2D(1,1), new Vec2D(2,2),30.5, 2);
        double expResult = 30.5;
        double result = fakeAgent.getRadius();
        assertEquals(expResult, result, 0.0);
       
    }

    /**
     * Test of getPos method, of class Agent.
     */
    @Test
    public void testGetPos() {
        System.out.println("getPos");
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Vec2D expResult = new Vec2D(1.0,1.0);
        Vec2D result = fakeAgent.getPos();
        assertEquals(expResult.getX(), result.getX(), 0.0);
        assertEquals(expResult.getY(), result.getY(), 0.0);

    }

    /**
     * Test of getDir method, of class Agent.
     */
    @Test
    public void testGetDir() {
        System.out.println("getDir");
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Agent expAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Vec2D expResult = expAgent.getDirToObj();       
        Vec2D result = fakeAgent.getDir();
        assertEquals( expResult.getX(), result.getX(), 0.0);
        assertEquals(expResult.getY(), result.getY(), 0.0);
    
    }

    /**
     * Test of getObj method, of class Agent.
     */
    @Test
    public void testGetObj() {
        System.out.println("getObj");
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Vec2D expResult = new Vec2D(2,2);
        Vec2D result = fakeAgent.getObj();
        assertEquals(expResult.getX(), result.getX(), 0.0);
        assertEquals(expResult.getY(), result.getY(), 0.0);
   
    }

    /**
     * Test of setPos method, of class Agent.
     */
    @Test
    public void testSetPos() {
        System.out.println("setPos");
        Vec2D vector = new Vec2D(3,3);
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        fakeAgent.setPos(vector);
        assertEquals(vector, fakeAgent.getPos());
    }

    /**
     * Test of setObj method, of class Agent.
     */
    @Test
    public void testSetObj() {
        System.out.println("setObj");
        Vec2D vector = new Vec2D(3,3);
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        fakeAgent.setObj(vector);
        assertEquals(vector, fakeAgent.getObj());
    }

    /**
     * Test of setDir method, of class Agent.
     */
    @Test
    public void testSetDir() {
        System.out.println("setDir");
        Vec2D vector = new Vec2D(3,3);
        Agent fakeAgent = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        fakeAgent.setDir(vector);
        assertEquals(vector, fakeAgent.getDir());
    }

    /**
     * Test of getDirToObj method, of class Agent.
     */
    @Test
    public void testGetDirToObj() {
        System.out.println("getDirToObj");
        Agent fakeAgent1 = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Agent fakeAgent2 = new Agent (new Vec2D(1.0,1.0), new Vec2D(2,2),30.5, 2);
        Vec2D vector1 = fakeAgent1.getDirToObj();
        Vec2D vector2 = fakeAgent2.getDir();
        assertEquals(vector1.getX(), vector2.getX(), 0.0);
        assertEquals(vector1.getY(), vector2.getY(), 0.0);
    }

    /**
     * Test of objReached method, of class Agent.
     */
    @Test
    public void testObjReached() {
        System.out.println("objReached");
        Agent fakeAgent = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        fakeAgent.setObj(new Vec2D(300, 300));
        Boolean expResult = fakeAgent.objReached();
        assertTrue(expResult);
    }
    
    /**
     * Test of objReached method, of class Agent for non reaching the objective.
     */
    @Test
    public void testObjNotReached() {
        System.out.println("objNotReached");
        Agent fakeAgent = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        fakeAgent.setObj(new Vec2D(200, 200));
        Boolean expResult = fakeAgent.objReached();
        assertFalse(expResult);
    }
    /**
     * Test of update method, of class Agent.
     */


    /**
     * Test of collisionWith method, of class Agent.
     */
    @Test
    public void testCollisionWith() {
        System.out.println("collisionWith");
        Agent fakeAgent1 = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        Agent fakeAgent2 = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        Boolean expResult = fakeAgent1.collisionWith(fakeAgent2);
        assertTrue(expResult);

    }
        /**
     * Test of collisionWith method, of class Agent. Not colliding
     */
    @Test
    public void testNotCollisionWith() {
        System.out.println("Not collisionWith");
        Agent fakeAgent1 = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        Agent fakeAgent2 = new Agent(new Vec2D(400,400), new Vec2D(1,2),30.5, 2);
        Boolean expResult = fakeAgent1.collisionWith(fakeAgent2);
        assertFalse(expResult);

    }

    /**
     * Test of toString method, of class Agent.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Agent fakeAgent = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        String expResult = "Agent { id: " + 2 + ", position: {" + new Vec2D(300,300).getX() + "," + new Vec2D(300,300).getY() + "}, objective: {" + new Vec2D(2,2).getX() + "," + new Vec2D(2,2).getY() + "}";  ;
        String result = fakeAgent.toString();
        assertEquals(expResult, result);

    }
    
     /* 
    Test of getCollided method, of class Agent.
     */
    @Test
    public void testGetCollided() {
        System.out.println("toString");
        boolean expResult = true; 
        Agent fakeAgent1 = new Agent(new Vec2D(300,300), new Vec2D(2,2),30.5, 2);
        fakeAgent1.setCollided(true); 
        boolean result = fakeAgent1.getCollided(); 
        assertEquals(expResult, result);

    }
    
}
