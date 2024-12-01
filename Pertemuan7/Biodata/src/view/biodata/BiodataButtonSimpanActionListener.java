package view.biodata;


import dao.BiodataDao;
import java.awt.event.*;
import java.util.UUID;
import model.Biodata;

public class BiodataButtonSimpanActionListener implements ActionListener {
    private BiodataFrame biodataFrame;
    private BiodataDao biodataDao;

    public BiodataButtonSimpanActionListener(BiodataFrame biodataFrame, BiodataDao biodataDao) {
        this.biodataFrame = biodataFrame;
        this.biodataDao = biodataDao;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nama = biodataFrame.getNama();
        String nrp = biodataFrame.getNrp();
        String jurusan = biodataFrame.getJurusan();
        String alamat = biodataFrame.getAlamat();

        Biodata biodata = new Biodata();
        biodata.setId(UUID.randomUUID().toString());
        biodata.setNama(nama);
        biodata.setNrp(nrp);
        biodata.setJurusan(jurusan);
        biodata.setAlamat(alamat);

        biodataFrame.addBiodata(biodata);
        biodataDao.insert(biodata);
    }
}