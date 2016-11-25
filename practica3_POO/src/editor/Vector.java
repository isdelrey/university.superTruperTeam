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
    private final Object[] values;
    int dim;
    public Vector() {
        super();
        dim = 0;
        values = new Object[maxDimension];
        zero();
    }
    public Vector(int maxDim) {
        super(maxDim);
        values = new Object[maxDimension];
        zero();
    }
    public void zero() {
        for(Object v : values) v = 0;
    }
    public Boolean isZero() {
        Boolean is = true;
        for(Object v : values)
            if((double)v != 0) {
                is = false;
                break;
            }
        return is;
    }
    public int getDim() {
        return dim;
    }
    public Object[] getArray() {
        return this.values;
    }
    public double get(int index) {
        return (double)values[index];
    }
    //setters
    public void set(int index, Object v) {
        values[index] = v;
        if(index > this.dim && (double)v != 0){
            dim = index;
        }
    }
    public void setZero(int index) {
        values[index] = 0;
        if(index == dim) dim--;
    }
    
    public Object sumAll() {
        double n = 0;
        for(Object v : values) n += (double)v;
        return n;
    }
    public void sumTo(Vector v) {
        v.sumFrom(this);
    }
    public void sumFrom(Vector v) {
        for(int i = 0;i<v.getDim();i++)
            set(i, v.get(i)+ v.get(i));
    }
    public Vector sumWith(Vector v) {
        Vector s = new Vector((this.getMaxDimension()>v.getMaxDimension())?this.getMaxDimension():v.getMaxDimension());
        for(int i = 0;i<v.getDim();i++)
            s.set(i, (double)get(i)+(double)v.get(i));
        return s;
    }
    public Vector multiplyWith(Vector v) {
        Vector m = new Vector((this.getMaxDimension()>v.getMaxDimension())?this.getMaxDimension():v.getMaxDimension());
        for(int i = 0;i<v.getDim();i++)
            m.set(i, (double)get(i)*(double)v.get(i));
        return m;
    }
    public void multiply(double d) {
        for(int i = 0; i<this.values.length; i++){
            this.set(i, (double)this.values[i] * d); 
        }
    }
    public void print() {
        for(Object value :this.getArray()){
            System.out.println(value);    
         }        
    }
    public void set3D (Object i, Object j, Object k){
        if(this.dim == 3){
            this.values[0] = i;
            this.values[1] = j;
            this.values[2] = k;
        }
        else{
            System.out.println("Vector size does not match");
        }
    }
    /*
    Multiplies the current vector by a matrix
    public void multiplyMat(Matrix m){
        Vector tempVec = new Vector (this.dim);
        if(this.dim == 3 && m.getColumnsNumber() ==3 && m.getRowsNumber() == 3){
            for (Integer i = 0; i < this.dim; i++){
               Object value = 0.0;
               Object[] rowVector; 
               rowVector = m.getRowVector(i).getArray();
               for(Integer j = 0; j < rowVector.length; j++){
                   value = (double)value + (double)rowVector[j] * (double)this.values[j];            
               }
               tempVec.set(i,value);
            }
            values = tempVec.getArray();
        }
        else{
            System.out.println("Vector length and matrix lenght does not match");
        }
    }
    */
    public void addDim(){
        dim++;
    }
}