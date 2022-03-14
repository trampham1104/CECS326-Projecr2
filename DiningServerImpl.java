/**
 * DiningServer.java
 *
 * This class contains the methods called by the  philosophers.
 *
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class DiningServerImpl  implements DiningServer
{  	
	private Lock lock = new ReentrantLock();

	// called by a philosopher when they wish to eat 
	public boolean takeForks(Philosopher phil, int philNumber) throws InterruptedException{
		if( lock.tryLock(2, TimeUnit.SECONDS) ){
			System.out.println(phil + " picked up ");
			
			return true;
		}

		return false;
	}
  
	// called by a philosopher when they are finished eating 
	public void returnForks(Philosopher phil, int philNumber){
		lock.unlock();
		System.out.println(phil + " put down " );
	}
}
