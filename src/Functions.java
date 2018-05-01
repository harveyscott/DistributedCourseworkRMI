import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

interface Functions extends Remote{
    public String getMean(ArrayList<Integer> numbers) throws RemoteException;
    public String getMode(ArrayList<Integer> numbers) throws RemoteException;
    public String getMedian(ArrayList<Integer> numbers) throws RemoteException;
    public String getAsc(ArrayList<Integer> numbers) throws RemoteException;
}
