<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://tiles.apache.org/tags-tiles" prefix = "tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel = "stylesheet" href = "/css/layout/adminLayout/layout.css">
<link href="/mainImages/icon.ico" rel="shortcut icon" type="image/x-icon">

</head>
<body style = "overflow : hidden">
	<div class = "layoutWrapper">
		<tiles:insertAttribute name = "section" />
		<tiles:insertAttribute name = "body" />
	</div>
</body>
</html>