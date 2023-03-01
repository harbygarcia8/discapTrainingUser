package com.discaptraining.apidiscapuser.web.controllers;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<DiscapUser> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{document}")
    public DiscapUser getByDocument(@PathVariable(name = "document") int document) {
        return userService.getUserByPersonId(document);
    }

    @PostMapping("/new")
    public String newUser() {
        return "se ha creado un nuevo usuario";
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable(name = "id") int id){
        userService.updateUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name = "id") int id){
        userService.deleteUserById(id);
    }

    @PatchMapping("/parchUser/{document}")
    public String updateUserByElement(@PathVariable String document){
        return "se ha actualizado solo un dato de la informacion del usuario";
    }

}

