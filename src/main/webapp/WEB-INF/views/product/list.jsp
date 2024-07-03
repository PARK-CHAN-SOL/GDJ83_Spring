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
      
      <div class="d-md-flex justify-content-md-end">
        <a class="btn btn-primary justify-content-end" href="./add" role="button">상품등록</a>
      </div>

      <table class="table table-hover">
        <thead>
          <tr>
            <th>PRODUCT_ID</th>
            <th>PRODUCT_NAME</th>
            <th>PRODUCT_RATE</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${requestScope.list}" var="dto">
            <tr>
              <td>${dto.item_id}</td>
              <td><a href="./detail?item_id=${dto.item_id}">${dto.item_name}</a></td>
              <td>${dto.item_rate}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>