/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.Controllet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.example.model.Animal;
import com.example.Repository.AnimalRepository;

/**
 *
 * @author cifuentes0903
 */
import javax.validation.Valid;
import java.util.List;
import org.bson.types.ObjectId;

@RestController
@RequestMapping("/animales")
public class AnimalController {
    
@Autowired
  private AnimalRepository repository;
  
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public List<Animal> getAllPets() {
    return repository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Animal getPetById(@PathVariable("id") ObjectId id) {
    return repository.findBy_id(id);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public void modifyPetById(@PathVariable("id") ObjectId id, @Valid @RequestBody Animal animal) {
    animal.setId(id);
    repository.save(animal);
  }
  
  @RequestMapping(value = "/", method = RequestMethod.POST)
  public Animal createPet(@Valid @RequestBody Animal animal) {
    animal.setId(ObjectId.get());
    repository.save(animal);
    return animal;
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePet(@PathVariable ObjectId id) {
    repository.delete(repository.findBy_id(id));
  }
}
