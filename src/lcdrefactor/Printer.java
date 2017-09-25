package lcdrefactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * @author angieqt
 */

public class Printer {
    
    // Puntos fijos
    private final int[] pivotPoint1;
    private final int[] pivotPoint2;
    private final int[] pivotPoint3;
    private final int[] pivotPoint4;
    private final int[] pivotPoint5;
    private String[][] printMatrix;
    private int size;

    /**
     * // Inicializa variables
     */
    public Printer() {
        
        this.pivotPoint1 = new int[2];
        this.pivotPoint2 = new int[2];
        this.pivotPoint3 = new int[2];
        this.pivotPoint4 = new int[2];
        this.pivotPoint5 = new int[2];
    }  
    
    /**
     * Genera la matriz de impresion.
     * Para ello consume los metodos encargados de calcular el tamaño de la matriz de impresion, inicializar,
     * imprimir y calcular los puntos pivote de la matriz.
     *
     * @param size        Argumento tipo int correspondiente al tamaño de la impresion.
     * @param numberPrint Argumento tipo String correspondiente al numero a Imprimir que se va a imprimir.
     * @param space       Argumento tipo int correponciente al espacio entre los digitos a imprimir.
     */
    public void generatePrintMatrix(int size, String numberPrint, int space) {
        Matrix matrix = new Matrix();
        this.size = size; 
        int sizeMatrix[] = matrix.calculateSizeMatrix(size, numberPrint, space);
        final int heightMatrix = sizeMatrix[0];
        final int widthMatrix = sizeMatrix[1];
        this.printMatrix = new String[heightMatrix][widthMatrix];
        initializeArray(heightMatrix, widthMatrix);
        calculatePivotPoints(numberPrint, space);
        printArray(heightMatrix, widthMatrix);
        
    }

    /**
     * Inicializa el array bi-dimensional (matriz de impresion).
     *
     * @param height Argumento tipo int que correspondiente a la altura de la matriz.
     * @param width  Argumento tipo int que correspondiente a la anchura de la matriz.
     */
    private void initializeArray(int height, int width){
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                this.printMatrix[i][j] = " ";
            }
        }
    }

    /**
     * Imprime el array bi-dimensional (matriz de impresion).
     *
     * @param height Argumento tipo int que correspondiente a la altura de la matriz.
     * @param width  Argumento tipo int que correspondiente a la anchura de la matriz.
     */
    private void printArray(int height, int width){
    
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print(this.printMatrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Calcula puntos pivote.
     * Inicialmente convierte el numero a imprimir en un lista de caracteres, para luego, a traves de un foreach,
     * especificar los puntos pivote para cada digito de la impresion. Ademas consume el metodo encargado de adicionar
     * las lineas del digito.
     *
     * @param numberPrint Numero a imprimir.
     * @param space       Espacio entre los digitos de la impresion.
     */
    private void calculatePivotPoints(String numberPrint, int space){
        char[] digits = numberPrint.toCharArray();
        int pivotX = 0;
        for (char digit : digits) {
            if (!Character.isDigit(digit)) {
                throw new IllegalArgumentException("Caracter " + digit
                        + " no es un digito");
            }
            int numberDigit = Integer.parseInt(String.valueOf(digit));
            Digit x = new Digit();
            int[] sizeDigit = x.calculateSizeDigit(size);
            int heightDigit = sizeDigit[0];
            int widthDigit = sizeDigit[1];
            this.pivotPoint1[0] = 0;
            this.pivotPoint1[1] = pivotX;
            this.pivotPoint2[0] = (heightDigit / 2);
            this.pivotPoint2[1] = pivotX;
            this.pivotPoint3[0] = (heightDigit - 1);
            this.pivotPoint3[1] = pivotX;
            this.pivotPoint4[0] = (widthDigit - 1);
            this.pivotPoint4[1] = (heightDigit / 2) + pivotX;
            this.pivotPoint5[0] = 0;
            this.pivotPoint5[1] = (widthDigit - 1) + pivotX;
            pivotX = pivotX + widthDigit + space;
            defineDigitLines(numberDigit);
        }
    }
    
    /**
     * Define las lineas de un digito.
     * Inicialmente se crea un ArrayList donde se almacenaran las lineas correspondientes a un digito.
     * Se crea un iterator del Arraylist de lineas y se determina que mientras exista un siguiente elemento ,
     * se adicionen las lineas del digito.
     *
     * @param numberDigit Digito de la impresion
     */
    private void defineDigitLines(int numberDigit) {
        List<Integer> lines = new ArrayList<>();
        Digit digit = new Digit();
        digit.representDigito(numberDigit, lines);
        Iterator<Integer> iterator = lines.iterator();
        while (iterator.hasNext()) {
            addLine(iterator.next());
        }
    }
    
     /**
     * Adiciona lineas a la matriz de Impresion.
     *A partir de la linea recibida como parametro de entrada, addiona los segmentos que la conformaran.
     *
     * @param line Segmento a adicionar
     */
    private void addLine(int line) {
        final String verticalSegment = "|";
        final String horizontalSegment = "-";
        final String positionX = "X";
        final String positionY = "Y";

        switch (line) {
            case 1:
                addSegment(this.pivotPoint1, positionY, verticalSegment);
                break;
            case 2:
                addSegment(this.pivotPoint2, positionY, verticalSegment);
                break;
            case 3:
                addSegment(this.pivotPoint5, positionY, verticalSegment);
                break;
            case 4:
                addSegment(this.pivotPoint4, positionY, verticalSegment);
                break;
            case 5:
                addSegment(this.pivotPoint1, positionX, horizontalSegment);
                break;
            case 6:
                addSegment(this.pivotPoint2, positionX, horizontalSegment);
                break;
            case 7:
                addSegment(this.pivotPoint3, positionX, horizontalSegment);
                break;
            default:
                break;
        }
    }
    
    /**
     * Añade los segmentos a la matriz de Impresion.
     * Inicialmente identifica la posicion fija que corresponde a la linea a la que se le adicionaran los segmetos.
     * Luego toma la posicion especifica del punto pivote en la matriz y asignara los segmentos bien sea de forma horizontal
     * o vertical ('-', '|') de acuerdo al contenido de la variable segment.
     *
     * @param pivotePoint   Lista tipo int que contiene la posicion especifia del punto pivote.
     * @param fixedPosition Argumento tipo String que contiene la posicion fija para el asignacion de los segmentos ("X" o "Y").
     * @param segment       Argumento correspondiente al caracter que sera establecido en la linea, ("-" o "|")
     * 
     */
    private void addSegment(int[] pivotePoint, String fixedPosition, String segment) {
        if (fixedPosition.equalsIgnoreCase("X")) {
            for (int i = 1; i <= size; i++) {
                int value = pivotePoint[1] + i;
                printMatrix[pivotePoint[0]][value] = segment;
            }
        } else {
        
            for (int j = 1; j <= size; j++) {
                int valor = pivotePoint[0] + j;
                printMatrix[valor][pivotePoint[1]] = segment;
            }
        }
    }
    
}