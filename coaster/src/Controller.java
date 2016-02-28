
/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller 
{

  public static int Max = 9;
  protected NumberCanvas passengers;
  
  protected int count;
  


  public Controller(NumberCanvas nc)
  {
    passengers = nc;
    count = 0;

  }

  public synchronized void newPassenger() throws InterruptedException 
  {
	  while (count >= Max)
	  {
		  wait();
	  }
	  
	  count++;
	  passengers.setValue(count);
	  notifyAll();
	  // complete implementation
     // use "passengers.setValue(integer value)" to update diplay
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException
  {
	  if(mcar > 0)
	  {
		  while (count < mcar)
		  {
			  wait(); // Will awaken when a new passenger is added
		  }

		  count -= mcar;
		  passengers.setValue(count);
		  notifyAll();
		  // System.out.println("get");
		  return mcar;


		  // update for part II
		  // use "passengers.setValue(integer value)" to update diplay
		  // dummy value to allow compilation
	  }
	  else 
		  return 0;
  }

  public synchronized void goNow() 
  {
    // complete implementation for part II
  }

}