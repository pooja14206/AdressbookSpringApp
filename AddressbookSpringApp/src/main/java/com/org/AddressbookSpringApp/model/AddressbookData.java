package com.org.AddressbookSpringApp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter@Setter
public class AddressbookData {
    private String firstName;
    private String lastName;
    private String city;
    private int zip;
    private String address;
}
