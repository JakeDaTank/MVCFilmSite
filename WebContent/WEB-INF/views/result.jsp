<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
<c:choose>
 <c:when test="${film != null}">
<c:out value="${film.title}" />
						<ul>					
					<li>Length=<c:out value="${film.length}" /></li>
					<li>Rating=<c:out value="${film.rating}" /></li>
					<li>Description=<c:out value="${film.description}" /></li>
				<%-- 	<li>Film cast=<c:out value="${film.cast}" /></li> --%>
					<ul>
					<h3>Film has been added</h3>
</c:when>
<c:otherwise>
Error.  Film was not added.
</c:otherwise>
</c:choose>
<br><br>
<form action="home.do" method="GET">
		<input type="submit" class="button"
			value="Go back" /><br />
	</form>
</body>
</html>