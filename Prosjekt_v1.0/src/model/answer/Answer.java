package model.answer;


import model.*;
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) 
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
	
	public Answer(Integer id, Interview interview) {
		super();
		this.id = id;
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

	
	 	

}
