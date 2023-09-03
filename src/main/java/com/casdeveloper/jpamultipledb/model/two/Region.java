package com.casdeveloper.jpamultipledb.model.two;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "REGION")
public class Region {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;
}
