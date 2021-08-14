package com.org.AddressbookSpringApp.repository;

import com.org.AddressbookSpringApp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAddressbookRepository extends JpaRepository<AddressbookData,Integer> {
}
