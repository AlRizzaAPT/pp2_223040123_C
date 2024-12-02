
package main;

import dao.JenisMemberDao;
import dao.MemberDao;
import java.io.IOException;
import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import view.main.MainFrame;

public class Main {
    public static void main(String[] args) throws IOException {
        // Lokasi konfigurasi MyBatis
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // Membuat SqlSessionFactory dari konfigurasi
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // Membuat DAO menggunakan SqlSessionFactory
        JenisMemberDao jenisMemberDao = new JenisMemberDao(sqlSessionFactory);
        MemberDao memberDao = new MemberDao(sqlSessionFactory);

        // Membuat dan menampilkan MainFrame
        MainFrame f = new MainFrame(jenisMemberDao, memberDao);
        javax.swing.SwingUtilities.invokeLater(() -> {
            f.setVisible(true);
        });
    }
}
