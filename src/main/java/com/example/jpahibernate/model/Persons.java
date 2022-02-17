package com.example.jpahibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Persons{
    @Column(columnDefinition = "serial")
    private Integer id;
    @EmbeddedId
    private RelationShipId relationShipId;;
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;
}
