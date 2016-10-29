<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Dashboard</title>
	<link rel="stylesheet" href="./css/test.css">
	<link rel="stylesheet" href="./css/furtive.min.css">
	<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	<section class="measure p2">
		<form action="Create.html" method="get" role="form" class="my2">
			<div class="my2">
				<input type="submit" value="Create new survey" class="btn--green" />
			</div>
		</form>
		<c:forEach var="survey" items="${surveys}">
		<fieldset>
			<legend>${survey.name}</legend>
			<p>Survey link: ${interviewHomeUrl}${survey.id}</p>
			<form action="Publish" method="post" role="form" class="my2">
				<div class="my2">
					<input type="submit" name="Publish" value="Publish" class="dashboard" />
					<input type="hidden" name="surveyId" value="${survey.id}" />
				</div>
			</form>
			<form action="Edit" method="post" role="form" class="my2">
				<div class="my2">
					<input type="submit" value="Edit" class="dashboard" />
					<input type="hidden" name="surveyId" value="${survey.id}" />
				</div>
			</form>
			<form action="Delete" method="post" role="form" class="my2">
				<div class="my2">
					<input type="submit" value="Delete" class="dashboard" />
					<input type="hidden" name="surveyId" value="${survey.id}" />
				</div>
			</form>
			<form action="Duplicate" method="post" role="form" class="my2">
				<div class="my2">
					<input type="submit" value="Duplicate" class="dashboard" />
					<input type="hidden" name="surveyId" value="${survey.id}" />
				</div>
			</form>
			<form action="SurveyResults" method="post" role="form" class="my2">
				<div class="my2">
					<input type="submit" value="Results" class="dashboard" />
					<input type="hidden" name="surveyId" value="${survey.id}" />
				</div>
			</form>
		</fieldset>
		</c:forEach>
		<form action="Logout" method="get" role="form">
			<div class="my2">
				<input type="submit" value="Log Out" class="logOut" />
			</div>
		</form>
	</section>
</body>
</html>
