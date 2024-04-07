package com.example.testexam2.controllers;

import com.example.testexam2.entities.LopHoc;
import com.example.testexam2.entities.SinhVien;
import com.example.testexam2.repositories.LopHocRepo;
import com.example.testexam2.repositories.SinhVienRepo;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "SinhVienServlet", value =
        {
                "/home-sinhVien",
                "/store-sinhVien",
                "/edit-sinhVien",
                "/update-sinhVien",
                "/delete-sinhVien",
                "/find-sinhVien"
        })
public class SinhVienServlet extends HttpServlet {

    SinhVienRepo sinhVienRepo = new SinhVienRepo();
    LopHocRepo lopHocRepo = new LopHocRepo();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home-sinhVien")){
            home(request, response);
        } else if (uri.contains("edit-sinhVien")) {
            edit(request, response);
        } else if (uri.contains("delete-sinhVien")) {
            delete(request, response);
        } else if (uri.contains("find-sinhVien")) {
            find(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store-sinhVien")){
            store(request, response);
        } else if (uri.contains("update-sinhVien")) {
            update(request, response);
        }
    }

    protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("listLop", lopHocRepo.getList());
        request.setAttribute("listSV", sinhVienRepo.getList());
        if (sinhVienRepo.getList().size() == 0){
            request.setAttribute("checkList", "List is empty!");
        }
        request.getRequestDispatcher("/view/home.jsp").forward(request,response);
    }

    protected void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hoten = request.getParameter("hoTen");
        int idLops = Integer.parseInt(request.getParameter("idLop"));
        LopHoc lopHoc = lopHocRepo.findById(idLops);
        String diaChi = request.getParameter("diaChi");
        String trangThai = request.getParameter("trangThai");
        SinhVien sinhVien = new SinhVien(hoten, idLops, diaChi, trangThai, lopHoc);
        sinhVienRepo.insert(sinhVien);
        response.sendRedirect("/home-sinhVien");
    }

    protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SinhVien sinhVien = sinhVienRepo.findById(id);
        request.setAttribute("sv", sinhVien);
        request.setAttribute("listLop", lopHocRepo.getList());
        request.getRequestDispatcher("/view/edit.jsp").forward(request,response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String hoten = request.getParameter("hoTen");
        int idLops = Integer.parseInt(request.getParameter("idLop"));
        LopHoc lopHoc = lopHocRepo.findById(idLops);
        String diaChi = request.getParameter("diaChi");
        String trangThai = request.getParameter("trangThai");
        SinhVien sinhVien = new SinhVien(id, hoten, idLops, diaChi, trangThai, lopHoc);
        sinhVienRepo.update(sinhVien);
        response.sendRedirect("/home-sinhVien");
    }
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        sinhVienRepo.delete(id);
        if (sinhVienRepo.getList().size() == 0){
            request.setAttribute("checkList", "List is empty!");
        }
        response.sendRedirect("home-sinhVien");
    }

    protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String find = request.getParameter("find");
        request.setAttribute("listLop", lopHocRepo.getList());
        request.setAttribute("listSV", sinhVienRepo.find(find));
        if (sinhVienRepo.find(find).size() == 0){
            request.setAttribute("checkList", "Not is exists");
        }
        request.getRequestDispatcher("/view/home.jsp").forward(request,response);
    }

}
