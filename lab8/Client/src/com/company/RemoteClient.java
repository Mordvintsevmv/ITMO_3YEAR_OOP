package com.company;

import Common.RemoteUtility;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoteClient {

    public static void main(String[] args) {

        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager == null){
            System.setSecurityManager(new SecurityManager());
        }

        try {
            Scanner scanner = new Scanner(System.in);

            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            String name = "MyRemoteUtility";
            RemoteUtility remoteUtilityStub = (RemoteUtility)registry.lookup(name);

            String choose = "start";
            while (!choose.equalsIgnoreCase("quit")){

                String reply = remoteUtilityStub.echo("\nПереданный массив чисел:");

                ArrayList<Double> numbers = new ArrayList<Double>();
                double num;
                System.out.print("\nПри вводе отрицательного числа корень рассчитываться не будет!\n");
                System.out.print("Введите чилса массива (0 - конец массива):\n");
                do{
                    num = scanner.nextDouble();
                    if (num != 0) {numbers.add(num);}
                }while (num != 0);

                remoteUtilityStub.echoArray(numbers);

                System.out.print("\nКвадраты чисел: ");
                ArrayList<Double> resultS = remoteUtilityStub.getSquare(numbers);
                System.out.println(resultS.toString());

                System.out.print("Корни чисел: ");
                ArrayList<Double> resultR = remoteUtilityStub.getRoot(numbers);
                System.out.println(resultR.toString());

                System.out.print("\nПродолжить? (quit для выхода | любое слово для продолжения)\n");
                choose = scanner.next();
            }
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}
