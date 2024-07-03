<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PRODUCT LIST</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/headerItem.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9"></div>
      <table class="table table-hover">
        <thead>
          <tr>
            <th>PRODUCT_ID</th>
            <th>PRODUCT_NAME</th>
            <th>PRODUCT_RATE</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>${dto.item_id}</td>
            <td>${dto.item_name}</td>
            <td>${dto.item_rate}</td>
          </tr>
          <tr>
            <td colspan='3'>세부정보: ${dto.item_detail}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>