/**
 * Created by Ovylock on 22.05.2015.
 */
import java.rmi.*;

public interface InterfataMathWiz extends Remote
{
    public String adunare(double a, double b)
            throws RemoteException;

    public String scadere(double a, double b)
            throws RemoteException;

    public String inmultire(double a, double b)
            throws RemoteException;

    public String impartire(double a, double b)
            throws RemoteException;

    public String inversare(double a)
            throws RemoteException;

    public String putere(double a,double b)
            throws RemoteException;

    public String factorial(double a)
            throws RemoteException;

    public String radacina(double a)
            throws RemoteException;
}