<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<section class="py-5">
	<div class="container px-5 my-5">
    	<div class="text-center mb-5">
             <h1 class="fw-bolder">${board}</h1>
        </div>
             	<div class="row gx-5 justify-content-center">
                	<div class="col-xl-8 jus">
						<h1>${board} 내용</h1>
							<table class="table table-striped">
								<thead>
									<tr>
										<th style="width:10%"># ${dto.boardNum}</th>
										<th style="width:10%">제목</th>
										<th>${dto.boardTitle}</th>
										<td>등록일: ${dto.createDate} | 수정일: ${dto.updateDate}</td>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th>작성자</th>
										<td colspan="3">${dto.boardWriter}</td>
									</tr>
									<tr>
										<th>내용</th>
										<td colspan="3">${dto.boardContents}
                                          <ol>
                                              <c:forEach items="${dto.fileDTOs}" var="f">
                                                <li>
                                                  <a href="./fileDown?fileNum=${f.fileNum}">${f.oriName}</a>
                                                </li>
                                              </c:forEach>                                            
                                          </ol>
                                        </td>	
									</tr>
								</tbody>
							</table>
				<div>
					<div>
						<c:if test="${board ne 'Notice'}">
					      	<a href="./reply?boardNum=${dto.boardNum}" class="btn btn-outline-success mb-3">답글</a>
						</c:if>
						<a href="./list" class="btn btn-outline-success mb-3">돌아가기</a>
						<c:if test="${member.member_id eq dto.boardWriter}">
					      	<a href="./update?boardNum=${dto.boardNum}" class="btn btn-outline-success mb-3">게시글 수정</a>
					      	<a href="./delete?boardNum=${dto.boardNum}" class="btn btn-outline-success mb-3">게시글 삭제</a>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>


<footer class="fixed-bottom">
<c:import url="../template/footer.jsp"></c:import>
</footer>
<c:import url="../template/footerJS.jsp"></c:import>
</body>
</html>