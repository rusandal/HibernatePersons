package com.example.jpahibernate.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class RelationShipId implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
