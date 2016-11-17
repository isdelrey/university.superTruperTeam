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
public class Matrix extends ObjectCollection {
    private Vector[] values, transposed;
    private int rows, cols;
    public Matrix() {
        values = new Vector[maxDimension];
    }
    public Vector getRow(int r) {
        return values[r];
    }
    public Vector getColumn(int c) {
        Vector v = new Vector();
        for(int i=0;i<rows;i++) v.set(i,values[i].get(c));
        return v;
    }
    public void setRow(int r, Vector v) {
        values[r] = v;
    }
    public void setColumn(int c, Vector v) {
        for(int i=0;i<rows;i++) values[i].set(c,v.get(i));
    }
    public void zero() {
        for(Vector v : values) v.zero();
    }
    public int rows() {
        
    }
    public int columns() {
        
    }
    public void addColumn(Vector v) {
        
    }
}
