package com.company;

import Common.RemoteUtility;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RemoteServer {

    public static void main(String[] args) {

        System.setProperty("java.rmi.server.hostname", "127.0.0.1");
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null){
            System.setSecurityManager(new SecurityManager());
        }

        try{
            RemoteUtilityImpl remoteUtility = new RemoteUtilityImpl();
            int port = 0;
            RemoteUtility remoteUtilityStub = (RemoteUtility) UnicastRemoteObject.exportObject(remoteUtility, port);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            String name = "MyRemoteUtility";
            registry.rebind(name, remoteUtilityStub);
            System.out.println("Удалённый сервер запущен!");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
