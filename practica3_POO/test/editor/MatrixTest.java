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
        Vector result = instance.getRows(r);
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

    /**
     * Test of getRows method, of class Matrix.
     */
    @Test
    public void testGetRows() {
        System.out.println("getRows");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getRows();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumns method, of class Matrix.
     */
    @Test
    public void testGetColumns() {
        System.out.println("getColumns");
        Matrix instance = null;
        int expResult = 0;
        int result = instance.getColumns();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Matrix.
     */
    @Test
    public void testGetValue() throws Exception {
        System.out.println("getValue");
        Integer i = null;
        Integer j = null;
        Matrix instance = null;
        double expResult = 0.0;
        double result = instance.getValue(i, j);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnVector method, of class Matrix.
     */
    @Test
    public void testGetColumnVector() throws Exception {
        System.out.println("getColumnVector");
        int c = 0;
        Matrix instance = null;
        Vector expResult = null;
        Vector result = instance.getColumnVector(c);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRowVector method, of class Matrix.
     */
    @Test
    public void testGetRowVector() throws Exception {
        System.out.println("getRowVector");
        int r = 0;
        Matrix instance = null;
        Vector expResult = null;
        Vector result = instance.getRowVector(r);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMatrixValues method, of class Matrix.
     */
    @Test
    public void testGetMatrixValues() {
        System.out.println("getMatrixValues");
        Matrix instance = null;
        Vector[] expResult = null;
        Vector[] result = instance.getMatrixValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class Matrix.
     */
    @Test
    public void testSet() throws Exception {
        System.out.println("set");
        int m = 0;
        int n = 0;
        double value = 0.0;
        Matrix instance = null;
        instance.set(m, n, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMatrix method, of class Matrix.
     */
    @Test
    public void testPrintMatrix() {
        System.out.println("printMatrix");
        Matrix instance = null;
        instance.printMatrix();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create3DRotationZ method, of class Matrix.
     */
    @Test
    public void testCreate3DRotationZ() throws Exception {
        System.out.println("create3DRotationZ");
        double alpha = 0.0;
        Matrix instance = null;
        instance.create3DRotationZ(alpha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRow method, of class Matrix.
     */
    @Test
    public void testAddRow() {
        System.out.println("addRow");
        Matrix instance = null;
        instance.addRow();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplyScalar method, of class Matrix.
     */
    @Test
    public void testMultiplyScalar() {
        System.out.println("multiplyScalar");
        double scalar = 0.0;
        Matrix instance = null;
        instance.multiplyScalar(scalar);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
