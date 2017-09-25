/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lcdrefactor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author angieqt
 */
public class LCDRefactor {
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listParameter = new ArrayList<>();
        String parameter;
        final String commandToFinish = "0,0";
        final int OPTION = 1;
        int space;
    
        try {
            try(Scanner lector = new Scanner(System.in)){
                System.out.print("Espacio entre digitos (0 a 5): ");
                parameter = lector.next();
                if (InputString.isNumeric(parameter)) {
                    if (InputString.isInIntervalo(OPTION, parameter)) {
                        space = Integer.parseInt(parameter);
                    } else {
                        throw new IllegalArgumentException("El espacio entre "
                                + "digitos debe estar entre 0 y 5");
                    }
                } else {
                    throw new IllegalArgumentException("El espacio entre dígitos " + parameter
                                + " no es un entero");
                }
                
                do {
                
                    System.out.print("Entrada: \n");
                    parameter = lector.next();
                    if(!parameter.equalsIgnoreCase(commandToFinish)){
                        listParameter.add(parameter);
                    }
                } while(!parameter.equalsIgnoreCase(commandToFinish));
            }
            
            InputString inputString = new InputString();
            Iterator<String> iterator = listParameter.iterator();
            while(iterator.hasNext()){
            
                try{
                
                    inputString.processInputString(iterator.next(), space);
                }catch(Exception ex){
                
                    System.out.println("Error: " + ex.getMessage());
                }
            }
        }catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }   
}
