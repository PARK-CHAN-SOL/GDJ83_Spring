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
<div class="container">
		<div class="row">
			<h1>${board} 작성</h1>
		</div>
		<div class="container-fluid mt-5">
		<div class="row">
			<form method="post">
				<input type="hidden" value="${dto.boardNum}" name="boardNum">
				<div class="mb-3">
				<table class="table table-striped">
					<thead>
						<tr>
							<th><label for="item_name" class="form-label">상품명</label> </th>
							<th colspan="2"><input type="text" class="form-control" id="item_name" name="item_name"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<th>이자율</th>
							<td colspan="2"><input type="text" class="form-control" id="item_rate" name="item_rate"></td>
							
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="2"><textarea class="form-control" id="item_detail" name="item_detail" rows="3"></textarea></td>	
						</tr>
					</tbody>
				</table>
				<div class="mb-3">
					<button type="button" id="add" class="btn btn-success">파일 추가</button>
				</div>
				<div id="result">
				
				</div>
				
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