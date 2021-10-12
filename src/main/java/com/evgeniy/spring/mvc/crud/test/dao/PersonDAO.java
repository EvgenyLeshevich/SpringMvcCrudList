package com.evgeniy.spring.mvc.crud.test.dao;

import com.evgeniy.spring.mvc.crud.test.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT,"Evgeniy","Leshevich",22,"jeniya.leshevich@yandex.by"));
        people.add(new Person(++PEOPLE_COUNT,"Tom","Cat",2,"tom.cat@yandex.by"));
        people.add(new Person(++PEOPLE_COUNT,"Vasya","Cat",5,"vasya.cat@yandex.by"));
    }

    public List<Person> all(){
        return people;
    }

    public Person searchById(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person person) {
        Person personToBeUpdated = searchById(id);
        personToBeUpdated.setName(person.getName());
        personToBeUpdated.setLastName(person.getLastName());
        personToBeUpdated.setAge(person.getAge());
        personToBeUpdated.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
