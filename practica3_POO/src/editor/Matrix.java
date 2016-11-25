/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo & bassagap
 * Class that represents a Matrix as an array of vectors, where each column is represented as a Vector
 * 
 */
public class Matrix extends ObjectCollection {
    
    //Attributes
    private Vector[] values, transposed;
    private int rows, cols;
    
    //Constructor
    public Matrix(Integer m, Integer n) {
        super();
        this.cols = n;
        this.rows = m;
        this.values = new Vector[this.maxDimension];        
        for(Integer i= 0; i<this.maxDimension; i++){
            this.values[i] = new Vector(this.maxDimension);
        }      
    }
    
    //Public methods:
    //getters
    public int getRows() {
        return this.rows;
    }
    
    public int getColumns() {
        return this.cols;
    } 
    
    public double getValue(Integer i, Integer j) throws Exception{
        double ret;
        if(i <= this.rows && j <= this.cols){
            ret = this.getColumnVector(j).getPositionValue(i);
        }
        else {
            throw new Exception("Values are outside Matrix dimensions");
        }
        return ret; 
    }
    
    // Returns the column vector of the matrix belonging to column c
    public Vector getColumnVector(int c) throws Exception{
        if(c <= this.cols) {
            throw new Exception("Values are outside Matrix dimensions");
        }
        return this.values[c];
    }
    
    // Returns the Row vector of the matrix belonging to row r
    public Vector getRowVector(int r)throws Exception {
        Vector v;
        if(r <= this.rows){
            v = new Vector(this.cols);
            for(int i=0;i<this.rows;i++) {
                v.set(i,values[i].getPositionValue(r));
            }            
        }
        else {
            throw new Exception("Values are outside Matrix dimensions");
        }
        return v;
    } 
    
    //setters: 
    // sets in a matrix position (m row and n column) a given value
    public void set (int m, int n, double value)throws Exception{
        if(m <= this.rows && n <= this.cols){
            Vector vector = this.values[n];
            vector.set(m, value);   
        }       
        else {
            throw new Exception("Values are outside Matrix dimensions");
        }
    }
    
    //Prints the matrix
    public void printMatrix(){
        System.out.println();
        for(Integer m = 0; m < this.rows; m++){
            for(Vector v : this.values){  
                System.out.print(v.getArray()[m] + " ");      
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
            throw new Exception("Matrix dimension doesn't match");
        }
    }
    
    //Adds a void column to the matrix
    public void addColumn(){
        this.cols++; 
    }
    
    //Adds a void row to the matrix
    public void addRow(){
        this.rows++;
    }
    
    //Multiplies each value of the matrix by a given scalar 
    public void multiplyScalar(double scalar){
        for(Integer i = 0; i < this.cols; i++){
            this.values[i].multiply(scalar);
        }
    }
}
