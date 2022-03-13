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
     Object[] chopsticks = new Object[philosophers.length];

     //Creating 5 chopstics
     for(int i = 0; i < chopsticks.length; i++){
       chopsticks[i] = new Object();
     }

     for (int i = 0; i < philosophers.length; i++){
       Object leftChopstick = chopsticks[i];
       Object rightChopstick = chopsticks[(i + 1) % chopsticks.length];

       //The last philosophe picks up the right chopstick first to avoid circular wait condition that leads to deadlock
       if(i == philosophers.length - 1){
          philosophers[i] = new Philosopher(rightChopstick, leftChopstick);
       }

       else{
         philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
       }

       //Creating thread for each philosopher
       Thread t = new Thread(philosophers[i], "Philosopher " + (i+1));
       t.start();
     }

   }
}
