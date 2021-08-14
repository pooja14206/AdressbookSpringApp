package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.exception.AddressbookException;
import com.org.AddressbookSpringApp.model.AddressbookData;
import com.org.AddressbookSpringApp.repository.IAddressbookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressbookService implements IAddressbookService {

    @Autowired
    private IAddressbookRepository addressbookRepository;

    @Override
    public List<AddressbookData> getAddressbookData() {
        return addressbookRepository.findAll();
    }

    @Override
    public AddressbookData getAddressbookDataById(int id) {
        return addressbookRepository.findById(id).orElseThrow(() -> new AddressbookException("Id: " + id +" does not exists.Please write a correct empId"));
    }

    @Override
    public AddressbookData addAddressbookData(AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = new AddressbookData(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public AddressbookData updateAddressbookData(int id, AddressbookDTO addressbookDTO) {
        AddressbookData addressbookData = this.getAddressbookDataById(id);
        addressbookData.updateaddressbookData(addressbookDTO);
        return addressbookRepository.save(addressbookData);
    }

    @Override
    public void deleteAddressbookData(int id) {
        AddressbookData addressbookData = this.getAddressbookDataById(id);
        addressbookRepository.delete(addressbookData);

    }
}