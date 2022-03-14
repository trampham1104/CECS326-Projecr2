import java.util.Random;

/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

public class Philosopher implements Runnable
{
 private int philNumber;
 private Object leftFork;
 private Object rightFork;

 //constructor
 public Philosopher(Object leftF, Object rightF, int philNumber){
    leftFork = leftF;
    rightFork = rightF;
    this.philNumber = philNumber;
 }

 @Override
 public void run(){
 //alternating btw thinking and eating by picking up chopstick
    try{
        while(true){
            //Entering thinking state
            Thread.sleep(3000);
            System.out.println("Philosopher" + philNumber + " is thinking...");

            //Picking up fork
        }
    }    
 }



}
