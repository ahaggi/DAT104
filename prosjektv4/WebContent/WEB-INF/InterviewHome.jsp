<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="./css/furtive.min.css">
<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	<section class="measure p2">
		<c:if test="${empty survey}">
			<p class="h4">${errorMsg}</p>
		</c:if>

		<c:if test="${not empty survey}">
			<form action="InterviewStart.html" method="get" role="form"	class="my2">
				<fieldset>
					<legend>${survey.name}</legend>
					<p class="h4">${survey.description}</p>
					<div class="my2">
						<input type="submit" value="Start" class="btn--green" />
					</div>
				</fieldset>
			</form>

		</c:if>

	</section>
</body>
</html>
