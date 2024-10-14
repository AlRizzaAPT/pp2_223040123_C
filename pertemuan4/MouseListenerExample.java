package pertemuan4;

import javax.swing.*;
import java.awt.event.*;

public class MouseListenerExample {
    public static void main(String[] args) {
        //mmebuat frame
        JFrame frame = new JFrame("MouseListener Example");

        //membuat label utk menampilkan pesan
        JLabel label = new JLabel("Arahkan dan klik mouse pada area ini");
        label.setBounds(50,50,300,30);

        label.addMouseListener(new MouseListener(){
            //dijalankan ketika mouse di klik(kiri kanan atau tengah)
            public void mouseClicked(MouseEvent e){
                label.setText("Mouse clicked at :(" + e.getX() + "," + e.getY() + ")");
            }

            //dijalankan ketika mouse ditekan tanpa dilepaskan
            public void mousePressed(MouseEvent e){
                label.setText("Mouse pressed at :(" + e.getX() + "," + e.getY() + ")");
            }

            //dijalankan ketika mouse dilepas setelah ditekan
            public void mouseReleased(MouseEvent e){
                label.setText("Mouse released at :(" + e.getX() + "," + e.getY() + ")");
            }

            //dijalankan ketika mouse masuk ke area komponen
            public void mouseEntered(MouseEvent e){
                label.setText("Mouse entered at :(" + e.getX() + "," + e.getY() + ")");
            }
            //dijalankan ketika mouse keluar dari area komponen
            public void mouseExited(MouseEvent e){
                label.setText("Mouse exited at :(" + e.getX() + "," + e.getY() + ")");
            }
        });

        //nemabahkan labek ke frame
        frame.add(label);

        //setting frame
        frame.setSize(400,200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
