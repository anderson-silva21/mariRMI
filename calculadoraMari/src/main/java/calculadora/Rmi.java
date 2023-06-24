package calculadora;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.lang.Math;
import java.util.concurrent.locks.ReentrantLock;

public class Rmi extends UnicastRemoteObject implements Calculadora {
    private ReentrantLock lock; // Adicionando o lock

    public Rmi() throws RemoteException {
        lock = new ReentrantLock(); // Inicializando o lock
    }

    public int add(int a, int b) throws RemoteException {
        lock.lock(); // Obtendo o lock antes de executar a operação
        try {
            return a + b;
        } finally {
            lock.unlock(); // Liberando o lock após a operação
        }
    }

    public int sub(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return a - b;
        } finally {
            lock.unlock();
        }
    }

    public int mul(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return a * b;
        } finally {
            lock.unlock();
        }
    }

    public double div(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return a / b;
        } finally {
            lock.unlock();
        }
    }

    public double pot(int a, int b) throws RemoteException {
        lock.lock();
        try {
            return Math.pow(a, b);
        } finally {
            lock.unlock();
        }
    }

    public double root(int a, double b) throws RemoteException {
        lock.lock();
        try {
            return Math.pow(a, (1 / b));
        } finally {
            lock.unlock();
        }
    }

    public double rootsq(int a) throws RemoteException {
        lock.lock();
        try {
            return Math.sqrt(a);
        } finally {
            lock.unlock();
        }
    }
}
