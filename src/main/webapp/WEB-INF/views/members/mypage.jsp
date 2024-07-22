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
  <div class="d-flex mt-5">
    <div class="container-fluid col-6 justify-contents-center mt-5">
      <div class="d-grid gap-2 d-md-flex justify-content-md-end mt-5">
        <a class="btn btn-secondary" href="./update?id=seon" role="button">수정</a> <a class="btn btn-danger" href="./delete?id=${member.member_id}" role="button">탈퇴</a>
      </div>

      <table class="table mt-4">
        <tbody class="table-group-divider">
          <tr>
            <td>ID</td>
            <th colspan="2">${member.member_id}</th>
            <td rowspan="4" style="width:160px; height:160px;">
              <c:if test="${not empty member.memberFileDTO}">
                <img src="/resources/upload/members/${member.memberFileDTO.fileName}" onerror="this.src='/resources/upload/members/default.jpg'" class="rounded mx-auto d-block" style="width:100%; height:100%;">
              </c:if>
              <c:if test="${empty member.memberFileDTO}"> 
                <img src="/resources/upload/members/default.jpg" style="width:100%; height:100%;" class="rounded mx-auto d-block">
              </c:if>
            </td>
          </tr>
          <tr>
            <td>이름</td>
            <td colspan="2">${member.member_name}</td>
          </tr>
          <tr>
            <td>email</td>
            <td colspan="2">${member.member_email}</td>
          </tr>
          <tr>
            <td>전화번호</td>
            <td colspan="2">${member.member_phone}</td>
          </tr>
          <tr>
            <td colspan="4"></td>
          </tr>
          <tr>
            <td colspan="4">보유 계좌</td>
          </tr>
          <tr>
            <th colspan="2">계좌번호</th>
            <th colspan="2">잔고</th>
          </tr>

          <c:forEach items="${member.dtos}" var="ac">
            <tr>
              <td colspan="2"><a href="../accounts/detail?bank_id=${ac.bank_id}">${ac.bank_id}</a></td>
              <td colspan="2">${ac.balance}</td>
            </tr>
          </c:forEach>

        </tbody>
      </table>

    </div>
  </div>


  <script>
			const delbtn = document.getElementById("delbtn");
			const frm = document.getElementById("frm");
			delbtn.addEventListener("click", function() {
				let result = prompt("정말 삭제하시려면 \"삭제\"를 입력하세요.");
				if (result == "삭제") {
					frm.submit();
				}
			})
		</script>

  <footer class="fixed-bottom">
    <c:import url="../template/footer.jsp"></c:import>
  </footer>
  <c:import url="../template/footerJS.jsp"></c:import>
</body>
</html>