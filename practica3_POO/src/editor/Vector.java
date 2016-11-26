/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo & bassagap
 */

public class Vector extends ObjectCollection {
    
    //Attributes
    private Object[] values;
    private int dim;
    
    //Constructor
    public Vector(Integer dim) {
        super();
        this.dim = dim;
        this.values = new Object[Vector.maxDimension];
        this.zero();
    };
    
    //Public methods
    //getters:
    public int getDim() {
        return this.dim;
    };
    public Object[] getArray() {
        return this.values;
    };
    public double getPositionValue(int index) throws Exception{
        double ret;
        if( index <=  this.dim){
           ret = (double)values[index]; 
        }
        else{
            throw new Exception("Index is outside vector dimensions, getPositionValue");
        }
        return ret;
    }
    //setters
    public void set(int index, Object v) throws Exception {       
        if(index <= this.dim ){
            this.values[index] = v;
        }
        else {
            throw new Exception("Index is outside vector dimensions, set");
        }
    };
    
    //other methods:

    public void sumTo(Vector v) {
        v.sumFrom(this);
    };
    public void sumFrom(Vector v) {
        try{
            for(int i = 0;i<v.getDim();i++){
                set(i, v.getPositionValue(i)+ v.getPositionValue(i));                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    };
    public Vector sumWith(Vector v) throws Exception {
        Vector s = new Vector(this.dim);
        if( v.getDim() == this.dim){           
            try{
                for(int i = 0;i<v.getDim();i++)
                    s.set(i, (double)getPositionValue(i)+(double)v.getPositionValue(i));
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new Exception("Vector indices are not equals, sumWith");            
        }
        return s;
    }
    public Vector multiplyWith(Vector v) throws Exception{
        Vector m = new Vector(this.dim);
        if( v.getDim() == this.dim){ 
            try{
                for(int i = 0;i<v.getDim();i++){
                    m.set(i, (double)getPositionValue(i)*(double)v.getPositionValue(i));
                }
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            throw new Exception("Vector indices are not equals, multiplyWith");
        }
        return m;
    };
    public void multiply(double d) {
        try{
            for(int i = 0; i<this.dim; i++){
                this.set(i, (double)this.values[i] * d); 
            }            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    };
    public void print() {
        for(int i = 0; i < this.dim ; i++){
            System.out.println(this.values[i]);    
         }        
    };

    public void set3D (Object i, Object j, Object k){
        if(this.dim == 3){
            this.values[0] = i;
            this.values[1] = j;
            this.values[2] = k;
        }
        else{
            System.out.println("Vector size does not match, set3D");
        }
    };
    //Multiplies the current vector by a matrix
    public void multiplyMat(Matrix m) throws Exception{
        Vector rowVector;
        try{
            Vector tempVec = new Vector (this.dim);
            if(this.dim == 3 && m.getColumns() == 3 && m.getRows() == 3){
                for (Integer i = 0; i < this.dim; i++){
                   double value = 0.0; 
                   rowVector = m.getRowVector(i);
                   for(Integer j = 0; j < m.getRows(); j++){
                       value = value + (double)rowVector.getArray()[j] * (double)this.values[j];            
                   }
                   tempVec.set(i,value);
                }
                this.values = tempVec.getArray();
            }            
        }
        catch(Exception e){
            // throw new Exception("Matrix dimensions not correct, multiplyMat");
            throw e;
        }
        

    } 
    // Add a row to a vector with value 0
    public void addDim(){
       this.dim++;
    }
    
   public void zero() {
        for(Integer i = 0; i < this.values.length; i++ ){
            this.values[i] = 0.0;
        };
    };    
    
}