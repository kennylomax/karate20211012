package com.example.karate20211012;

import org.springframework.data.repository.CrudRepository;

public interface MaterialsRepository extends CrudRepository<Material, Long>{
    //        List<Customer> findByLastName(String lastName);      
    //        Customer findById(long id);
}