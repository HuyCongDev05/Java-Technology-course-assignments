import java.util.Scanner;

public class Exercise6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double sum = (a * 0.1) + (b * 0.3) + (c * 0.6);
        System.out.printf("%.2f", sum);
        sc.close();
    }
}
