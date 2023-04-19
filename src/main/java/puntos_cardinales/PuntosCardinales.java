
package puntos_cardinales;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import robot.Robot;


public class PuntosCardinales {

    
    public static void main(String[] args) {
        
        
        List<String> puntosCardinales= new ArrayList<>();
                
        String fichero= "localizaciones.txt";
        String tmp;
        String linea;
        puntosCardinales= anadirCardinalLista(fichero);
        
        
        
        
        System.out.println("-----------------------------------------");
        System.out.println("Puntos Cardinales en la lista");
        puntosCardinales.forEach(System.out::println);
        System.out.println("-----------------------------------------");
        
        
        Map<String,Integer> mapPuntosCardinales= mapAPartirLista(puntosCardinales);
        
        
        
        
        System.out.println("----------------------------------------------------");
        System.out.println("Recorrer Map");
        for (Map.Entry<String, Integer> entry : mapPuntosCardinales.entrySet()) {
            System.out.println("Localizacion: "+ entry.getKey()+" Repeticiones: "+entry.getValue());
            
            
        }
        
         System.out.println("----------------------------------------------------");
        
        
        String nuevoTexto="MapCardinales.txt";
        
        
        
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(nuevoTexto))) {
            
            for (Map.Entry<String, Integer> entry : mapPuntosCardinales.entrySet()) {
                
                tmp=entry.getKey()+"-"+entry.getValue();
                
                flujo.write(tmp);
                
                flujo.newLine();
                
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + nuevoTexto + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("Fichero creado");
        System.out.println("Leyendo map");
        
        try (Scanner datosFichero = new Scanner(new File(nuevoTexto), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                
                
                System.out.println(linea);
                
                
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
    
    public static List<String> anadirCardinalLista(String text){
        
        List<String> lista= new ArrayList<>();
        
        
        String tmp;
        
        String[] tokens;
        String linea;
    
    try (Scanner datosFichero = new Scanner(new File(text), "UTF-8")) {
            // hasNextLine devuelve true mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {
                // Guarda la línea completa en un String
                linea = datosFichero.nextLine();
                // Se guarda en el array de String cada elemento de la
                // línea en función del carácter separador de campos del fichero CSV
                
                tokens = linea.split("Localizacion: ");
                lista.add(tokens[1]);
                
                
                
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    
    
    
    return lista;
    
    
    }
    
    public static Map<String,Integer> mapAPartirLista(List<String> l){
    
        Map<String,Integer> aux= new HashMap<>();
    
    
        int repeticionN=0;
        int repeticionS=0;
        int repeticionE=0;
        int repeticionO=0;
        
        
        for (int i = 0; i < l.size(); i++) {
            
            
            if(l.get(i).equals("N")){
            
            repeticionN++;
            
            }
            
            if(l.get(i).equals("S")){
            
            repeticionS++;
            
            }
            
            if(l.get(i).equals("E")){
            
            repeticionE++;
            
            }
            
            if(l.get(i).equals("O")){
            
            repeticionO++;
            
            }
            
        }
        
        
        
        
        aux.put("N", repeticionN);
        aux.put("S", repeticionS);
        aux.put("E", repeticionE);
        aux.put("O", repeticionO);
    
        return aux;
    
    
    }
    public static void leerTextoAPartirMap(Map<String,Integer> m){
    
    
    
    
    
    
    
    
    
    }
}
