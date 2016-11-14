/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo
 * @param <T>
 */
public class ObjectCollection {
    protected static int maxDimension;
    public ObjectCollection() {
        maxDimension = 100;
    }
    public ObjectCollection(int maxDim) {
        maxDimension = maxDim;
    }
    public int getMaxDimension() {
        return maxDimension;
    }
    public void setMaxDimension(int dim) {
        maxDimension = dim;
    }
}
