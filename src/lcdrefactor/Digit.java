/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lcdrefactor;

import java.util.List;

/**
 *
 * @author Angie QT
 */
public class Digit {

    /**
     * Calcula el tamaño de un digito.
     *
     * @param size Argumento tipo int que correspondiente al tamaño de la impresion.
     * @return     Lista que contiene el tamaño del digito (altura y anchura)
     */
    
    public int[] calculateSizeDigit(int size){
        int heightDigit = (2 * size) + 3;
        int widthDigit = size + 2;
        return new int[] {heightDigit, widthDigit};
    }

    /**
     * Representa un digito.
     * Recibe una lista de lineas, donde se almacenaran las lineas que corresponden al numero que tambien recibe.
     *
     * @param digitNumber Argumento tipo int que corresponde a un digito de la impresion.
     * @param lines       Lista de lineas para almacenar las que corresponden a un digito.
     */

    public void representDigito(int digitNumber, List<Integer> lines) {

        switch (digitNumber) {
            case 1:
                representNumberOne(lines);
                break;
            case 2:
                representNumberTwo(lines);
                break;
            case 3:
                representNumberThree(lines);
                break;
            case 4:
                representNumberFour(lines);
                break;
            case 5:
                representNumberFive(lines);
                break;
            case 6:
                representNumberSix(lines);
                break;
            case 7:
                representNumberSeven(lines);
                break;
            case 8:
                representNumberEight(lines);
                break;
            case 9:
                representNumberNine(lines);
                break;
            case 0:
                representNumberZero(lines);
                break;
            default:
                break;
        }
    }

    private void representNumberOne(List<Integer> line) {
        line.add(3);
        line.add(4);
    }

    private void representNumberTwo(List<Integer> line) {
        line.add(5);
        line.add(3);
        line.add(6);
        line.add(2);
        line.add(7);
    }

    private void representNumberThree(List<Integer> line) {
        line.add(5);
        line.add(3);
        line.add(6);
        line.add(4);
        line.add(7);
    }

    private void representNumberFour(List<Integer> line) {
        line.add(1);
        line.add(6);
        line.add(3);
        line.add(4);
    }

    private void representNumberFive(List<Integer> line) {
        line.add(5);
        line.add(1);
        line.add(6);
        line.add(4);
        line.add(7);
    }

    private void representNumberSix(List<Integer> line) {
        line.add(5);
        line.add(1);
        line.add(6);
        line.add(2);
        line.add(7);
        line.add(4);
    }

    private void representNumberSeven(List<Integer> line) {
        line.add(5);
        line.add(3);
        line.add(4);
    }

    private void representNumberEight(List<Integer> line) {
        line.add(1);
        line.add(2);
        line.add(3);
        line.add(4);
        line.add(5);
        line.add(6);
        line.add(7);
    }

    private void representNumberNine(List<Integer> line) {
        line.add(1);
        line.add(3);
        line.add(4);
        line.add(5);
        line.add(6);
        line.add(7);
    }

    private void representNumberZero(List<Integer> line) {
        line.add(1);
        line.add(2);
        line.add(3);
        line.add(4);
        line.add(5);
        line.add(7);
    }

}
