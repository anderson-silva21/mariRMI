package calculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import javax.jws.WebService;

@WebService
public class Rmi extends UnicastRemoteObject implements Calculadora{
    public Rmi() throws RemoteException {
        super();
    }

    public int add(int a, int b) throws RemoteException {
        System.out.println(a + b);
        return a + b;
    }

    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }

    public int mul(int a, int b) throws RemoteException {
        return a * b;
    }

    public double div(int a, int b) throws RemoteException {
        return (double) a / b;
    }
}
