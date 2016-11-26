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

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class ColorFrame.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        Integer i = null;
        Integer j = null;
        ColorFrame instance = null;
        int[] expResult = null;
        int[] result = instance.get(i, j);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class ColorFrame.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Integer i = null;
        Integer j = null;
        Integer r = null;
        Integer g = null;
        Integer b = null;
        ColorFrame instance = null;
        instance.set(i, j, r, g, b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeBrightness method, of class ColorFrame.
     */
    @Test
    public void testChangeBrightness() {
        System.out.println("changeBrightness");
        double delta = 0.0;
        ColorFrame instance = null;
        instance.changeBrightness(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeRGB method, of class ColorFrame.
     */
    @Test
    public void testChangeRGB() {
        System.out.println("changeRGB");
        Integer dR = null;
        Integer dG = null;
        Integer dB = null;
        ColorFrame instance = null;
        instance.changeRGB(dR, dG, dB);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
