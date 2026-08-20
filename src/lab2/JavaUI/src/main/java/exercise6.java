import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
public class exercise6 extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(exercise6.class.getName());

    /**
     * Creates new form exercise6
     */
    public exercise6() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Custom Icon Window");
        setSize(500, 400);
        setLocationRelativeTo(null);

        // Icon Setup
        String iconPath = "logo.png";
        File iconFile = new File(iconPath);
        if (!iconFile.exists()) {
            createSampleLogo(iconFile);
        }
        if (iconFile.exists()) {
            ImageIcon icon = new ImageIcon(iconFile.getAbsolutePath());
            setIconImage(icon.getImage());
        }

        // Center Label
        JLabel label = new JLabel("Custom Icon Window", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 20));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label, BorderLayout.CENTER);
    }

    private void createSampleLogo(File file) {
        try {
            BufferedImage img = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(new Color(41, 128, 185));
            g2d.fillOval(4, 4, 56, 56);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("Segoe UI", Font.BOLD, 32));
            g2d.drawString("I", 24, 44);
            g2d.dispose();
            ImageIO.write(img, "png", file);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Could not create sample logo image", e);
        }
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

        java.awt.EventQueue.invokeLater(() -> new exercise6().setVisible(true));
    }
}
