package com.org.AddressbookSpringApp.service;

import com.org.AddressbookSpringApp.builder.AddressbookBuilder;
import com.org.AddressbookSpringApp.dto.AddressbookDTO;
import com.org.AddressbookSpringApp.dto.StateDTO;
import com.org.AddressbookSpringApp.exception.AddressbookException;
import com.org.AddressbookSpringApp.model.AddressbookData;
import com.org.AddressbookSpringApp.repository.IAddressbookRepository;
import com.org.AddressbookSpringApp.repository.IStateRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AddressbookService implements IAddressbookService {

    @Autowired
    private IAddressbookRepository addressbookRepository;

    @Autowired
    private AddressbookBuilder addressbookBuilder;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private IStateRepository stateRepository;

    @Override
    public List<AddressbookDTO> getAddressbookData() {
      log.info("Inside getAdressbookData method");
        return addressbookRepository.findAll().stream()
                .map(addressBookData -> modelMapper.map(addressBookData, AddressbookDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public AddressbookDTO getAddressbookDataById(int id) {
        log.info("Inside getAdressbookDataById method");
        AddressbookData personById = addressbookRepository.findById(id).
                orElseThrow(() -> new AddressbookException("Id: " + id + " does not exists.Please write a correct empId"));
        AddressbookDTO addressbookDTO = modelMapper.map(personById, AddressbookDTO.class);
        log.info("getAdressbookDataById method execute successfully");
        return addressbookDTO;
    }

    @Override
    public AddressbookDTO addAddressbookData(AddressbookDTO addressbookDTO) {
        log.info("Inside addAdressbookData method");
        AddressbookData addressbookData = addressbookBuilder.buildDTO(addressbookDTO);
        addressbookData = addressbookRepository.save(addressbookData);
//        addressbookDTO.setId(addressbookData.getId());
        log.info("addAdressbookData method execute successfully");
        return addressbookDTO;
    }

    @Override
    public AddressbookDTO updateAddressbookData(int id, AddressbookDTO addressbookDTO) {
        log.info("Inside updateAdressbookData method");
        AddressbookData addressbookData = addressbookRepository.findById(id).
                orElseThrow(() -> new AddressbookException("Error"));
        String[] ignoreFields = {"id", "name", "createdDate"};
        BeanUtils.copyProperties(addressbookDTO, addressbookData, ignoreFields);
        addressbookRepository.save(addressbookData);
        log.info("updateAdressbookData method successfully");
        return addressbookDTO;
    }

    @Override
    public void deleteAddressbookData(int id) {
        log.info("Inside deleteAdressbookData method");
        AddressbookDTO addressbookDTO = this.getAddressbookDataById(id);
        AddressbookData personToBeDeleted = addressbookBuilder.buildDTO(addressbookDTO);
        addressbookRepository.delete(personToBeDeleted);
        log.info("deleteAdressbookData method execute successfully");
    }

    @Override
    public List<StateDTO> getStateDetails() {
        log.info("Inside getStateDetails method");
        return stateRepository.findAll().stream().map(state -> {
            return new StateDTO(state.getId(), state.getStateName(), state.getCity());
        }).collect(Collectors.toList());
    }
}