package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.Discapacity;
import com.discaptraining.apidiscapuser.repository.IDiscapacityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DiscapacityService {
    @Autowired
    private IDiscapacityRepository discapacityRepository;

    public Optional<Discapacity> discapacityById(int id){
        return discapacityRepository.findById(id);
    }

    public Iterable<Discapacity> discapacitiesAll(){
        return discapacityRepository.findAll();
    }

    public Discapacity saveDiscapacity(Discapacity bodyDiscapacity){
        return discapacityRepository.save(bodyDiscapacity);
    }
}