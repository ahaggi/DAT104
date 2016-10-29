package model.answer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.Interview;
import model.question.*;
 

@Entity
@Table(schema="questionnaire", name="multiplechoiceanswer")

public class MultipleChoiceAnswer extends Answer {
	
//	@OneToMany(mappedBy = "multiplechoiceanswer", cascade = CascadeType.ALL)
//	private List<AnsweredChoices> answeredChoices = new ArrayList<AnsweredChoices>();

	@ManyToOne
	@JoinColumn(name = "multiplechoicequestion", referencedColumnName = "id", insertable = true, updatable = true)
	private MultipleChoiceQuestion multipleChoiceQuestion;
	

	public MultipleChoiceAnswer() {
		super();
 	}

	public MultipleChoiceAnswer(Integer id, Interview interview, MultipleChoiceQuestion multipleChoiceQuestion) {
		super(id, interview);
		this.multipleChoiceQuestion = multipleChoiceQuestion;
 	}

	
	
	public MultipleChoiceQuestion getMultipleChoiceQuestion() {
		return multipleChoiceQuestion;
	}

	public void setMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
		this.multipleChoiceQuestion = multipleChoiceQuestion;
	}

//	public List<AnsweredChoices> getAnsweredChoices() {
//		return answeredChoices;
//	}
//
//	public void setAnsweredChoices(List<AnsweredChoices> answeredChoices) {
//		this.answeredChoices = answeredChoices;
//	}

	
}
