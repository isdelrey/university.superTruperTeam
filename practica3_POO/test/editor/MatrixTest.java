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
public class MatrixTest {
    
    public MatrixTest() {
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
     * Test of getRow method, of class Matrix.
     */
    @Test
    public void testGetRow() {
        System.out.println("getRow");
        int r = 0;
        Matrix instance = new Matrix();
        Vector expResult = null;
        Vector result = instance.getRow(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumn method, of class Matrix.
     */
    @Test
    public void testGetColumn() {
        System.out.println("getColumn");
        int c = 0;
        Matrix instance = new Matrix();
        Vector expResult = null;
        Vector result = instance.getColumn(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRow method, of class Matrix.
     */
    @Test
    public void testSetRow() {
        System.out.println("setRow");
        int r = 0;
        Vector v = null;
        Matrix instance = new Matrix();
        instance.setRow(r, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumn method, of class Matrix.
     */
    @Test
    public void testSetColumn() {
        System.out.println("setColumn");
        int c = 0;
        Vector v = null;
        Matrix instance = new Matrix();
        instance.setColumn(c, v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of zero method, of class Matrix.
     */
    @Test
    public void testZero() {
        System.out.println("zero");
        Matrix instance = new Matrix();
        instance.zero();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rows method, of class Matrix.
     */
    @Test
    public void testRows() {
        System.out.println("rows");
        Matrix instance = new Matrix();
        int expResult = 0;
        int result = instance.rows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of columns method, of class Matrix.
     */
    @Test
    public void testColumns() {
        System.out.println("columns");
        Matrix instance = new Matrix();
        int expResult = 0;
        int result = instance.columns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addColumn method, of class Matrix.
     */
    @Test
    public void testAddColumn() {
        System.out.println("addColumn");
        Vector v = null;
        Matrix instance = new Matrix();
        instance.addColumn(v);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
