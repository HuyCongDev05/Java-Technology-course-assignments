package lab2;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập mã sinh viên: ");
        String maSV = sc.nextLine();

        System.out.print("Nhập họ tên: ");
        String hoTen = sc.nextLine();

        double diemChuyenCan = nhapDiem(sc, "điểm chuyên cần");
        double diemGiuaKy = nhapDiem(sc, "điểm giữa kỳ");
        double diemCuoiKy = nhapDiem(sc, "điểm cuối kỳ");

        double diemTongKet = (diemChuyenCan * 0.1) + (diemGiuaKy * 0.3) + (diemCuoiKy * 0.6);

        String xepLoai;
        if (diemTongKet >= 8.5) {
            xepLoai = "A";
        } else if (diemTongKet >= 7.0) {
            xepLoai = "B";
        } else if (diemTongKet >= 5.5) {
            xepLoai = "C";
        } else if (diemTongKet >= 4.0) {
            xepLoai = "D";
        } else {
            xepLoai = "F";
        }

        System.out.println("\n--- KẾT QUẢ ---");
        System.out.printf("%s - %s - %.2f - %s\n", maSV, hoTen, diemTongKet, xepLoai);

        sc.close();
    }

    private static double nhapDiem(Scanner sc, String tenDiem) {
        double diem;
        while (true) {
            System.out.print("Nhập " + tenDiem + ": ");
            if (sc.hasNextDouble()) {
                diem = sc.nextDouble();
                if (diem >= 0 && diem <= 10) {
                    break;
                } else {
                    System.out.println("Điểm không hợp lệ! (Phải từ 0 đến 10). Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Dữ liệu không hợp lệ! Vui lòng nhập số.");
                sc.next();
            }
        }
        return diem;
    }
}


