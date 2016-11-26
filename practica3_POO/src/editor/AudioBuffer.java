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
public class AudioBuffer extends Vector {
    
    //Contructor:

    /**
     *
     * @param d
     */
    public AudioBuffer(Integer d){
        super(d);
    }; 
    
    
    //public methods: 
    public void changeVolume(double delta){
        this.multiply(delta);
    };
    
}
