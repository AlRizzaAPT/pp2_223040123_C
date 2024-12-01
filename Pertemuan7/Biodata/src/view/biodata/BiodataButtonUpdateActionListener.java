package view.biodata;



import java.awt.event.*;
import model.Biodata;
import dao.BiodataDao;

public class BiodataButtonUpdateActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;

    public BiodataButtonUpdateActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Biodata selectedBiodata = biodataFrame.getSelectedBiodata();
        if (selectedBiodata != null) {
            String nama = biodataFrame.getNama();
            String nrp = biodataFrame.getNrp();
            String jurusan = biodataFrame.getJurusan();
            String alamat = biodataFrame.getAlamat();

            selectedBiodata.setNama(nama);
            selectedBiodata.setNrp(nrp);
            selectedBiodata.setJurusan(jurusan);
            selectedBiodata.setAlamat(alamat);

            biodataDao.update(selectedBiodata);
            biodataFrame.updateBiodata(selectedBiodata);
        }
    }
}