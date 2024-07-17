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
  <c:import url="/WEB-INF/views/sample/header.jsp"></c:import>

  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">
        <div>${board}</div>
        <!-- 검색 입력 폼 -->
        <form action="./list" class="row row-cols-lg-auto g-3 align-items-center">
          <div class="col-12">
            <label class="visually-hidden" for="inlineFormInputGroupUsername">Search</label> <input type="text" name="search" class="form-control" id="inlineFormInputGroupUsername" placeholder="Search">
          </div>

          <div class="col-12">
            <label class="visually-hidden" for="inlineFormSelectPref">Preference</label> <select name="kind" class="form-select" id="inlineFormSelectPref">
              <option value="title" ${pager.kind == 'title' ? 'selected' : '' }>글제목</option>
              <option value="contents" ${pager.kind == 'contents' ? 'selected' : '' }>글내용</option>
              <option value="writer" ${pager.kind == 'writer' ? 'selected' : '' }>작성자</option>
            </select>
          </div>

          <!-- <div class="col-12">
            <div class="form-check">
              <input class="form-check-input" type="checkbox" id="inlineFormCheck"> <label class="form-check-label" for="inlineFormCheck"> Remember me </label>
            </div>
          </div> -->

          <div class="col-12">
            <button type="submit" class="btn btn-primary">검색</button>
          </div>
        </form>

        <br>

        <%-- <c:if test=""> --%>

        <%-- </c:if> --%>

        <table class="table table-hover">
          <thead>
            <tr>
              <th>글번호</th>
              <th>제목</th>
              <th>작성자</th>
              <th>작성일</th>
              <th>조회수</th>
            </tr>
          </thead>
          <tbody>
            <c:forEach items="${requestScope.list}" var="dto">
              <tr>
                <td><c:if test="${dto.del eq 0}">
                  ${dto.boardNum}
                </c:if></td>
                <td><c:catch>
                    <c:forEach begin="1" end="${dto.depth}">--</c:forEach>
                  </c:catch> <c:choose>
                    <c:when test="${dto.del eq 0}">
                      <a href="./detail?boardNum=${dto.boardNum}">${dto.boardTitle}</a>
                    </c:when>
                    <c:otherwise>
                      삭제된 글입니다
                    </c:otherwise>
                  </c:choose></td>
                <td>${dto.boardWriter}</td>
                <td>${dto.createDate}</td>
                <td>${dto.boardHit}</td>
              </tr>
            </c:forEach>
          </tbody>
        </table>
        <nav aria-label="Page navigation example">
          <ul class="pagination justify-content-center">
            <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" href="./list?page=${pager.startNum-1}&kind=${pager.kind}&search=${pager.search}">Previous</a></li>
            <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
              <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
            </c:forEach>
            <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" href="./list?page=${pager.lastNum+1}&kind=${pager.kind}&search=${pager.search}">Next</a></li>
          </ul>
        </nav>
        <c:choose>
          <c:when test="${not empty sessionScope.member}">
            <div class="d-md-flex justify-content-md-end">
              <a class="btn btn-primary justify-content-end" href="./add" role="button">게시글 추가</a>
            </div>
          </c:when>
        </c:choose>
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>