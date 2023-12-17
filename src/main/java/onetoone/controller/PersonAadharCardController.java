package onetoone.controller;

import onetoone.dao.AadharCardDao;
import onetoone.dao.PersonDao;
import onetoone.dto.AadharCard;
import onetoone.dto.Person;

public class PersonAadharCardController {
	public static void main(String[] args) {
		PersonDao personDao=new PersonDao();
		AadharCardDao aadharCardDao=new  AadharCardDao();
		
		//save
		
		Person person=new Person();
		person.setId(1);
		person.setName("Muhammed Ali");
		person.setAddress("Tarnaka");
		
		person.setId(2);
		person.setName("Muhammed Bin");
		person.setAddress("Shah ali banda");
		
		person.setId(3);
		person.setName("Rakesh");
		person.setAddress("Raidurg");
	//--------------------------------------------------*******************************************************---------------------------------------------------
		AadharCard aadharCard=new AadharCard();
		aadharCard.setId(864);
		aadharCard.setName("Muhammed Ali");		
		aadharCard.setAge(24);
		
		aadharCard.setId(235);
		aadharCard.setName("Muhammed Bin");		
		aadharCard.setAge(32);
		
		aadharCard.setId(312);
		aadharCard.setName("Rakesh");		
		aadharCard.setAge(27);
	//---------------------------------------------------*******************************************************----------------------------------------------------
		aadharCardDao.saveAadharCard(aadharCard);
		person.setAadharCard(aadharCard);
		personDao.savePerson(person);
		
		
		//select 
//		personDao.findPersonById(1);
//		aadharCardDao.findAadharById(1);
		
		//delete
		personDao.deletePerson(1);
		aadharCardDao.deleteAadharCard(1);
		
//		AadharCard aadharCard = new AadharCard();
		aadharCard.setName("Bingo");
		aadharCard.setAge(18);
		aadharCardDao.updateAadhar(2, aadharCard);
	}
}
