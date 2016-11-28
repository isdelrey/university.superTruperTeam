/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo and bassagap
 */
public class BWFrame extends Frame {
    
    //Constructor:
    
    public BWFrame(Integer m, Integer n){
        super(m, n);
    }
    
    @Override
    public void changeBrightness(double delta){
        this.multiplyScalar(delta);
    }
    
    public double get(Integer i, Integer j) throws Exception{
        try{
           return this.getValue(i, j);   
        }
        catch(Exception e){
            throw e; 
        }
    }
    
    //setter:

    /**
     * Sets vector of the frame to val
     * @param i
     * @param val
     */
    public void set(int i, int val) throws Exception {
        set(i,i, val);  
    }
}
