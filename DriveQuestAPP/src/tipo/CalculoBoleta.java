/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tipo;


public interface CalculoBoleta {
    double IVA = 0.19;
    double DESCUENTOCARGA = 0.07;
    double DESCUENTOPASAJEROS = 0.12;

    double calcularTotal();
    String mostrarBoleta();
}