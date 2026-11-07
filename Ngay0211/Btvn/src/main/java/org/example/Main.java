package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 1. Nhap danh sach n nhan vien
        System.out.print("Nhap so luong nhan vien: ");
        int n = Integer.parseInt(sc.nextLine());

        List<NhanVien> danhSach = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "\nNhap thong tin nhan vien thu " + (i + 1)
            );

            NhanVien nv = new NhanVien();

            nv.nhap(sc);

            danhSach.add(nv);
        }

        // 2. Tim nhan vien co so nam cong tac nhieu nhat

        int maxNamCongTac = 0;

        for (NhanVien nv : danhSach) {

            if (nv.getSoNamCongTac() > maxNamCongTac) {
                maxNamCongTac = nv.getSoNamCongTac();
            }
        }

        System.out.println(
                "\n===== NHAN VIEN CO SO NAM CONG TAC NHIEU NHAT ====="
        );

        for (NhanVien nv : danhSach) {

            if (nv.getSoNamCongTac() == maxNamCongTac) {
                nv.xuat();
            }
        }

        // 3. Sap xep theo tien luong giam dan

        danhSach.sort(
                Comparator.comparingDouble(NhanVien::tinhTienLuong)
                        .reversed()
        );

        System.out.println(
                "\n===== DANH SACH NHAN VIEN THEO LUONG GIAM DAN ====="
        );

        for (NhanVien nv : danhSach) {
            nv.xuat();
        }

        sc.close();
    }
}