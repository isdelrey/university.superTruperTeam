/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *<h1>OBJECTCOLLECTION</h1>
 * Class that is the parent class of Vector and Matrix classes and that contains
 * their maxDimenion attribute and methods getter and setter related to this. 
 * It is used to set up the template where the matrices and vectors are going to be embeded. 
 * @author ivo and bassagap
 */
public class ObjectCollection {
    /**
     * Attribute MAx Dimension defines the dimension of the template where 
     * the matrices and vectors are going to be embeded. 
     */
    protected static int maxDimension;
    
    /**
     * Sets the max dimensions of the Matrix or Vectors, that are child classes 
     * of ObjectCollection
     */
    public ObjectCollection() {
        maxDimension = 100;
    }

    /**
     * Returns the maximum dimension that a matrix or vector is going to have
     * @return maxDimension
     */  
    public int getMaxDimension() {
        return maxDimension;
    };
    
    /**
     * Sets the Max Dimension of a vector or matrix template. 
     * @param dim max dimension
     */
    public void setMaxDimension(int dim) {
        maxDimension = dim;
    };
}
