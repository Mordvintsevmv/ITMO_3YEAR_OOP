package sample;

import java.io.*;
import java.util.ArrayList;

public final class Singleton  {
    private Singleton() {}
    private static Singleton instance;
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void saveData(ArrayList<Person> client) throws IOException {
        FileOutputStream fos = new FileOutputStream("src/sample/clientData");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(client);
        oos.close();
        fos.close();
    }

    public ArrayList<Person> loadData(ArrayList<Person> client) throws IOException {
        try {
            FileInputStream fis = new FileInputStream("src/sample/clientData");
            ObjectInputStream ois = new ObjectInputStream(fis);
            client = (ArrayList) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException | ClassNotFoundException e){
            client.add(new Person("Максим","Мордвинцев","1234"));
            client.add(new Person("Федерико","Феллини","5678"));
            client.add(new Person("Андрей","Рублёв","98"));
        }

        return client;
    }
}
