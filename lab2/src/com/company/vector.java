package com.company;

public class vector {
    private double x, y, z;

    public vector(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static void print(vector a){
        System.out.printf("(%.2f, %.2f, %.2f)\n", a.x, a.y, a.z);

    }

    public static double dlina(vector a){
        return Math.sqrt((a.x * a.x) + (a.y * a.y) + (a.z * a.z));
    }

    public static double skproizv(vector a, vector b){
        return ((a.x * b.x) + (a.y * b.y) + (a.z * b.z));
    }

    public static vector vectproizv(vector a, vector b){
        double c_x, c_y, c_z;
        c_x = (a.y * b.z) - (a.z * b.y);
        c_y = (a.z * b.x) - (a.x * b.z);
        c_z = (a.x * b.y) - (a.y * b.x);
        vector v = new vector(c_x, c_y, c_z);
        return v;
    }

    public static double vectcos(vector a, vector b){
        return skproizv(a,b) / (dlina(a) * dlina(b));
    }

    public static double vectgrad(vector a, vector b){
        return vectcos(a,b) * 180 / Math.PI;
    }

    public static vector vectsum(vector a, vector b){
        double c_x, c_y, c_z;
        c_x = (a.x) + (b.x);
        c_y = (a.y) + (b.y);
        c_z = (a.z) + (b.z);
        vector v = new vector(c_x, c_y, c_z);
        return v;
    }

    public static vector vectrazn(vector a, vector b){
        double c_x, c_y, c_z;
        c_x = (a.x) - (b.x);
        c_y = (a.y) - (b.y);
        c_z = (a.z) - (b.z);
        vector v = new vector(c_x, c_y, c_z);
        return v;
    }

    public static vector[] vectmass(int n){
        vector[] vect_mass = new vector[n];
        for (int i = 0; i < n; i++){
            vect_mass[i] = new vector((Math.random() * 10), (Math.random() * 10),(Math.random() * 10));
        }
        return vect_mass;
    }
}
