package lab2.Exercise14;

import java.util.ArrayList;
import java.util.List;

public class QuanLyCBGV {
    private final List<CBGV> dsCBGV = new ArrayList<>();

    public void them(CBGV cbgv) {
        dsCBGV.add(cbgv);
    }

    public boolean xoa(String maSoGV) {
        return dsCBGV.removeIf(c -> c.getMaSoGV().equalsIgnoreCase(maSoGV));
    }

    public void hienThiDanhSach() {
        if (dsCBGV.isEmpty()) {
            System.out.println("Danh sách trống.");
            return;
        }
        for (CBGV cbgv : dsCBGV) {
            cbgv.hienThi();
        }
    }
}