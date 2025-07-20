/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import gestion.FlotaVehiculos;
import javax.swing.SwingUtilities;
import ui.InterfazGrafica;

public class Main {
    public static void main(String[] args) {
        FlotaVehiculos gestor = new FlotaVehiculos();

        // Lanzar la interfaz gráfica en el hilo de eventos
        SwingUtilities.invokeLater(() -> {
            new InterfazGrafica(gestor).setVisible(true);
        });
    }
}
