/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author bassagap
 */
public class Main {
     public static void main(String[] args) throws Exception {
//         Vector vector = new Vector(3);
//         vector.set(2, 2.5);   
//         for(double value :vector.getArray()){
//            System.out.println(value);    
//         }
//         vector.multiply(3);
//         vector.print();
//         
//         Matrix matrix = new Matrix(2, 2);
//         matrix.set(0,0,1);
//         matrix.set(0,1,0);
//         matrix.set(1,0,0);
//         matrix.set(1,1,1);
//         matrix.printMatrix();
//        Vector v = new Vector(3);
//        v.set3D(1, 0, 0);
//        v.print();
        Matrix  m = new Matrix();
        m.create3DRotationZ(Math.PI / 2);
        m.print();
        m.addRow();
        m.print();
        m.multiplyScalar(40);
        m.print();

        
//        Vector v = new Vector (3) ;
//        v.set3D(1, 2, 3);
//        v.print();
//        v.addDim();
//        v.print();
        
        
        
        
                 
         
         
         
         
    
     }

    
}
