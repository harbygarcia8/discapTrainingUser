package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.repository.IUserRepository;
import com.discaptraining.apidiscapuser.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Service
public class UserService {

    //private static final Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    private IUserRepository userRepository;

    public ResponseEntity<Object> saveDiscapUser(@RequestBody DiscapUser bodyDiscapUsers){
        ResponseEntity<Object> respuesta;
        try {
            userRepository.save(bodyDiscapUsers);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion del cliente fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(bodyDiscapUsers);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
           // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear el cliente",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }
    public ResponseEntity<Object> getUserByPersonId(int userID){
        ResponseEntity<Object> respuesta;
        try {
            List<DiscapUser> discapUsers = userRepository.findDiscapUsers(userID);
            RespuestaPersonalizada res = new RespuestaPersonalizada(
                    "Consulta del cliente fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(discapUsers);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar el cliente",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> getAllUserPerson(){
        ResponseEntity<Object> respuesta;
        try {
            List<DiscapUser> discapUsers = userRepository.findDiscapUserList();
            discapUsers.forEach(user -> {
                System.out.println("usuario consultado: "+ user.getEmail());
            });
            RespuestaPersonalizada res = new RespuestaPersonalizada(
                    "Consulta de los clientes fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(discapUsers);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de consultar los clientes",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }

    public ResponseEntity<Object> deleteDiscapUser(int userID){
        ResponseEntity<Object> respuesta;
        try {
            userRepository.deleteById(userID);
            RespuestaPersonalizada res = new RespuestaPersonalizada(
                    "Eliminacion del cliente fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(new Object());
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de eliminar el cliente",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }
}
