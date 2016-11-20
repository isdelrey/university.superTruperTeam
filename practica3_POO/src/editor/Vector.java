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
public class Vector extends ObjectCollection {
    private final double[] values;
    int dim;
    public Vector() {
        super();
        dim = 0;
        values = new double[maxDimension];
    }
    public Vector(int maxDim) {
        super(maxDim);
        values = new double[maxDimension];
    }
    public void zero() {
        for(double v : values) v = 0;
    }
    public Boolean isZero() {
        Boolean is = true;
        for(double v : values)
            if(v != 0) {
                is = false;
                break;
            }
        return is;
    }
    public int getDim() {
        int dim = 0;
        for(int i = maxDimension-1;i >= 0;i--)
            if(get(i) != 0) {
                dim = i;
                break;
            }
        return dim;
    }
    public double[] getArray() {
        return values;
    }
    public double get(int index) {
        return values[index];
    }
    public void set(int index, double v) {
        values[index] = v;
        if(index > dim && v != 0) dim = index;
    }
    public void setZero(int index) {
        values[index] = 0;
        if(index == dim) dim--;
    }
    public double sumAll() {
        double n = 0;
        for(double v : values) n += v;
        return n;
    }
    public void sumTo(Vector v) {
        v.sumFrom(this);
    }
    public void sumFrom(Vector v) {
        for(int i = 0;i<v.getDim();i++)
            set(i, get(i)+v.get(i));
    }
    public Vector sumWith(Vector v) {
        Vector s = new Vector();
        for(int i = 0;i<v.getDim();i++)
            s.set(i, get(i)+v.get(i));
        return s;
    }
    public Vector multiplyWith(Vector v) {
        Vector m = new Vector();
        for(int i = 0;i<v.getDim();i++)
            m.set(i, get(i)*v.get(i));
        return m;
    }
    public void print() {
        System.out.println();
        for(double v : values) System.out.print(v + " ");
    }
    
}
