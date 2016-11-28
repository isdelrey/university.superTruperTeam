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
public class ColorFrameTest {
    
    public ColorFrameTest() {
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
     * Test of set and get method, of class ColorFrame.
     */
    @Test
    public void testSetGet() throws Exception {
        System.out.println("set");
        ColorFrame c = new ColorFrame(2,2);
        c.set(1, 1, 1, 0, 0);
        assertEquals(1,c.get(1, 1)[0],0);
        Boolean catched = false;
        try {
            c.set(8, 2, 0);
        }
        catch(Exception e) {
            catched = true;
        }
        assertTrue(catched);
        catched = false;
        try {
            c.get(8, 8);
        }
        catch(Exception e) {
            catched = true;
        }
        assertTrue(catched);
    }

    /**
     * Test of changeBrightness method, of class ColorFrame.
     */
    @Test
    public void testChangeBrightness() throws Exception {
        System.out.println("changeBrightness");
        // Black
        Integer dR = 0;
        Integer dG = 0;
        Integer dB = 0;
        ColorFrame instance = new ColorFrame(2,2);
        instance.changeBrightness(0);
        assertEquals(0,instance.get(1, 1)[0],0);
    }

    /**
     * Test of changeRGB method, of class ColorFrame.
     */
    @Test
    public void testChangeRGB() throws Exception {
        System.out.println("changeRGB");
        // Black
        Integer dR = 0;
        Integer dG = 0;
        Integer dB = 0;
        ColorFrame instance = new ColorFrame(2,2);
        instance.changeRGB(0, 0, 0);
        instance.get(1, 1);
    }
    
}
