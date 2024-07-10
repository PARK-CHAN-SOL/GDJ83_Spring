<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/headerMember.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">
        <div class="d-md-flex justify-content-md-end">
          <a class="btn btn-primary justify-content-end me-2" href="./update" role="button">수정</a> <a class="btn btn-primary justify-content-end" href="#" role="button" id="delbtn">계정삭제</a>
        </div>
        <form action="./delete" method="post" id="frm"></form>
        <div class="col-md-12">
          <label for="member_id" class="form-label">ID</label> <input type="text" class="form-control" name="member_id" id="member_id" value="${member.member_id}" readonly>
        </div>

        <div class="col-md-12 mt-2">
          <label for="member_name" class="form-label">FULL NAME</label> <input type="text" class="form-control" name="member_name" id="member_name" value="${member.member_name}" readonly>
        </div>
        <div class="col-md-12 mt-2">
          <label for="member_phone" class="form-label">PHONE NUMBER</label> <input type="text" class="form-control" name="member_phone" id="member_phone" value="${member.member_phone}" readonly>
        </div>
        <div class="col-md-12 mt-2">
          <label for="member_email" class="form-label">EMAIL</label> <input type="email" class="form-control" name="member_email" id="member_email" value="${member.member_email}" readonly>
        </div>
        
        <div class="col-md-12 mt-5">
          <h3>계좌정보</h3>

          <div class="table-responsive-md">
            <table class="table align-middle">
              <thead>
                <tr class="table-info">
                  <th>계좌번호</th>
                  <th>잔액</th>
                </tr>
              </thead>
              <tbody>

                <c:forEach items="${member.dtos}" var="ac">
                  <tr>
                    <td><a href="../accounts/detail?bank_id=${ac.bank_id}&balance=${ac.balance}">${ac.bank_id}</a></td>
                    <td>${ac.balance}</td>
                  </tr>
                </c:forEach>

              </tbody>
            </table>
          </div>



        </div>


      </div>
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

  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>