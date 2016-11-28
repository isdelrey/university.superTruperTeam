/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *<h1>VECTOR</h1>
 * Class that represents a Vector as an array of doubles.
 * <b>Note:</b> Vector inherits from Object collection and it is generated as a "template" 
 * so it has a max dimension, and then by passing the desired dimension 
 * by its constructor we define its real dimensions
 * @author ivo and bassagap
 */

public class Vector extends ObjectCollection {
    
    //Attributes
    /**
     * Attributes
     * Object[] values the array of doubles that represents the vector
     * int dim the chosen dimension of the vector settled on the constructor.
     */
    private Object[] values;
    private int dim;

    /**
     * Vector constructor takes a dimension and initializes the dim attribute to 
     * this dimension. After that it creates a "template" vector of maxDimensions
     * a property inherited from the ObjectCollection parent class
     * @param dim dimension
     */
    public Vector(int dim) {
        super();
        this.dim = dim;
        this.values = new Object[Vector.maxDimension];
        this.zero();
    }
    
    /**
     * Returns the dimension of the vector
     * @return Integer
     */
    public int getDim() {
        return this.dim;
    }
    
    
    /**
     * Returns the array of values of the Vector
     * @return Object[] of doubles
     */
    public Object[] getArray() {
        return this.values;
    }
    
    /**
     * Returns the value of a given position 
     * @param index the position from which the vector value is going to be returned.
     * @return returns the value of a vector in the index position 
     * @throws Exception 
     */
    public double getPositionValue(int index) throws Exception{
        double ret;
        if( index <  this.dim){
           ret = (double)values[index]; 
        }
        else{
            throw new Exception("Index is outside vector dimensions, getPositionValue");
        }
        return ret;
    }
    
    /**
     * Set a value v into a position index of a vector
     * @param index position where the new value is about to be set
     * @param v value that is going to be set on the index position of the vector
     * @throws Exception 
     */
    public void set(int index, Object v) throws Exception {       
        if(index < this.dim ){
            this.values[index] = v;
        }
        else {
            throw new Exception("Index is outside vector dimensions, set:" + index + " and max:" + dim);
        }
    }
    
    /**
     * Sums the current vector with an other vector and sets the result to the current
     * vector
     * @param v vector v is summed with the current vector
     */
    public void sumFrom(Vector v) {
        try{
            for(int i = 0;i<v.getDim();i++){
                set(i, v.getPositionValue(i)+ v.getPositionValue(i));                
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Sums the current vector with an other vector and returns the output vector
     * @param v vector v is summed with the current vector
     * @return the resulting vector is returned
     * @throws Exception 
     */
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
    
    /**
     * Multiplies the current vector by another vector
     * @param v current vector is multiplied by vector v
     * @return
     * @throws Exception 
     */
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
    }
    
    /**
     * Multiplies the vector by a scalar
     * @param d scalar that multiplies each vector value
     */
    public void multiply(double d) {
        try{
            for(int i = 0; i<this.dim; i++){
                this.set(i, (double)this.values[i] * d); 
            }            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Prints  the vector values
     */
    public void print() {
        for(int i = 0; i < this.dim ; i++){
            System.out.println(this.values[i]);    
         }        
    }
    
    /**
     * Sets a vector as a 3D vector
     * @param i
     * @param j
     * @param k 
     */
    public void set3D (Object i, Object j, Object k){
        if(this.dim == 3){
            this.values[0] = i;
            this.values[1] = j;
            this.values[2] = k;
        }
        else{
            System.out.println("Vector size does not match, set3D");
        }
    }
    
    /**
     * Multiplies the current vector by a matrix
     * @param m matrix that is going to be multiplied by the current vector
     * @throws Exception 
     */
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
    
    /**
     * Increases dim by 1
     * @throws Exception 
     */
    public void addDim(){
       this.dim++;
    }
    /**
     * Sets dim to d
     * @param m will be the new dim
     * @throws Exception 
     */
    public void newDim(int d) throws Exception {
       int diff = d - this.dim;
       if(diff != 0)
           if(diff > 0)
               for(int i = 0;i < diff;i++)
                   addDim();
           else
               for(int i = 0;i < -diff;i++)
                   removeDim();
           
    }
    
    /**
     * Decreases dim by 1 and sets the current dim position to 0
     * @throws Exception 
     */
    public void removeDim() throws Exception {
       this.set(--this.dim, 0);
    }
    /**
     * Sets to zero all values on a vector
     */
   public final void zero() {
        for(Integer i = 0; i < this.values.length; i++ ){
            this.values[i] = 0.0;
        }
    }
    public Boolean isZero() throws Exception {
        Boolean is = true;
        for(Object o : this.values ) {
            is = ((double)o == 0);
            if(!is) break;
        }
        return is;
    }
    public Boolean doubleEquals(Vector v) {
        if(this.dim != v.dim) {
            System.out.println("doubleEquals: size diference");
            return false;
        }
        else {
            Boolean e = true;
            Object[] o1 = v.getArray();
            Object[] o2 = this.getArray();
            for(int i = 0;i < v.dim;i++) {
                if((double)o1[i] != (double)o2[i]) {
                    e = false;
                    System.out.println("doubleEquals: one element differs");
                    break;
                }
            }
            return e;
        }
        
    }
}