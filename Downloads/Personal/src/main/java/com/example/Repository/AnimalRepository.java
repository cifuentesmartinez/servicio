/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Repository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.model.Animal;
/**
 *
 * @author cifuentes0903
 */
public interface AnimalRepository extends MongoRepository <Animal, String> {
    Animal findBy_id(ObjectId _id);
    
}
