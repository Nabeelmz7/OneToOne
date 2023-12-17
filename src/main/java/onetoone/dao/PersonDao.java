package onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone.dto.AadharCard;
import onetoone.dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void savePerson(Person person) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(person);
		entityTransaction.commit();
	}
	public void findPersonById(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person!=null){
			//if id present in db
			System.out.println(person);
		}
		else {
			//if id not present in db
			System.out.println("Id is not present");
		}
	}
	public void deletePerson(int id) {
		EntityManager entityManager=getEntityManager();
		Person person=entityManager.find(Person.class, id);
		if(person!=null) {
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(person);
			entityTransaction.commit();
		}
		else {
			System.out.println("Id is not present");
		}
	}
	public void updatePerson(int id, Person person) {
		EntityManager entityManager=getEntityManager();
		Person dbPerson = entityManager.find(Person.class, id);
		if(dbPerson!=null) {
			//if id is present we can update the data
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			person.setId(id);
			person.setAadharCard(dbPerson.getAadharCard());
			entityManager.merge(person);
			entityTransaction.commit();
		}
		else {
			//if id is not present
			System.out.println("Id is not present to update the data");
		}
	}
}
