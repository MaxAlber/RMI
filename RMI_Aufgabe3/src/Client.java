import java.rmi.*;
import java.rmi.server.*;
import java.util.Scanner;
public class Client
{
	static public void main (String[] args) /*args[0]: host, args[1]: port*/
	{
		String host = (args.length < 1) ? "127.0.0.1" : args[0];
		int port = (args.length < 2) ? 4711 : Integer.parseInt(args[1]);
		try
		{
		
			Question obj = (Question) Naming.lookup ("rmi://" + host + ":" + port + "/" + "QuadratObj");
			
			Scanner s = new Scanner(System.in);
			
			System.out.println("Bitte geben Sie Ihre Frage ein");
			
			String ques = s.nextLine();
					
			System.out.println (obj.makeQues(ques));
			
		} 
		
		catch (Exception e)
		{
			System.out.println ("HelloClient failed, caught exception " + e.getMessage());
		}
	}
} 