package com.smartcontact.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontact.entities.ContactEntity;

public interface ContactReposotories extends JpaRepository<ContactEntity, Long>{
	
	// for pagination we use JPA repository.
	@Query("from ContactEntity as c where c.userEntity.id =:id")
	public Page<ContactEntity> findContactByUser(@Param("id") Long userID,Pageable pageable);
	
	@Query("from ContactEntity as c where c.cid =:id")
	public Optional<ContactEntity> findById(Long id);

}
