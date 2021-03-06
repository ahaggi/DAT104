package model.question;

import model.Survey;
import javax.persistence.*;

@Entity
@Table(schema="questionnaire", name="textquestion")
public class TextQuestion extends Question{

	private Integer minLength;
	private Integer maxLength;
	
	
	public TextQuestion(Integer id, String text, Integer minLength, Integer maxLength, Survey survey) {
		super(id, text, survey);
		this.minLength = minLength;
		this.maxLength = maxLength;
	}
	public TextQuestion() {
		super();
	}
	public Integer getMinLength() {
		return minLength;
	}
	public void setMinLength(Integer minLength) {
		this.minLength = minLength;
	}
	public Integer getMaxLength() {
		return maxLength;
	}
	public void setMaxLength(Integer maxLength) {
		this.maxLength = maxLength;
	}


	
	
}
