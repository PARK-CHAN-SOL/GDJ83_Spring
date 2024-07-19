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
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">

                            <h1 class="fw-bolder">정보 수정</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="frm" data-sb-form-api-token="API_TOKEN" method="post">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_id" id="member_id" type="text" value="${member.member_id}" data-sb-validations="required" />
                                        <label for="member_id">ID</label>
                                        
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_pw" id="member_pw" type="text" value="${member.member_pw}" data-sb-validations="required" />
                                        <label for="member_pw">Password</label>
                                        
                                        
                                        
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_name" id="member_name" type="text" value="${member.member_name}" data-sb-validations="required" />
                                        <label for="member_name">Name</label>
                                        
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_phone" id="member_phone" type="tel" value="${member.member_phone}" data-sb-validations="required" />
                                        <label for="member_phone">Phone number</label>
                                        
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_email" id="member_email" type="email" value="${member.member_email}" data-sb-validations="required,email" />
                                        <label for="member_email">Email</label>
                                        
                                    </div>
                                    <div class="d-grid">
                                    <button class="btn btn-secondary btn-lg" id="btn" type="button">Submit</button>
                                    </div>
                                </form>
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