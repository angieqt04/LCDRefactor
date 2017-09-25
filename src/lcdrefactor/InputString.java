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
public class InputString {

    /**
     * Metodo encargado de procesar la cadena de entrada.
     * Este obtiene el tamaño de la impresion (size) y numero a imprimir; para lo que utiliza los metodos encargados de
     * dividir la cadena de entrada, validar el numero de parametros y el intervalo de la variable size.
     * Finalmente envia los parametros correspondientes al "tamaño", "numero a imprimir" y "espacio entre digitos"
     * al metodo que genera la matriz de impresion.
     *
     * @param inputString argumento tipo String de la cadena de entrada.
     * @param space       argumento tipo int del espacio entre los digitos del numero de impresion.
     */
    public void processInputString(String inputString, int space) {
        int size;
        final int option = 2;
        String[] parameters = splitInputString(inputString);
        validateNumberOfParameters(parameters);
        if (isNumeric(parameters[0])) {
            size = Integer.parseInt(parameters[0]);
            if(!isInIntervalo(option, parameters[0])){
                throw new IllegalArgumentException("El parametro size [" + size
                        + "] debe estar entre 1 y 10");   
            }
        } else {
            throw new IllegalArgumentException("Parametro Size [" + parameters[0]
                    + "] no es un numero");
        }
        Printer printer = new Printer();
        printer.generatePrintMatrix(size, parameters[1], space);
    }
    
    /**
     * Divide la cadena de entrada.
     * Para ello inicialmente utiliza el metodo contains que una vez encontrado el caracter "," divide la cadena y
     * retorna una lista tipo string que debe contener el tamaño de la impresion y numero a imprimir.
     * En caso de no encontrar el caracter mencionado, realiza una excepcion donde indica que dicha cadena
     * no contiene el caacter.
     *
     * @param inputString argumento tipo String de la cadena de entrada.
     * @return            lista tipo string que contiene los parametros correspondientes al tamaño de la impresion
     *                    y numero a imprimir.
     */
    private String[] splitInputString(String inputString){
        if (!inputString.contains(",")) {
            throw new IllegalArgumentException("Cadena " + inputString
                    + " no contiene el caracter ','");
        }
        return inputString.split(",");
    }
    
    /**
     * Valida la cantidad de parametros.
     * Es utilizado el metodo lenght para obtener el tamaño de la lista y verificar que el numero de parametros sea
     * estrictamente igual a dos (2); en caso contrario se realiza una excepcion para notificar el inconveniente.
     *
     * @param parameters lista de parametros que contiene la cadena de entrada
     */
    private void validateNumberOfParameters(String parameters[]){
        if(parameters.length > 2){
            throw new IllegalArgumentException("La cadena contiene mas de un caracter");
        }
        if(parameters.length < 2){
            throw new IllegalArgumentException("La cadena no contiene los parametros requeridos");
        }
    }

    /**
     * Valida el intervalo de un parametro.
     * A partir de la opcion especificada por los metodos que consumen este; verifica que
     * @param option especifica si el parametro a validar corresponde al espacio (1) o al tamaño del numeron (2)
     * @param parameter el parametro a validar
     * @return false o true dependiendo si corresponde o no al intervalo especificado
     */
    static boolean isInIntervalo(int option, String parameter){
      int number = Integer.parseInt(parameter);
      switch(option){
          case 1:
              return !(number < 0 || number > 5);
          case 2: 
              return !(number < 1 || number > 10);
          default: 
              return false;
      }
    }   
    
     /**
     * valida si una cadena es numerica.
     * @param parameter argumento tipo String a validar.
     */
    static boolean isNumeric(String parameter) {
        try {
            Integer.parseInt(parameter);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
