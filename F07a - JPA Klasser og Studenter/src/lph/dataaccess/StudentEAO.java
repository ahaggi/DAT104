package lph.dataaccess;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import lph.model.Klasse;
import lph.model.Student;

@Stateless
public class StudentEAO {
	
	@PersistenceContext(name = "studentPersistenceUnit")
	private EntityManager em;
	
	public void leggTilStudent(Student s) {
		em.persist(s);
	}
	
	public Student finnStudent(String id) {
		return em.find(Student.class, id);
	}
	
	public void oppdaterStudent(Student s) {
		em.merge(s);
	}
	
	public void slettStudent(String id) {
		em.remove(em.find(Student.class, id));
	}
	
	public void byttKlasse(String studentid, String klassekode) {

		Student s = em.find(Student.class, studentid);
		Klasse k = em.find(Klasse.class, klassekode); 
		s.setKlasse(k);
		k.addStudent(s);
//? Også slette fra gammel klasse?
		em.merge(s);
		em.merge(k);
//? flush() ..
	}

	public List<Student> alleStudenterIKlasse(String klassekode) {
		return em.find(Klasse.class, klassekode).getStudenter();
	}
	
	public List<Student> alleStudenterTotalt() {
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s", Student.class);
		return query.getResultList();
	}

	public List<Klasse> allekalasserTotalt() {
		TypedQuery<Klasse> query = em.createQuery("SELECT k FROM Klasse k", Klasse.class);
		return query.getResultList();
	}

}
