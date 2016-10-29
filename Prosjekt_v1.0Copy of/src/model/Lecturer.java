package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(schema="questionnaire", name="lecturer")

public class Lecturer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "lecturer", cascade = CascadeType.ALL)
	private List<Survey> surveys=new ArrayList<Survey>();
	
	
	
	public Lecturer() {
		super();
 	}
	public Lecturer(Integer id, String name, String password) {
		super();
		this.id = id;
		this.username = name;
		this.password = password;
 	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return username;
	}
	public void setName(String name) {
		this.username = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public List<Survey> getSurvey() {
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
