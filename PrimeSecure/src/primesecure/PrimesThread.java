/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;
import java.util.Random;

public class PrimesThread implements Runnable{
    private final PrimesList primesList;
    private final int maxValor;

    public PrimesThread(PrimesList primesList, int maxValor) {
        this.primesList = primesList;
        this.maxValor = maxValor;
    }
    
    @Override
    public void run() {
        Random random = new Random();
        int numero = random.nextInt(maxValor);
        if (primesList.isPrime(numero)) {
            try {
                primesList.add(numero);
                System.out.println(Thread.currentThread().getName() + " agregó numero: " + numero);
            } catch (IllegalArgumentException e) {
                System.out.println(Thread.currentThread().getName() + " numero rechazado: " + numero + " no es primo");
            }
        }
    }
    
  
    
}
