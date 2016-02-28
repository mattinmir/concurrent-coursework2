import java.util.concurrent.Semaphore;

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {
	
	/* declarations required */
	protected int count;
	protected Semaphore space;
	
	public PlatformAccess()
	{
		space = new Semaphore(1);
		count = 0;
	}
	
	public void arrive() throws InterruptedException {
		space.acquire();
		
		
		
		// complete implementation
	}

	public synchronized void depart() {
		// complete implementation
		space.release();
	}

}