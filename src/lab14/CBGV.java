package lab14;

public class CBGV extends Nguoi {
    private final double luongCung;
    private final double luongThuong;
    private final double luongPhat;
    private double luongThucLinh;

    public CBGV(String hoTen, int tuoi, String queQuan, String maSoGV, double luongCung, double luongThuong, double luongPhat) {
        super(hoTen, tuoi, queQuan, maSoGV);
        this.luongCung = luongCung;
        this.luongThuong = luongThuong;
        this.luongPhat = luongPhat;
        this.luongThucLinh = tinhLuong();
    }

    public double tinhLuong() {
        this.luongThucLinh = luongCung + luongThuong - luongPhat;
        return this.luongThucLinh;
    }

    public double getLuongThucLinh() {
        return tinhLuong();
    }

    @Override
    public void hienThi() {
        super.hienThi();
        System.out.println("Lương cứng: " + luongCung + " | Thưởng: " + luongThuong + " | Phạt: " + luongPhat + " | Thực lĩnh: " + tinhLuong());
    }
}