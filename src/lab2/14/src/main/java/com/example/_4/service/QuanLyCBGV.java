package com.example._4.service;

import com.example._4.model.CBGV;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuanLyCBGV {
    private final List<CBGV> dsCBGV = new ArrayList<>();

    public void them(CBGV cbgv) {
        dsCBGV.add(cbgv);
    }

    public boolean xoa(String maSoGV) {
        return dsCBGV.removeIf(c -> c.getMaSoGV() != null && c.getMaSoGV().equalsIgnoreCase(maSoGV));
    }

    public List<CBGV> getDsCBGV() {
        return dsCBGV;
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
