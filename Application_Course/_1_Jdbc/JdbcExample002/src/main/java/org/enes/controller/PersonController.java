package org.enes.controller;

import org.enes.entity.Person;
import org.enes.repository.PersonRepository;
import org.enes.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(){
        personService = new PersonService();
    }
    public void register(Person person){
        personService.register(person);
    }
}
