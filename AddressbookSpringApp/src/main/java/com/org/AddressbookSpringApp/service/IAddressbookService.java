package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.dto.StateDTO;

import java.util.List;

public interface IAddressbookService {
    /*
     * @purpose: Ability To Get All Person From Addressbook.
     * @Execution URL: localhost:8080/addressbook/get.
     * @return: List of person.
     */

    List<AddressbookDTO> getAddressbookData();

    /*
     * @purpose: Ability to get person by id from address book.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/get/1.
     * @return
     */

    AddressbookDTO getAddressbookDataById(int id);

    /*
     * @purpose: Ability to add person to the address book.
     * @param: addressbookDTO.
     * @Execution URL: localhost:8080/address-book/create.
     * @return
     */

    AddressbookDTO addAddressbookData(AddressbookDTO addressbookDTO);

    /**
     * @purpose: Ability to update person to the addressbook.
     * @param: addressbookDTO.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/update.
     * @return.
     */

    AddressbookDTO updateAddressbookData(int id, AddressbookDTO addressbookDTO);

    /*
     * @purpose: Ability to delete person from the adress book.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/delete/1.
     * @return.
     */

    void deleteAddressbookData(int id);

    /**
     * Purpose : Ability to get all state details.
     * @return.
     */

    public List<StateDTO> getStateDetails();
}