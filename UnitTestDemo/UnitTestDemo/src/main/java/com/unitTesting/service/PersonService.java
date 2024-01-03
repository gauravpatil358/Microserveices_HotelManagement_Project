package com.unitTesting.service;

import com.unitTesting.entities.Person;

import java.util.List;

public interface PersonService {

    Person create(Person person);

    List<Person> getAll();

    Person getPersonById(Person person,Integer id);
}
