package lab2.Exercise14;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        QuanLyCBGV ql = new QuanLyCBGV();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Thêm giảng viên");
            System.out.println("2. Hiển thị danh sách giảng viên");
            System.out.println("3. Xóa giảng viên");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Nhập họ tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập tuổi: ");
                    int tuoi = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập quê quán: ");
                    String queQuan = scanner.nextLine();
                    System.out.print("Nhập mã số giáo viên: ");
                    String msgv = scanner.nextLine();
                    System.out.print("Nhập lương cứng: ");
                    double luongCung = scanner.nextDouble();
                    System.out.print("Nhập lương thưởng: ");
                    double luongThuong = scanner.nextDouble();
                    System.out.print("Nhập tiền phạt: ");
                    double tienPhat = scanner.nextDouble();

                    CBGV gv = new CBGV(hoTen, tuoi, queQuan, msgv, luongCung, luongThuong, tienPhat);
                    ql.them(gv);
                    System.out.println("Đã thêm giảng viên.");
                    break;
                case 2:
                    System.out.println("\nDanh sách giảng viên:");
                    ql.hienThiDanhSach();
                    break;
                case 3:
                    System.out.print("Nhập mã số giáo viên cần xóa: ");
                    String maCanXoa = scanner.nextLine();
                    if (ql.xoa(maCanXoa)) {
                        System.out.println("Đã xóa giảng viên.");
                    } else {
                        System.out.println("Không tìm thấy giảng viên.");
                    }
                    break;
                case 0:
                    System.out.println("Đã thoát chương trình.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}