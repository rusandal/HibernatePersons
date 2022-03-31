package com.example.jpahibernate.controller;

import com.example.jpahibernate.model.Persons;
import com.example.jpahibernate.model.RelationShipId;
import com.example.jpahibernate.repository.JpaPersonRepository;
import com.example.jpahibernate.repository.PersonRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.util.List;
import java.util.Optional;

@RestController
@Data
@AllArgsConstructor
public class PersonController {
    private PersonRepository personRepository;
    private JpaPersonRepository jpaPersonRepository;

    @RolesAllowed({"ROLE_ADMIN"})
    @GetMapping("/persons/by-city")
    public List<Persons> getPersons(@RequestParam String city){
        return personRepository.getPersonByCity(city);
    }

    @Secured({"ROLE_ADMIN"})
    @GetMapping("/persons/byCity")
    public List<Persons> getPersonsByCity (@RequestParam String city){
        return jpaPersonRepository.getPersonsByCityOfLiving(city);
        //return jpaPersonRepository.getPersonsByCityOfLiving(city);
    }

    @PreAuthorize("hasAnyRole('USER')")
    @GetMapping("/persons/byAgeSort")
    public List<Persons> getPersonsByAgeSort (@RequestParam String age){
        return jpaPersonRepository.findByRelationShipIdAgeLessThan(Integer.parseInt(age));
        //return jpaPersonRepository.findByRelationShipIdAgeLessThan(Integer.parseInt(age), Sort.by("relationShipId.age"));
    }

    @GetMapping("/persons/byNameAndSurname")
    public Optional<Persons> getPersonsByAgeSort (@RequestParam String name, @RequestParam String surname){
        return jpaPersonRepository.findByRelationShipIdNameAndRelationShipIdSurname(name, surname);
        //return jpaPersonRepository.findByRelationShipIdNameAndRelationShipIdSurname(name, surname);
    }
}
