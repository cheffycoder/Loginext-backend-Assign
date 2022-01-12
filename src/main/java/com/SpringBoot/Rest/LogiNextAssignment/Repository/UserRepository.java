package com.SpringBoot.Rest.LogiNextAssignment.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.SpringBoot.Rest.LogiNextAssignment.Entities.UserData;

public interface UserRepository extends MongoRepository<UserData, String>{
//	This is created as an Interface.
//	We don't need to define function and we are leveraging the functions provided by the MongoRepository package
}
