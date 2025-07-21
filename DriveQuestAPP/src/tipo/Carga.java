/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipo;

import java.io.Serializable;


public class Carga extends Vehiculo implements Serializable, CalculoBoleta {
    private double capacidadCarga;

    public Carga() {}

    public Carga(String patente, String marca, int diasArriendo, double capacidadCarga) {
        super(patente, marca, diasArriendo);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String mostrarDatos() {
        return "Vehículo de Carga: " + patente + ", Marca: " + marca + ", Días: " + diasArriendo + ", Capacidad: " + capacidadCarga + " T";
    }

    @Override
    public double calcularTotal() {
        double base = diasArriendo * 50000;
        double conIVA = base + (base * IVA);
        return conIVA - (base * DESCUENTOCARGA);
    }

    @Override
    public String mostrarBoleta() {
    return "\n------ BOLETA VEHICULO DE CARGA ------\nPatente: " + patente 
            + "\nMarca: " + marca 
            + "\nDías de arriendo:  " + diasArriendo 
            + "\nCapacidad de carga: " + capacidadCarga + "T"
            + "\nTotal: $" + calcularTotal() 
            + "\n---------------------------------------------------------";
    }
}