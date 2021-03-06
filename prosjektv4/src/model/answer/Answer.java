package model.answer;


import javax.persistence.*;

import model.Interview;

@Entity
@Table(schema="questionnaire_joined", name="answer")

@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "class_name")
public abstract class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "interview", referencedColumnName = "id", insertable = true, updatable = true)
	private Interview interview;
	
	
	public Answer() {
		super();
 	}
	
	public Answer(Interview interview) {
		super();
		this.interview = interview;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Interview getInterview() {
		return interview;
	}
	public void setInterview(Interview interview) {
		this.interview = interview;
	}
	
	/**
	 * Get the type of answer
	 * @return answer type as string
	 */
	public String getType() {
		return this.getClass().getSimpleName();
	}
}
