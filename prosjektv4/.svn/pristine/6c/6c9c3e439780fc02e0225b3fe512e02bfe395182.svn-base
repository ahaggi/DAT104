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
				Name of survey: <input type="text" name="name" value="" />
			</p>
			<p>
				Description: <textarea name="description"></textarea>
			</p>
			<p>
				End date(can be changed): <input type="datetime-local" name="endDate" value="" />
			</p>
			Repeatable(Survey can be repeated on the same computer)<input type="checkbox" name="repeatable" value="repeatable" />
			Traversable<input type="checkbox" name="traversable" value="traversable" />
			<fieldset>
				<legend>Question 1</legend>
				<p>
					Text: <input type="text" name="text" />
				</p>
				<p>
					Choice 1: <input type="text" name="choice1" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove choice" formaction="AddQuestion" />
				</div>
				<p>
					Choice 2: <input type="text" name="choice2" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove choice" formaction="AddQuestion" />
				</div>
				<div class="my2">
					<input type="submit" value="Add choice" formaction="AddQuestion" />
				</div>
				<div class="my2">
					<input type="submit" value="Remove Question" formaction="AddQuestion" />
				</div>
			</fieldset>
			<fieldset>
				<legend>Question 2</legend>
				<p>
					Text: <input type="text" name="text" />
				</p>
				<p>
					Choice 1: <input type="text" name="choice1" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove choice" formaction="AddQuestion" />
				</div>
				<p>
					Choice 2: <input type="text" name="choice2" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove choice" formaction="AddQuestion" />
				</div>
				<p>
					Choice 3: <input type="text" name="choice3" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove choice" formaction="AddQuestion" />
				</div>
				<div class="my2">
					<input type="submit" value="Add choice" formaction="AddQuestion" />
				</div>
				<div class="my2">
					<input type="submit" value="Remove Question" formaction="AddQuestion" />
				</div>
			</fieldset>
			<fieldset>
				<legend>Question 3</legend>
				<p>
					Text: <input type="text" name="text" />
				</p>
				<div class="my2">
					<input type="submit" value="Remove Question" formaction="AddQuestion" />
				</div>
			</fieldset>
			<fieldset>
				<legend>Add Question</legend>
				<div class="my2">
					<select name="questionType">
						<option value="mcQuestion" selected="selected">Mc Question</option>
						<option value="textQuestion">Text Question</option>
					</select>
					<input type="submit" value="Add question" formaction="AddQuestion" />
				</div>
			</fieldset>
			<div class="my2">
				<input type="submit" value="Done" formaction="Dashboard.html" />
			</div>
		</form>
	</section>
</body>
</html>
