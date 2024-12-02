
package view.jenismember;

import dao.JenisMemberDao;
import model.JenisMember;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JenisMemberUpdateButtonActionListener implements ActionListener {

    private JenisMemberFrame jenisMemberFrame;
    private JenisMemberDao jenisMemberDao;

    public JenisMemberUpdateButtonActionListener(JenisMemberFrame jenisMemberFrame, JenisMemberDao jenisMemberDao) {
        this.jenisMemberFrame = jenisMemberFrame;
        this.jenisMemberDao = jenisMemberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected row from the table
        int selectedRow = jenisMemberFrame.getTableModel().getSelectedRow();
        
        if (selectedRow != -1) {
            // Retrieve the updated data from the input fields
            String updatedNama = jenisMemberFrame.getTextFieldNama().getText();

            // Retrieve the ID of the selected JenisMember (assumed to be in the first column)
            String jenisMemberId = (String) jenisMemberFrame.getTableModel().getValueAt(selectedRow, 0);

            // Create the updated JenisMember object
            JenisMember updatedJenisMember = new JenisMember();

            // Perform update operation
            jenisMemberDao.update(updatedJenisMember);
            
            // Update table and clear fields
            jenisMemberFrame.getTableModel().setValueAt(updatedNama, selectedRow, 1);
            JOptionPane.showMessageDialog(jenisMemberFrame, "Jenis Member updated successfully.");
        } else {
            JOptionPane.showMessageDialog(jenisMemberFrame, "Please select a Jenis Member to update.");
        }
    }
}
