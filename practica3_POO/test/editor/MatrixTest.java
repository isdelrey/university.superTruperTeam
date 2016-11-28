/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
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
     * Test of isZero and zero methods, of class Matrix.
     */
    @Test
    public void testZero() throws Exception {
        Random r = new Random();
        for(int k = 0;k < r.nextInt(100);k++) {
            int rows = r.nextInt(95)+1;
            int cols = r.nextInt(95)+1;
            Matrix instance = new Matrix(rows,cols);
            for(int i = 0;i < rows;i++) {
                for(int j = 0;j < cols;j++) {
                    instance.set(i, j, r.nextInt(100)+1);
                }
            }
            assertEquals(false,instance.isZero());
            instance.zero();
            assertEquals(true,instance.isZero());
        }
    }

    /**
     * Test of getRows, rows, set, getRowVector, getColumnVector method, of class Matrix.
     */
    @Test
    public void testRowsColumns() throws Exception {
        Random r = new Random();
        for(int k = 0;k < r.nextInt(100);k++) {
            // Iterates a randomly-sized matrix
            int rows = r.nextInt(95)+1;
            int cols = r.nextInt(95)+1;
            Matrix instance = new Matrix(rows,cols);
            for(int i = 0;i < rows;i++) {
                Vector v = new Vector(cols);
                for(int j = 0;j < cols;j++) {
                    // Fills every matrix row and the vector value
                    double value = r.nextInt(100)+1;
                    instance.set(i, j, value);
                    v.set(j,value);
                }
                // Check if vector and matrix row match
                assertTrue(v.doubleEquals(instance.getRowVector(i)));
            }
        }
    }
    @Test
    public void testgetMatrixValues() throws Exception {
        // Iterates a randomly-sized matrix
        int rows = 2;
        int cols = 2;
        Matrix instance = new Matrix(rows,cols);
        for(int i = 0;i < rows;i++)
            for(int j = 0;j < cols;j++)
                instance.set(i, j, 3);
        Vector[] exp = new Vector[2];
        exp[0] = new Vector(2);
        exp[1] = new Vector(2);
        exp[0].set(0, (double)3);
        exp[0].set(1, (double)3);
        exp[1].set(0, (double)3);
        exp[1].set(1, (double)3);
        // Check if vector and matrix row match
        for(int i = 0;i<exp.length;i++)
            assertTrue(exp[i].doubleEquals(instance.getMatrixValues()[i]));
    }
    @Test
    public void testgetRowsgetColumns() throws Exception {
        Random r = new Random();
        for(int k = 0;k < r.nextInt(100);k++) {
            // Iterates a randomly-sized matrix
            int rows = r.nextInt(95)+1;
            int cols = r.nextInt(95)+1;
            Matrix instance = new Matrix(rows,cols);
            assertEquals(rows,instance.getRows());
            assertEquals(cols,instance.getColumns());
        }
    }
    @Test
    public void testRowsColumnsErrors() throws Exception {
        Boolean catched = false;
        Random r = new Random();
        int rows = r.nextInt(95)+1;
        int cols = r.nextInt(95)+1;
        Matrix instance = new Matrix(rows,cols);
        try {
            instance.getRowVector(rows+1);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
    }
    @Test
    public void testprint() throws Exception {
        Matrix m = new Matrix(2,2);
        m.printMatrix();
    }
    @Test
    public void testgetValueError() throws Exception {
        Boolean catched = false;
        Matrix m = new Matrix(2,2);
        try {
            m.getValue(8, 2);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
    }
    @Test
    public void testgetColumnVectorError() throws Exception {
        Boolean catched = false;
        Matrix m = new Matrix(2,2);
        try {
            m.getColumnVector(8);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
    }
    @Test
    public void test3DRotation() throws Exception {
        Boolean catched = false;
        Matrix m = new Matrix(2,2);
        m.set(0, 0, 1);
        m.set(0, 1, 1);
        try {
            m.create3DRotationZ(0);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        
        m.addColumn();
        catched = false;
        try {
            m.create3DRotationZ(0);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        
        m.addRow();
        m.removeColumn();
        catched = false;
        try {
            m.create3DRotationZ(0);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        
        m.addColumn();
        m.create3DRotationZ(0);
        assertTrue((double)-Math.sin(0)==(double)m.getValue(0, 1));
        assertTrue((double)Math.cos(0)==(double)m.getValue(0, 0));
    }
    @Test
    public void testsetError() throws Exception {
        Boolean catched = false;
        Random r = new Random();
        int rows = r.nextInt(95)+1;
        int cols = r.nextInt(95)+1;
        Matrix instance = new Matrix(rows,cols);
        try {
            instance.set(rows, cols, 2);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        catched = false;
        try {
            instance.set(rows-1, cols, 2);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        catched = false;
        try {
            instance.set(rows, cols-1, 2);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
    }

    /**
     * Test of columns method, of class Matrix.¡
     */
    @Test
    public void testdim() throws Exception {
        Matrix m = new Matrix(2,2);
        m.set(0, 0, 1);
        m.set(0, 1, 1);
        assertEquals(2,m.getColumns());
        m.removeColumn();
        assertEquals(1,m.getColumns());
        m.removeRow();
        assertEquals(1,m.getRows());
        Boolean catched = false;
        try {
            m.getValue(0, 1);
        }
        catch(Exception e) {
                catched = true;
        }
        assertTrue(catched);
        m.newSize(8, 8);
        m.newSize(6, 6);
        m.newSize(8, 6);
        m.newSize(6, 8);
        m.newSize(6, 8);
        assertEquals(8,m.getColumns());
        assertEquals(6,m.getRows());
    }
    /**
     * Test of multiplyScalar methods, of class Matrix.
     */
    @Test
    public void testmultiplyScalar() throws Exception {
        Random r = new Random();
        Matrix m = new Matrix(2,2);
        m.multiplyScalar(8);
        assertTrue(m.isZero());
        m.set(0, 1, 2);
        m.multiplyScalar(8);
        assertTrue((double)m.getValue(0, 1) == (double)16);
    }
    /**
     * Test of addColumn method, of class Matrix.
     */
    @Test
    public void testAddColumn() {
    }
    
}