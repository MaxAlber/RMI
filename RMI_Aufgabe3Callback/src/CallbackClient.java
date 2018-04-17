import java.io.*;
import java.rmi.*;
import java.util.Scanner;

/**
 * This class represents the object client for a
 * distributed object of class CallbackServerImpl, 
 * which implements the remote interface 
 * CallbackServerInterface.  It also accepts callback
 * from the server.
 * 
 * 
 * 
 * @author M. L. Liu
 */

public class CallbackClient implements CallbackClientInterface
{
	
	
	

  public static void main(String args[])
  {
	  String hostName = "localhost";
	  String portNum = "4711";
	  String registryURL = null;
	  CallbackServerInterface h = null;
	  CallbackClientInterface callbackObj = null;
	  
	  
    try
    {
    	int RMIPort = 4711;         
	    InputStreamReader is = new InputStreamReader(System.in);
     	BufferedReader br = new BufferedReader(is);
	    RMIPort = Integer.parseInt(portNum); 
	    System.out.println("Enter how many seconds to stay registered:");
	    String timeDuration = br.readLine();
	    int time = Integer.parseInt(timeDuration);
	    registryURL = "rmi://localhost:" + portNum + "/callback";  
	    // find the remote object and cast it to an 
	    //   interface object
	    h = (CallbackServerInterface)Naming.lookup(registryURL);
	    System.out.println("Lookup completed " );
	    System.out.println("Server said " + h.sayHello());
	    callbackObj = new CallbackClientImpl();
	    // register for callback
	    h.registerForCallback(callbackObj);
	    System.out.println("Registered for callback.");
	    
	   /* try
	    {
	      Thread.sleep(time * 1000);
	    }
	    
	    catch (InterruptedException ex)
	    { 
	    	// sleep over
	    }*/
	      
	   
    } // end try 
    
    catch (Exception e)
    {
    	System.out.println("Exception in CallbackClient: " + e);
    } // end catch
    
    
    
    
    
    
  } //end main

@Override
public String notifyMe(String message) throws RemoteException
{
	String s1 = null;
	
	try
	{
	
    	Question obj = (Question) Naming.lookup ("rmi://localhost:" + 4711 + "/callback");
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Bitte geben Sie Ihre Frage ein");
		
		String ques = s.nextLine();
				
		s1 = (obj.makeQues(ques));
		
		
	} 
	
	catch (Exception e)
	{
		System.out.println ("HelloClient failed, caught exception " + e.getMessage());
	}
	
	return s1;
}
  
  
  
  
  
  
  
  
  
  
  
  
}//end class