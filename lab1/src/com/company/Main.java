package com.company;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static boolean isPrime(int n) {
        for (int i = 2; i <= n / 2; i++) {
            double temp = n % i;
            if (temp == 0) {
                return false;
            }
        }
        return true;
    }

    public static int fibonachi(int a, int b) {
        return a+b;
    }

    public static void main(String[] args) {

        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;
        int sum = 0;

        System.out.print("Введите размер массива: ");

        Scanner scanner = new Scanner(System.in);
        int n_mass = scanner.nextInt();

        System.out.printf("\nПолучен массив:\n");

        int mass[] = new int[n_mass];
        for (int i = 0; i < n_mass; i++) {
            mass[i] = (int) (Math.random() * 1000);
            System.out.printf("mass[%d] = %d\n", i, mass[i]);
        }


        int temp_m;
        for (int i = 0; i < n_mass-1; i++) {
            for (int j = 0; j < n_mass-i-1; j++){
                if (mass[j] > mass[j+1]) {
                        temp_m = mass[j];
                        mass[j] = mass[j+1];
                        mass[j+1] = temp_m;
                }
            }
        }

        System.out.printf("\nОтсортированный массив (Пузырёк):\n");

        for (int i = 0; i < n_mass; i++) {
            System.out.printf("mass[%d] = %d\n", i, mass[i]);
        }

        for (int i = 0; i < n_mass; i++) {
            if (mass[i] > maxValue) {
                maxValue = mass[i];
            }
            ;
            if (mass[i] < minValue) {
                minValue = mass[i];
            }
            ;
            sum += mass[i];
        }

        System.out.printf("\n#Данные по массиву#\nНаибольшее число: %d\n", maxValue);
        System.out.printf("Наименьшее число: %d\n", minValue);
        System.out.printf("Среднее значение: %.2f\n", (float) sum / n_mass);

        System.out.print("\nЧАСТЬ II\n\nВведите любое число: ");
        int n = scanner.nextInt();

        System.out.print("\nПростые числа от 0 до n:\n0");
        for (int i = 1; i < n+1; i++) {
            if (isPrime(i)) {
                System.out.printf(", %d", i);
            }
        }

        System.out.print("\n\nn Чисел Фибоначчи:\n0, 1");
        int a = 0;
        int b = 1;
        int temp_f;
        for (int i = 0; i < n-2; i++) {
                System.out.printf(", %d", fibonachi(a,b));
                temp_f = b;
                b = fibonachi(a,b);
                a = temp_f;

        }
    }
}
