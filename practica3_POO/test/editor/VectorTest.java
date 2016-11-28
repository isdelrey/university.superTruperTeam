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
public class VectorTest {
    
    public VectorTest() {
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
    public void testSum() throws Exception {
        Vector v = new Vector(2);
        v.set(0, 1);
        v.set(1, 1);
        Vector w = new Vector(2);
        w.set(0, 1);
        w.set(1, 1);
        
        v.sumFrom(w);
        assertEquals((double)2,v.getPositionValue(0),0);
        assertEquals((double)2,v.getPositionValue(1),0);
        
        Vector q = v.sumWith(w);
        assertEquals((double)3,q.getPositionValue(0),0);
        assertEquals((double)3,q.getPositionValue(1),0);
    }
    @Test
    public void testMultiply() throws Exception {
        Vector v = new Vector(2);
        v.set(0, 1);
        v.set(1, 1);
        Vector w = new Vector(2);
        w.set(0, 2);
        w.set(1, 2);
        
        v.multiply(3);
        assertEquals((double)3,v.getPositionValue(0),0);
        assertEquals((double)3,v.getPositionValue(1),0);
        
        Vector q = v.multiplyWith(w);
        assertEquals((double)6,q.getPositionValue(0),0);
        assertEquals((double)6,q.getPositionValue(1),0);
        
        Matrix m = new Matrix(3,3);
        v.addDim();
        v.multiplyMat(m);
        assertTrue(v.isZero());
    }
    @Test
    public void testDim() throws Exception {
        Vector v = new Vector(2);
        v.set(0, 1);
        v.set(1, 1);
        v.newDim(30);
        
        Boolean catched = false;
        try {
            v.newDim(300);
        }
        catch(Exception e) {
            catched = true;
        }
        assertTrue(catched);
        
        assertEquals(30,v.getDim());
        v.removeDim();
        assertEquals(29,v.getDim());
    }
}
