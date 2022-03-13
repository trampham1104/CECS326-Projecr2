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
 private Object leftChopstick;
 private Object rightChopstick;

 //constructor
 public Philosopher(Object leftCh, Object rightCh){
    leftChopstick = leftCh;
    rightChopstick = rightCh;
 }
 @Override
 public void run(){
 //alternating btw thinking and eating by picking up chopstick
    try{
        while(true){
            //Entering thinking state
            Thread.sleep(3000);
            System.out.println("...thinking");
        }
    }    
 }



}
