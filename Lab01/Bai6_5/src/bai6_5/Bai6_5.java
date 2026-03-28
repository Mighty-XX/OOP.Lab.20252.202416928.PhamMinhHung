/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai6_5;

/**
 *
 * @author Phạm Minh Hùng
 */
import java.util.Scanner;
import java.util.Arrays;
public class Bai6_5 {

    /**
     * @param args the command line arguments
     */
  
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        double sum = 0;
        double arr[] = new double [n];
        System.out.print("Enter elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
            sum += arr[i];
        }

        Arrays.sort(arr);
     
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (sum / n));
        
        sc.close();
    }
    }
    

