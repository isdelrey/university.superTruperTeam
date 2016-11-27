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
    
    //Contructor:
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
    
    //To be reviewed
    public void set(Integer i, Integer val){
        try{
            set(i,i, val);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }       
    }
}
