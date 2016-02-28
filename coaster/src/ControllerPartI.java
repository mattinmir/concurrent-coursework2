
/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class ControllerPartI 
{

  public static int Max = 9;
  protected NumberCanvas passengers;
  
  protected int count;

  public ControllerPartI(NumberCanvas nc)
  {
    passengers = nc;
    count = 0;
  }

  public synchronized void newPassenger() throws InterruptedException 
  {
	  while (count >= Max)
		  wait(); // Waits until there is room on the platform
	  
	  count++;
	  passengers.setValue(count);
	  notifyAll();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException
  {
	  if(mcar > 0)
	  {
		  while (count < mcar)
			  wait(); // Will awaken when a new passenger is added

		  count -= mcar;
		  passengers.setValue(count);
		  notifyAll();
		  return mcar;
	  }
	  else 
		// Would throw some exception here but extra files not allowed by CATe submission
		  return 0; 
  }

  public synchronized void goNow() 
  {
    // complete implementation for part II
  }

}