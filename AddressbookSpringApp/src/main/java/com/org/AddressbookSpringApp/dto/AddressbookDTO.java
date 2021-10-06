package com.org.AddressbookSpringApp.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@ToString
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressbookDTO {
    int id;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "person FirstName is Invalid")
    @NotEmpty(message = "Full name should not be Empty")
    public String fullName;

    @NotNull(message = "City should not be Empty")
    public String city;

    @NotNull(message = "State should not be Empty")
    public String state;

    @Pattern(regexp = "^[a-zA-Z0-9]{1,}[.a-zA-Z0-9]*@[a-zA-Z0-9]{1,}((.){1}+)([a-z]{1,3}+)(.[a-z]{2})*$", message = "Email is invalid")
    @NotNull(message = "Email should not be Empty")
    public String emailId;

    @NotNull(message = "Zip should not be Empty")
    @Pattern(regexp = "^[0-9]{6}$", message = "Person Zip Invalid")
    public String zip;

    @NotEmpty(message = "Phone Number should not be Empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Person PhoneNo Invalid")
    public String phoneNumber;

    @NotNull(message = "Address should not be Empty")
    public String address;
}