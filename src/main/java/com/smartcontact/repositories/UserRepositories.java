package com.smartcontact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcontact.entities.UserEntity;
import com.sun.xml.bind.v2.model.core.ID;

public interface UserRepositories extends JpaRepository<UserEntity, Long> {

}
