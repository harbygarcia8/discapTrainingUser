package com.discaptraining.apidiscapuser.controllers;

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
    public ResponseEntity<Object> discapacityList(){
        ResponseEntity<Object> response;
        try {
            List<Discapacity> discapacities = (List<Discapacity>) discapacityService.discapacitiesAll();
            CustomResponse customResponse = new CustomResponse("Consulta de las discapacidades exitosa", HttpStatus.OK);
            customResponse.setResults(discapacities);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);

        }catch (Exception e){
            response= new ResponseEntity<>("Error tratando de consultar discapacidades", HttpStatus.BAD_REQUEST);
        }
        return response;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getByIdDiscapacity(@PathVariable int id){
        ResponseEntity<Object> response;
        try{
            Optional<Discapacity> discapacities = discapacityService.discapacityById(id);;
            CustomResponse customResponse = new CustomResponse("Consulta de discapacidades fue exitosa"+ id, HttpStatus.OK);
            customResponse.setResults(discapacities);
            response = new ResponseEntity<>(customResponse,HttpStatus.OK);

        }catch (Exception e){
            response = new ResponseEntity<>("Error tratando de consultar discapacidades" + id, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody Discapacity newDiscapacity) {
        ResponseEntity<Object> response;
        try {
            discapacityService.saveDiscapacity(newDiscapacity);
            CustomResponse customResponse = new CustomResponse(" Creacion de la discapacidad fue exitosa", HttpStatus.OK);
            customResponse.setResults(newDiscapacity);
            response = new ResponseEntity<>(customResponse,HttpStatus.OK);
        } catch (Exception e){
            response = new ResponseEntity<>("Disculpa tenemos un problema creando la discapacidad" + newDiscapacity, HttpStatus.BAD_REQUEST);
        }
        return response;
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
