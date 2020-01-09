package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.model.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String>{

}
