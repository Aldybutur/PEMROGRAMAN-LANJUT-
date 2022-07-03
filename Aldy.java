package com;


import java.util.ArrayList;
import java.util.Scanner;

public class Aldy {

    public static void main(String[] args) {

        ArrayList<String> nama = new ArrayList<>();
        ArrayList<String> nim = new ArrayList<>();
        ArrayList<String> alamat = new ArrayList<>();
        Scanner input = new Scanner(System.in);

        int pilihan;

        do {
            System.out.println("Program Data mahasiswa");
            System.out.println("====================");
            System.out.println("1.Tambahkan");
            System.out.println("2.Tampilkan");
            System.out.println("3.Cari");
            System.out.println("4.Hapus");
            System.out.println("5.Keluar");
            System.out.print("\nPilih Menu :");
            pilihan = input.nextInt();

            if (pilihan == 1) {
                System.out.print("Masukan nama :");
                String nm = input.next();
                nama.add(nm);

                System.out.print("Masukan nim : ");
                String Nim = input.next();
                nim.add(Nim);

                System.out.print("Masukan alamat : ");
                String alm = input.next();
                alamat.add(alm);


            } else if (pilihan == 2) {
                System.out.println("Data Mahasiswa");
                System.out.println("=============");

                for (int i = 0; i <nim.size() ; i++){
                    System.out.print(i + 1 + "." + nim.get(i));

                }

                System.out.println("Untuk melihat data lengkap, Cari Data (3)");
            } else if (pilihan == 3) {
                System.out.print("Masukan data nomor berapa yang ingin di cari: ");
                int cari = input.nextInt();
                if (cari == 1) {
                    System.out.println("Nama : " + nama.get(0));
                    System.out.println("Nim :" + nim.get(0));
                    System.out.println("Alamat : " + alamat.get(0));
                }

            } else if (pilihan == 4) {
                System.out.println("Data Mahasiswa");
                System.out.println("=============");

                for (int i = 0; i <nim.size() ; i++){
                    System.out.println(i + "." + nim.get(i));
                }
                System.out.print("Masukan nim yang akan di hapus: ");
                String Nim = input.next();
                nim.remove(Nim);
            }
            else if (pilihan==5) {
                System.out.print("Selesai");

            }else {
                System.err.println("menu tidak tersedia");

            }
        }while (pilihan != 5);
    }
}
