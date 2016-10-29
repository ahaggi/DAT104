package controller.hjelpeKlasser;

import java.util.ArrayList;
import java.util.List;

import model.Survey;
import model.answer.Answer;
import model.question.MultipleChoiceQuestion;
import model.question.Question;
import model.question.TextQuestion;

public class GenererSurvey {

	public static Survey generer() {
		Survey survey = new Survey();
		TextQuestion question1 = new TextQuestion();
		MultipleChoiceQuestion question2 = new MultipleChoiceQuestion();
		List<Question> questions = new ArrayList<Question>();
		List<String> options = new ArrayList<String>();
		
		survey.setName("Test Survey");
		survey.setDescription("Dette er en description");
		survey.setRepeatable(true);
		survey.setTraversable(true);
		survey.setLength(0);
		survey.setEndDate(0);
		
		question1.setText("Hva heter du?");
		question1.setMinLength(0);
		question1.setMaxLength(100);
		question1.setAnswers(new ArrayList<Answer>());
		
		question2.setText("Hva er favorittfargen din?");
		question2.setSingleAnswer(true);
		options.add("Roed");
		options.add("Groenn");
		question2.setOptions(options);
		question2.setAnswers(new ArrayList<Answer>());
		
		questions.add(question1);
		questions.add(question2);
		
		survey.setQuestions(questions);
		
		return survey;
		
	}
}
