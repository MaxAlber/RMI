import java.rmi.*;
import java.rmi.server.*;
public class QuestionImpl extends UnicastRemoteObject implements Question
{
	protected QuestionImpl() throws RemoteException
	{
		super();
	}

	public String makeQues(String ques) throws RemoteException
	{
		return "Die Antwort auf deine Frage " + ques +  "ist wahrscheinlich 61";
	}

	
}