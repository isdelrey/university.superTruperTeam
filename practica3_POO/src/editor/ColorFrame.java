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
public class ColorFrame extends Frame {
    
    //Constructor
    public ColorFrame(Integer m, Integer n) {
        super(m,n);
    }
    //getters:
    public int[] get(Integer i, Integer j) throws Exception {
        int[] value = null;
        double ret = this.getValue(i, j);
        value = this.valToRGB(ret);
        return value;         
    }
    
    //setter:
    public void set(Integer i, Integer j, Integer r, Integer g, Integer b) throws Exception {
        double ret = RGBToVal(r, g, b);
        set(i, j, ret);
        
    };
    public void changeRGB(Integer dR, Integer dG, Integer dB) {
        double ret = RGBToVal(dR, dG, dB);
        this.multiplyScalar(ret);
    }
    
    //Private methods:
    
    private int[] valToRGB(double rgb ) {
        int[]ret = new int [ 3 ] ;
        ret[0]= ((int) rgb >> 16) & 255;
        ret[1]= ((int) rgb >> 8) & 255;
        ret[2]= ((int) rgb ) & 255;
        return ret ;
    }
    private double RGBToVal(Integer r, Integer g, Integer b){
        double ret =(r<<16) | (g << 8) | b;
        return ret;
    }

    @Override
    void changeBrightness(double delta) {
        this.multiplyScalar(delta);
    }
    
}
