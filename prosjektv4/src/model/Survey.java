package model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import model.question.Question;



@Entity
@Table(schema="questionnaire_joined", name="survey")
public class Survey implements SurveyADT {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private String description;
	private Boolean repeatable;
	private Boolean traversable;
	private Long length;
	private Long endDate;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="survey", referencedColumnName="id")
	private List<Question> questions = new ArrayList<Question>();
	
	public Survey() {
		super();
	}
	
    public Survey(String name, String description, boolean repeatable, boolean traversable,	 long length) {
		super();
		this.name = name;
		this.description = description;
		this.repeatable = repeatable;
		this.traversable = traversable;
		this.length = length;
		this.endDate = (Long) null;
		
	}
    public void Publish(){
    	if (!isPublished()) {
    		this.endDate=Instant.now().toEpochMilli() + this.length;
		}
    }

    public boolean isPublished() {
 		return (endDate != null);
	}

    public boolean isValidToStart() {
    	if (isPublished()) {
    		return Instant.now().toEpochMilli() < this.endDate;
		}
 		return false;
	}

    
    
	public List<Question> getQuestions() {
		return questions;
	}



	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}


    public void addQuestion(Question question) {
    	this.questions.add(question);
    }

    public void removeQuestion(Question question) {
    	this.questions.remove(question);
    }

	public Question getQuestion(int index) {
		Question question;
		question = (index < questions.size()) ? questions.get(index) : null;
		return question;

	}

	public Question findQuestion(Integer id) {
        Question question;
        for (Question q : questions) {
            if (q.getId()==(id)) {
            	question=q;
            	return question;
            }
        }
        return null;
    }
	
	public Integer getId() {
		return id;
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

	public boolean isRepeatable() {
		return repeatable;
	}

	public void setRepeatable(boolean repeatable) {
		this.repeatable = repeatable;
	}

	public boolean isTraversable() {
		return traversable;
	}

	public void setTraversable(boolean traversable) {
		this.traversable = traversable;
	}


	public long getLength() {
		return length;
	}

	public void setLength(long length) {
		this.length = length;
	}

	public long getEndDate() {
		return endDate;
	}

	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
}
