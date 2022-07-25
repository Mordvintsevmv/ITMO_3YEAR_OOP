package com.company;

import Common.RemoteUtility;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RemoteUtilityImpl implements RemoteUtility {

    @Override
    public String echo(String s) throws RemoteException {
        System.out.println(s);
        return s;
    }

    @Override
    public String echoArray(ArrayList<Double> numbers) throws RemoteException {
        String ArrayS = "| ";
        for (double num : numbers){
            ArrayS += (num + " | ");
        }
        System.out.println(ArrayS);
        return ArrayS;
    }

    @Override
    public ArrayList<Double> getSquare(ArrayList<Double> numbers) throws RemoteException{
        ArrayList<Double> square = new ArrayList<>();
        for (double num : numbers){
            square.add(num*num);
        }
        return square;
    }

    @Override
    public ArrayList<Double> getRoot(ArrayList<Double> numbers) throws RemoteException{
        ArrayList<Double> root = new ArrayList<>();
        for (double num : numbers){

            if (num > 0) {root.add(Math.sqrt(num));}
            else {root.add(num);}
        }
        return root;
    }
}
