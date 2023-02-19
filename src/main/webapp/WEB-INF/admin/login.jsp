<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel = "stylesheet" href = "/css/admin/login.css">

<!-- script -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src = "/js/admin/login.js"></script>


</head>
<body>

<div class="noite"></div>

  <div class="constelacao"></div>

  <div class="chuvaMeteoro"></div>

  <div class="floresta">
    <img src="https://raw.githubusercontent.com/interaminense/starry-sky/master/src/img/bgTree.png" alt="" />
  </div>

	<section class="login">
    <div class="login_box">
      <div class="left">
        <div class="contact">
          <form action="">
            <img src = "/image/logologo.png" class = "logo"> 
            <br> <br> <br> <span class="signIN" > SIGN IN</span> <br> <br> <br>
            <input type="text" id = "id" placeholder="ADMIN-ID">
            <input type="password" id = "pw" placeholder="PASSWORD">
            <button type = "button" class = "adminloginBtn" onclick = "verify()">로그인</button>
          </form>
        </div>
      </div>
      <div class="right">
        <div class="right-inductor"><img  id="gif" src="/image/logoGif.gif" alt=""></div>
      </div>
    </div>
  </section>
</body>
</html>