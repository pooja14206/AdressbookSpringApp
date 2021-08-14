package com.org.AddressbookSpringApp.dto;

import lombok.*;

import java.util.Date;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressbookDTO {
    public String firstName;
    public String lastName;
    public  String city;
    public int zip;
    public String address;
    public Date createTime;
    public Date updateTime;

}
