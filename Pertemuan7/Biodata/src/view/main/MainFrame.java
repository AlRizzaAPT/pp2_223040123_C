package view.main;

import dao.BiodataDao;
import java.awt.*;
import javax.swing.*;
import view.biodata.BiodataFrame;

public class MainFrame extends JFrame {
    private BiodataFrame biodataFrame;
    private JButton buttonBiodata;
    private BiodataDao biodataDao;

    public MainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 500);
        this.setLayout(new FlowLayout());

        // Inisialisasi DAO dan frame Biodata
        this.biodataDao = new BiodataDao();
        this.biodataFrame = new BiodataFrame(biodataDao);

        // Membuat dan menambahkan tombol Biodata
        this.buttonBiodata = new JButton("Biodata");
        this.buttonBiodata.addActionListener(e -> showBiodataFrame());
        this.add(buttonBiodata);
    }

    // Method untuk menampilkan BiodataFrame
    public void showBiodataFrame() {
        if (biodataFrame == null) {
            biodataFrame = new BiodataFrame(biodataDao);
        }
        biodataFrame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setVisible(true);
        });
    }
}