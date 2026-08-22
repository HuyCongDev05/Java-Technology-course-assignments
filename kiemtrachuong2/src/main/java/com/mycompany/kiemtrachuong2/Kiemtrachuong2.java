package com.mycompany.kiemtrachuong2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Kiemtrachuong2 extends JFrame {

    private JTextField txtMaSV, txtHoTen, txtNgaySinh, txtSoHP;
    private JPanel panelDiem;
    private JTextField[] txtTenHP, txtCC, txtGK, txtCK;
    private final JTable table;
    private DefaultTableModel tableModel;
    private JButton btnTaoForm, btnTinhDiem, btnXoaHet;

    public Kiemtrachuong2() {
        setTitle("Quan Ly Diem Sinh Vien - Kiem Tra Chuong 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900, 700);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelTop = new JPanel(new GridBagLayout());
        panelTop.setBorder(BorderFactory.createTitledBorder("Thong tin sinh vien"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        panelTop.add(new JLabel("Ma sinh vien:"), gbc);
        gbc.gridx = 1;
        txtMaSV = new JTextField(12);
        panelTop.add(txtMaSV, gbc);

        gbc.gridx = 2; gbc.gridy = 0;
        panelTop.add(new JLabel("Ho va ten:"), gbc);
        gbc.gridx = 3;
        txtHoTen = new JTextField(15);
        panelTop.add(txtHoTen, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        panelTop.add(new JLabel("Ngay sinh (dd/MM/yyyy):"), gbc);
        gbc.gridx = 1;
        txtNgaySinh = new JTextField(12);
        panelTop.add(txtNgaySinh, gbc);

        gbc.gridx = 2; gbc.gridy = 1;
        panelTop.add(new JLabel("So hoc phan (n):"), gbc);
        gbc.gridx = 3;
        txtSoHP = new JTextField(5);
        panelTop.add(txtSoHP, gbc);

        gbc.gridx = 4; gbc.gridy = 1;
        btnTaoForm = new JButton("Tao form nhap diem");
        panelTop.add(btnTaoForm, gbc);

        add(panelTop, BorderLayout.NORTH);

        panelDiem = new JPanel();
        panelDiem.setLayout(new BoxLayout(panelDiem, BoxLayout.Y_AXIS));
        panelDiem.setBorder(BorderFactory.createTitledBorder("Nhap diem cac hoc phan"));

        JScrollPane scrollDiem = new JScrollPane(panelDiem);
        add(scrollDiem, BorderLayout.CENTER);

        JPanel panelBottom = new JPanel(new BorderLayout(5, 5));

        JPanel panelBtn = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        btnTinhDiem = new JButton("Tinh diem & Hien thi");

        btnXoaHet = new JButton("Xoa tat ca");

        panelBtn.add(btnTinhDiem);
        panelBtn.add(btnXoaHet);
        panelBottom.add(panelBtn, BorderLayout.NORTH);

        String[] columns = {"Ho va Ten", "Ngay Sinh", "Ten Hoc Phan", "Diem CC", "Diem GK", "Diem CK", "Tong Ket", "Xep Loai"};
        tableModel = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };
        table = new JTable(tableModel);

        JScrollPane scrollTable = new JScrollPane(table);
        scrollTable.setBorder(BorderFactory.createTitledBorder("Ket qua"));
        panelBottom.add(scrollTable, BorderLayout.CENTER);

        add(panelBottom, BorderLayout.SOUTH);

        btnTaoForm.addActionListener(e -> taoFormNhapDiem());
        btnTinhDiem.addActionListener(e -> tinhVaHienThiDiem());
        btnXoaHet.addActionListener(e -> xoaTatCa());
    }

    private void taoFormNhapDiem() {
        String soHPStr = txtSoHP.getText().trim();
        if (soHPStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so hoc phan!", "Loi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int n;
        try {
            n = Integer.parseInt(soHPStr);
            if (n <= 0) throw new NumberFormatException();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "So hoc phan phai la so nguyen duong!", "Loi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        panelDiem.removeAll();

        txtTenHP = new JTextField[n];
        txtCC    = new JTextField[n];
        txtGK    = new JTextField[n];
        txtCK    = new JTextField[n];

        JPanel panelHeader = new JPanel(new GridLayout(1, 5, 5, 5));
        panelHeader.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        panelHeader.add(new JLabel("STT", SwingConstants.CENTER));
        panelHeader.add(new JLabel("Ten hoc phan", SwingConstants.CENTER));
        panelHeader.add(new JLabel("Diem CC (0-10)", SwingConstants.CENTER));
        panelHeader.add(new JLabel("Diem GK (0-10)", SwingConstants.CENTER));
        panelHeader.add(new JLabel("Diem CK (0-10)", SwingConstants.CENTER));
        panelDiem.add(panelHeader);

        for (int i = 0; i < n; i++) {
            JPanel row = new JPanel(new GridLayout(1, 5, 5, 5));
            row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
            row.setPreferredSize(new Dimension(0, 50));

            txtTenHP[i] = new JTextField("Hoc phan " + (i + 1));
            txtCC[i]    = new JTextField();
            txtGK[i]    = new JTextField();
            txtCK[i]    = new JTextField();

            row.add(new JLabel("  " + (i + 1) + ".", SwingConstants.CENTER));
            row.add(txtTenHP[i]);
            row.add(txtCC[i]);
            row.add(txtGK[i]);
            row.add(txtCK[i]);

            panelDiem.add(row);
            panelDiem.add(Box.createVerticalStrut(3));
        }

        panelDiem.revalidate();
        panelDiem.repaint();
    }

    private boolean kiemTraDiem(double diem) {
        return diem >= 0 && diem <= 10;
    }

    private double tinhTongKet(double cc, double gk, double ck) {
        return cc * 0.1 + gk * 0.3 + ck * 0.6;
    }

    private String xepLoai(double tongKet) {
        if (tongKet >= 8.5) return "A";
        if (tongKet >= 7.0) return "B";
        if (tongKet >= 5.5) return "C";
        if (tongKet >= 4.0) return "D";
        return "F";
    }

    private double docVaKiemTraDiem(JTextField field, String tenHocPhan, String loaiDiem) {
        while (true) {
            String s = field.getText().trim();
            try {
                double d = Double.parseDouble(s);
                if (!kiemTraDiem(d)) {
                    String nhapMoi = JOptionPane.showInputDialog(
                            this,
                            "Diem " + loaiDiem + " cua '" + tenHocPhan + "' = " + d
                                    + " khong hop le!\nVui long nhap lai (0 - 10):",
                            "Diem khong hop le",
                            JOptionPane.WARNING_MESSAGE
                    );
                    if (nhapMoi == null) return -1;
                    field.setText(nhapMoi.trim());
                } else {
                    return d;
                }
            } catch (NumberFormatException ex) {
                String nhapMoi = JOptionPane.showInputDialog(
                        this,
                        "Diem " + loaiDiem + " cua '" + tenHocPhan + "' khong phai so!\nVui long nhap lai (0 - 10):",
                        "Diem khong hop le",
                        JOptionPane.WARNING_MESSAGE
                );
                if (nhapMoi == null) return -1;
                field.setText(nhapMoi.trim());
            }
        }
    }

    private void tinhVaHienThiDiem() {
        String hoTen    = txtHoTen.getText().trim();
        String ngaySinh = txtNgaySinh.getText().trim();

        if (hoTen.isEmpty() || ngaySinh.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui long nhap ho ten va ngay sinh sinh vien!", "Loi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (txtTenHP == null || txtTenHP.length == 0) {
            JOptionPane.showMessageDialog(this, "Vui long nhap so hoc phan va bam 'Tao form nhap diem'!", "Loi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        tableModel.setRowCount(0);

        int n = txtTenHP.length;
        for (int i = 0; i < n; i++) {
            String tenHP = txtTenHP[i].getText().trim();
            if (tenHP.isEmpty()) tenHP = "Hoc phan " + (i + 1);

            double cc = docVaKiemTraDiem(txtCC[i], tenHP, "Chuyen Can");
            if (cc < 0) return;

            double gk = docVaKiemTraDiem(txtGK[i], tenHP, "Giua Ky");
            if (gk < 0) return;

            double ck = docVaKiemTraDiem(txtCK[i], tenHP, "Cuoi Ky");
            if (ck < 0) return;

            double tongKet = tinhTongKet(cc, gk, ck);
            String loai    = xepLoai(tongKet);

            tableModel.addRow(new Object[]{
                hoTen,
                ngaySinh,
                tenHP,
                String.format("%.1f", cc),
                String.format("%.1f", gk),
                String.format("%.1f", ck),
                String.format("%.2f", tongKet),
                loai
            });
        }

        JOptionPane.showMessageDialog(this, "Tinh diem thanh cong! Xem ket qua trong bang.", "Thanh cong", JOptionPane.INFORMATION_MESSAGE);
    }

    private void xoaTatCa() {
        txtMaSV.setText("");
        txtHoTen.setText("");
        txtNgaySinh.setText("");
        txtSoHP.setText("");
        panelDiem.removeAll();
        panelDiem.revalidate();
        panelDiem.repaint();
        tableModel.setRowCount(0);
        txtTenHP = null;
        txtCC    = null;
        txtGK    = null;
        txtCK    = null;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Kiemtrachuong2 frame = new Kiemtrachuong2();
            frame.setVisible(true);
        });
    }
}
