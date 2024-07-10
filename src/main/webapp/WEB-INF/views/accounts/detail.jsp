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
  <c:import url="/WEB-INF/views/sample/headerBank.jsp"></c:import>
  <div class="container">
    <div class="row justify-content-center mt-5">
      <div class="col-lg-7 col-md-9">
        <div class="d-md-flex justify-content-md-end">
          <a class="btn btn-primary justify-content-end me-2" href="/accounts/transfer?bank_id=${param.bank_id}&balance=${param.balance}" role="button">이체</a>
        </div>
        <table class="table table-hover">
          <thead>
            <tr>
              <th>계좌번호</th>
              <th>가입자명</th>
              <th>상품번호</th>
              <th>개설일</th>
              <th>잔액</th>
              <th>상품명</th>
              <th>이자율</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>${dto.bank_id}</td>
              <td>${member.member_name}</td>
              <td>${dto.item_id}</td>
              <td>${dto.open_date}</td>
              <td>${dto.balance}</td>
              <td>${dto.itemDTO.item_name}</td>
              <td>${dto.itemDTO.item_rate}</td>
            </tr>
            <tr>
              <td colspan='7'>세부정보: ${dto.itemDTO.item_detail}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
  <c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>