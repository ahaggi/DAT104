<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		<form action="Create" method="post" role="form" class="my2">
			<p>
				Name of survey: <input type="text" name="navn"
					value="${survey.navn}" required />
			</p>
			<fieldset>
				<legend>Question ${sporsmaalNr}</legend>
				<p>
					Question: <input type="text" name="sporsmaal" required />
				</p>
				<p>
					Alternative 1: <input type="text" name="alternativ1" required />
				</p>
				<p>
					Alternative 2: <input type="text" name="alternativ2" required />
				</p>
				<div class="my2">
					<input type="submit" value="Add question" formaction="AddQuestion" />
				</div>
				<div class="my2">
					<input type="submit" value="Done" />
				</div>
			</fieldset>
		</form>
	</section>
</body>
</html>