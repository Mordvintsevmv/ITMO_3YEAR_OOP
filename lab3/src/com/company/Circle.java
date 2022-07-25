package com.company;

public class Circle extends Figure {

    private static double xc;
    private static double yc;

    private static double xo;
    private static double yo;

    public Circle(double xc,double yc,double xo,double yo){
        this.xc = xc;
        this.yc  = yc;
        this.xo = xo;
        this.yo = yo;
    }

    public static double radius(){
        return Math.sqrt( (xo-xc)*(xo-xc) + (yo-yc)*yo-yc);
    }

    public static double diametr(){

         return 2*Math.sqrt( (xo-xc)*(xo-xc) + (yo-yc)*yo-yc);
    }

    @Override
    public double h1(){
        return 0;
    }

    @Override
    public double h2(){
        return 0;
    }

    @Override
    public double h3(){
        return 0;
    }

    @Override
    public double h4(){
        return 0;
    }

    @Override
    public double dl_r1(){
        return 0;
    }

    @Override
    public double dl_r2(){
        return 0;
    }

    @Override
    public double dl_r3(){
        return 0;
    }

    @Override
    public double dl_r4(){
        return 0;
    }

    @Override
    public double m1(){
        return 0;
    }

    @Override
    public double m2(){
        return 0;
    }

    @Override
    public double m3(){
        return 0;
    }

    @Override
    public double b1(){
        return 0;
    }

    @Override
    public double b2(){
        return 0;
    }

    @Override
    public double b3(){
        return 0;
    }

    @Override
    public double ploshad(){
        return Math.PI * radius() * radius();
    }

    @Override
    public double perimetr(){
        return 2 * Math.PI * radius();
    }

    @Override
    public void printInf(){
        System.out.print("Это окружность!\n");
        System.out.printf("Её радиус = %.2f;\n", radius());
        System.out.printf("Её диаметр = %.2f;\n", diametr());
        System.out.printf("Её площадь = %.2f;\n", ploshad());
        System.out.printf("Её периметр = %.2f.\n", perimetr());
    }
    @Override
    public String toString(){
        return "\n\n\n!Окружность!\n \tРадиус = " + radius() + "\n \tДиаметр = " + diametr() + "\n \tПлощадь = " + ploshad() + "\n \tПериметр = " + perimetr();
    }

}
