package model.answer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.Interview;
import model.question.*;

@Entity
@Table(schema="questionnaire", name="textAnswer")
public class TextAnswer extends Answer {

	private String text;
	
	@ManyToOne
	@JoinColumn(name = "textquestion", referencedColumnName = "id", insertable = true, updatable = true)
	private TextQuestion textQuestion;

	public TextAnswer() {
		super();
 	}

 	public TextAnswer(Integer id, Interview interview, String text, TextQuestion textQuestion) {
		super(id, interview);
		this.text = text;
		this.textQuestion = textQuestion;
	}

	public TextQuestion getTextQuestion() {
		return textQuestion;
	}

	public void setTextQuestion(TextQuestion textQuestion) {
		this.textQuestion = textQuestion;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	

}
