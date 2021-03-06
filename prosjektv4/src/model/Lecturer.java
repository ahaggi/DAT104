package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(schema="questionnaire_joined", name="lecturer")

public class Lecturer implements LecturerADT {
	@Id
	private String username;
	
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="lecturer", referencedColumnName="username")
	private List<Survey> surveys = new ArrayList<Survey>();
	
	public Lecturer() {
		super();
 	}
	public Lecturer( String name, String password) {
		super();
		this.username = name;
		this.password = password;
 	}
	
	/* (non-Javadoc)
	 * @see model.LecturerEAO#getName()
	 */
	@Override
	public String getName() {
		return username;
	}
	/* (non-Javadoc)
	 * @see model.LecturerEAO#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.username = name;
	}
	/* (non-Javadoc)
	 * @see model.LecturerEAO#getPassword()
	 */
	@Override
	public String getPassword() {
		return password;
	}
	/* (non-Javadoc)
	 * @see model.LecturerEAO#setPassword(java.lang.String)
	 */
	@Override
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Survey> getSurveys() {
		return surveys;
	}
	public void setSurvey(List<Survey> surveys) {
		this.surveys = surveys;
	}

    public void addSurvey(Survey survey) {
    	this.surveys.add(survey);
    }

    public void removeSurvey(Survey survey) {
    	this.surveys.remove(survey);
    }
    
    public Survey findSurvey(Integer id) {
        Survey survey;
        for (Survey s : surveys) {
            if (s.getId()==(id)) {
            	survey=s;
            	return survey;
            }
        }
        return null;
    }

}
