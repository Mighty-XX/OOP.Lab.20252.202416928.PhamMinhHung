import java.util.Scanner;

public class Bai2_2_6_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Giai phuong trinh bac hai: ax^2 + bx + c = 0");
        System.out.print("Nhap a, b, c: ");
        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();

        if (a == 0) {
            // Neu a = 0 thi tro thanh phuong trinh bac nhat bx + c = 0
            if (b == 0) {
                if (c == 0) {
                    System.out.println("Phuong trinh vo so nghiem.");
                } else {
                    System.out.println("Phuong trinh vo nghiem.");
                }
            } else {
                System.out.println("Phuong trinh co nghiem x = " + (-c / b));
            }
        } else {
            // tinh Delta
            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Phuong trinh co 2 nghiem phan biet: x1 = " + x1 + " va x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("Phuong trinh co nghiem kep: x = " + x);
            } else {
                System.out.println("Phuong trinh vo nghiem.");
            }
        }
       
    }
}