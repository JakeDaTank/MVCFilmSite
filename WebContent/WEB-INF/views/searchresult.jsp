<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Films</title>
</head>
<body>
	<c:choose>
		<c:when test="${filmTitlekey != null}">
			<ul>
				<c:forEach var="film" items="${filmTitlekey}">
					<li><h2>
							<c:out value="${film.title}" />
						</h2></li>
					<ul>
						<li>ID=<c:out value="${film.ID}" /></li>
						<li>Length=<c:out value="${film.length}" /></li>
						<li>Rating=<c:out value="${film.rating}" /></li>
						<li>Description=<c:out value="${film.description}" /></li>
						<%-- <li>Cast=<c:out value="${film.cast}" /></li> --%>
					</ul>
					<form action="deletefilm.do" method="POST">
						ID =<input type="number" name="id" value="${film.ID}"> <input
							type="submit" class="button" value="Delete this film" /><br />
					</form>
					<br>
					<br>
					<h3>Update this Film</h3>
					<form action="updatefilm.do" method="POST">
						ID <input type="number" name="film id" value="${film.ID}">
						<br> Title <input type="text" name="film title"
							value="${film.title}"> <br>Length <input
							type="number" name="film length" value="${film.length}">
						<br>Rating <select name="film rating" value="${film.rating}">
							<option value="G">G</option>
							<option value="PG">PG</option>
							<option value="PG13">PG13</option>
							<option value="R">R</option>
						</select> <br>Description <input type="text" name="film description"
							value="${film.description}"> <br> <input
							type="submit" value="Update Film">
					</form>
					<br>
					<br>
					<hr>
				</c:forEach>
			</ul>
		</c:when>
		<c:otherwise>
No film found.
</c:otherwise>
	</c:choose>
	<br>
	<br>
	<form action="home.do" method="GET">
		<input type="submit" class="button" value="Go back" /><br />
	</form>
</body>
</html>