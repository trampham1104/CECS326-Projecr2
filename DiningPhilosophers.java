/**
 * DiningPhilosophers.java
 *
 * This program starts the dining philosophers problem.
 *
 */
import java.lang.*;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//import java.util.zip.CheckedInputStream;

public class DiningPhilosophers
{  
  

  public static void main(String args[]) throws InterruptedException
   {  
     ExecutorService executorService = null;
     //Creating 5 threads for each philosophy
     Philosopher[] philosophers = null;
     try {
      
      philosophers = new Philosopher[5];
      

      //Creating 5 chopstics
      Forks[] fork = new Forks[philosophers.length];
      for(int i = 0; i < philosophers.length; i++){
        fork[i] = new Forks(i);
      }

      executorService = Executors.newFixedThreadPool(philosophers.length);

      for (int i = 0; i < philosophers.length; i++){
        //The last philosophe picks up the right chopstick first to avoid circular wait condition that leads to deadlock
        if(i == 0){
            philosophers[i] = new Philosopher(i, fork[i],fork[4] );
        } 

        else{
            philosophers[i] = new Philosopher(i, fork[i], fork[(i - 1) % philosophers.length]);
        }
        
        //Executing thread for each philosopher
        executorService.execute(philosophers[i]);
      }

      Thread.sleep(7);

      //Exit loop when all philosopher is full
      for(Philosopher p: philosophers)
        p.setFull(true);

     } finally {
          executorService.shutdown();
       }
    }
}
