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
        <h1 class="fw-bolder">Choose your product</h1>
        <p class="lead fw-normal text-muted mb-0">If not, your loss</p>
      </div>
      <div class="row gx-5 justify-content-center">
        <!-- Pricing card free-->
        <c:forEach items="${list}" var="dto">
          <div class="col-lg-6 col-xl-4">
            <div class="card mb-5 mb-xl-0">
              <div class="card-body p-5">
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
            <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
        </nav>
        <c:if test="${member ne null}">

          <c:if test="${member.member_id eq 'kk3223'}">
            <div class="d-md-flex justify-content-md-end">
              <a class="btn btn-secondary justify-content-end mb-5" href="./add" role="button">상품등록</a>
            </div>
          </c:if>
        </c:if>

      </div>
    </div>
  </section>



  <c:import url="../template/footer.jsp"></c:import>
  <c:import url="../template/footerJS.jsp"></c:import>
</body>
</html>