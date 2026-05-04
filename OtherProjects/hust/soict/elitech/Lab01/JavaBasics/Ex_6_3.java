package hust.soict.elitech.Lab01.JavaBasics;

import java.util.Scanner;
public class Ex_6_3 {
     public static void main(String args[]) {
         Scanner s = new Scanner (System.in);
         System.out.println("Nhap chieu cao: ");
         int h = s.nextInt();
         int tmp = h;
         int tmp1 = 1;
         for (int i=0;i<h;i++){
             // space
             for (int j=0;j<tmp-1;j++){
                 System.out.print(" ");
             }
             // *
             for (int k=0;k<tmp1;k++){
                 System.out.print("*");
             }
             tmp--;
             tmp1+=2;
             System.out.println("");
         }
    }
}

