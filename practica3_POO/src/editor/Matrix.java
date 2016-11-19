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
    public Matrix(Integer m, Integer n) {
        this.cols = n;
        this.rows = m;
       this.values = new Vector[n];        
        for(Integer i= 0; i<n; i++){
            this.values[i] = new Vector(m);
        }      
    };
    //Public methods:
    //getters
    public int getRowsNumber() {
        return this.rows;
    };
    public int getColumnsNumber() {
        return this.cols;
    };
    public Vector[] getMatrix (){
        return this.values; 
    };
    
    // Returns the column vector of the matrix belonging to column c
    public Vector getColumnVector(int c) {
        return this.values[c];
    };
    
    // Returns the Row vector of the matrix belonging to row r
    public Vector getRowVector(int r) {
        Vector v = new Vector(this.cols);
        for(int i=0;i<this.rows;i++) {
            v.set(i,values[i].getPositionValue(r));
        }
        return v;
    };
    
    //setters: 
    // sets in a matrix position (m row and n column) a given value
    public void set (int m, int n, double value){
        Vector vector = this.values[n];
        vector.set(m, value);
 
    };
    //sets in a matrix column c a given vector v
    public void setColumn(int c, Vector v) {
        this.values[c] = v;
    };
    //sets in a matrix row r a given vector v
    public void setRow(int r, Vector v) {
        for(int i=0;i<this.rows;i++){
            this.values[i].set(r,v.getPositionValue(i));
        }
    };
    //sets all values in a matrix to zero
    public void zero() {
        for(Vector v : this.values) {
            v.zero();
        }
    };
    
    //Prints the matrix
    public void printMatrix(){
        System.out.println();
        for(Integer m = 0; m < this.rows; m++){
            for(Vector v : this.values){  
                System.out.print(v.getArray()[m] + " ");      
            }
            System.out.println();
        }
    };
    
    // 3D 
    //Creates a rotation matrix of angle alpha, it also checks the matrix dimensions
    public void create3DRotationZ(double alpha){
        if(this.cols == 3 && this.rows ==3){
            this.values[0].set(0, Math.cos(alpha));
            this.values[1].set(0, -Math.sin(alpha));
            this.values[0].set(1, Math.sin(alpha));
            this.values[1].set(1, Math.cos(alpha));
            this.values[2].set(2, 1);  
        }
        else{
            System.out.println("Matrix dimension doesn't match");
        }
    };
    
    //Adds a void column to the matrix
    public void addColumn(){
        Matrix matrix = new Matrix(this.rows, this.cols + 1);
        for(Integer i = 0; i < this.cols; i++){
            matrix.setColumn(i, this.getColumnVector(i));
        }
        this.values = matrix.values;
    }


}
    
    
    

