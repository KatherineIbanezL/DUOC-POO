/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Archivos {
    public static void cargaArchivosCSV(String filename, PrimesList primesList) {
        int lineNumber = 1;
        int ignoradas = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    int number = Integer.parseInt(line.trim());
                    primesList.add(number);
                }catch (NumberFormatException e) {
                    ignoradas++;
                }catch (IllegalArgumentException e){
                    ignoradas++;                   
            }
            lineNumber++;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    public static void mensajesEncriptados(List<String> mensajes, List<Integer> listaPrimos, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
             int cantidad = Math.min(mensajes.size(), listaPrimos.size());
            for (int i = 0; i < cantidad; i++) {
                writer.write("Mensaje: " + mensajes.get(i) + ", Código Primo: " + listaPrimos.get(i) + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    
}
