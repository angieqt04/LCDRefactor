/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lcdrefactor;


/**
 *
 * @author Angie QT
 */
public class Matrix {

    /**
     * Calcula el tamaño de la matriz.
     * Intancia un objeto tipo digito a fin de obtener el tamaño de un digito. Luego a partir de este, calcula la altura
     * y anchura de la matriz impresion y finalmente retorna estos valores.
     *
     * @param size        Argumento tipo int que concierne al tamaño de los digitos.
     * @param numberPrint Argumento tipo String que concierne al numero de impresion.
     * @param space       argumento tipo int que concierne al espacio entre los digitos de impresion.
     * @return            Lista que contiene tamaño de la matriz de impresion (altura y anchura).
     */
     
    public int[] calculateSizeMatrix(int size, String numberPrint, int space){
        Digit digit = new Digit();
        int[] sizeDigit = digit.calculateSizeDigit(size);
        int heightDigit = sizeDigit[0];
        int widgthDigit = sizeDigit[1];
        int widthMatrix = (widgthDigit * numberPrint.length())
                + (space * numberPrint.length());

        return new int[]{heightDigit, widthMatrix};
    }
    
}