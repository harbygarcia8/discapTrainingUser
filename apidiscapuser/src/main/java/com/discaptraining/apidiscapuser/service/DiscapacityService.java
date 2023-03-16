package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.Discapacity;
import com.discaptraining.apidiscapuser.repository.IDiscapacityRepository;
import com.discaptraining.apidiscapuser.response.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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