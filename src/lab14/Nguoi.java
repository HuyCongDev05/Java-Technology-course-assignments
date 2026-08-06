package lab14;

public class Nguoi {
    private final String hoTen;
    private final int tuoi;
    private final String queQuan;
    private final String maSoGV;

    public Nguoi(String hoTen, int tuoi, String queQuan, String maSoGV) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.queQuan = queQuan;
        this.maSoGV = maSoGV;
    }

    public String getMaSoGV() {
        return maSoGV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void hienThi() {
        System.out.println("Mã GV: " + maSoGV + " | Họ tên: " + hoTen + " | Tuổi: " + tuoi + " | Quê quán: " + queQuan);
    }
}