/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.util.logging.Level;
import java.util.logging.Logger;
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

    /**
     * Test of changeBrightness method, of class BWFrame.
     */
    @Test
    public void testChangeBrightness() {
        System.out.println("changeBrightness");
        double delta = 2.0;
        BWFrame instance = new BWFrame(2,2);
        try {
            instance.set(1, 1, delta);
            instance.changeBrightness(delta);
            double current = instance.get(1, 1);
            assertEquals(4.0, current, 0.0);
        } catch (Exception ex) {
            fail("Failed test");
        }
    }

    /**
     * Test of get method, of class BWFrame.
     */
    @Test
    public void testGet() throws Exception {
        System.out.println("get");
        Integer i = 1;
        Integer j = 1;
        BWFrame instance = new BWFrame(2,2);
        instance.set(i, j, 2);
        double expResult = 2;
        double result = instance.get(i, j);
        assertEquals(expResult, result,0);
        Boolean catched = false;
        try {
            instance.get(2, 1);
        }
        catch(Exception e) {
            catched = true;
        }
        assertTrue(catched);
    }

    /**
     * Test of set method, of class BWFrame.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Integer i  = 1;
        Integer j = 1; 
        double val = 1.0;
        BWFrame instance = new BWFrame(2,2);
        try {
            instance.set(i, j, val);
            double result = instance.get(i, j);
            assertEquals(val, result, 0.0);
        } catch (Exception ex) {
            fail("Failed test");
        }
        
        
    }
    
}
