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

    /**
     * Test of zero method, of class Vector.
     */
    @Test
    public void testZero() {
        System.out.println("zero");
        Vector instance = new Vector();
        instance.zero();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDim method, of class Vector.
     */
    @Test
    public void testGetDim() {
        System.out.println("getDim");
        Vector instance = new Vector();
        int expResult = 0;
        int result = instance.getDim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArray method, of class Vector.
     */
    @Test
    public void testGetArray() {
        System.out.println("getArray");
        Vector instance = new Vector();
        double[] expResult = null;
        double[] result = instance.getArray();
        //assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class Vector.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        Vector instance = new Vector();
        double expResult = 0.0;
        double result = instance.get(index);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Vector.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        int index = 0;
        double v = 0.0;
        Vector instance = new Vector();
        instance.set(index, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setZero method, of class Vector.
     */
    @Test
    public void testSetZero() {
        System.out.println("setZero");
        int index = 0;
        Vector instance = new Vector();
        instance.setZero(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumAll method, of class Vector.
     */
    @Test
    public void testSumAll() {
        System.out.println("sumAll");
        Vector instance = new Vector();
        double expResult = 0.0;
        double result = instance.sumAll();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumTo method, of class Vector.
     */
    @Test
    public void testSumTo() {
        System.out.println("sumTo");
        Vector v = null;
        Vector instance = new Vector();
        instance.sumTo(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumFrom method, of class Vector.
     */
    @Test
    public void testSumFrom() {
        System.out.println("sumFrom");
        Vector v = null;
        Vector instance = new Vector();
        instance.sumFrom(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sumWith method, of class Vector.
     */
    @Test
    public void testSumWith() {
        System.out.println("sumWith");
        Vector v = null;
        Vector instance = new Vector();
        Vector expResult = null;
        Vector result = instance.sumWith(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplyWith method, of class Vector.
     */
    @Test
    public void testMultiplyWith() {
        System.out.println("multiplyWith");
        Vector v = null;
        Vector instance = new Vector();
        Vector expResult = null;
        Vector result = instance.multiplyWith(v);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of print method, of class Vector.
     */
    @Test
    public void testPrint() {
        System.out.println("print");
        Vector instance = new Vector();
        instance.print();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPositionValue method, of class Vector.
     */
    @Test
    public void testGetPositionValue() {
        System.out.println("getPositionValue");
        int index = 0;
        Vector instance = null;
        double expResult = 0.0;
        double result = instance.getPositionValue(index);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiply method, of class Vector.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        Integer integer = null;
        Vector instance = null;
        instance.multiply(integer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set3D method, of class Vector.
     */
    @Test
    public void testSet3D() {
        System.out.println("set3D");
        Object i = null;
        Object j = null;
        Object k = null;
        Vector instance = null;
        instance.set3D(i, j, k);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplyMat method, of class Vector.
     */
    @Test
    public void testMultiplyMat() {
        System.out.println("multiplyMat");
        Matrix m = null;
        Vector instance = null;
        instance.multiplyMat(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addDim method, of class Vector.
     */
    @Test
    public void testAddDim() {
        System.out.println("addDim");
        Vector instance = null;
        instance.addDim();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
