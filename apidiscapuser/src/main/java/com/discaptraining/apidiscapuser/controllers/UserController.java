package com.discaptraining.apidiscapuser.controllers;

import com.discaptraining.apidiscapuser.config.JwtTokenUtil;
import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.domain.model.JwtRequest;
import com.discaptraining.apidiscapuser.domain.model.JwtResponse;
import com.discaptraining.apidiscapuser.response.CustomResponse;
import com.discaptraining.apidiscapuser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;




    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService jwtInMemoryUserDetailsService;

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



    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
            throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }


    private void authenticate(String username, String password) throws Exception {
        Objects.requireNonNull(username);
        Objects.requireNonNull(password);

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }

}