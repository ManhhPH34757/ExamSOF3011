<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 4/2/2024
  Time: 2:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
    <div class="container">
        <h2 class="text-center">Them sinh vien</h2>
        <form action="find-sinhVien" method="get">
            <div>
                <label>Ho ten</label>
                <input type="text" class="form-control" name="find">
            </div>
            <button type="submit">Find</button>
        </form>
        <form action="store-sinhVien" method="post">
            <div>
                <label>Ho ten</label>
                <input type="text" class="form-control" name="hoTen" value="${hoTen}">
                <div class="text-danger">${validHoTen}</div>
            </div>
            <div>
                <label>Lop</label>
                <select class="form-control" name="idLop">
                    <option value="" hidden>--Select lop</option>
                    <c:forEach items="${listLop}" var="lop">
                        <option value="${lop.id}">${lop.tenLop}</option>
                    </c:forEach>
                </select>
                <div class="text-danger">${validLop}</div>
            </div>
            <div>
                <label>Dia chi</label>
                <input type="text" class="form-control" name="diaChi" value="${diaChi}">
            </div>
            <div>
                <label>Trang thai</label>
                <input type="radio" name="trangThai" value="Active" id="1"><label for="1">Active</label>
                <input type="radio" name="trangThai" value="InActive" id="0"><label for="0">InActive</label>
            </div>
            <button type="submit">Add</button>
        </form>
        <div class="text-danger">${checkList}</div>
        <table class="table">
            <tr>
                <th>STT</th>
                <th>Ho ten</th>
                <th>Lop</th>
                <th>Dia chi</th>
                <th>Trang thai</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${listSV}" var="sv" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${sv.hoTen}</td>
                    <td>${sv.lopHocByIdLop.tenLop}</td>
                    <td>${sv.diaChi}</td>
                    <td>${sv.trangThai}</td>
                    <td>
                        <a href="edit-sinhVien?id=${sv.id}">Edit</a>
                        <a href="delete-sinhVien?id=${sv.id}" onclick="return confirm('Ban muon xoa?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
