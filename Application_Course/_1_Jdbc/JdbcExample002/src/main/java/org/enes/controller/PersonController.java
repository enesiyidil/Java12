package org.enes.controller;

import org.enes.entity.Person;
import org.enes.service.PersonService;

public class PersonController {

    private final PersonService personService;

    public PersonController(){
        personService = new PersonService();
    }
    public boolean register(Person person){
        return personService.register(person);
    }

    public void getAllData() {
        personService.getAllData();
    }

    public void deleteAllData() {
        personService.deleteAllData();
    }

    public void findPersonById(int id) {
        personService.findPersonById(id);
    }

    public void deletePersonById(int id) {
        personService.deletePersonById(id);
    }
}
