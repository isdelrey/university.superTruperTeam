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
public class AudioBufferTest {
    
    public AudioBufferTest() {
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
     * Test of changeVolume method, of class AudioBuffer.
     */
    @Test
    public void testChangeVolume() {
        System.out.println("changeVolume");
        double delta = 2.0;
        double current;
        AudioBuffer audioBuffer = new AudioBuffer(3);
        try {
            audioBuffer.set(1, 2.0);
            audioBuffer.changeVolume(delta);
            current = audioBuffer.getPositionValue(1);
            assertEquals(4.0, current, 0.0);
        } catch (Exception ex) {
            fail("Failed test");
        }


        
    }
    
}
