package com.company;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
	vector a = new vector(5,10,15);
	vector b = new vector(-6,7,9);

	System.out.printf("Вектор a: ");
	vector.print(a);
	System.out.printf("Вектор b: ");
	vector.print(b);
	System.out.printf("\n");

	System.out.printf("Длина вектора a: %.2f\n", vector.dlina(a));
	System.out.printf("Длина вектора b: %.2f\n", vector.dlina(b));

	System.out.printf("Скалярное произведение a и b: %.2f\n", vector.skproizv(a,b));

	System.out.printf("Векторное произведение a и b: ");
	vector.print(vector.vectproizv(a,b));

	System.out.printf("\nКосинус угла между a и b: %.2f\n", vector.vectcos(a,b));

	System.out.printf("Угол между a и b: %.2f°\n", vector.vectgrad(a,b));

	System.out.printf("\nСумма a и b: ", vector.vectsum(a,b));
	vector.print(vector.vectsum(a,b));

	System.out.printf("Разность a и b: ", vector.vectrazn(a,b));
	vector.print(vector.vectrazn(a,b));
	Scanner scanner = new Scanner(System.in);
	System.out.printf("\nЧисло векторов: \n");
	int n = scanner.nextInt();
	vector[] vect_mass = new vector[n];
	vect_mass = vector.vectmass(n);
	for (int i =  0; i < n; i++){
	    System.out.printf("[%d] - ",i);
	    vector.print(vect_mass[i]);
    }

    }
}
