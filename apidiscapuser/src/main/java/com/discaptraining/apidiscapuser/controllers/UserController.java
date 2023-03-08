package com.discaptraining.apidiscapuser.controllers;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.response.CustomResponse;
import com.discaptraining.apidiscapuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO: SE DEBE TENER EN CUENTA QUE SE DEBE USAR OBJETO USUARIO

    @GetMapping
    public ResponseEntity<Object> getAllUsers() {
        ResponseEntity<Object> response;
        try{
            List<DiscapUser> discapUsers = userService.getAllUserPerson();
            CustomResponse customResponse = new CustomResponse("Consulta de los clientes fue exitosa", HttpStatus.OK);
            customResponse.setResponseObject(discapUsers);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>("Error tratando de consultar los clientes",HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @GetMapping("/{personId}")
    public ResponseEntity<Object> getByDocument(@PathVariable int personId) {
        ResponseEntity<Object> response;
        try{
            List<DiscapUser> discUsers = userService.getUserByPersonId(personId);;
            CustomResponse customResponse = new CustomResponse("Consulta del cliente exitosa: " + personId, HttpStatus.OK);
            customResponse.setResponseObject(discUsers);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>("No se pudo encontrar el cliente con la cédula: " + personId, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody DiscapUser newDiscapUser) {
        ResponseEntity<Object> response;
        try{
            userService.saveDiscapUser(newDiscapUser);
            CustomResponse customResponse = new CustomResponse("Creacion del cliente fue exitosa", HttpStatus.OK);
            customResponse.setResponseObject(newDiscapUser);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);

        } catch (Exception e) {
            response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el cliente" + newDiscapUser, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int id) {
        ResponseEntity<Object> response;
        try {
            userService.deleteDiscapUser(id);
            CustomResponse customResponse = new CustomResponse(
                    "Eliminacion del usuario con id " + id + " fue exitosa", HttpStatus.OK);
            customResponse.setResponseObject(new Object());
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);
        } catch (Exception e) {
            response = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de eliminar el cliente:" + id,
                    HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PutMapping("/{document}")
    public String updateUser(@PathVariable String document){
        return "se ha actualizado el usuario segun el documento: " + document;
    }

    @PatchMapping("/{document}")
    public String updateUserByElement(@PathVariable String document){
        return "se ha actualizado la informacion del usuario";
    }



}

