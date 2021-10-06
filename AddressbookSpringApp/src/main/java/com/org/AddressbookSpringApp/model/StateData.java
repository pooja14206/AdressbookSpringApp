package com.org.AddressbookSpringApp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class StateData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "STATE_NAME")
    private String stateName;

    @ElementCollection
    @CollectionTable(name = "state_city", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "CITY")
    private List<String> city;
}
