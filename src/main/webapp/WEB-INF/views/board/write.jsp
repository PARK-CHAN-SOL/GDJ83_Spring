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
  <div class="container">
    <div class="row">
      <h1>${board}작성</h1>
    </div>
    <div class="container-fluid mt-5">
      <div class="row">
        <form method="post" enctype="multipart/form-data">
          <input type="hidden" value="${dto.boardNum}" name="boardNum">
          <div class="mb-3">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th><label for="boardTitle" class="form-label">제목</label></th>
                  <th colspan="2"><input type="text" class="form-control" id="boardTitle" name="boardTitle" value="${dto.boardTitle}"></th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <th>작성자</th>
                  <td><input type="text" class="form-control" readonly value="${member.member_id}" id="boardWriter" name="boardWriter"></td>
                  <td>등록일: 현재시각</td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td colspan="2"><textarea class="form-control" id="boardContents" name="boardContents" rows="3">${dto.boardContents}</textarea></td>
                </tr>
              </tbody>
            </table>
            <div class="mb-3">
              <button type="button" id="add" class="btn btn-success">파일 추가</button>
            </div>
            <div id="result"></div>
            <button type="submit" class="btn btn-secondary">등록</button>
          </div>
        </form>
      </div>
    </div>
  </div>

  <footer class="fixed-bottom">
    <c:import url="../template/footer.jsp"></c:import>
  </footer>
  <c:import url="../template/footerJS.jsp"></c:import>
  <script type="text/javascript" src="/resources/js/commons/files.js"></script>
  <script type="text/javascript">
			setMax(5);
		</script>
</body>
</html>