package com.smartcontact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcontact.entities.User;
import com.sun.xml.bind.v2.model.core.ID;

public interface UserRepositories extends JpaRepository<User, Long> {

}
