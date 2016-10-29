package EAO;


import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

import model.*;

 

@Stateless
public class EAO {
	
	@PersistenceContext(name = "PersistenceUnit")
	private EntityManager em;
	

	/**De essentialle sporringene mot interview tabell*/
	public void addInterview(Interview i) {
		em.persist(i)  ; 
	}
	
	public void updateInterview(Interview i) {
		em.merge(i)  ; 
	}
	
	public void deleteInterview(Integer id) {
		em.remove(em.find(Interview.class, id));
	}
	
	public Interview findInterview(Integer id){
		return em.find(Interview.class, id);
	}

	public List<Integer> visInterviewResultat(Integer interviewId) {
		String sporring =	"SELECT  (SELECT count(ac.choice) as res"
				+ "			FROM multiplechoiceanswer mca, answeredchoices ac"
				+ "			WHERE c.id=ac.choice and mca.id=ac.multiplechoiceanswer  and mca.interview=interviewId"
				+ "			)"
				+ "FROM choice c"
				+ "ORDER BY c.id";
		Query query =  em.createQuery(sporring).setParameter("interviewId", interviewId);
		List <Integer> resultal = query.getResultList();
		return resultal;
	}

	
	/**De essentialle sporringene mot Lecturer tabell*/

	public void addLecturer(Lecturer l) {
		em.persist(l)  ; 
	}
	
	public void updateLecturer(Lecturer l) {
		em.merge(l)  ; 
	}
	
	public void deleteLecturer(Integer id) {
		em.remove(em.find(Lecturer.class, id));
	}
	
	public Lecturer findLecturer(Integer id){
		return em.find(Lecturer.class, id);
	}

	
	/**De essentialle sporringene mot Survey tabell*/
	public void addSurvey(Survey s) {
		em.persist(s)  ; 
	}
	
	public void updateSurvey(Survey s) {
		em.merge(s)  ; 
	}

	
	public void deleteSurvey(Integer id) {
		em.remove(em.find(Survey.class, id));
	}
	
	public Survey findSurvey(Integer id){
		return em.find(Survey.class, id);
	}

}
