package com.org.AddressbookSpringApp.controller;


import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.dto.ResponseDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AddressbookController {
    //curl localhost:8080/addressbook/get
    @RequestMapping("/get")
    public ResponseEntity<String> getAddressbookData() {
        return new ResponseEntity<String>("Get Call Success.", HttpStatus.OK);
    }

    //curl localhost:8080/addressbook/get/1
    @GetMapping("/get/{Id}")
    public ResponseEntity<String> getAddressbookData(@PathVariable("Id") int id){
        return new ResponseEntity<String >("Get Call Success for id:"+id, HttpStatus.OK);
    }

     //http://localhost:8080/addressbook/create
    @PostMapping("/create")
    public ResponseEntity<String> addAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        return new ResponseEntity<String >("Created Employee payroll data for:"+addressbookDTO, HttpStatus.OK);
    }

     //http://localhost:8080/addressbook/update
    @PutMapping("/update")
    public ResponseEntity<String > updateAddressbookData(@RequestBody AddressbookDTO addressbookDTO) {
        return new ResponseEntity<String >("Updated Employee payroll Data for: "+addressbookDTO, HttpStatus.OK);
    }

     //http://localhost:8080/addressbook/delete/1
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String> deleteAddressbookData(@PathVariable("Id") int id) {
        return new ResponseEntity<String >("Delete Call Success for id: "+id, HttpStatus.OK);
        }
}
