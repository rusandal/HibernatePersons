package com.example.jpahibernate.repository;

import com.example.jpahibernate.model.Persons;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PersonRepository {
    @PersistenceContext
    EntityManager entityManager;

    public List<Persons> getPersonByCity(String myCity){
        Query query = entityManager.createQuery("select p from Persons p where p.cityOfLiving=:city");
        query.setParameter("city", myCity);
        return query.getResultList();
    }
}
