package com.example.jpahibernate.repository;

import com.example.jpahibernate.model.Persons;
import com.example.jpahibernate.model.RelationShipId;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JpaPersonRepository extends JpaRepository<Persons, RelationShipId> {
    //List<Persons> getPersonsByCityOfLiving(String city);
    @Query("select p from Persons p where p.cityOfLiving=:city")
    List<Persons> getPersonsByCityOfLiving(@Param("city") String city);

    //List<Persons> findByRelationShipIdAgeLessThan(Integer age, Sort sort);
    @Query("select p from Persons p where p.relationShipId.age<:age order by p.relationShipId.age")
    List<Persons> findByRelationShipIdAgeLessThan(@Param("age") Integer age);

    //Optional<Persons> findByRelationShipIdNameAndRelationShipIdSurname(String name, String surname);
    @Query("select p from Persons p where p.relationShipId.name=:name and p.relationShipId.surname=:surname")
    Optional<Persons> findByRelationShipIdNameAndRelationShipIdSurname(@Param("name") String name, @Param("surname") String surname);

}
