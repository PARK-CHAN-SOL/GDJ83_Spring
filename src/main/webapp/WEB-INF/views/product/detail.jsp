<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body class="bg-light py-5">
  <c:import url="../template/navbar.jsp"></c:import>
  <div class="container px-5 my-5">
    <div class="row gx-5 justify-content-center">
      <div class="col-lg-6 col-xl-4">
        <div class="card mb-5 mb-xl-0">
          <div class="card-body p-5">
            <div class="small text-uppercase fw-bold text-muted">${dto.item_id}</div>
            <div class="mb-3">
              <span class="display-4 fw-bold">${dto.item_rate}%</span> <span class="text-muted">/ year.</span>
            </div>
            <ul class="list-unstyled mb-4">
              <li class="mb-2"><strong>${dto.item_name}</strong></li>
              <li class="mb-2"><strong>${dto.item_detail}</strong></li>
              <c:forEach items="${dto.fileDTOs}" var="f">
                <li>
                  <a href="/resources/upload/products/${f.fileName}">${f.oriName}</a>
                </li>
              </c:forEach>
            </ul>
          </div>
        </div>

        <div class="d-md-flex justify-content-md-end mt-5">
          <input type="button" class="btn btn-secondary" value="돌아가기" onclick="history.back();">
          <button id="addWish" class="btn btn-secondary justify-content-end" data-item-id="${dto.item_id}">찜</button>
        </div>
      </div>
    </div>
  </div>
  <div id="wishResult">
    
  </div>
  <footer class="fixed-bottom">
    <c:import url="../template/footer.jsp"></c:import>
  </footer>
  <c:import url="../template/footerJS.jsp"></c:import>
  <script src="/resources/js/product/wish.js"></script>
</body>
</html>