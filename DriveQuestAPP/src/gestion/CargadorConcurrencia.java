/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestion;

import tipo.Vehiculo;

public class CargadorConcurrencia implements Runnable {
    private final FlotaVehiculos gestor;
    private final Vehiculo vehiculo;

    public CargadorConcurrencia(FlotaVehiculos gestor, Vehiculo vehiculo) {
        this.gestor = gestor;
        this.vehiculo = vehiculo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(60);
            boolean agregado = gestor.agregarVehiculo(vehiculo);
            if (agregado) {
                System.out.println("Vehículo cargado: " + vehiculo.getPatente());
            }
        } catch (InterruptedException e) {
            System.out.println("Error en hilo: " + e.getMessage());
        }
    }
}
