/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipo;

import javax.swing.JOptionPane;

public class Pasajeros extends Vehiculo implements CalculoBoleta {
    private int cantidadPasajeros;

    public Pasajeros() {}

    public Pasajeros(String patente, String marca, int diasArriendo, int cantidadPasajeros) {
        super(patente, marca, diasArriendo);
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String mostrarDatos() {
        return "Vehículo de Pasajeros: " + patente + ", Marca: " + marca + ", Días: " + diasArriendo + ", Capacidad: " + cantidadPasajeros + " pasajeros";
    }

    @Override
    public double calcularTotal() {
        double base = diasArriendo * 30000;
        double conIVA = base + (base * IVA);
        return conIVA - (base * DESCUENTOPASAJEROS);
    }

    @Override
    public String mostrarBoleta() {
    return "\n------ BOLETA VEHICULO DE PASAJEROS ------\nPatente: " + patente 
            + "\nMarca: " + marca 
            + "\nDías de arriendo:  " + diasArriendo 
            + "\nCapacidad de pasajeros: " + cantidadPasajeros
            + "\nTotal: $" + calcularTotal() 
            + "\n-----------------------------------------------------------------";
    }
}
