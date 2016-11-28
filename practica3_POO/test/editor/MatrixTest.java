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
    public void testsetError() throws Exception {
        Boolean catched = false;
        Random r = new Random();
        int rows = r.nextInt(95)+1;
        int cols = r.nextInt(95)+1;
        Matrix instance = new Matrix(rows,cols);
        try {
            instance.set(rows+1, cols+1, 2);
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
    public void testColumns() {
    }

    /**
     * Test of addColumn method, of class Matrix.
     */
    @Test
    public void testAddColumn() {
    }
    
}