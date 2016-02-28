
/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller 
{

  public static int Max = 9;
  protected NumberCanvas passengers;
  
  private int count;
  private int tempCount;
  private boolean goNowPressed;
  
  public Controller(NumberCanvas nc)
  {
    passengers = nc;
    count = 0;
    tempCount=0;
    goNowPressed = false;
  }

  public synchronized void newPassenger() throws InterruptedException 
  {
	  while (count >= Max)
		  wait();
	  
	  count++;
	  passengers.setValue(count);
	  notifyAll();
  }

  public synchronized int getPassengers(int mcar) throws InterruptedException
  {
	  if(mcar > 0)
	  {
		  // Wait until a single passenger is added so it is possible to press goNow
		  while (count < 1)
		  {
			  goNowPressed = false;
			  wait();
		  }
		  while (!goNowPressed && count < mcar)
		  {
			  goNowPressed = false;
			  wait();
		  } 
		  
		  if (count > mcar)
		  {
			  count -= mcar;
			  passengers.setValue(count);
			  notifyAll();
			  return mcar;
		  }	
		  else
		  {
			  tempCount = count;
			  count = 0;
			  passengers.setValue(0);
			  notifyAll();
			  return tempCount;
		  }
	  }
	  else 
	  {
		  notifyAll();
		  return 0;
	  }
}

  public synchronized void goNow() 
  {
	  goNowPressed = true;
	  notifyAll();
    
  }

}