package com.mycompany.lab4;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.util.concurrent.ExecutionException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

/**
 * Bài 3: Tính tổng các số nguyên tố nhỏ hơn N bằng SwingWorker
 */
public class Exercise3 extends JFrame {

    private JTextField txtN;
    private JButton btnCalculate;
    private JLabel lblResult;
    private JTextField txtProgress;

    public Exercise3() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Tính tổng số nguyên tố nhỏ hơn N");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 220);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 5, 5));

        // Nhập N
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(new JLabel("Nhập N:"));
        txtN = new JTextField(10);
        panel1.add(txtN);

        // Nút Tính
        JPanel panel2 = new JPanel(new FlowLayout());
        btnCalculate = new JButton("Tính");
        btnCalculate.addActionListener(e -> calculatePrimeSum());
        panel2.add(btnCalculate);

        // Hiển thị tiến độ (%)
        JPanel panel3 = new JPanel(new FlowLayout());
        panel3.add(new JLabel("Tiến độ:"));
        txtProgress = new JTextField(10);
        txtProgress.setEditable(false);
        panel3.add(txtProgress);

        // Kết quả
        JPanel panel4 = new JPanel(new FlowLayout());
        lblResult = new JLabel("Kết quả sẽ hiển thị ở đây");
        panel4.add(lblResult);

        add(panel1);
        add(panel2);
        add(panel3);
        add(panel4);
    }

    // Hàm kiểm tra số nguyên tố (theo gợi ý đề bài)
    private boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // Hàm xử lý tính toán bằng SwingWorker
    private void calculatePrimeSum() {
        int n;
        try {
            n = Integer.parseInt(txtN.getText().trim());
            if (n <= 2) {
                JOptionPane.showMessageDialog(this, "N phải lớn hơn 2");
                return;
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên hợp lệ");
            return;
        }

        btnCalculate.setEnabled(false);
        txtProgress.setText("0%");
        lblResult.setText("Đang tính...");

        // SwingWorker giúp chạy tính toán ở luồng phụ (không làm đơ giao diện)
        SwingWorker<Long, Void> worker = new SwingWorker<Long, Void>() {
            @Override
            protected Long doInBackground() {
                long sum = 0;
                for (int i = 2; i < n; i++) {
                    if (isPrime(i)) {
                        sum += i;
                    }
                    // Tính phần trăm tiến độ
                    int progress = (int) ((i * 100.0) / n);
                    setProgress(progress);
                }
                return sum;
            }

            @Override
            protected void done() {
                try {
                    long result = get(); // Lấy kết quả từ doInBackground
                    lblResult.setText("Tổng các số nguyên tố nhỏ hơn " + n + " = " + result);
                } catch (InterruptedException | ExecutionException ex) {
                    lblResult.setText("Có lỗi khi tính toán");
                }
                btnCalculate.setEnabled(true);
                txtProgress.setText("100%");
            }
        };

        // Lắng nghe sự thay đổi của tiến độ "progress" để cập nhật lên JTextField
        worker.addPropertyChangeListener((PropertyChangeEvent evt) -> {
            if ("progress".equals(evt.getPropertyName())) {
                txtProgress.setText(evt.getNewValue() + "%");
            }
        });

        // Bắt đầu chạy SwingWorker
        worker.execute();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Exercise3().setVisible(true));
    }
}
