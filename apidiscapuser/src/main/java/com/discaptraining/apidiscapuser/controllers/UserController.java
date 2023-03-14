package com.discaptraining.apidiscapuser.controllers;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.response.CustomResponse;
import com.discaptraining.apidiscapuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
            customResponse.setResults(discapUsers);
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
            customResponse.setResults(discUsers);
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
            customResponse.setResults(newDiscapUser);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);


        } catch (Exception e) {
            response = new ResponseEntity<>("Disculpa tenemos un error tratando de crear el cliente" + newDiscapUser, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {

            userService.deleteDiscapUser(id);

    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@RequestBody DiscapUser updateDiscapUser){
        ResponseEntity<Object> response;
        try{
            userService.saveDiscapUser(updateDiscapUser);
            CustomResponse customResponse = new CustomResponse("Actualizacion del cliente fue exitosa", HttpStatus.OK);
            customResponse.setResults(updateDiscapUser);
            response = new ResponseEntity<>(customResponse, HttpStatus.OK);


        } catch (Exception e) {
            response = new ResponseEntity<>("Disculpa tenemos un error tratando de actualizar el cliente" + updateDiscapUser, HttpStatus.BAD_REQUEST);
        }
        return response;
    }

    @PatchMapping("/{document}")
    public String updateUserByElement(@PathVariable String document){
        return "se ha actualizado la informacion del usuario";
    }
}