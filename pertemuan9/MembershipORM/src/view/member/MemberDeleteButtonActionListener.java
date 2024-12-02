
package view.member;

import dao.MemberDao;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberDeleteButtonActionListener implements ActionListener {

    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberDeleteButtonActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the selected row from the table
        int selectedRow = memberFrame.getTableModel().getSelectedRow();
        
        if (selectedRow != -1) {
            // Get the ID of the selected Member (assumed to be in the first column)
            String memberId = (String) memberFrame.getTableModel().getValueAt(selectedRow, 0);

            // Perform delete operation
            memberDao.delete(memberId);
            
            // Remove from table model and clear fields
            memberFrame.getTableModel().removeMember(selectedRow);
            memberFrame.getTextFieldNama().setText("");
            
            JOptionPane.showMessageDialog(memberFrame, "Member deleted successfully.");
        } else {
            JOptionPane.showMessageDialog(memberFrame, "Please select a Member to delete.");
        }
    }
}
