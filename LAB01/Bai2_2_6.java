import java.util.Scanner;

public class Bai2_2_6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Giai he phuong trinh: ");
        System.out.println("a11*x1 + a12*x2 = b1");
        System.out.println("a21*x1 + a22*x2 = b2");

        System.out.print("Nhap a11, a12, b1: ");
        double a11 = s.nextDouble();
        double a12 = s.nextDouble();
        double b1 = s.nextDouble();

        System.out.print("Nhap a21, a22, b2: ");
        double a21 = s.nextDouble();
        double a22 = s.nextDouble();
        double b2 = s.nextDouble();

        // tinh cac dinh thuc D, D1, D2
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("He co nghiem duy nhat: x1 = " + x1 + ", x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("He phuong trinh co vo so nghiem.");
            } else {
                System.out.println("He phuong trinh vo nghiem.");
            }
        }
       
    }
}