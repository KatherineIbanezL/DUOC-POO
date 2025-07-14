/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

    public class concurrenciaPrimesList extends PrimesList {
    private final Lock lock = new ReentrantLock();

    @Override
    public boolean add(Integer num) {
        lock.lock();
        try {
            return super.add(num);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public boolean remove(Object obj) {
        lock.lock();
        try {
            return super.remove(obj);
        } finally {
            lock.unlock();
        }
    }
    
    
}

