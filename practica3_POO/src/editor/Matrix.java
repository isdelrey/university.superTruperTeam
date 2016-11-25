/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo
 */
public class Matrix extends ObjectCollection {
    
    //Attributes
    private Vector[] values, transposed;
    private int rows, cols;
    
    //Constructor
    public Matrix(int maxRows, int maxCols) {
        this.cols = 0;
        this.rows = 0;
       this.values = new Vector[maxRows];
    }
    public Matrix() {
        this.cols = 0;
        this.rows = 0;
        this.values = new Vector[maxDimension];
    }
    
    //Public methods:
    //getters
    public int countRows() {
        return this.rows;
    }
    public int countCols() {
        return this.cols;
    }
    public Vector[] getMatrix() {
        return this.values; 
    }
    
    public double get(Integer i, Integer j){
        return this.values[i].get(j);
    }
    
    // Returns the column vector of the matrix belonging to column c
    public Vector getRow(int c) {
        return this.values[c];
    }
    
    // Returns the Row vector of the matrix belonging to row r
    public Vector getColumn(int r) {
        Vector v = new Vector(this.cols);
        for(int i=0;i<this.rows;i++)
            v.set(i,values[i].get(r));
        return v;
    }
    //sets in a matrix row r a given vector v
    public void setRow(int r, Vector v) {
        values[r] = v;
        if(v.isZero()) {
            if(rows == r) r--;
        }
        else if(r>rows) rows = r;
    }
    
    //setters: 
    // sets in a matrix position (m row and n column) a given value
    public void set(int m, int n, double value){
        Vector vector = this.values[n];
        vector.set(m, value);
 
    };
    //sets in a matrix column c a given vector v
    public void setColumn(int c, Vector vv) {
        if(!vv.isZero() && vv.getDim() < c) c = vv.getDim();
        for(int i = 0; i < vv.getDim();i++) {
            Vector v = this.values[i];
            v.set(c, vv.get(c));
            if(vv.get(c) != 0 && i > rows) {
                rows = i;
            }
        }
    }
    
    //sets all values in a matrix to zero
    public void zero() {
        for(Vector v : this.values) v.zero();
    }
    
    //Prints the matrix
    public void print(){
        for(Vector v1 : this.values){
            for(Object v2 : v1.getArray()){  
                System.out.print((double)v2 + " ");      
            }
            System.out.println();  
        }
    }
    
    // 3D 
    //Creates a rotation matrix of angle alpha, it also checks the matrix dimensions
    public void create3DRotationZ(double alpha) throws Exception {
        if(this.cols == 3 && this.rows ==3){
            this.values[0].set(0, (double)Math.cos(alpha));
            this.values[1].set(0, -(double)Math.sin(alpha));
            this.values[0].set(1, (double)Math.sin(alpha));
            this.values[1].set(1, (double)Math.cos(alpha));
            this.values[2].set(2, (double)1);  
        }
        else{
            Exception e = new Exception("Matrix dimension doesn't match");
            throw e;
        }
    }
    
    //Adds a void column to the matrix
    public void addColumn(){
        for(Vector v : this.values)
            v.addDim();
    }
    
    //Adds a void row to the matrix
    public void addRow(){
        rows++;
    }
    
    //Multiplies each value of the matrix by a given scalar 
    public void multiplyScalar(double scalar){
        for(Vector vector : this.values)
            vector.multiply(scalar);
    }
}
    
    
    

