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
public class Vector extends ObjectCollection {
    
    //Attributes
    private double[] values;
    private int dim;
    
    //Constructor
    public Vector(Integer dim) {
        this.dim = dim;
        this.values = new double[dim];
        this.zero();
        
    };
    

//    public Vector(int maxDim) {
//        super(maxDim);
//        values = new double[maxDimension];
//    };
    
    //Public methods
    public void zero() {
        for(Integer i = 0; i < this.values.length; i++ ){
            this.values[i] = 0;
        };
    };
    public int getDim() {
        int dim = 0;
        for(int i = maxDimension-1;i >= 0;i--)
            if(getPositionValue(i) != 0) {
                dim = i;
                break;
            }
        return dim;
    };
    public double[] getArray() {
        return this.values;
    };
    public double getPositionValue(int index) {
        return values[index];
    };
    public void set(int index, double v) {
        this.values[index] = v;
        if(index > this.dim && v != 0){
            dim = index;
        }
    };
    public void setZero(int index) {
        values[index] = 0;
        if(index == dim) dim--;
    };
    public double sumAll() {
        double n = 0;
        for(double v : values) n += v;
        return n;
    };
    public void sumTo(Vector v) {
        v.sumFrom(this);
    };
    public void sumFrom(Vector v) {
        for(int i = 0;i<v.getDim();i++)
            set(i, getPositionValue(i)+v.getPositionValue(i));
    };
    public Vector sumWith(Vector v) {
        Vector s = new Vector(3);
        for(int i = 0;i<v.getDim();i++)
            s.set(i, getPositionValue(i)+v.getPositionValue(i));
        return s;
    };
    public Vector multiplyWith(Vector v) {
        Vector m = new Vector(2);
        for(int i = 0;i<v.getDim();i++)
            m.set(i, getPositionValue(i)*v.getPositionValue(i));
        return m;
    };
    public void multiply(Integer integer) {
        for(int i = 0; i<this.values.length; i++){
            this.values[i] = this.values[i] * integer; 
        }
    };
    
    public void print() {
        for(double value :this.getArray()){
            System.out.println(value);    
         }
        
    };
    public void set3D (double i, double j, double k){
        if(this.dim == 3){
            this.values[0] = i;
            this.values[1] = j;
            this.values[2] = k;
        }
        else{
            System.out.println("Vector size does not match");
        }
    };
    //Multiplies the current vector by a matrix
    public void multiplyMat(Matrix m){
        Vector tempVec = new Vector (this.dim);
        if(this.dim == 3 && m.getColumnsNumber() ==3 && m.getRowsNumber() == 3){
            for (Integer i = 0; i < this.dim; i++){
               double value = 0;
               double[] rowVector; 
               rowVector = m.getRowVector(i).getArray();
               for(Integer j = 0; j < rowVector.length; j++){
                   value = value + rowVector[j] * this.values[j];            
               }
               tempVec.set(i,value);
            }
            this.values = tempVec.getArray();
        }
        else{
            System.out.println("Vector length and matrix lenght does not match");
        }
    }   
}