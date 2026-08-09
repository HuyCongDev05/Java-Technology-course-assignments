package com.example._4.model;

public class CBGV extends Nguoi {
    private double luongCung;
    private double luongThuong;
    private double luongPhat;
    private double luongThucLinh;

    public CBGV() {
    }

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

    public double getLuongCung() {
        return luongCung;
    }

    public void setLuongCung(double luongCung) {
        this.luongCung = luongCung;
    }

    public double getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(double luongThuong) {
        this.luongThuong = luongThuong;
    }

    public double getLuongPhat() {
        return luongPhat;
    }

    public void setLuongPhat(double luongPhat) {
        this.luongPhat = luongPhat;
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
