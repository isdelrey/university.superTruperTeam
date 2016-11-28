/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *<h1>MATRIX</h1>
 * Class that represents a Matrix as an array of vectors, where each column is 
 * represented as a Vector
 * <b>Note:</b> Matrix inherits from Object collection and it is generated as a "template" 
 * so it has a max dimension, and then by passing the number of rows and columns 
 * by its constructor we define its real dimensions
 * @author ivo and bassagap
 */
public class Matrix extends ObjectCollection {
    
    /**
     * Attributes: the matrix has as parameters the values of the matrix, 
     * its rows and its columns
     */
    private final Vector[] values;
    private int rows, cols;   
    
    /**
     * Constructor: receives as parameters the number of rows and columns of the 
     * matrix, and sets the actual size of the matrix to the maxDimensions defined 
     * by the objectCollection
     * @param m : rows 
     * @param n : columns
     */
    public Matrix(int m, int n) {
        super();
        this.cols = n;
        this.rows = m;
        this.values = new Vector[Matrix.maxDimension];        
        for(int i = 0; i< Matrix.maxDimension; i++)
            this.values[i] = new Vector(m);
    }
    
    /**
     * Returns the number of rows of the matrix
     * @return integer (number of rows)
     */
    public int getRows() {
        return this.rows;
    }
    
    /**
     * Returns the number of columns of the matrix 
     * @return integer (number of columns)
     */
    public int getColumns() {
        return this.cols;
    } 
    
    /**
     * Returns the value of a matrix in a given position (i, j)
     * @param i: row position
     * @param j: column position
     * @return  the value of the matrix at the given position
     * @throws Exception Values are outside Matrix dimensions
     */
    public double getValue(Integer i, Integer j) throws Exception{
        double ret;
        if(i < this.rows && j < this.cols){
            ret = this.getColumnVector(j).getPositionValue(i);
        }
        else {
            throw new Exception("Values are outside Matrix dimensions");
        }
        return ret; 
    }
    
    /**
     * Returns the column vector of the matrix belonging to column c
     * @param c column
     * @return resulting vector
     * @throws Exception Values are outside Matrix dimensions
     */
    public Vector getColumnVector(int c) throws Exception{
        if(c > this.cols) {
            throw new Exception("Values are outside Matrix dimensions, getColumnVector");
        }
        return this.values[c];
    }
    
    /**
     * Returns the Row vector of the matrix belonging to row r 
     * @param r row position of the returned row vector
     * @return Vector
     * @throws Exception Values are outside Matrix dimensions
     */
    public Vector getRowVector(int r) throws Exception {
        Vector v = new Vector(cols);
        if(r <= this.rows){
            for(int i=0;i<this.cols;i++) {
                v.set(i,values[i].getPositionValue(r));
            }            
        }
        else {
            throw new Exception("Values are outside Matrix dimensions, getRowVector");
        }
        return v;
    } 
    
    /**
     * Return the array of Values representing the matrix
     * @return Vector array 
     */
    public Vector[] getMatrixValues(){
        return this.values;
    }

    /**
     * Sets in a matrix position (m row and n column) a given value
     * @param m rows
     * @param n columns
     * @param value value that is going to be set on the position m, n
     * @throws Exception Values are outside Matrix dimensions
     */
    public void set (int m, int n, double value) throws Exception {
        if(m < this.rows && n < this.cols){
            Vector vector = this.values[n];
            vector.set(m, value);
        }       
        else {
            throw new Exception("Values are outside Matrix dimensions, set");
        }
    }
    
    /**
     * Prints the matrix
     * @throws java.lang.Exception Exception throwable by Matrix.set
     */
    public void printMatrix() throws Exception {
        System.out.println();
        for(Integer m = 0; m < this.rows; m++){
            for(Integer n = 0; n < this.cols; n++){
                    double d = (double)this.getValue(m, n); 
                    d = Math.round(d);
                    System.out.print(d + " ");
            }
            System.out.println();
        }
    }

    /**
     * Creates a rotation of a 3D matrix of angle alpha, it also checks the matrix dimensions
     * @param alpha rotation angle
     * @throws Exception Matrix dimension doesn't match
     */
    public void create3DRotationZ(double alpha) throws Exception {
        if(this.cols == 3 && this.rows ==3){
            this.values[0].set(0, (double)Math.cos(alpha));
            this.values[1].set(0, -(double)Math.sin(alpha));
            this.values[0].set(1, (double)Math.sin(alpha));
            this.values[1].set(1, (double)Math.cos(alpha));
            this.values[2].set(2, (double)1);  
        }
        else{
            throw new Exception("Matrix dimension doesn't match, create3DRotationZ");
        }
    }
    
    /**
     * Adds a void column to the matrix
     * @throws java.lang.Exception Maximum Vector length reached
     */
    public void addColumn() throws Exception {
        this.cols++;
        for(Vector v : this.values) v.addDim();
    }
    /**
     * Sets cols, rows to new values and resizes Matrix
     * @param r row
     * @param c column
     * @throws java.lang.Exception Maximum Vector size reached
     */
    public void newSize(int r, int c) throws Exception {
        int cDiff = c-cols;
        int rDiff = r-rows;
        
        if(cDiff != 0)
           if(cDiff > 0)
               for(int i = 0;i < cDiff;i++)
                   addColumn();
           else
               for(int i = 0;i < -cDiff;i++)
                   removeColumn();
        
        if(rDiff != 0)
           if(rDiff > 0)
               for(int i = 0;i < rDiff;i++)
                   addRow();
           else
               for(int i = 0;i < -rDiff;i++)
                   removeRow();
    }
    /**
     * Adds a void row to the matrix
     * @throws java.lang.Exception Maximum vector size reached
     */
    public void addRow() throws Exception {
        this.rows++;
        for(Vector v : this.values) v.addDim();
    }
    /**
     * Removes row from the matrix
     * @throws Exception Cannot remove more rows
     */
    public void removeRow() throws Exception{
        int r = --this.rows;
        for(Vector v : this.values) v.removeDim();
        
        
    }
    /**
     * Removes column from the matrix
     * @throws java.lang.Exception Cannot remove more columns
     */
    public void removeColumn() throws Exception{
        int c = --this.cols;
        this.values[c] = new Vector(this.rows);
        
    }
    
    /**
     * Multiplies each value of the matrix by a given scalar 
     * @param scalar scalar value that multiplies each matrix value
     */
    public void multiplyScalar(double scalar){
        for(Integer i = 0; i < this.cols; i++){
            this.values[i].multiply(scalar);
        }
    }
    /**
     * Sets all values to zero
     */
    public void zero() {
       for ( Integer m = 0; m < this.cols; m++){
           this.values[m].zero();
       }
    }
    public Boolean isZero() throws Exception {
        Boolean is = true;
        for(Object o : values) {
            is = ((Vector)o).isZero();
            if(!is) break;
        }
        return is;
    } 
}
