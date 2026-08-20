import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author congt
 */
public class exercise9 extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(exercise9.class.getName());

    /**
     * Creates new form exercise9
     */
    public exercise9() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("JDialog Demo");
        setSize(500, 400);
        setLocationRelativeTo(null);

        JButton btnOpen = new JButton("Open Dialog");
        btnOpen.setFont(new Font("Segoe UI", Font.BOLD, 16));
        btnOpen.addActionListener(evt -> showCustomDialog());

        getContentPane().setLayout(new GridBagLayout());
        getContentPane().add(btnOpen);
    }

    private void showCustomDialog() {
        JDialog dialog = new JDialog(this, "Notification", true);
        dialog.setSize(200, 150);
        dialog.setLocationRelativeTo(this);

        JLabel label = new JLabel("This is a dialog", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        dialog.getContentPane().setLayout(new BorderLayout());
        dialog.getContentPane().add(label, BorderLayout.CENTER);
        dialog.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new exercise9().setVisible(true));
    }
}
