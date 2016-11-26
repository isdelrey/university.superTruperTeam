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
public class FrameTest {
    
    public FrameTest() {
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
     * Test of changeBrightness method, of class Frame.
     */
    @Test
    public void testChangeBrightness() {
        System.out.println("changeBrightness");
        double delta = 0.0;
        Frame instance = null;
        instance.changeBrightness(delta);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class FrameImpl extends Frame {

        public FrameImpl() {
            super(null, null);
        }

        public void changeBrightness(double delta) {
        }
    }
    
}
