package com.example.jpahibernate.controller;

import com.example.jpahibernate.model.Persons;
import com.example.jpahibernate.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Data
@AllArgsConstructor
public class PersonController {
    private PersonRepository personRepository;

    @GetMapping("/persons/by-city")
    public List<Persons> getPersons(@RequestParam String city){
        return personRepository.getPersonByCity(city);
    }
}
