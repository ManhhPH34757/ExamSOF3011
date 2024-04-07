package com.example.testexam2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lop_hoc", schema = "dbo", catalog = "DB1")
public class LopHoc {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "ma_lop")
    private String maLop;
    @Basic
    @Column(name = "ten_lop")
    private String tenLop;
    @Basic
    @Column(name = "trang_thai")
    private String trangThai;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaLop() {
        return maLop;
    }

    public void setMaLop(String maLop) {
        this.maLop = maLop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LopHoc lopHoc = (LopHoc) o;

        if (id != lopHoc.id) return false;
        if (!Objects.equals(maLop, lopHoc.maLop)) return false;
        if (!Objects.equals(tenLop, lopHoc.tenLop)) return false;
        if (!Objects.equals(trangThai, lopHoc.trangThai)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (maLop != null ? maLop.hashCode() : 0);
        result = 31 * result + (tenLop != null ? tenLop.hashCode() : 0);
        result = 31 * result + (trangThai != null ? trangThai.hashCode() : 0);
        return result;
    }
}
