package ThreadProgramming;

import java.io.Serializable;

class ThreadDemo
{
   public static void main (String [] args) throws InterruptedException
   {
      MyThread mt = new MyThread ();
      new Thread(group, name)
      mt.start ();
      Serializable
//      System.out.println("Active count -- " + Thread.activeCount());
      mt.join();
      for (int i = 0; i < 50; i++)
           System.out.println ("i = " + i + ", i * i = " + i * i);
   }
}
class MyThread extends Thread
{
   public void run ()
   {
      for (int count = 1, row = 1; row < 20; row++, count++)
      {
           for (int i = 0; i < count; i++)
                System.out.print ('*');
           System.out.print ('\n');
      }
   }
   //It will throw an exception if it is called before the first run is completed
   public void callMeAgain(MyThread t){
	   t.start();
   }
}