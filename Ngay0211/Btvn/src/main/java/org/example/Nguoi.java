package org.example;

import java.util.Scanner;

public class Nguoi {
    protected String hoTen;
    protected int tuoi;

    // Nhap thong tin nguoi
    public void nhap(Scanner sc) {
        System.out.print("Nhap ho ten: ");
        hoTen = sc.nextLine();

        System.out.print("Nhap tuoi: ");
        tuoi = Integer.parseInt(sc.nextLine());
    }

    // Xuat thong tin nguoi
    public void xuat() {
        System.out.print(
                "Ho ten: " + hoTen +
                        " | Tuoi: " + tuoi
        );
    }
}