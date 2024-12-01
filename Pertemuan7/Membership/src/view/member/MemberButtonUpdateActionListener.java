package view.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Member;
import dao.MemberDao;

public class MemberButtonUpdateActionListener implements ActionListener {
    private MemberFrame memberFrame;
    private MemberDao memberDao;

    public MemberButtonUpdateActionListener(MemberFrame memberFrame, MemberDao memberDao) {
        this.memberFrame = memberFrame;
        this.memberDao = memberDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Member selectedMember = memberFrame.getSelectedMember();
        if (selectedMember == null) {
            memberFrame.showAlert("Pilih member yang ingin di-update.");
            return;
        }

        String nama = memberFrame.getNama();
        if (nama.isEmpty()) {
            memberFrame.showAlert("Nama tidak boleh kosong.");
            return;
        }

        selectedMember.setNama(nama);
        selectedMember.setJenisMember(memberFrame.getJenisMember());

        memberDao.update(selectedMember);
        memberFrame.updateMember(selectedMember);
        memberFrame.showAlert("Member berhasil di-update.");
    }
}