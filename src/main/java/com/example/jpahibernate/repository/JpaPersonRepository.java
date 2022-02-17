package com.example.jpahibernate.repository;

import com.example.jpahibernate.model.Persons;
import com.example.jpahibernate.model.RelationShipId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JpaPersonRepository extends JpaRepository<Persons, RelationShipId> {
    List<Persons> getPersonsByCityOfLiving(String city);
    List<Persons> findByRelationShipIdAgeLessThan(Integer age, Sort sort);
    Optional<Persons> findByRelationShipIdNameAndRelationShipIdSurname(String name, String surname);
}
