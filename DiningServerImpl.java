/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{  	
	private Lock lock = new ReentrantLock();
	private boolean available = false;
	private Condition conVar = lock.newCondition();

	// called by a philosopher when they wish to eat 
	public void takeForks(int philNumber){
		lock.lock(); //a philosopher is eating, lock a chopstick
		try{
			while(available == false){ //chopstick not available
				try{
					conVar.await();
				} catch(InterruptedException e) {}
			}
			available = false;
			conVar.signalAll();
		} finally{
			lock.unlock();
		}
	}
  
	// called by a philosopher when they are finished eating 
	public void returnForks(int philNumber){

	}
}
