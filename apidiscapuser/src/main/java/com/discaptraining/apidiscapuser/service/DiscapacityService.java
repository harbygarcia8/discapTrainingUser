package com.discaptraining.apidiscapuser.service;

import com.discaptraining.apidiscapuser.domain.entity.DiscapUser;
import com.discaptraining.apidiscapuser.domain.entity.Discapacity;
import com.discaptraining.apidiscapuser.repository.IDiscapacityRepository;
import com.discaptraining.apidiscapuser.response.RespuestaPersonalizada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class DiscapacityService {

    @Autowired
    private IDiscapacityRepository discapacityRepository;

    public ResponseEntity<Object> saveDiscapacity(@RequestBody Discapacity bodyDiscapacity){
        ResponseEntity<Object> respuesta;
        try {
            discapacityRepository.save(bodyDiscapacity);
            RespuestaPersonalizada res = new RespuestaPersonalizada("Creacion de la discapacidad fue exitosa", HttpStatus.OK);
            res.setObjetoRespuesta(bodyDiscapacity);
            respuesta = ResponseEntity.ok(HttpStatus.OK);
            respuesta = new ResponseEntity<>(res, HttpStatus.OK);
        } catch (Exception e) {
            // logger.error(e);
            System.out.println(e);
            respuesta = ResponseEntity.ok(HttpStatus.BAD_REQUEST);
            respuesta = new ResponseEntity<>(
                    "Disculpa tenemos un error tratando de crear la discapacidad",
                    HttpStatus.BAD_REQUEST);

        }
        return respuesta;
    }
}


