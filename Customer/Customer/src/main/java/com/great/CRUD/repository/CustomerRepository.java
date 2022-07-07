package com.great.CRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.great.CRUD.model.*;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}