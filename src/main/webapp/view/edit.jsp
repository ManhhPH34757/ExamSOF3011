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
    <title>Edit</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

</head>
<body>
<form action="update-sinhVien?id=${sv.id}" method="post">
    <div>
        <label>Ho ten</label>
        <input type="text" class="form-control" name="hoTen" value="${sv.hoTen}">
        <div class="text-danger">${validHoTen}</div>
    </div>
    <div>
        <label>Lop</label>
        <select class="form-control" name="idLop">
            <option value="" hidden>--Select lop</option>
            <c:forEach items="${listLop}" var="lop">
                <option value="${lop.id}"
                <c:if test="${sv.lopHocByIdLop.id == lop.id}"> selected </c:if>
                >${lop.tenLop}</option>
            </c:forEach>
        </select>
        <div class="text-danger">${validLop}</div>
    </div>
    <div>
        <label>Dia chi</label>
        <input type="text" class="form-control" name="diaChi" value="${sv.diaChi}">
    </div>
    <div>
        <label>Trang thai</label>
        <input type="radio" name="trangThai" value="Active" id="1"
        <c:if test="${sv.trangThai == 'Active'}"> checked </c:if>
        ><label for="1">Active</label>
        <input type="radio" name="trangThai" value="InActive" id="0"
        <c:if test="${sv.trangThai == 'InActive'}"> checked </c:if>
        ><label for="0">InActive</label>
    </div>
    <button type="submit">update</button>
</form>
</body>
</html>
