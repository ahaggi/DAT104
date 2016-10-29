package EAO;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.*;

import model.*;

 

@Stateless
public class EAO {
	
	@PersistenceContext(name = "PersistenceUnit")
	private EntityManager em;
	
//	<class> model.Interview</class>
//	<class> model.Lecturer</class>
//	<class> model.Survey</class>

	/**De essentialle sporringene mot interview tabell*/
	public void leggTilInterview(Interview i) {
		em.persist(i)  ; 
	}
	
	public void oppdaterInterview(Interview i) {
		em.merge(i)  ; 
	}
	
	public void slettInterview(Integer id) {
		em.remove(em.find(Interview.class, id));
	}
	
	public Interview finnInterview(Integer id){
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

	public void leggTilLecturer(Lecturer l) {
		em.persist(l)  ; 
	}
	
	public void oppdaterLecturer(Lecturer l) {
		em.merge(l)  ; 
	}
	
	public void slettLecturer(Integer id) {
		em.remove(em.find(Lecturer.class, id));
	}
	
	public Lecturer finnLecturer(Integer id){
		return em.find(Lecturer.class, id);
	}

	
	/**De essentialle sporringene mot Survey tabell*/
	public void leggTilSurvey(Survey s) {
		em.persist(s)  ; 
	}
	
	public void oppdaterSurvey(Survey s) {
		em.merge(s)  ; 
	}

	
	public void slettSurvey(Integer id) {
		em.remove(em.find(Survey.class, id));
	}
	
	public Survey finnSurvey(Integer id){
		return em.find(Survey.class, id);
	}

	
	

 
 


}
