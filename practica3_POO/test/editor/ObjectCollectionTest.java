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
public class ObjectCollectionTest {
    
    public ObjectCollectionTest() {
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
     * Test of getMaxDimension method, of class ObjectCollection.
     */
    @Test
    public void testGetMaxDimension() {
        System.out.println("getMaxDimension");
        ObjectCollection instance = new ObjectCollection();
        int expResult = 0;
        int result = instance.getMaxDimension();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMaxDimension method, of class ObjectCollection.
     */
    @Test
    public void testSetMaxDimension() {
        System.out.println("setMaxDimension");
        int dim = 0;
        ObjectCollection instance = new ObjectCollection();
        instance.setMaxDimension(dim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
