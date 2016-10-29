package model.answer;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import model.Interview;
 

@Entity
@Table(schema="questionnaire_joined", name="multiplechoiceanswer")

public class MultipleChoiceAnswer extends Answer {
	
	@ElementCollection
	@CollectionTable(name ="answeredoptions")
	private List<Integer> options = new ArrayList<Integer>();

	public MultipleChoiceAnswer() {
		super();
 	}

	public MultipleChoiceAnswer(Interview interview) {
		super(interview);
 	}

	public List<Integer> getAnsweredChoices() {
		return options;
	}

	public void setAnsweredChoices(List<Integer> choices) {
		this.options = choices;
	}
	
	//TODO Det kan v�re flere options som har det samme verdi, vi b�r sjekke p� id
	  public void addOption(Integer option) {
		  options.add(option);
	}

	public void removeOption(String option) {
		options.remove(option);
	}
//TODO java doc
	public Integer findOption(Integer option) {
		Integer opt;
	    for (Integer o : options) {
	        if (o==(option)) {
	        	opt= o;
	        	return opt;
	        }
	    }
	    return null;
	}

}
