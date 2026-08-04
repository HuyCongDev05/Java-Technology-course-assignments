import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double tong = 0;
        for (int i = 1; i <= n; i++) {
            tong = tong + (1.0 / i);
        }
        System.out.println(tong);
        sc.close();
    }
}
