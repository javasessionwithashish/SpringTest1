package com.virinchi.repository;

import com.virinchi.model.Address;
import com.virinchi.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepo extends JpaRepository<Address, Integer> {
}
