/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */
import java.util.*;
//import java.util.zip.CheckedInputStream;

public class DiningPhilosophers
{  
   public static void main(String args[])
   {  
     //Creating 5 threads for each philosophy
     Philosopher[] philosophers = new Philosopher[5];
     Object[] forks = new Object[philosophers.length];

     //Creating 5 chopstics
     for(int i = 0; i < forks.length; i++){
       forks[i] = new Object();
     }

     for (int i = 0; i < philosophers.length; i++){
       Object leftFork = forks[i];
       Object rightFork = forks[(i + 1) % forks.length];

       //The last philosophe picks up the right chopstick first to avoid circular wait condition that leads to deadlock
       if(i == philosophers.length - 1){
          philosophers[i] = new Philosopher(leftFork, rightFork, i);
       }

       else{
         philosophers[i] = new Philosopher(leftFork, rightFork, i);
       }

       //Creating thread for each philosopher
       Thread t = new Thread(philosophers[i], "Philosopher " + (i+1));
       t.start();
     }

   }
}
