import java.rmi.*;
import java.rmi.server.*;
public class QuadratImpl extends UnicastRemoteObject implements Quadrat
{
	protected QuadratImpl() throws RemoteException
	{
		super();
	}

	public int makeQuad(int length) throws RemoteException
	{
		return length*length;
	}

	
}