package lab1;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dem = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                dem = dem + 1;
            }
        }
        if (dem == 2) {
            System.out.println(n + " la so nguyen to");
        } else {
            System.out.println(n + " khong phai so nguyen to");
        }
        sc.close();
    }
}
