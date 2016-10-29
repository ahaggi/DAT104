package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.answer.Answer;


@Entity
@Table(schema="questionnaire_joined", name="interview")

public class Interview implements InterviewADT {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String uid;	
	
	@ManyToOne
	@JoinColumn(name = "survey", referencedColumnName = "id", insertable = true, updatable = true)
	private Survey survey;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="interview", referencedColumnName="id")
	private List<Answer> answers = new ArrayList<Answer>();

	public Interview() {
		super();
	}
	
	public Interview(String uid, Survey survey ) {
		super();
		this.uid = uid;
		this.survey = survey;
 	}


	public Interview(Survey survey) {
		this.survey = survey;
	}

	/* (non-Javadoc)
	 * @see model.InterviewEAO#getId()
	 */
	@Override
	public Integer getId() {
		return id;
	}

	/* (non-Javadoc)
	 * @see model.InterviewEAO#setId(java.lang.Integer)
	 */
	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/* (non-Javadoc)
	 * @see model.InterviewEAO#getSurvey()
	 */
	@Override
	public Survey getSurvey() {
		return survey;
	}

	/* (non-Javadoc)
	 * @see model.InterviewEAO#setSurvey(model.Survey)
	 */
	@Override
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}


	/* (non-Javadoc)
	 * @see model.InterviewEAO#getUid()
	 */
	@Override
	public String getUid() {
		return uid;
	}


	/* (non-Javadoc)
	 * @see model.InterviewEAO#setUid(java.lang.String)
	 */
	@Override
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
