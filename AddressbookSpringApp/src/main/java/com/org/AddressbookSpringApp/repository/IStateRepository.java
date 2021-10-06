package com.org.AddressbookSpringApp.repository;

import com.org.AddressbookSpringApp.model.StateData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<StateData, Integer > {
}
