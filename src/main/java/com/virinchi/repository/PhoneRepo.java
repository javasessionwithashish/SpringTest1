package com.virinchi.repository;

import com.virinchi.model.Address;
import com.virinchi.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepo extends JpaRepository<Phone, Integer> {
}
