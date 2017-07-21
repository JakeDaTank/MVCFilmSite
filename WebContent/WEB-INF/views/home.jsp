<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="getTitle.do" method="get">
		<input type="text" name="filmId"> <input type="submit"
			value="Look Up Film">
	</form>

	<c:choose>
		<c:when test="${filmTitle != null}">
			<h3>${filmTitle}</h3>
		</c:when>
	</c:choose>
</body>
</html>