package com.project.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Location {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String name;
    private Long startDate;
    private Long endDate;

    public Location() {}
}
