/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrimesList primesList = new PrimesList();

        // Cargar desde CSV
        Archivos.cargaArchivosCSV("primos.csv", primesList);

        // Crear hilos de verificación y adición
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new PrimesThread(primesList, 100), "Hilo " + (i + 1));
            threads[i].start();
        }

        // Esperar a que terminen
        for (Thread t : threads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Guardar mensajes simulados
        List<String> mensajes = List.of("Hola", "Clave", "Acceso");
        List<Integer> codigos = primesList.subList(0, Math.min(mensajes.size(), primesList.size()));
        Archivos.mensajesEncriptados(mensajes, primesList, "mensajes_codificados.txt");

        //conteo final
        System.out.println("Total de códigos primos registrados: " + primesList.getPrimesCount());
    }
}
