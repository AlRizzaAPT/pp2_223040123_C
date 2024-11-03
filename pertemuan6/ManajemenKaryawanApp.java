package pertemuan6;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManajemenKaryawanApp extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField namaField;
    private JTextArea alamatArea;
    private JRadioButton priaRadio;
    private JRadioButton wanitaRadio;
    private JCheckBox statusCheckbox;
    private JComboBox<String> jabatanCombo;
    private JList<String> departemenList;
    private ButtonGroup genderGroup;

    public ManajemenKaryawanApp() {
        setTitle("Manajemen Karyawan");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        menu.add(exitMenuItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        // Panel Form dengan Border dan BoxLayout
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createEtchedBorder(), "Form Input Karyawan", TitledBorder.CENTER, TitledBorder.TOP));

        // Nama
        JPanel namaPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namaPanel.add(new JLabel("Nama:"));
        namaField = new JTextField(20);
        namaPanel.add(namaField);
        formPanel.add(namaPanel);

        // Alamat
        JPanel alamatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        alamatPanel.add(new JLabel("Alamat:"));
        alamatArea = new JTextArea(3, 20);
        alamatPanel.add(new JScrollPane(alamatArea));
        formPanel.add(alamatPanel);

        // Jenis Kelamin
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.add(new JLabel("Jenis Kelamin:"));
        priaRadio = new JRadioButton("Pria");
        wanitaRadio = new JRadioButton("Wanita");
        genderGroup = new ButtonGroup();
        genderGroup.add(priaRadio);
        genderGroup.add(wanitaRadio);
        genderPanel.add(priaRadio);
        genderPanel.add(wanitaRadio);
        formPanel.add(genderPanel);

        // Status
        JPanel statusPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        statusPanel.add(new JLabel("Status:"));
        statusCheckbox = new JCheckBox("Menikah");
        statusPanel.add(statusCheckbox);
        formPanel.add(statusPanel);

        // Jabatan
        JPanel jabatanPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        jabatanPanel.add(new JLabel("Jabatan:"));
        jabatanCombo = new JComboBox<>(new String[]{"Manager", "Staff", "Intern"});
        jabatanPanel.add(jabatanCombo);
        formPanel.add(jabatanPanel);

        // Departemen
        JPanel departemenPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        departemenPanel.add(new JLabel("Departemen:"));
        departemenList = new JList<>(new String[]{"IT", "HR", "Finance", "Marketing"});
        departemenPanel.add(new JScrollPane(departemenList));
        formPanel.add(departemenPanel);

        // Tombol Submit dan Clear
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton submitButton = new JButton("Submit");
        JButton clearButton = new JButton("Clear");
        buttonPanel.add(submitButton);
        buttonPanel.add(clearButton);
        formPanel.add(buttonPanel);

        // Tabel Data
        String[] columnNames = {"Nama", "Alamat", "Jenis Kelamin", "Status", "Jabatan", "Departemen"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane tableScrollPane = new JScrollPane(table);

        // Action Listeners
        submitButton.addActionListener(new SubmitButtonListener());
        clearButton.addActionListener(e -> resetForm());
        exitMenuItem.addActionListener(e -> System.exit(0));

        // Main Layout
        setLayout(new BorderLayout());
        add(formPanel, BorderLayout.WEST);
        add(tableScrollPane, BorderLayout.CENTER);
    }

    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String nama = namaField.getText();
            String alamat = alamatArea.getText();
            String jenisKelamin = priaRadio.isSelected() ? "Pria" : "Wanita";
            String status = statusCheckbox.isSelected() ? "Menikah" : "Belum Menikah";
            String jabatan = (String) jabatanCombo.getSelectedItem();
            String departemen = String.join(", ", departemenList.getSelectedValuesList());

            tableModel.addRow(new Object[]{nama, alamat, jenisKelamin, status, jabatan, departemen});
            resetForm();
        }
    }

    // Fungsi untuk mereset form
    private void resetForm() {
        namaField.setText("");
        alamatArea.setText("");
        genderGroup.clearSelection();
        statusCheckbox.setSelected(false);
        jabatanCombo.setSelectedIndex(0);
        departemenList.clearSelection();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ManajemenKaryawanApp().setVisible(true);
        });
    }
}
