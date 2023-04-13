
package robot;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class PruebaFichero {

    
    public static void main(String[] args) {
        
        
        List<Robot> robots= getListaRobots(20);
        
        robots.forEach(System.out::println);
        
        
        String fichero = "Robots.csv";
        String tmp;
        
        String[] tokens;
        String linea;
        
        List<Robot> listaRobots= new ArrayList<>();
        
        
        
         try (BufferedWriter flujo = new BufferedWriter(new FileWriter(fichero))) {
            for (int i = 0; i < robots.size(); i++) {
                
                    // Obtengo en un String el elemento int de la matriz
                    tmp = robots.get(i).toString();
                    // Si es el último de la fila no pone la coma
                    
                        flujo.write(tmp);
                    
                

                // Metodo newLine() añade salto de línea después de cada fila
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + fichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("----------------------H----------------------------");
       
         try (Scanner datosFichero = new Scanner(new File(fichero), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                tokens = linea.split("(Robot: | - Vida: )");
                
                System.out.println(tokens[1]+" "+tokens[2]);
                System.out.println();
                
                
                Robot aux= new Robot(Integer.parseInt(tokens [1]), Integer.parseInt(tokens[2]));
                listaRobots.add(aux);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
         System.out.println("Lista");
         
         listaRobots.forEach(System.out::println);
    }
    
    public static List<Robot> getListaRobots(int num) {

        var listaRobots = new ArrayList<Robot>();
        Random rd = new Random();

        if (num <= 0) {
            throw new IllegalArgumentException("El numero para crear robots no es valido");
        }

        for (int i = 0; i < num; i++) {

            listaRobots.add(new Robot(rd.nextInt(0, 5000), rd.nextInt(1, 100)));
        }

        return listaRobots;
    }
    
}
