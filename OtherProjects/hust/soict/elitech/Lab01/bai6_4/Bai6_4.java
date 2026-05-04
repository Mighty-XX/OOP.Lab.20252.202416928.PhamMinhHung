package hust.soict.elitech.Lab01.bai6_4;

import java.util.Scanner;
public class Bai6_4 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] full = {"january", "february", "march", "april", "may", "june", "july", "august", "september", "october", "november", "december"};
        String[] abbr = {"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};

        while (true) {
            System.out.print("Enter month: ");
            String sm = sc.next().toLowerCase();
            
            System.out.print("Enter year: ");
            if (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid year.");
                continue;
            }
            int y = sc.nextInt();
            int m = -1;

            for (int i = 0; i < 12; i++) {
                if (sm.equals(full[i]) || sm.equals(abbr[i]) || sm.equals(abbr[i] + ".") || sm.equals(String.valueOf(i + 1))) {
                    m = i + 1;
                    break;
                }
            }

            if (m != -1 && y >= 0) {
                int d;
                if (m == 2) {
                    d = ((y % 4 == 0 && y % 100 != 0) || (y % 400 == 0)) ? 29 : 28;
                } else if (m == 4 || m == 6 || m == 9 || m == 11) {
                    d = 30;
                } else {
                    d = 31;
                }
                System.out.println("Number of days: " + d);
                break;
            } else {
                System.out.println("Invalid input, try again.");
            }
        }
    
    }
    
}

