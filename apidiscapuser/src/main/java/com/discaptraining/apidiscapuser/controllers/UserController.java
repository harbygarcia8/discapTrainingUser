package com.discaptraining.apidiscapuser.controllers;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //TODO: SE DEBE TENER EN CUENTA QUE SE DEBE USAR OBJETO USUARIO

    @GetMapping("/all")
    public ResponseEntity<Object> getAllUsers() {
        return userService.getAllUserPerson();
    }

    @GetMapping("/{document}")
    public ResponseEntity<Object> getByDocument(@PathVariable int document) {
        return userService.getUserByPersonId(document);
    }


    @PostMapping
    public ResponseEntity<Object> newUser(@RequestBody DiscapUser newDiscapUser) {
        return userService.saveDiscapUser(newDiscapUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable int document){
        return userService.deleteDiscapUser(document);
    }

    @PutMapping("/{document}")
    public String updateUser(@PathVariable String document){
        return "se ha actualizado el usuario segun el documento";
    }

    @PatchMapping("/{document}")
    public String updateUserByElement(@PathVariable String document){
        return "se ha actualizado la informacion del usuario";
    }



}

