import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloGridBagLayout extends JFrame {

    public HelloGridBagLayout() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Membuat header label
        JLabel headerLabel = new JLabel("Layout in action: GridBagLayout", JLabel.CENTER);
        
        // Membuat control panel dengan FlowLayout
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Membuat panel utama
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);
        panel.setSize(300, 300);

        // Mengatur GridBagLayout dan GridBagConstraints
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();

        // Pengaturan tombol dengan posisi dan ukuran pada layout
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JButton("Button 1"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(new JButton("Button 2"), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 20;
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JButton("Button 3"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(new JButton("Button 4"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        panel.add(new JButton("Button 5"), gbc);

        // Menambahkan panel ke controlPanel
        controlPanel.add(panel);

        // Mengatur layout JFrame dan menambahkan komponen
        this.setLayout(new GridLayout(2, 1));
        this.add(headerLabel);
        this.add(controlPanel);

        // Mengatur ukuran frame
        this.setSize(400, 400);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloGridBagLayout h = new HelloGridBagLayout();
                h.setVisible(true);
            }
        });
    }
}
