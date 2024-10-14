package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class ButtonExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Example");  // Perbaikan argumen di JFrame
        JButton button = new JButton("Click Me");     // Perbaikan argumen di JButton

        // Menambahkan ActionListener ke JButton
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button clicked!"); // Perbaikan argumen di System.out.println
            }
        });

        button.setBounds(50, 50, 150, 30);            // Perbaikan parameter pada setBounds
        frame.add(button);
        frame.setSize(300, 200);                      // Perbaikan parameter pada setSize
        frame.setLayout(null);                        // Perbaikan parameter pada setLayout
        frame.setVisible(true);                       // Perbaikan parameter pada setVisible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Memastikan program keluar saat jendela ditutup
    }
}
