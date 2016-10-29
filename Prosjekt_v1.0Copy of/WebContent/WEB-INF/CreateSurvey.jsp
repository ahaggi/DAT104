<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="controller.hjelpeKlasser.UrlMappings" %>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create</title>
<link rel="stylesheet" href="./css/furtive.min.css">
<link rel="stylesheet" href="./css/main.css">
</head>
<body>
	<section class="measure p2">
		<form action="createsurvey" method="post" role="form" class="my2">
			<p>
				Name of survey: <input type="text" name="navn"	value=""   />
			</p>
 				<p>
					Description: <textarea name="description" rows="5" cols="50" maxlength="250"   ></textarea>
				</p>
				<p>
				        <input type="checkbox" name="repeatable" value="true" />Repeatable	
 				</p>
				<p>
				        <input type="checkbox" name="traversable" value="true" />Traversable
 				</p>
				<div class="my2">
					<input type="submit" value="Cancel" formaction="dashboard" />
				</div>
				<div class="my2">
					<input type="submit" value="Add question" />
				</div>
 		</form>
	</section>
</body>
</html>