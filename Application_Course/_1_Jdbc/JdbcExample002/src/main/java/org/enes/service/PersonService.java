package org.enes.service;

import org.enes.entity.Person;
import org.enes.repository.PersonRepository;

public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(){
        personRepository = new PersonRepository();
    }
    public boolean register(Person person){
        return personRepository.register(person);
    }

    public void getAllData() {
        personRepository.getAllData();
    }

    public void deleteAllData() {
        personRepository.deleteAllData();
    }

    public void findPersonById(int id) {
        personRepository.findPersonById(id);
    }

    public void deletePersonById(int id) {
        personRepository.deletePersonById(id);
    }
}
