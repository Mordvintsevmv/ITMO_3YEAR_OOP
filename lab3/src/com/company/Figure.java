package com.company;

public abstract class Figure implements Comparable<Figure> {

    public int compareTo(Figure f)
    {
        if (this.ploshad() == f.ploshad()) {
            return 0;
        } else if (this.ploshad() < f.ploshad()) {
            return -1;
        } else {
            return 1;
        }
    }

    public abstract double perimetr();

    public abstract double ploshad();

    public abstract double h1();

    public abstract double h2();

    public abstract double h3();

    public abstract double h4();

    public abstract double dl_r1();

    public abstract double dl_r2();

    public abstract double dl_r3();

    public abstract double dl_r4();

    public abstract double m1();

    public abstract double m2();

    public abstract double m3();

    public abstract double b1();

    public abstract double b2();


    public abstract double b3();

    public abstract void printInf();

    public abstract String toString();
}
