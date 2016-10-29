package model.question;

import model.Survey;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 

public abstract class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String text;
	
	@ManyToOne
	@JoinColumn(name = "survey", referencedColumnName = "id", insertable = true, updatable = true)
	private Survey survey;
	
	public Question() {
		super();
	}
	
 
	public Question(Integer id, String text, Survey survey) {
		super();
		this.id = id;
		this.text = text;
		this.survey = survey;
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

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	
	
}
