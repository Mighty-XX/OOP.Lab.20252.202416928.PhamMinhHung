import java.util.Scanner;
public class Bai2_2_5 {
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
		double a = s.nextDouble();
		double b = s.nextDouble();
		System.out.println("Nhap dau");
		char x = s.next().charAt(0);
		switch (x){
			case '+':
				System.out.println("Ket qua phep cong: " + (a+b));
				break;
			case '-':
				System.out.println("Ket qua phep tru: " + (a-b));
				break;
			case '*':
				System.out.println("Ket qua phep nhan: " + (a*b));
				break;
			case '/':
				if (b==0){
					 System.out.println("Loi: Khong the chia cho 0!");
				}
				else {
				System.out.println("Ket qua phep chia: " + (a/b));
				break;	
				}
			default:
				System.out.println("Khong nhap dau hop le");
 		}
	}
}