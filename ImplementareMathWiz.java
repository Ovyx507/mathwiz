/**
 * Created by Ovylock on 22.05.2015.
 */
import java.rmi.*;
import java.rmi.server.*;

public class ImplementareMathWiz extends UnicastRemoteObject
        implements InterfataMathWiz {

    public ImplementareMathWiz() throws RemoteException {
        //There is no action need in this moment.
    }

    @Override
    public String adunare(double a, double b)
            throws RemoteException {
        System.out.println ("Doing addition");
        return Double.toString(a+b);
    }

    public String scadere(double a, double b)
            throws RemoteException {
        System.out.println ("Doing addition");
        return Double.toString(a - b);
    }

    public String inmultire(double a, double b)
            throws RemoteException {
        System.out.println ("Doing multiplication");
        return Double.toString(a * b);
    }

    public String impartire(double a, double b)
            throws RemoteException {
        System.out.println ("Doing division");
        return Double.toString(a / b);
    }

    public String inversare(double a)
            throws RemoteException {
        System.out.println ("Inverting a number");
        return Double.toString(1 / a);
    }

    public String putere(double a,double b)
            throws RemoteException {
        System.out.println ("Powering a number");
        return Double.toString(Math.pow(a, b));

    }

    public String factorial(double a)
            throws RemoteException {
        System.out.println ("Inverting a number");
        double b=1;
        for(int i=1;i<=a;i++)
        {
            b=b*i;
        }
        return Double.toString(b);
    }

    public String radacina(double a)
            throws RemoteException {
        System.out.println ("Sqrting a number");
        return Double.toString(Math.sqrt(a));
    }
}
