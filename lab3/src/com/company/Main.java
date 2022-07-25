package com.company;
import java.awt.*;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static int checkTriangle(double[] x, double[] y){

        //1 - равносторонний
        //2 - равнобедренный
        //3 - прямоугольный
        //0 - любой другой

        Triangle t_test = new Triangle(x[0],y[0],x[1],y[1],x[2],y[2]);

        double xv0 = x[1]-x[0];
        double yv0 = y[1]-y[0];

        double xv1 = x[2]-x[1];
        double yv1 = y[2]-y[1];

        double xv2 = x[2]-x[0];
        double yv2 = y[2]-y[0];

        if ((t_test.dl_r1() == t_test.dl_r1()) && (t_test.dl_r2() == t_test.dl_r3()) && (t_test.dl_r1() == t_test.dl_r3()) ){
            return 1;
        }
        else if ((t_test.dl_r1() == t_test.dl_r2()) || (t_test.dl_r2() == t_test.dl_r3()) || (t_test.dl_r1() == t_test.dl_r3()) ){
            return 2;
        }
        else if ( ((xv0 * xv1) + (yv0 * yv1) == 0) || ((xv2 * xv1) + (yv2 * yv1) == 0) || ((xv0 * xv2) + (yv0 * yv2) == 0)){
            return 3;
        }
        return 0;
    }

    public static int checkRect(double[] x, double[] y){

        //1 - квадрат
        //2 - ромб
        //3 - прямоугольник
        //4 - параллелограмм
        //5 - трапеция
        //0 - любой другой

       double a =  (Math.sqrt( (x[1]-x[0])*(x[1]-x[0]) + (y[1]-y[0])*(y[1]-y[0])));
       double b =  (Math.sqrt( (x[1]-x[2])*(x[1]-x[2]) + (y[1]-y[2])*(y[1]-y[2])));
       double c =  (Math.sqrt( (x[3]-x[2])*(x[3]-x[2]) + (y[3]-y[2])*(y[3]-y[2])));
       double d =  (Math.sqrt( (x[3]-x[0])*(x[3]-x[0]) + (y[3]-y[0])*(y[3]-y[0])));

        double diag1 =  (Math.sqrt( (x[0]-x[2])*(x[0]-x[2]) + (y[0]-y[2])*(y[0]-y[2])));
        double diag2 =  (Math.sqrt( (x[3]-x[1])*(x[3]-x[1]) + (y[3]-y[1])*(y[3]-y[1])));

       if ((a==b) && (b==c) && (c==d) && (d==a)){
            if (diag1==diag2){
                return 1;
            }
            else {
                return 2;
            }
       }

       else if ((a==c)&&(b==d)){
           if (diag1==diag2){
               return 3;
           }
           else {
               return 4;
           }
       }

       else if ( ( ((y[1]-y[0])/(x[1]-x[0])) == ((y[3]-y[2])/(x[3]-x[2])) ) || ( ((y[3]-y[0])/(x[3]-x[0]))==((y[2]-y[1])/(x[2]-x[1])) ) ){
           return 5;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {



        Scanner scanner = new Scanner(System.in);
        FileWriter writer = new FileWriter("text.txt");
        int x = 0;
        int y = 0;
        int obj_type = 0;
        double [] xt = new double[3];
        double [] yt = new double[3];
        double [] xr = new double[4];
        double [] yr = new double[4];

        System.out.print("Тест интерфейса Comparable (сравнение площадей):\n");

        System.out.print("\n1 - первый объект больше второго\n");
        System.out.print("0 - объекты равны\n");
        System.out.print("-1 - первый объект меньше второго\n\n");

        System.out.print("Треугольник A(0,0) B(0,5) C(5,0)\n");
        Triangle t1 = new Triangle(0,0,0,5,5,0);

        System.out.print("Квадрат A(0,0) B(0,5) C(5,5) D(5,0)\n");
        Square s1 = new Square(0,0,0,5,5,5,5,0);
        System.out.printf("Ответ: %d", t1.compareTo(s1));

        System.out.print("\n\nКруг O(0,0) A(7,9) \n");
        Circle c1 = new Circle(0,0,7,9);

        System.out.print("Трапеция A(0,0) B(2,4) C(5,4) D(7,0)\n");
        Trapeze tr1 = new Trapeze(0,0,2,4,5,4,7,0);
        System.out.printf("Ответ: %d", c1.compareTo(tr1));

        System.out.print("\n\nТест интерфейса Comparator (сравнение площадей):\n");
        FigureComparator myComp = new FigureComparator();

        System.out.print("\n1 - первый объект больше второго\n");
        System.out.print("0 - объекты равны\n");
        System.out.print("-1 - первый объект меньше второго\n\n");

        System.out.print("Треугольник A(0,0) B(0,5) C(5,0)\n");
        System.out.print("Квадрат A(0,0) B(0,5) C(5,5) D(5,0)\n");
        System.out.printf("Ответ: %d", myComp.compare(t1,s1));

        System.out.print("\n\nКруг O(0,0) A(7,9) \n");
        System.out.print("Трапеция A(0,0) B(2,4) C(5,4) D(7,0)\n");
        System.out.printf("Ответ: %d", myComp.compare(c1,tr1));

        while (true) {
            System.out.print("\n\nКакую фигуру вы хотите измерить?");
            System.out.print("\n1 - Окружность");
            System.out.print("\n2 - Треугольник");
            System.out.print("\n3 - Четырёхугольник");
            System.out.print("\n0 - Выйти из режима измерения");
            System.out.print("\nВыберите: ");
            obj_type = scanner.nextInt();
            if (obj_type == 0) break;

            switch (obj_type) {

                case (1):

                    System.out.print("\nКоординаты центра:\n");
                    System.out.print("\nxc: ");
                    double xc = scanner.nextDouble();
                    System.out.print("yc: ");
                    double yc = scanner.nextDouble();

                    System.out.print("\nКоординаты любой точки  на окружности:\n");
                    System.out.print("\nxo: ");
                    double xo = scanner.nextDouble();
                    System.out.print("yo: ");
                    double yo = scanner.nextDouble();

                    Circle c = new Circle(xc,yc,xo,yo);
                    c.printInf();
                    writer.write(c.toString());
                    break;

                case (2):
                    System.out.print("\nВведите координаты точек по часовой стрелке:\n");
                    for (int i = 0; i<3; i++){
                        System.out.printf("\nx[%d]: ", i);
                        xt[i] = scanner.nextDouble();
                        System.out.printf("y[%d]: ", i);
                        yt[i] = scanner.nextDouble();
                }
                    switch (checkTriangle(xt,yt)) {
                        case (0):
                            Triangle t = new Triangle(xt[0], yt[0], xt[1], yt[1], xt[2], yt[2]);
                            t.printInf();
                            writer.write(t.toString());
                            break;

                        case (1):
                            Equal_Triangle t_ravn = new Equal_Triangle(xt[0], yt[0], xt[1], yt[1], xt[2], yt[2]);
                            t_ravn.printInf();
                            writer.write(t_ravn.toString());
                            break;

                        case (2):
                            Bedro_Triangle t_bedr = new Bedro_Triangle(xt[0], yt[0], xt[1], yt[1], xt[2], yt[2]);
                            t_bedr.printInf();
                            writer.write(t_bedr.toString());
                            break;

                        case (3):
                            Right_Triangle t_pr = new Right_Triangle(xt[0], yt[0], xt[1], yt[1], xt[2], yt[2]);
                            t_pr.printInf();
                            writer.write(t_pr.toString());
                            break;

                        default:
                            System.out.print("\nНе может такого быть!");
                            break;

                    } break;

                case (3):
                    System.out.print("\nВведите координаты точек по часовой стрелке:\n");
                    for (int i = 0; i<4; i++){
                        System.out.printf("\nx[%d]: ", i);
                        xr[i] = scanner.nextDouble();
                        System.out.printf("y[%d]: ", i);
                        yr[i] = scanner.nextDouble();
                    }

                    switch (checkRect(xr,yr)){
                        case (0):
                            FourUgl f = new FourUgl(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            f.printInf();
                            writer.write(f.toString());
                            break;

                        case (1):
                            Square s = new Square(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            s.printInf();
                            writer.write(s.toString());
                            break;

                        case (2):
                            Rhombus r = new Rhombus(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            r.printInf();
                            writer.write(r.toString());
                            break;

                        case (3):
                            Rectangle rect = new Rectangle(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            rect.printInf();
                            writer.write(rect.toString());
                            break;

                        case (4):
                            Parallelogram p = new Parallelogram(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            p.printInf();
                            writer.write(p.toString());
                            break;

                        case (5):
                            Trapeze tr = new Trapeze(xr[0],yr[0],xr[1],yr[1],xr[2],yr[2],xr[3],yr[3]);
                            tr.printInf();
                            writer.write(tr.toString());
                            break;

                        default:
                            System.out.print("\nНе может такого быть!");
                            break;
                    }
                    break;


                default:
                    System.out.print("\nВы ввели что-то не то!");
                    break;
            }
        }
        writer.close();
        System.out.print("\nВсе измерения записаны в файл!");
    }
}
