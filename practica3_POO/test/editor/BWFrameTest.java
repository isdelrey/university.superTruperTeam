/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

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
public class BWFrameTest {
    
    public BWFrameTest() {
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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeBrightness method, of class BWFrame.
     */
    @Test
    public void testChangeBrightness() {
        System.out.println("changeBrightness");
        double delta = 0.0;
        BWFrame instance = null;
        instance.changeBrightness(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class BWFrame.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        Integer i = null;
        Integer j = null;
        BWFrame instance = null;
        double expResult = 0.0;
        double result = instance.get(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class BWFrame.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Integer i = null;
        Integer val = null;
        BWFrame instance = null;
        instance.set(i, val);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
