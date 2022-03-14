/**
 * Forks.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Forks implements DiningServer{
    private int id;
    private Lock lock;
    
    Forks(int id){
        this.id = id;
        this.lock = new ReentrantLock();
    }
    
    //called by a philosopher when they wish to eat 
	public boolean takeForks(Philosopher phil, State state) throws InterruptedException{
		if( lock.tryLock(1, TimeUnit.SECONDS) ){
			System.out.println(phil + " picked up " + state.toString() + this);
			
			return true;
		}

		return false;
	}

	// called by a philosopher when they are finished eating 
	public void returnForks(Philosopher phil, State state){
		lock.unlock();
		System.out.println(phil + " put down " + state.toString() + this);
	}

    @Override
    public String toString(){
        return " fork " + id;
    }
}
