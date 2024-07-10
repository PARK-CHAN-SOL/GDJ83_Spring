<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ADD ACCOUNT</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
  <c:import url="/WEB-INF/views/sample/headerBank.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">

      <div class="col-lg-5 col-md-6">
        <table class="table align-middle">
          <thead>
            <tr class="table-info">
              <th>내계좌</th>
              <th>잔액</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${param.bank_id}</td>
              <td>${param.balance}</td>
            </tr>

          </tbody>
        </table>

        <br>
        <br>

        <form class="row g-3" method="post" id="frm" action="./transfer">
          <input type="hidden" value="${param.bank_id}" name="bank_id">
          <div class="col-md-12">
            <label for="bank_id" class="form-label">상대방계좌번호</label> <input type="text" class="form-control" name="account_u">
          </div>
          <div class="col-md-12">
            <label for="difference" class="form-label">이체금액</label> <input type="number" class="form-control" name="difference" id="difference">
          </div>
          <div class="col-md-12">
            <label for="bank_pw" class="form-label">계좌비밀번호</label> <input type="password" class="form-control" name="bank_pw" id="bank_pw">
          </div>
        </form>
        <div class="d-grid gap-2 d-md-flex justify-content-md-end">
          <button class="btn btn-primary me-md-2 mt-2" type="button" id="smbtn">이체</button>
        </div>
        <br> <br> <br> <br>
        <h3>사이트 주인 계좌번호: 001100000015</h3>
        <h3>많은 후원 부탁드립니다 ^^</h3>
      </div>
    </div>
  </div>

  <script>
			const bank_pw = document.getElementById("bank_pw");
			const smbtn = document.getElementById("smbtn");
			const frm = document.getElementById("frm");
			const difference = document.getElementById("difference");

			smbtn.addEventListener("click", function() {
				if (bank_pw.value == "") {
					alert("공백을 채워주세요");
				} else if (bank_pw.value * 1.0 != bank_pw.value
						|| bank_pw.value.length != 4) {
					alert("비밀번호는 4개의 숫자를 입력하세요");
				} else if (difference.value <= 0) {
					alert("1원 이상부터 이체할 수 있습니다")
				} else if (difference.value > ${param.balance}){
					alert("잔액이 부족합니다")
				} else {
					frm.submit();
				}
			})
		</script>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>