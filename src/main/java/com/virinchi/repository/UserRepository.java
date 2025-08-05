package com.virinchi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.virinchi.model.UserClass;

@Repository
public interface UserRepository extends JpaRepository<UserClass,Integer> {

	
		//void findByUsernameAndPassword(String username, String password);
		boolean existsByUsernameAndPassword(String username, String password);
}
