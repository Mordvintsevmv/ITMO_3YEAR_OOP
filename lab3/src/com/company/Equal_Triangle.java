package com.company;

public class Equal_Triangle extends Figure{

    private static double x1;
    private static double y1;

    private static double x2;
    private static double y2;

    private static double x3;
    private static double y3;

    public Equal_Triangle(double x1,double y1,double x2,double y2,double x3,double y3){
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
        return dl_r1();
    }

    @Override
    public double dl_r3(){
        return dl_r1();
    }

    @Override
    public double dl_r4(){
        return 0;
    }

    @Override
    public double perimetr(){
        return dl_r1()*3;
    }

    @Override
    public double ploshad(){
        return Math.pow(dl_r1(),2) * Math.sqrt(3) / 4;
    }

    @Override
    public double h1(){
        return dl_r1()* Math.sqrt(3) / 2;
    }

    @Override
    public double h2(){
        return h1();
    }

    @Override
    public double h3(){
        return h1();
    }

    @Override
    public double h4(){
        return 0;
    }

    @Override
    public double m1(){
        return h1();
    }

    @Override
    public double m2(){
        return h1();
    }

    @Override
    public double m3(){
        return h1();
    }

    @Override
    public double b1(){
        return h1();
    }

    @Override
    public double b2(){
        return h1();
    }

    @Override
    public double b3(){
        return h1();
    }

    public double d_vpis(){
        return dl_r1() / (2 * Math.sqrt(3));
    }

    public double d_opis(){
        return dl_r1() / (Math.sqrt(3));
    }

    @Override
    public void printInf(){
        System.out.print("Это равносторонний треугольник!\n");
        System.out.printf("Длины рёбер:\n");
        System.out.printf("\ta = %.2f;\n", dl_r1());

        System.out.printf("\nПериметр = %.2f;\n", perimetr());
        System.out.printf("Площадь = %.2f;\n", ploshad());

        System.out.printf("\nВысота, медиана и биссектриса = %.2f;\\n", h1());

        System.out.printf("\nДиаметры:\n");
        System.out.printf("\tВписанной окружности = %.2f;\n", d_vpis());
        System.out.printf("\tОписанной окружности = %.2f.\n", d_opis());
    }

    @Override
    public String toString(){
        return "\n\n\n!Равносторонний треугольник! \n\t a = " + dl_r1() + "\n\t b = " + dl_r2() + "\n\t c = " + dl_r3() +"" +
                "\n\t Периметр = " + perimetr() + "\n\t Площадь = " + ploshad() + "\n\tВысоты:" +
                "\n\t\t h1 = " + h1() + "\n\t\t h2 = " + h2() + "\n\t\t h3 = " + h3() + "\n\t Медианы: " +
                "\n\t\t m1 = " + m1() + "\n\t\t m2 = " + m2() + "\n\t\t m3 = " + m3() + "\n\t Биссектрисы: " +
                "\n\t\t b1 = " + b1() + "\n\t\t b2 = " + b2() + "\n\t\t b3 = " + b3() + "\n\t Диаметры: " +
                "\n\t\t Вписанной окружности = " + d_vpis() + "\n\t\t Описанной окружности = " + d_opis();
    }

}
