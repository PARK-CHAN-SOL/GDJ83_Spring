<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/header_css.jsp"></c:import>
</head>
<body>
  <c:import url="../template/navbar.jsp"></c:import>
  <section class="bg-light py-5">
    <div class="container px-5 my-5">
      <div class="text-center mb-5">
        <h1 class="fw-bolder">WISH LIST</h1>
      </div>
      <div class="row gx-5 justify-content-center" id="itemDiv">
        <!-- Pricing card free-->
        <c:forEach items="${wishList}" var="dto" varStatus="i">
          <div class="col-lg-6 col-xl-4">
            <div class="card mb-5 mb-xl-0">
              <div class="card-body p-5">
                <input class="delChk" type="checkbox">
                <button class="btn btn-outline-secondary delBtn" data-wish-num="${dto.item_id}">x</button>
                <div class="small text-uppercase fw-bold text-muted">${dto.item_id}</div>
                <div class="mb-3">
                  <span class="display-4 fw-bold">${dto.item_rate}%</span> <span class="text-muted">/ year.</span>
                </div>
                <ul class="list-unstyled mb-4">
                  <li class="mb-2"><strong>${dto.item_name}</strong></li>

                </ul>
                <div class="d-grid">
                  <a class="btn btn-outline-secondary" href="./detail?item_id=${dto.item_id}">자세히 보기</a>
                </div>
              </div>
            </div>
          </div>
        </c:forEach>
      </div>
      <div class="row gx-5 mt-5">
        <nav aria-label="Page navigation example mb-5">
          <ul class="pagination justify-content-center mb-5">
            <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" href="./wishList?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" href="./wishList?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" href="./wishList?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
        </nav>

      </div>
    </div>
  </section>



  <c:import url="../template/footer.jsp"></c:import>
  <c:import url="../template/footerJS.jsp"></c:import>
  <script src="/resources/js/product/delete.js"></script>
</body>
</html>