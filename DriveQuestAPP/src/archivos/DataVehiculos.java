/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import tipo.Vehiculo;
import java.io.*;
import java.util.*;

public class DataVehiculos {
    public static void guardar(String ruta, List<Vehiculo> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ruta))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar vehículos: " + e.getMessage());
        }
    }

    public static List<Vehiculo> cargar(String ruta) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ruta))) {
            return (List<Vehiculo>) ois.readObject();
        } catch (Exception e) {
            System.out.println("No se pudo cargar: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}