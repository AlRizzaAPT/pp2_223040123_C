package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class KeyListenerExample {
    public static void main(String[] args) {
        //membuat frame
        JFrame frame = new JFrame("KeyListener Example");

        //membuat label untuk menampilkan pesan
        JLabel label = new JLabel("Tekan tombol pada keyboard");
        label.setBounds(50, 50, 300, 30);

        //membuat textfield untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        //menambahkan Keylistener ke textfield
        textField.addKeyListener(new KeyListener() {
            //dijalankan ketika tombol ditekan
            public void keyPressed(KeyEvent e) {
                //menampilkan pesan ketika tombol ditekan
                label.setText("Tombol " + e.getKeyText(e.getKeyCode()));
            }

            //dijalankan ketika tombol dilepaskan
            public void keyReleased(KeyEvent e) {
                //menampilkan pesan ketika tombol dilepaskan
                label.setText("Tombol " + e.getKeyText(e.getKeyCode()));
            }

            //dijalankan ketika tobol ditekan dan dilepaskan(sama dengan mengetik karakter)
            public void keyTyped(KeyEvent e) {
                //menampilkan pesan ketika tombol ditekan dan dilepaskan
                label.setText("Tombol " + e.getKeyText(e.getKeyCode()));
            }

        });

        //menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);

        //setting frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
