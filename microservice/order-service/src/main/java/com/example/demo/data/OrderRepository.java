  
package com.example.demo.data;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.OrderEntity;
@Repository
public interface OrderRepository extends MongoRepository<OrderEntity, String>{

}