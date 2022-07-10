package com.aldy.gui;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MainScreen extends  JFrame {
    private JPanel panelMain;
    private JList listDataMahasiswa;
    private JTextField textFieldFilter;
    private JTextField textFieldNama;
    private JTextField textFieldNim;
    private JTextField textFieldipk;
    private JButton saveButton;
    private JButton deleteButton;
    private JButton clearButton;
    private JButton filterbutton;

    private List<Mahasiswa> arrayData = new ArrayList<>();

    private DefaultListModel defaultListModel = new DefaultListModel<>();

    class Mahasiswa{
        private String nama;

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNim() {
            return nim;
        }

        public void setNim(String nim) {
            this.nim = nim;
        }

        public float getIpk() {
            return ipk;
        }

        public void setIpk(float ipk) {
            this.ipk = ipk;
        }

        private String nim;
        private float ipk;
    }

    public  MainScreen(){
        super("Data Mahasiswa");
        this.setContentPane(panelMain);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nama = textFieldNama.getText();
                String nim = textFieldNim.getText();
                Float ipk = Float.valueOf(textFieldipk.getText());

                Mahasiswa mahasiswa = new Mahasiswa();

                mahasiswa.setNama(nama);
                mahasiswa.setNim(nim);
                mahasiswa.setIpk(ipk);

                arrayData.add(mahasiswa);
                setClearButton();
                fromMahasiswaTolistmodel();
            }
        });
        listDataMahasiswa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int index = listDataMahasiswa.getSelectedIndex();

                if (index < 0 )
                    return;

                String nama = listDataMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayData.size(); i++) {
                    if (arrayData.get(i).getNama().equals(nama)){
                        Mahasiswa mahasiswa = arrayData.get(i);
                        textFieldipk.setText(String.valueOf(mahasiswa.getIpk()));
                        textFieldNama.setText(mahasiswa.getNama());
                        textFieldNim.setText(mahasiswa.getNim());
                        break;
                    }

                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = listDataMahasiswa.getSelectedIndex();
                if (index < 0)
                    return;

                String nama =listDataMahasiswa.getSelectedValue().toString();

                for (int i = 0; i < arrayData.size(); i++) {
                    if (arrayData.get(i).getNama().equals(nama)){
                        arrayData.remove(i);
                        break;
                    }

                }
                setClearButton();
                fromMahasiswaTolistmodel();
            }
        });
        filterbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String keyWord = textFieldFilter.getText();;

                List<String> filtered = new ArrayList<>();

                for (int i = 0; i < arrayData.size(); i++) {
                    if (arrayData.get(i).getNama().contains(keyWord)) {
                        filtered.add(arrayData.get(i).getNama());
                    }
                }
                refreshListModel(filtered);
            }
        });
    }


    private void fromMahasiswaTolistmodel(){
        List<String> listNamaMahasiswa = new ArrayList<>();

        for (int i = 0; i < arrayData.size(); i++) {
            listNamaMahasiswa.add(arrayData.get(i).getNama());

        }
        refreshListModel(listNamaMahasiswa);
    }

    private  void  setClearButton(){
        textFieldNama.setText("");
        textFieldNim.setText("");
        textFieldipk.setText("");
    }

    private void refreshListModel(List<String>list){
        defaultListModel.clear();
        defaultListModel.addAll(list);
        listDataMahasiswa.setModel(defaultListModel);
    }

    public static void main(String[] args) {
        MainScreen mainScreen = new MainScreen();
        mainScreen.setVisible((true));
    }
}
