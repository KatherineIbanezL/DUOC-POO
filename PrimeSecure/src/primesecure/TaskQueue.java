/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primesecure;

import java.util.LinkedList;
import java.util.Queue;

public class TaskQueue {
       private final Queue<Integer> queue = new LinkedList<>();
    
    //despierta hilos 
    public synchronized void addTask(int numero) {
        queue.add(numero);
        notify();
    }
    
    //espera si no hay tareas
    public synchronized int getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }
        return queue.poll();
    } 
}
