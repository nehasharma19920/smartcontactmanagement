package com.smartcontact.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartcontact.entities.UserEntity;

@Repository
public interface UserRepositories extends JpaRepository<UserEntity, Long> {


}

