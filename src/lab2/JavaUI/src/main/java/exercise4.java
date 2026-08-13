import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics2D;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author congt
 */
public class exercise4 extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(exercise4.class.getName());

    /**
     * Creates new form exercise4
     */
    public exercise4() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image Viewer");

        String imagePath = "sample.png";
        File imgFile = new File(imagePath);
        
        if (!imgFile.exists()) {
            createSampleImage(imgFile);
        }

        ImageIcon imageIcon = new ImageIcon(imgFile.getAbsolutePath());
        JLabel imageLabel = new JLabel(imageIcon);

        getContentPane().add(imageLabel, java.awt.BorderLayout.CENTER);

        pack(); // Auto size based on image content
        setLocationRelativeTo(null);
    }

    private void createSampleImage(File file) {
        try {
            BufferedImage img = new BufferedImage(350, 250, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = img.createGraphics();
            g2d.setColor(new Color(60, 120, 216));
            g2d.fillRect(0, 0, 350, 250);
            g2d.setColor(Color.WHITE);
            g2d.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));
            g2d.drawString("Sample Image Viewer", 70, 130);
            g2d.dispose();
            ImageIO.write(img, "png", file);
        } catch (Exception e) {
            logger.log(java.util.logging.Level.SEVERE, "Could not create sample image", e);
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

        java.awt.EventQueue.invokeLater(() -> new exercise4().setVisible(true));
    }
}
