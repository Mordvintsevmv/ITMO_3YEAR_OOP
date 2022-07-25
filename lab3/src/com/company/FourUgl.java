package com.company;

public class FourUgl extends Figure{

    private static double x0;
    private static double y0;

    private static double x1;
    private static double y1;

    private static double x2;
    private static double y2;

    private static double x3;
    private static double y3;

    public FourUgl(double x0,double y0,double x1,double y1,double x2,double y2,double x3,double y3){
        this.x0 = x0;
        this.y0  = x0;
        this.x1 = x1;
        this.y1  = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    @Override
    public double dl_r1(){
        return (Math.sqrt( (x1-x0)*(x1-x0) + (y1-y0)*(y1-y0)));
    }

    @Override
    public double dl_r2(){
        return (Math.sqrt( (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
    }

    @Override
    public double dl_r3(){
        return (Math.sqrt( (x3-x2)*(x3-x2) + (y3-y2)*(y3-y2)));
    }

    @Override
    public double dl_r4(){
        return (Math.sqrt( (x3-x0)*(x3-x0) + (y3-y0)*(y3-y0)));
    }

    @Override
    public double perimetr(){
        return dl_r1() + dl_r2() + dl_r3() + dl_r4();
    }

    @Override
    public double ploshad(){
        double p = perimetr()/2;
        return Math.sqrt((p-dl_r1())*(p-dl_r2())*(p-dl_r3())*(p-dl_r4()));
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
    public void printInf(){
        System.out.print("Это четырёхугольник!\n");
        System.out.printf("Длины рёбер:\n");
        System.out.printf("\ta = %.2f;\n", dl_r1());
        System.out.printf("\tb = %.2f;\n", dl_r2());
        System.out.printf("\tc = %.2f.\n", dl_r3());
        System.out.printf("\td = %.2f.\n", dl_r4());

        System.out.printf("\nПериметр = %.2f;\n", perimetr());
        System.out.printf("Площадь = %.2f;\n", ploshad());


    }

    @Override
    public String toString(){
        return "\n\n\n!Четырёхугольник! \n\t a = " + dl_r1() + "\n\t b = " + dl_r2() + "\n\t c = " + dl_r3() + "\n\t в = " + dl_r4() +
                "\n\t Периметр = " + perimetr() + "\n\t Площадь = " + ploshad();
    }
}
