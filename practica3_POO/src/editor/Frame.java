/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *<h1>FRAME</h1>
 * Class that represents Frame of a video, that at the end is going to be an image
 * that can be represented as a Matrix, where each value represents a colored pixel
 * thus the Frame is a child class of its parent Matrix. At the same time it is the parent
 * class of two different kind of frames, the BWFrame and the ColorFrame. 
 * @author ivo and bassagap
 */
abstract class Frame extends Matrix {
    
    /**
     * The constructor, as in Matrix class, takes as input the dimensions of the matrix. 
     * @param m : rows
     * @param n : columns
     */
    public Frame(Integer m, Integer n){
        super(m, n);
    }
    
    /**
     * It multiplies each value of the matrix (frame) by a double delta value. 
     * @param delta 
     */
    abstract void changeBrightness(double delta);
    
    
    
}
