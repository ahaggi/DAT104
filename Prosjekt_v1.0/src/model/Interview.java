package model;

import java.util.ArrayList;
import java.util.List;

import model.answer.Answer;
import javax.persistence.*;


@Entity
@Table(schema="questionnaire", name="interview")

public class Interview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String uid;	
	
	@ManyToOne
	@JoinColumn(name = "survey", referencedColumnName = "id", insertable = true, updatable = true)
	private Survey survey;
	
	@OneToMany(mappedBy = "interview", cascade = CascadeType.ALL)
	private List<Answer> answers = new ArrayList<Answer>();

	public Interview() {
		super();
	}
	
	public Interview(Integer id, String uid, Survey survey ) {
		super();
		this.id = id;
		this.uid = uid;
		this.survey = survey;
 	}


	public Interview(Survey survey) {
		this.survey = survey;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

    public void addAnswer(Answer answer) {
    	this.answers.add(answer);
    }

    public void removeAnswer(Answer answer) {
    	this.answers.remove(answer);
    }
    
    public Answer findAnswer(Integer id) {
        Answer answer;
        for (Answer a : answers) {
            if (a.getId()==(id)) {
            	answer=a;
            	return answer;
            }
        }
        return null;
    }



	
}
