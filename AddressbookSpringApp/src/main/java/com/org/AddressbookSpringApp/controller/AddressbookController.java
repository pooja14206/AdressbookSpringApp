package com.org.AddressbookSpringApp.controller;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.dto.ResponseDTO;
import com.org.AddressbookSpringApp.service.IAddressbookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@Slf4j
public class AddressbookController {

    @Autowired
    IAddressbookService addressbookService;

    /*
     * @purpose: Ability To Get All Person From Address book.
     * @Execution URL: localhost:8080/address book/get.
     * @return: response DTO.
     */

    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAddressbookData() {
        log.info("Inside getAdressbookData method.");
        ResponseDTO responseDTO = new ResponseDTO("get All employees", addressbookService.getAddressbookData());
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @purpose: Ability to get person by id from address book.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/get/1.
     * @return:responseDTO.
     */

    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getAddressbookData(@PathVariable("id") int id) {
        log.info("Inside getAddressbookData method");
        ResponseDTO responseDTO = new ResponseDTO("Get person by id successfully executed", addressbookService.getAddressbookDataById(id));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @purpose: Ability to add person to the address book.
     * @param: addressbookDTO.
     * @Execution URL: localhost:8080/address-book/create.
     * @return:responseDTO
     */

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> addAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO) {
        log.info("Inside addAddressbookData method");
        ResponseDTO responseDTO = new ResponseDTO("add person Successfully", addressbookService.addAddressbookData(addressbookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * @purpose: Ability to update person to the addressbook.
     * @param: addressbookDTO.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/update.
     * @return: responseDTO.
     */

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> updateAddressbookData(@Valid @RequestBody AddressbookDTO addressbookDTO, @PathVariable int id) {
        log.info("Inside updateAddressbookData method");
        ResponseDTO responseDTO = new ResponseDTO("Updated person Successfully", addressbookService.updateAddressbookData(id, addressbookDTO));
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /*
     * @purpose: Ability to delete person from the adress book.
     * @param: id.
     * @Execution URL: localhost:8080/addressbook/delete/1.
     * @return: responseDTO.
     */

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> deleteAddressbookData(@PathVariable("id") int id) {
        log.info("Inside deleteAddressbookData method");
        addressbookService.deleteAddressbookData(id);
        ResponseDTO responseDTO = new ResponseDTO("Deleted Successfully: ", "Deleted id: " + id);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    /**
     * Purpose : Ability to get all state details.
     * @return responseDTO
     */

    @GetMapping(value = "/getStateDetails")
    public ResponseEntity<ResponseDTO> getStateDetails() {
        log.info("Inside getStateDetails method");
        ResponseDTO responseDTO = new ResponseDTO("Fetched all State Details", addressbookService.getStateDetails());
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
}