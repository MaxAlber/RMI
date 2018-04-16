import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Quadrat extends Remote
{
	public int makeQuad (int length) throws
	RemoteException;
}
