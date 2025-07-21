/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;


import tipo.*;
import java.util.*;


public class FlotaVehiculos {
    private final Set<String> patentes = Collections.synchronizedSet(new HashSet<>());
    private final List<Vehiculo> vehiculos = Collections.synchronizedList(new ArrayList<>());

    public synchronized boolean agregarVehiculo(Vehiculo v) {
        String patenteNormalizada = v.getPatente().toLowerCase();
        if (patentes.contains(patenteNormalizada)) {
            System.out.println("Error: Patente duplicada.");
            return false;
        }
        patentes.add(patenteNormalizada);
        vehiculos.add(v);
        return true;
    }

    public List<Vehiculo> listarVehiculos() {
        return vehiculos;
    }

    public void mostrarBoleta(Vehiculo v) {
            if (v instanceof CalculoBoleta calculoBoleta) {
                calculoBoleta.mostrarBoleta();
            System.out.println();           
            }
    }

    public long contarArriendosLargos() {
        int contador = 0;
        for (Vehiculo v : vehiculos) {
            if (v.getDiasArriendo() >= 7) {
                contador++;
            }
        }
        return contador;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
}