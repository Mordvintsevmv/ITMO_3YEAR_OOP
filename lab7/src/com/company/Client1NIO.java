package com.company;

import java.io.*;
import java.net.Socket;

public class Client1NIO {
    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket("localhost", 9999);) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            System.out.print("Клиент подключился!\n");
            System.out.print("Возможности программы:\n");
            System.out.print("\tВведите \"upper\" перед строкой, чтобы перевести сообщение в верхний регистр.\n");
            System.out.print("\tВведите \"lower\" перед строкой, чтобы перевести сообщение в нижний регистр.\n");
            System.out.print("\tВведите \"quit\" или \"выход\", чтобы прервать соединение.\n");
            String clientMessage = null;

            System.out.print("\nВаше ссобщение:\n\t");
            while ((clientMessage = br.readLine()) != null) {

                out.writeUTF(clientMessage);
                out.flush();
                System.out.println("Отправлено сообщение:\n\t" + clientMessage);

                if (clientMessage.equalsIgnoreCase("выход")) {
                    System.out.println("Соединение закрыто!");
                    break;
                }

                System.out.println("Сервер: \n\t" + in.readUTF() + "\n");
                System.out.print("Ваше ссобщение:\n\t");
            }
        }catch (IOException e){
            System.out.print("Не найден сервер!");
        }
    }
}
