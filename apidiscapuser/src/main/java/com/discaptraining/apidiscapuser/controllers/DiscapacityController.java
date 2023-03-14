package com.discaptraining.apidiscapuser.controllers;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.domain.entity.Discapacity;
import com.discaptraining.apidiscapuser.response.CustomResponse;
import com.discaptraining.apidiscapuser.service.DiscapacityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/discapacity")
public class DiscapacityController {

    @Autowired
    private DiscapacityService discapacityService;

    @GetMapping
    public List<Discapacity> discapacityList(){
        return (List<Discapacity>) discapacityService.discapacitiesAll();
    }
    @GetMapping("/{id}")
    public Optional<Discapacity> getByIdDiscapacity(@PathVariable int id){
        return discapacityService.discapacityById(id);
    }

    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody Discapacity newDiscapacity) {
        return discapacityService.saveDiscapacity(newDiscapacity);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody Discapacity updateDiscapacity){
        ResponseEntity<Object> response;
        try{
            discapacityService.saveDiscapacity(updateDiscapacity);
            CustomResponse customResponse = new CustomResponse("Actualización de la discapacidad exitosa", HttpStatus.OK);
            customResponse.setResults(updateDiscapacity);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>("Error tratando de actualizar la discapacidad" + updateDiscapacity, HttpStatus.BAD_REQUEST);
        }
        return response;
    }
}
