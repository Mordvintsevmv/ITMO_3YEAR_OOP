package com.company;

public class Bedro_Triangle extends Figure {

    private static double x1;
    private static double y1;

    private static double x2;
    private static double y2;

    private static double x3;
    private static double y3;

    public Bedro_Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
        this.x1 = x1;
        this.y1  = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double dl_r1(){
        return (Math.sqrt( (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)));
    }

    @Override
    public double dl_r2(){
        return (Math.sqrt( (x3-x2)*(x3-x2) + (y3-y2)*(y3-y2)));
    }

    @Override
    public double dl_r3(){
        return (Math.sqrt( (x1-x3)*(x1-x3) + (y1-y3)*(y1-y3)));
    }

    @Override
    public double dl_r4(){
        return 0;
    }

    @Override
    public double perimetr(){
        return dl_r1() + dl_r2() + dl_r3();
    }

    @Override
    public double ploshad(){
        double p = perimetr()/2;
        return Math.sqrt(p * (p-dl_r1()) * (p - dl_r2()) * (p - dl_r3()));
    }

    @Override
    public double h1(){
        return (2 * ploshad())/dl_r1();
    }

    @Override
    public double h2(){
        return (2 * ploshad())/dl_r2();
    }

    @Override
    public double h3(){
        return (2 * ploshad())/dl_r3();
    }

    @Override
    public double h4(){
        return 0;
    }

    @Override
    public double m1(){
        return Math.sqrt(2 * (dl_r2()*dl_r2() + dl_r3()*dl_r3()) - dl_r1()*dl_r1())/2;
    }

    @Override
    public double m2(){
        return Math.sqrt(2 * (dl_r1()*dl_r1() + dl_r3()*dl_r3()) - dl_r2()*dl_r2())/2;
    }

    @Override
    public double m3(){
        return Math.sqrt(2 * (dl_r2()*dl_r2() + dl_r1()*dl_r1()) - dl_r3()*dl_r3())/2;
    }

    @Override
    public double b1(){
        return (Math.sqrt(dl_r3()*dl_r2()*(dl_r1() + dl_r2() + dl_r3())*(dl_r3() + dl_r2() - dl_r1())))/(dl_r2() + dl_r3());
    }

    @Override
    public double b2(){
        return (Math.sqrt(dl_r1()*dl_r3()*(dl_r1() + dl_r2() + dl_r3())*(dl_r3() + dl_r1() - dl_r2())))/(dl_r3() + dl_r1());
    }

    @Override
    public double b3(){
        return (Math.sqrt(dl_r1()*dl_r2()*(dl_r1() + dl_r2() + dl_r3())*(dl_r1() + dl_r2() - dl_r3())))/(dl_r2() + dl_r1());
    }

    public double d_vpis(){
        double p = perimetr()/2;
        return 2* Math.sqrt((p-dl_r1()) * (p - dl_r2()) * (p - dl_r3())/p);
    }

    public double d_opis(){
        double p = perimetr()/2;
        return  (dl_r1()*dl_r2()*dl_r3())/(2*ploshad());
    }

    @Override
    public void printInf(){
        System.out.print("Это равнобедренный треугольник!\n");
        System.out.printf("Длины рёбер:\n");
        System.out.printf("\ta = %.2f;\n", dl_r1());
        System.out.printf("\tb = %.2f;\n", dl_r2());
        System.out.printf("\tc = %.2f.\n", dl_r3());

        System.out.printf("\nПериметр = %.2f;\n", perimetr());
        System.out.printf("Площадь = %.2f;\n", ploshad());

        System.out.printf("\nВысоты:\n");
        System.out.printf("\tК стороне a = %.2f;\n", h1());
        System.out.printf("\tК стороне b = %.2f;\n", h2());
        System.out.printf("\tК стороне c = %.2f.\n", h3());

        System.out.printf("\nМедианы:\n");
        System.out.printf("\tК стороне a = %.2f;\n", m1());
        System.out.printf("\tК стороне b = %.2f;\n", m2());
        System.out.printf("\tК стороне c = %.2f.\n", m3());

        System.out.printf("\nБиссектрисы:\n");
        System.out.printf("\tУгла a = %.2f;\n", b1());
        System.out.printf("\tУгла b = %.2f;\n", b2());
        System.out.printf("\tУгла c = %.2f.\n", b3());

        System.out.printf("\nДиаметры:\n");
        System.out.printf("\tВписанной окружности = %.2f;\n", d_vpis());
        System.out.printf("\tОписанной окружности = %.2f.\n", d_opis());
    }

    @Override
    public String toString(){
        return "\n\n\n!Равнобедренный треугольник! \n\t a = " + dl_r1() + "\n\t b = " + dl_r2() + "\n\t c = " + dl_r3() +"" +
                "\n\t Периметр = " + perimetr() + "\n\t Площадь = " + ploshad() + "\n\tВысоты:" +
                "\n\t\t h1 = " + h1() + "\n\t\t h2 = " + h2() + "\n\t\t h3 = " + h3() + "\n\t Медианы: " +
                "\n\t\t m1 = " + m1() + "\n\t\t m2 = " + m2() + "\n\t\t m3 = " + m3() + "\n\t Биссектрисы: " +
                "\n\t\t b1 = " + b1() + "\n\t\t b2 = " + b2() + "\n\t\t b3 = " + b3() + "\n\t Диаметры: " +
                "\n\t\t Вписанной окружности = " + d_vpis() + "\n\t\t Описанной окружности = " + d_opis();
    }

}
