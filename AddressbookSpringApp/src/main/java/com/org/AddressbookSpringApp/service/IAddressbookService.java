package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;

import java.util.List;

public interface IAddressbookService {
    List<AddressbookData> getAddressbookData();
    AddressbookData getAddressbookDataById(int id);
    AddressbookData addAddressbookData(AddressbookDTO addressbookDTO);
    AddressbookData updateAddressbookData(int id, AddressbookDTO addressbookDTO);
    void deleteAddressbookData(int id);
}
