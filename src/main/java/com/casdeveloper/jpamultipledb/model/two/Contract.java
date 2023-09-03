package com.casdeveloper.jpamultipledb.model.two;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CONTRACT")
public class Contract {


    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "region", referencedColumnName = "id")
    private Region region;
}
