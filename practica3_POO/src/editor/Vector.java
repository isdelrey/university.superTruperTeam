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
//Paula test
public class Vector extends ObjectCollection {
    
    //Attributes
    private Object[] values;
    private int dim;
    
    //Constructor
    public Vector(Integer dim) {
        this.dim = dim;
        this.values = new Object[dim];
        this.zero();
    };
  
    public Vector() {
        super();
        values = new Object[this.maxDimension];
    };
    
    //Public methods
    //getters:
    public int getDim() {
        int dim = 0;
        for(int i = maxDimension-1;i >= 0;i--)
            if(this.getPositionValue(i) != 0) {
                dim = i;
                break;
            }
        return dim;
    };
    public Object[] getArray() {
        return this.values;
    };
    public double getPositionValue(int index) {
        return (double)values[index];
    };
    //setters
    public void set(int index, Object v) {
        this.values[index] = v;
        if(index > this.dim && (double)v != 0){
            dim = index;
        }
    };
    public void setZero(int index) {
        values[index] = 0.0;
        if(index == dim) dim--;
    };
    
    //To review
//    public Object sumAll() {
//        double n = 0;
//        for(Object v : values) n += v;
//        return n;
//    };
    
    //other methods:
    public void zero() {
        for(Integer i = 0; i < this.values.length; i++ ){
            this.values[i] = 0.0;
        };
    };
    public void sumTo(Vector v) {
        v.sumFrom(this);
    };
    public void sumFrom(Vector v) {
        for(int i = 0;i<v.getDim();i++)
            set(i, v.getPositionValue(i)+ v.getPositionValue(i));
    };
    public Vector sumWith(Vector v) {
        Vector s = new Vector(3);
        for(int i = 0;i<v.getDim();i++)
            s.set(i, (double)getPositionValue(i)+(double)v.getPositionValue(i));
        return s;
    };
    public Vector multiplyWith(Vector v) {
        Vector m = new Vector(2);
        for(int i = 0;i<v.getDim();i++)
            m.set(i, (double)getPositionValue(i)*(double)v.getPositionValue(i));
        return m;
    };
    public void multiply(double d) {
        for(int i = 0; i<this.values.length; i++){
            this.set(i, (double)this.values[i] * d); 
        }
    };
    public void print() {
        for(Object value :this.getArray()){
            System.out.println(value);    
         }        
    };
    public void set3D (Object i, Object j, Object k){
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
    public void multiplyMat(Matrix m) throws Exception{
        try{
            Vector tempVec = new Vector (this.dim);
            if(this.dim == 3 && m.getColumns() ==3 && m.getRows() == 3){
                for (Integer i = 0; i < this.dim; i++){
                   Object value = 0.0;
                   Object[] rowVector; 
                   rowVector = m.getRowVector(i).getArray();
                   for(Integer j = 0; j < rowVector.length; j++){
                       value = (double)value + (double)rowVector[j] * (double)this.values[j];            
                   }
                   tempVec.set(i,value);
                }
                this.values = tempVec.getArray();
            }            
        }
        catch(Exception e){
            throw new Exception("Matrix dimensions not correct");
        }
        

    } 
    // Add a row to a vector with value 0
    public void addDim(){
        Vector vector = new Vector(this.dim + 1);
        for(Integer i = 0; i < this.values.length; i++){
           vector.set(i, this.values[i]);
        }
         this.values = vector.values;
         this.dim = this.dim + 1; 
    }
}