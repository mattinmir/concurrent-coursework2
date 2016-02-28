

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {
	
	/* declarations required */

	
	protected boolean full;
	
	public PlatformAccess()
	{
		full = false;
	}
	
	public synchronized void arrive() throws InterruptedException
	{
		while (full)
		{
			wait();
		}
		
		full = true;
		
		notifyAll();
	}

	public synchronized void depart()
	{
		full = false;
		notifyAll();

	}

}