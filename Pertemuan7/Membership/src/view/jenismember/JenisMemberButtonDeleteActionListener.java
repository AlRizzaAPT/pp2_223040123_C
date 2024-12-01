package view.jenismember;


import java.awt.event.*;
import model.JenisMember;
import dao.JenisMemberDao;
import javax.swing.JOptionPane;

public class JenisMemberButtonDeleteActionListener implements ActionListener {
    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberButtonDeleteActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JenisMember selectedJenisMember = jenisMemberFrame.getSelectedJenisMember();
        if (selectedJenisMember != null) {
            int confirm = JOptionPane.showConfirmDialog(jenisMemberFrame, "Kamu yakin ingin menghapus ?", 
                                                        "Delete Confirmation", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                jenisMemberDao.delete(selectedJenisMember);
                jenisMemberFrame.deleteJenisMember(selectedJenisMember);
            }
        }
    }
}