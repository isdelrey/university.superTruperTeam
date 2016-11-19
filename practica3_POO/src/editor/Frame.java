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
abstract class Frame extends Matrix{
    
    //Contructor
    public Frame(Integer m, Integer n){
        super(m, n);
    }
    abstract void changeBrightness(double delta);
    
    
    
}
