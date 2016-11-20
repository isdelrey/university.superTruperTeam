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
public class BWFrame extends Frame {
    
    //Contructor:
    public BWFrame(Integer m, Integer n){
        super(m, n);
    }
    @Override
    public void changeBrightness(double delta){
        
    };
    public double get(Integer i, Integer j){
      return this.getValue(i, j);   
    };
    
    //setter:
    
    //To be reviewed
    public void set(Integer i, Integer val){
        set(i,i, val);
    };
}
