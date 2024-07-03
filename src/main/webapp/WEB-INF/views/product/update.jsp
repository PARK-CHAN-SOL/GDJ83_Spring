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
    <form class="row g-3 mt-3" method="post">
    	<input type="hidden" value="${dto.item_id}">
      <div class="col-md-6">
        <label for="ITEM_NAME" class="form-label">Name</label> <input type="text" class="form-control" name="item_name" value="${dto.item_name}">
      </div>
      <div class="col-md-6">
        <label for="ITEM_RATE" class="form-label">Rate</label> <input type="text" class="form-control" name="item_rate" value="${dto.item_rate}">
      </div>
      <div class="col-12">
        <label for="ITEM_DETAIL" class="form-label">Detail</label>
        <textarea class="form-control" name="item_detail"> ${dto.item_detail}</textarea>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-end">
        <button class="btn btn-primary me-md-2" type="submit">수정</button>
      </div>
    </form>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>