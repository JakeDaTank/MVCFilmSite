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
	<h2>Search for a Film details</h2>
	<form action="getKeyword.do" method="GET">
		<input type="text" name="filmkey" value="${filmkey}"> <input
			type="submit" value="Look Up Film Keyword">

		<c:choose>
			<c:when test="${filmTitlekey != null}">
				<ul>
					<c:forEach var="film" items="${filmTitlekey}">
						<li><c:out value="${film.title}" /></li>
						<ul>
							<li>Length=<c:out value="${film.length}" /></li>
							<li>Rating=<c:out value="${film.rating}" /></li>
							<li>Description=<c:out value="${film.description}" /></li>
							<li>Cast=<c:out value="${film.cast}" /></li>
						</ul>
					</c:forEach>


				</ul>
			</c:when>
		</c:choose>
	</form>


	<form action="getTitle.do" method="GET">
		<input type="text" name="filmId"> <input type="submit"
			value="Look Up Film by ID">

	</form>
	<c:choose>
		<c:when test="${filmTitle != null}">
			<h3>${filmTitle}</h3>
		</c:when>
	</c:choose>
	</form>

	<br>
	<br>
	<br>

	<h3>Add a film</h3>
	<form action="addFilm.do" method="POST">
		Title <input type="text" name="film title"> <br>Length <input
			type="number" name="film length" value='120'> <br>Rating
		<select name="film rating">
			<option value="G">G</option>
			<option value="PG">PG</option>
			<option value="PG-13">PG13</option>
			<option value="R">R</option>
		</select> <br>Describe the Film <input type="text" name="film description">
		<br> <input type="submit" value="submit">
	</form>
</body>
</html>