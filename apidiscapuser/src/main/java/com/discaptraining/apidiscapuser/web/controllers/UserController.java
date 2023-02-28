package com.discaptraining.apidiscapuser.web.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/discaptraininguser/users")
public class UserController {


    //TODO: SE DEBE TENER EN CUENTA QUE SE DEBE USAR OBJETO USUARIO

    @GetMapping("/all")
    public String getAllUsers() {
        return "Estos son todos los users";
    }

    @GetMapping("/{document}")
    public String getByDocument(@PathVariable String document) {
        return "obteniendo segun el documento de identidad";
    }


    @PostMapping("/new")
    public String newUser() {
        return "se ha creado un nuevo usuario";
    }

    @PutMapping("/updateUser/{document}")
    public String updateUser(@PathVariable String document){
        return "se ha actualizado el usuario segun el documento";
    }

    @PatchMapping("/parchUser/{document}")
    public String updateUserByElement(@PathVariable String document){
        return "se ha actualizado la informacion del usuario";
    }

    @DeleteMapping("/deleteUser/{document}")
    public String deleteUser(@PathVariable String document){
        return "se ha borrado el usuario";
    }

}

