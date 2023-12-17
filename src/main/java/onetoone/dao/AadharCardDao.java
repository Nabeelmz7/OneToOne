package onetoone.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import onetoone.dto.AadharCard;
import onetoone.dto.Person;

public class AadharCardDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	public void saveAadharCard(AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(aadharCard);
		entityTransaction.commit();
	}
	public void findAadharById(int id) {
		EntityManager entityManager = getEntityManager();
		AadharCard aadharCard=entityManager.find(AadharCard.class, id);
		if(aadharCard!=null) {
			//id is present in db
			System.out.println(aadharCard);
		}
		else {
			System.out.println("Id is not present in database");
		}
	}
	public void deleteAadharCard(int id) {
		EntityManager entityManager=getEntityManager();
		AadharCard aadharCard=entityManager.find(AadharCard.class, id);
		if(aadharCard!=null) {
			//if id is present then it will be deleted from here
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.remove(aadharCard);
			entityTransaction.commit();
		}
		else 
			//if id is not present
		{
			System.out.println("Id is not present");
		}
	}
	public void updateAadhar(int id, AadharCard aadharCard) {
		EntityManager entityManager=getEntityManager();
		AadharCard dbAadharCard=entityManager.find(AadharCard.class, id);
		if(dbAadharCard!=null) {
			//if id is present this will execute
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			aadharCard.setId(id);
			entityManager.merge(aadharCard);
			entityTransaction.commit();
		}
		else {
			//if id is not present
			System.out.println("Sorry id is not present");
		}
	}
}
