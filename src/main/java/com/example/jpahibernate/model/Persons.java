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
public class Persons implements Serializable {
    @Column(columnDefinition = "serial")
    private Integer id;
    @Id
    private String name;
    @Id
    private String surname;
    @Id
    private Integer age;
    private String phoneNumber;
    @Column(nullable = false)
    private String cityOfLiving;
}
