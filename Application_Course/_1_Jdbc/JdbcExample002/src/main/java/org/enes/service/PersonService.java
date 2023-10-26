package org.enes.service;

import org.enes.entity.Person;
import org.enes.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(){
        personRepository = new PersonRepository();
    }
    public void register(Person person){
        personRepository.save(person);
    }
}
