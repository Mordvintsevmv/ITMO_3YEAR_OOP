package com.company;

import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.print("Сервер ожидает подключения!\n");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            System.out.print("\nУстановлено соединение!\n");

            while (!clientSocket.isClosed()) {
                String message = in.readUTF();
                System.out.print("\nСообщение от клиента: " + message);

                if (message.equalsIgnoreCase("выход") || message.equalsIgnoreCase("quit")) {
                    System.out.println("\nСоединение закрыто!\n");
                    out.writeUTF("Соединение закрыто!\n");
                    out.flush();
                    break;
                }

                if (message.length() > 5) {
                    if (message.substring(0, 5).equals("upper")) {
                        out.writeUTF("Сообщение переведено в верхний регистр: \n\t" + message.toUpperCase().substring(5));
                        System.out.print("\nВыполнен перевод в верхний регистр!");
                    } else if (message.substring(0, 5).equals("lower")) {
                        out.writeUTF("Сообщение переведено в нижний регистр: \n\t" + message.toLowerCase().substring(5));
                        System.out.print("\nВыполнен перевод в нижний регистр!");
                    } else {
                        out.writeUTF("Сообщение без изменений: \n\t" + message);
                        System.out.print("\nСообщение оставлено в прежнем виде!");
                    }
                    System.out.print("\nСообщение отправлено!\n");
                } else {
                    out.writeUTF("Сообщение без изменений: \n\t" + message);
                    System.out.print("\nСообщение оставлено в прежнем виде!");
                    System.out.print("\nСообщение отправлено!\n");
                }
            }

            out.flush();
            in.close();
            out.close();
            clientSocket.close();

        }
    }
}
