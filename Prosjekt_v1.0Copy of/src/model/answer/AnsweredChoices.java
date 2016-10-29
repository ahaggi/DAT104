package model.answer;

import model.question.MultipleChoiceOptions;
import javax.persistence.*;


@Entity
@Table(schema="questionnaire", name="answeredchoices")

public class AnsweredChoices {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "multiplechoiceanswer", referencedColumnName = "id", insertable = true, updatable = true)
	private MultipleChoiceAnswer multipleChoiceAnswer;
	
	private MultipleChoiceOptions multipleChoiceOptions; //FK??
	
	
	public AnsweredChoices() {
		super();
 	}
	
	public AnsweredChoices(Integer id, MultipleChoiceAnswer multipleChoiceAnswer, MultipleChoiceOptions multipleChoiceOptions) {
		super();
		this.id = id;
//		this.multipleChoiceAnswer = multipleChoiceAnswer;
		this.multipleChoiceOptions = multipleChoiceOptions;
		//TODO this.multipleChoiceOption=multipleChoiceAnswer.getMultipleChoiceQuestion().getChoices().get(index);
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public MultipleChoiceAnswer getMultipleChoiceAnswer() {
		return multipleChoiceAnswer;
	}
	public void setMultipleChoiceAnswer(MultipleChoiceAnswer multipleChoiceAnswer) {
		this.multipleChoiceAnswer = multipleChoiceAnswer;
	}
	public MultipleChoiceOptions getMultipleChoiceOption() {
		return multipleChoiceOptions;
	}
	public void setMultipleChoiceOption(MultipleChoiceOptions multipleChoiceOptions) {
		this.multipleChoiceOptions = multipleChoiceOptions;
	}
	
	 
}
