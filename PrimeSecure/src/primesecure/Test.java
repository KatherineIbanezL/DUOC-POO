/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

public class Test {
        public static void main(String[] args) {
        PrimesList primesList = new PrimesList();

        // Prueba de agregar primo
        primesList.add(7);
        assert primesList.contains(7);

        // Prueba de error por no primo
        try {
            primesList.add(8);
            assert false;
        } catch (IllegalArgumentException e) {
            assert true;
        }

        // Prueba de contar
        assert primesList.getPrimesCount() == 1;

        System.out.println("Pruebas básicas completadas.");
    }
}
