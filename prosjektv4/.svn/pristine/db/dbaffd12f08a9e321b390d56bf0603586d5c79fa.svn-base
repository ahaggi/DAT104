package model.answer;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import model.Interview;
import model.question.*;

@Entity
@Table(schema="questionnaire_joined", name="textanswer")
public class TextAnswer extends Answer {

	private String text;

	public TextAnswer() {
		super();
 	}

 	public TextAnswer(Interview interview, String text) {
		super(interview);
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
