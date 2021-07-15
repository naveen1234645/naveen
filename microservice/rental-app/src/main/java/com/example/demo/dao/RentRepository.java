  
package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.RentEntity;
@Repository
public interface RentRepository extends JpaRepository<RentEntity, Integer>{

}