package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Person;
import com.repository.PersonRepository;
import com.request.PersonClass;

@Service
public class PersonService {

	
	@Autowired
	PersonRepository personRepository;
	
	public String persistPersonWithHobbies(PersonClass person)
	{ 
		//System.out.println("h");
		//System.out.println("here");
		Person personToPersist = new Person();
		personToPersist.setId(person.getId());
		personToPersist.setName(person.getName());
		personToPersist.setHobbies(person.getHobbies());
		
		
		
		//System.out.println(personToPersist);
		
		Person pp  = this.personRepository.save(personToPersist);
		//System.out.println("printing persisted persons id " + pp.getId());
		for (int i =0; i<person.getHobbies().size(); i++)
		{
			
			pp.getHobbies().get(i).setPerson(pp);
			pp.getHobbies().get(i).setNameOfHobby(person.getHobbies().get(i).getNameOfHobby());
		}
		this.personRepository.save(pp);
		return "successfully inserted";
	}
}
