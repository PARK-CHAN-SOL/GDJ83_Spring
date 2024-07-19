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
<body class="bg-light">
<c:import url="../template/navbar.jsp"></c:import>
<section class="py-5">
                <div class="container px-5">
                    <!-- Contact form-->
                    <div class="rounded-3 py-5 px-4 px-md-5 mb-5">
                        <div class="text-center mb-5">

                            <h1 class="fw-bolder">회원가입</h1>
                        </div>
                        <div class="row gx-5 justify-content-center">
                            <div class="col-lg-8 col-xl-6">
                                <form id="frm" data-sb-form-api-token="API_TOKEN" method="post" enctype="multipart/form-data">
                                    <!-- Name input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_id" id="member_id" type="text" placeholder="Enter your ID" data-sb-validations="required" />
                                        <label for="member_id">ID</label>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">ID is required.</div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" id="member_pw" type="password" placeholder="Enter your PW" data-sb-validations="required" />
                                        <label for="member_pw">Password</label>
                                        <div id="password-error"></div>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">Password is required.</div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_pw" id="member_pwCheck" type="password" placeholder="Enter your PW" data-sb-validations="required" />
                                        <label for="member_pw">Password</label>
                                        <div id="password-eqError"></div>
                                        <div class="invalid-feedback" data-sb-feedback="name:required">Password is required.</div>
                                    </div>
                                    <!-- Email address input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_name" id="member_name" type="text" placeholder="Enter your name" data-sb-validations="required" />
                                        <label for="member_name">Name</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An name is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">name is not valid.</div>
                                    </div>
                                    <!-- Phone number input-->
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_phone" id="member_phone" type="tel" placeholder="(123) 456-7890" data-sb-validations="required" />
                                        <label for="member_phone">Phone number</label>
                                        <div class="invalid-feedback" data-sb-feedback="phone:required">A phone number is required.</div>
                                    </div>
                                    <div class="form-floating mb-3">
                                        <input class="form-control ch" name="member_email" id="member_email" type="email" placeholder="name@example.com" data-sb-validations="required,email" />
                                        <label for="member_email">Email</label>
                                        <div class="invalid-feedback" data-sb-feedback="email:required">An email is required.</div>
                                        <div class="invalid-feedback" data-sb-feedback="email:email">Email is not valid.</div>
                                    </div>
                                    
                                    
                                    <button class="btn btn-secondary btn-lg px-4 mb-2" id="add" type="button">사진 파일 추가</button>
                                   
                                    <div class="mb-3 input-group" id="result">
                                    	
                                    </div>
                                    
                                    
                                    <div class="d-grid mt-5">
                                    <button class="btn btn-secondary btn-lg" id="btn" type="submit">Submit</button>
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
<script type="text/javascript" src="../resources/js/member/memberJoinCheck.js"></script>
<script type="text/javascript" src="../resources/js/commons/files.js"></script>
</body>
</html>