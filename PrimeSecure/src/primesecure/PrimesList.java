/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

import java.util.ArrayList;

public class PrimesList extends ArrayList<Integer> {

    // Metodo verificador de numero primo
    public boolean isPrime(int numero) {
        if (numero <= 1) 
            return false;
        if (numero == 2) 
            return true;
        if (numero % 2 == 0) 
            return false;
        for (int i = 3; i <= Math.sqrt(numero); i += 2) {
            if (numero % i == 0) 
                return false;
        }
        return true;
    }

    // Sobrescribir metodo add
    @Override
    public synchronized boolean add(Integer numero) {
        if (!isPrime(numero)) {
            throw new IllegalArgumentException("Solo se permiten agregar numeros primos.");
        }
        return super.add(numero);
    }

    // Sobrescribir metodo remove
    @Override
    public synchronized boolean remove(Object obj) {
        if (obj instanceof Integer) {
            int numero = (Integer) obj;
            if (!isPrime(numero)) {
                throw new IllegalArgumentException("Solo se puede remover numeros primos de la lista.");
            }
        }
        return super.remove(obj);
    }

    //devuelve cantidad de numeros primos en lista
    public synchronized int getPrimesCount() {
        return this.size();
    }
}