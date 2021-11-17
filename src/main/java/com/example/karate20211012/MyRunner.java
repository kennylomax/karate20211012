package com.example.karate20211012;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private MaterialsRepository materialsRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        materialsRepository.save( new Material("Bob") );
        materialsRepository.save( new Material("Fred") );
        materialsRepository.save( new Material("Jack") );
    }
}