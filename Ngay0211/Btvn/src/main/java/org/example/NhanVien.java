package org.example;

import java.util.Scanner;

public class NhanVien extends Nguoi {

    private int soNamCongTac;
    private double heSoLuong;

    // Nhap thong tin nhan vien
    @Override
    public void nhap(Scanner sc) {

        // Goi phuong thuc nhap cua lop cha
        super.nhap(sc);

        System.out.print("Nhap so nam cong tac: ");
        soNamCongTac = Integer.parseInt(sc.nextLine());

        System.out.print("Nhap he so luong: ");
        heSoLuong = Double.parseDouble(sc.nextLine());
    }

    // Tinh tien luong (don vi: trieu dong)
    public double tinhTienLuong() {
        double lcb = 1.5;
        double phuCap = 0.2 * soNamCongTac;

        return lcb * heSoLuong + phuCap;
    }

    // Xuat thong tin nhan vien
    @Override
    public void xuat() {

        // Goi phuong thuc xuat cua lop cha
        super.xuat();

        System.out.printf(
                " | Nam cong tac: %d" +
                        " | He so luong: %.2f" +
                        " | Tien luong: %.2f trieu%n",
                soNamCongTac,
                heSoLuong,
                tinhTienLuong()
        );
    }

    // Getter
    public int getSoNamCongTac() {
        return soNamCongTac;
    }
}