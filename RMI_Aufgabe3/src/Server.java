import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;


@SuppressWarnings("serial")
public class Server extends UnicastRemoteObject implements Question
{
	protected Server() throws RemoteException
	{
		super();
	}
	
	public String makeQues(String ques) throws RemoteException
	{
		return "Die Antwort auf deine Frage " + ques + " ist wahrscheinlich 61";
	}
	
	public static void main(String[] args) throws RemoteException
	{
		int port = (args.length > 0) ? Integer.parseInt(args[0]) : 4711;
		Server obj = new Server();
		String objName = "QuadratObj";
		Registry registry = LocateRegistry.getRegistry(port);
		boolean bound = false;
		for(int i = 0; ! bound && i < 2; i++)
		{
			try
			{
				registry.rebind(objName, (Remote) obj);
				bound = true;
				System.out.println(objName+" bound to registry, port " + port + ".");
			}
			catch(RemoteException e)
			{
				System.out.println("Rebinding " + objName + " failed, " + "retrying ...");
				registry = LocateRegistry.createRegistry(port);
				System.out.println("Registry started on port " + port + ".");
			}
		}
		System.out.println("HelloServer ready.");
	}

}