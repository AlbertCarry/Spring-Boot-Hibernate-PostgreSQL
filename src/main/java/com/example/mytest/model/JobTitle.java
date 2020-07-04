package com.example.mytest.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "jobtitle")
public class JobTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "position")
    private String jobPosition;

}
