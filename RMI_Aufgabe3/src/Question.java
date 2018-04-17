import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Question extends Remote
{
	public String makeQues (String ques) throws RemoteException;
}
