package Common;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RemoteUtility extends Remote {

    String echo(String msg) throws RemoteException;
    String echoArray(ArrayList<Double> numbers) throws RemoteException;
    ArrayList<Double> getSquare(ArrayList<Double> numbers) throws RemoteException;
    ArrayList<Double> getRoot(ArrayList<Double> numbers) throws RemoteException;
}
