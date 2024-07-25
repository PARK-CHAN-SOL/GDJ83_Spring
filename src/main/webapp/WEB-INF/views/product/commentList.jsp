<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="border p-5">
  <div class="row justify-content-center">
    <c:forEach items="${list}" var="dto">
      <table class="table table-borderless" style="width: 100%; height: auto;">
        <tbody class="border">
          <tr>
            <td style="word-break: break-all">작성자: ${dto.boardWriter}</td>
            <td>작성일: ${dto.createDate}</td>
            <td style="width:55px;">
              <c:if test="${member ne null}">
                <c:if test="${dto.boardWriter eq member.member_id }">
                  <button class="btn btn-outline-secondary" data-board-num="${dto.boardNum}">X</button>
                </c:if>
              </c:if>
            </td>
          </tr>
          <tr class="border mb-2">
            <td colspan="3" style="word-break: break-all">${dto.boardContents}</td>
          </tr>
        </tbody>
      </table>
    </c:forEach>
  </div>
  <div class="row mt-2">
    <nav aria-label="Page navigation example mb-3">
      <ul class="pagination justify-content-center">
        <li class="page-item ${pager.pre ? '' : 'disabled'}"><a class="page-link" data-comment-list="./commentList?page=${pager.startNum-1}&item_id=${param.item_id}">Previous</a></li>
        <c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
          <li class="page-item"><a class="page-link ${pager.page == i ? 'active' : ''  }" data-comment-list="./commentList?page=${i}&item_id=${param.item_id}">${i}</a></li>
        </c:forEach>
        <li class="page-item ${pager.next ? '':'disabled'}"><a class="page-link" data-comment-list="./commentList?page=${pager.lastNum+1}&item_id=${param.item_id}">Next</a></li>
      </ul>
    </nav>
  </div>
</div>