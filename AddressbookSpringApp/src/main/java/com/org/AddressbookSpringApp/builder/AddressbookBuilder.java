package com.org.AddressbookSpringApp.builder;

import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.model.AddressbookData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AddressbookBuilder {
    public AddressbookData buildDTO(AddressbookDTO addressbookDTO) {
        log.info("inside buildDTO method");
        AddressbookData addressBookData = new AddressbookData();
        BeanUtils.copyProperties(addressbookDTO, addressBookData);
        log.info("buildDTO method execute successfully");
        return addressBookData;
    }
}