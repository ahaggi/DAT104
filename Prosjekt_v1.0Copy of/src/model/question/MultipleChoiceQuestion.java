package model.question;

import java.awt.Choice;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import model.Survey;

@Entity
@Table(schema="questionnaire", name="multiplechoicequestion")

public class MultipleChoiceQuestion extends Question{
	
	private boolean singleAnswer;
	
	@OneToMany(mappedBy = "multiplechoicequestion", cascade = CascadeType.ALL)
	private List<MultipleChoiceOptions> choices = new ArrayList<MultipleChoiceOptions>();
	

	public MultipleChoiceQuestion() {
		super();
 	}


	public MultipleChoiceQuestion(Integer id, String text,boolean singleAnswer, Survey survey) {
		super(id, text, survey);
		this.singleAnswer = singleAnswer;
 	}

	public boolean isSingleAnswer() {
		return singleAnswer;
	}

	public void setSingleAnswer(boolean singleAnswer) {
		this.singleAnswer = singleAnswer;
	}

	public List<MultipleChoiceOptions> getChoices() {
		return choices;
	}

	public void setChoices(List<MultipleChoiceOptions> choices) {
		this.choices = choices;
	}


	
	

}
