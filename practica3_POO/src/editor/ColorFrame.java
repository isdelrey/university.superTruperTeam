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
public class ColorFrame extends Frame {
    
    //Constructor
    public ColorFrame(Integer m, Integer n){
        super(m,n);
    }
    @Override
    public void changeBrightness(double delta){
        this.multiplyScalar(delta);
    };
}
