//import java.util.Random;

/**
 * Philosopher.java
 *
 * This class represents each philosopher thread.
 * Philosophers alternate between eating and thinking.
 *
 */

public class Philosopher implements Runnable
{
 private Forks leftFork;
 private Forks rightFork;
 private int id;
 private volatile boolean isFull = false;

 //constructor
 public Philosopher(int id, Forks leftF, Forks rightF){
    this.id = id;
    leftFork = leftF;
    rightFork = rightF;
 }

 @Override
 public void run(){
 //alternating btw thinking and eating by picking up chopstick
    try{
        while( !isFull ){
            //Entering thinking state
            think();

            if( this.id == 4){
                if( rightFork.takeForks(this, State.RIGHT)){
                    if( leftFork.takeForks(this, State.LEFT)){
                        eat(); //Begin eating when obtains 2 forks
                        System.out.println(this + " is full");
                        leftFork.returnForks(this, State.LEFT);
                    }
                    rightFork.returnForks(this, State.RIGHT);
                }
            }

            else{
                //Start picking up fork to eat
                if( leftFork.takeForks(this, State.LEFT)){
                    if( rightFork.takeForks(this, State.RIGHT)){
                        eat(); //Begin eating when obtains 2 forks
                        System.out.println(this + " is full");
                        rightFork.returnForks(this, State.RIGHT);
                    }
                    leftFork.returnForks(this, State.LEFT);
                }
            }
        }
    } catch (Exception e){
        e.printStackTrace();
    }
    
    
    }

    public void setFull(boolean isFull){
        this.isFull = isFull;
    }
    
    public void think() throws InterruptedException{
        System.out.println(this + " is thinking...");
        Thread.sleep(1000);

    }

    public void eat() throws InterruptedException{
        System.out.println(this + " is eating...");
        Thread.sleep(1000);

    }

    @Override
    public String toString(){
        return "Philosopher " + id;
    }
 }

