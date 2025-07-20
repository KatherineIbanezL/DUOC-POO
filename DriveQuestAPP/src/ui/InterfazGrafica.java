/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import gestion.FlotaVehiculos;
import tipo.CalculoBoleta;
import tipo.Carga;
import tipo.Pasajeros;

public class InterfazGrafica extends JFrame {
    private final FlotaVehiculos gestor;
    private JTextField patenteField, marcaField, diasField, capacidadField;
    private JComboBox<String> tipoVehiculoCombo;
    private JTextArea resultadoArea;
    private JButton agregarBtn, listarBtn, boletasBtn, contarArriendosBtn;

    public InterfazGrafica(FlotaVehiculos gestor) {
        this.gestor = gestor;
        setTitle("DriveQuest Rentals - Gestión de Flota");
        setSize(700, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        tipoVehiculoCombo = new JComboBox<>(new String[]{"Carga", "Pasajeros"});
        patenteField = new JTextField();
        marcaField = new JTextField();
        diasField = new JTextField();
        capacidadField = new JTextField();

        agregarBtn = new JButton("Agregar Vehículo");
        listarBtn = new JButton("Lista de Vehículos");
        boletasBtn = new JButton("Mostrar Boletas");
        contarArriendosBtn = new JButton("Conteo de arriendos superiores o igual a 7 días");

        resultadoArea = new JTextArea(12, 50);
        resultadoArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(resultadoArea);

        panel.add(new JLabel("Tipo de Vehículo:"));
        panel.add(tipoVehiculoCombo);
        panel.add(new JLabel("Patente:"));
        panel.add(patenteField);
        panel.add(new JLabel("Marca:"));
        panel.add(marcaField);
        panel.add(new JLabel("Días de Arriendo:"));
        panel.add(diasField);
        panel.add(new JLabel("Capacidad (Ton o Nº Pasajeros):"));
        panel.add(capacidadField);
        panel.add(agregarBtn);
        panel.add(listarBtn);
        panel.add(boletasBtn);
        panel.add(contarArriendosBtn);

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        agregarBtn.addActionListener(e -> {
            // Validación
            try {
                String patente = patenteField.getText().trim();
                if (patente.isEmpty()) throw new IllegalArgumentException("Patente no puede estar vacía.");

                String marca = marcaField.getText().trim();
                if (marca.isEmpty()) throw new IllegalArgumentException("Marca no puede estar vacía.");

                int dias = Integer.parseInt(diasField.getText().trim());
                if (dias <= 0) throw new IllegalArgumentException("Días debe ser positivo.");

                String tipo = (String) tipoVehiculoCombo.getSelectedItem();
                double capacidad = Double.parseDouble(capacidadField.getText().trim());
                if (capacidad <= 0) throw new IllegalArgumentException("Capacidad debe ser positiva.");

                // Crear vehículo según tipo
                Runnable tareaAgregar = () -> {
                try {
                        boolean agregado;
                        if ("Carga".equals(tipo)) {
                            agregado = gestor.agregarVehiculo(new Carga(patente, marca, dias, capacidad));
                        } else {
                            agregado = gestor.agregarVehiculo(new Pasajeros(patente, marca, dias, (int) capacidad));
                        }

                        boolean finalAgregado = agregado;

                        SwingUtilities.invokeLater(() -> {
                            if (finalAgregado) {
                                resultadoArea.setText("Vehículo agregado exitosamente.\n");
                            } else {
                                resultadoArea.setText("Error: la patente ya se encuentra registrada.\n");
                            }
                        });

                    } catch (Exception ex) {
                        SwingUtilities.invokeLater(() -> resultadoArea.setText("Error al agregar vehículo: " + ex.getMessage() + "\n"));
                    }
                };

                Thread hilo = new Thread(tareaAgregar);
                hilo.start();

            } catch (NumberFormatException nfe) {
                resultadoArea.setText("Error: debe ingresar números positivos y/o no debe estar vacío.\n");
            } catch (IllegalArgumentException iae) {
                resultadoArea.setText("Error: " + iae.getMessage() + "\n");
            }
        });

        listarBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (var v : gestor.listarVehiculos()) {
                sb.append(v.mostrarDatos()).append("\n");
            }
            resultadoArea.setText(sb.toString());
        });

        boletasBtn.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            for (var v : gestor.listarVehiculos()) {
            sb.append(((CalculoBoleta) v).mostrarBoleta()).append("\n");
            }
            resultadoArea.setText(sb.toString());
        });

        contarArriendosBtn.addActionListener(e -> {
            long cantidad = gestor.contarArriendosLargos();
            resultadoArea.setText("Vehículos con arriendo igual o superior a 7 días: " + cantidad + "\n");
        });
    }

    public static void main(String[] args) {
        FlotaVehiculos gestor = new FlotaVehiculos();
        SwingUtilities.invokeLater(() -> new InterfazGrafica(gestor).setVisible(true));
    }
}
