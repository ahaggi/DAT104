package model;

import java.util.ArrayList;
import java.util.List;

import model.question.Question;
import javax.persistence.*;


@Entity
@Table(schema="questionnaire", name="survey")

public class Survey {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id;
	private String name;
	private String description;
	private boolean repeatable;
	private boolean traversable;
	
//	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
//	private List<Question> questions = new ArrayList<Question>();
	
//	@OneToMany(mappedBy = "survey", cascade = CascadeType.ALL)
//	private List<Interview> interview = new ArrayList<Interview>();
	
	@ManyToOne
	@JoinColumn(name = "lecturer", referencedColumnName = "id", insertable = true, updatable = true)
	private Lecturer lecturer;

	public Survey() {
		super();
	}


	public Survey(Integer id, String name, String description,  boolean repeatable, boolean traversable, Lecturer lecturer) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.repeatable = repeatable;
		this.traversable = traversable;
		this.lecturer = lecturer;
	}






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public List<Question> getQuestions() {
//		return questions;
//	}
//
//	public void setQuestions(List<Question> questions) {
//		this.questions = questions;
//	}

//	public List<Interview> getInterview() {
//		return interview;
//	}
//
//	public void setInterview(List<Interview> interview) {
//		this.interview = interview;
//	}

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public Lecturer getLecturer() {
		return lecturer;
	}

	public void setLecturer(Lecturer lecturer) {
		this.lecturer = lecturer;
	}


	public boolean isTraversable() {
		return traversable;
	}


	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}

//    public void addQuestion(Question question) {
//    	this.questions.add(question);
//    }
//
//    public void removeQuestion(Question question) {
//    	this.questions.remove(question);
//    }
//    
//    public Question findQuestion(Integer id) {
//        Question question;
//        for (Question q : questions) {
//            if (q.getId()==(id)) {
//            	question=q;
//            	return question;
//            }
//        }
//        return null;
//    }


	
}
