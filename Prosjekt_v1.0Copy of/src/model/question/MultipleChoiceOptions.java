package model.question;

import javax.persistence.*;

@Entity
@Table(schema="questionnaire", name="multiplechoiceoptions")

public class MultipleChoiceOptions {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "multiplechoicequestion", referencedColumnName = "id", insertable = true, updatable = true)
	private MultipleChoiceQuestion multipleChoiceQuestion;
	 
	public MultipleChoiceOptions() {
		super();
 	}


	public MultipleChoiceOptions(Integer id, String text, MultipleChoiceQuestion multipleChoiceQuestion) {
		super();
		this.id = id;
		this.text = text;
		this.multipleChoiceQuestion  = multipleChoiceQuestion;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}


	public MultipleChoiceQuestion getMultipleChoiceQuestion() {
		return multipleChoiceQuestion;
	}


	public void setMultipleChoiceQuestion(MultipleChoiceQuestion multipleChoiceQuestion) {
		this.multipleChoiceQuestion = multipleChoiceQuestion;
	}

 	
	

}
