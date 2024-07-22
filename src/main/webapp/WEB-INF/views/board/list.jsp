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
  <h1>notice</h1>
  <section class="py-5">
    <div class="container px-5 my-5">
      <div class="text-center mb-5">
        <h1 class="fw-bolder">${board}</h1>
      </div>
      <div class="row gx-5 justify-content-center">
        <div class="col-xl-8 jus">
          <!-- FAQ Accordion 1-->
          <c:forEach items="${list}" var="dto">
            <h3 class="fw-bolder mb-3">
              <c:choose>
                <c:when test="${dto.del ne 1}">
                  <a href="./detail?boardNum=${dto.boardNum}" class="list-group-item list-group-item-action list-group-item-light" style="text-decoration: none; color: black;"> <c:if test="${board == 'QnA'}">
                      <c:forEach begin="1" end="${dto.depth}">--</c:forEach>
                    </c:if> ${dto.boardTitle}
                  </a>
                </c:when>
                <c:otherwise>
                    삭제된 게시글입니다
                   </c:otherwise>
              </c:choose>
            </h3>
            <p class="lead fw-normal text-muted mb-2">${dto.boardWriter}</p>
            <div class="accordion mb-5" id="accordionExample">
              <div class="accordion-item">
                <h3 class="accordion-header" id="headingOne">
                  <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="false" aria-controls="collapseOne">#${dto.boardNum}</button>
                </h3>
                <div class="accordion-collapse collapse" id="collapseOne" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                  <div class="accordion-body">${dto.boardContents}</div>
                </div>
              </div>
            </div>
          </c:forEach>
        </div>
      </div>
      <div class="row gx-5 mt-5">
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
        </nav>
        <div class="d-md-flex justify-content-md-end">
          <a class="btn btn-secondary justify-content-end" href="./add" role="button">글쓰기</a>
        </div>

      </div>
    </div>
  </section>
  <c:import url="../template/footer.jsp"></c:import>
  <c:import url="../template/footerJS.jsp"></c:import>
</body>
</html>