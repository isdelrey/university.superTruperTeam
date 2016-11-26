/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *<h1>AUDIOBUFFER</h1>
 * Class that represents an AudioBuffer which is as an array of values, and for 
 * that reason it inherits from Vector class, because it is just an specialization of
 * its parent, that is going to have an extra method in order to change the Audio Buffer
 * volume. 
 * @author ivo and bassagap
 */
public class AudioBuffer extends Vector {

    /**
     *
     * @param d
     */
    public AudioBuffer(Integer d){
        super(d);
    }; 
        
    /**
     * 
     * @param delta 
     */
    public void changeVolume(double delta){
        this.multiply(delta);
    };
    
}
