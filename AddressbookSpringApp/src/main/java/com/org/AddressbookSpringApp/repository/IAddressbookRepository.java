package com.org.AddressbookSpringApp.repository;

import com.org.AddressbookSpringApp.model.AddressbookData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAddressbookRepository extends JpaRepository<AddressbookData,Integer> {
}
