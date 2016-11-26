/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

/**
 *
 * @author ivo & bassagap
 */
public class Main {
     public static void main(String[] args) {
         
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("EXERCICI 1 : Vector constructor && set Method");
        System.out.println("1.1. Now we print a column vector:  v = [1 2 3] ");
        Vector v = new Vector ( 3 ) ;
        try{
            v.set(0, 1);
            v.set(1, 2);
            v.set(2, 3);
        }
        catch(Exception e){
            System.out.println("Exception on EXERCICI 1 " + e.getMessage());
        }  
        System.out.println("OUTPUT: The vector printed after initializing it and setting values is:");
        System.out.println();
        v.print();
        System.out.println();
        System.out.println("1.2. Now we print a zero column vector:  v = [0 0 0] using zero() method"); 
        System.out.println("OUTPUT: The vector printed after using zero() method is:");
        System.out.println();
        v.zero();
        v.print();
         
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("EXERCICI 2: Matrix constructor && set Method"); 
        System.out.println("2.1. Now we print a 2x2  matrix");
        Matrix m = new Matrix(2, 2); 
        try{
            m.set(0, 0, 1);
            m.set(0, 1, 0); 
            m.set(1, 0, 0);
            m.set(1, 1, 1);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("OUTPUT: The matrix printed after initializing it and setting values is:");
        m.printMatrix();
        System.out.println();
        System.out.println("2.2. Now we print a zero matrix by applying zero() method to the previous matrix");
        System.out.println("OUTPUT: The matrix printed after initializing it and setting values is:");
        m.zero();
        m.printMatrix();
        
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println("EXERCICI 3: Rotation matrices");
        System.out.println("3.1. Now we print a 3D rotation matrix and a rotation vector  ");
        Matrix  matrix = new Matrix(3,3);
        Vector vector = new Vector(3);
        try{
            matrix.create3DRotationZ(Math.PI / 2);    
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("OUTPUT: The matrix printed after initializing it and setting values is:");
        matrix.printMatrix();
        vector.set3D(1.0, 0.0, 0.0);
        System.out.println();
        vector.print();
        System.out.println();
        System.out.println("3.2. Now we will rotate the vector using the 3D rotation matrix");
        try{
            vector.multiplyMat(matrix);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("OUTPUT: The rotated vector is:");
        System.out.println();
        vector.print();
        
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(" EXERCICI 4: Adding rows and columns");
        System.out.println("4.1. We will add a row and a column to the following matrix");
        matrix.printMatrix();
        System.out.println();
        System.out.println("OUTPUT: The matrix with the added row is:");
        matrix.addRow();
        matrix.printMatrix();
        System.out.println();
        System.out.println("OUTPUT: The matrix with the added column is:"); 
        matrix.addColumn();
        matrix.printMatrix();
        


        matrix.multiplyScalar(40);
        matrix.printMatrix();

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

       

        
//        Vector v = new Vector (3) ;
//        v.set3D(1, 2, 3);
//        v.print();
//        v.addDim();
//        v.print();
        
        
        
        
                 
         
         
         
         
    
     }

    
}
