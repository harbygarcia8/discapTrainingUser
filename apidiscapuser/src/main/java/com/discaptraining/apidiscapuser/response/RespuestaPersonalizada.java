package com.discaptraining.apidiscapuser.response;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RespuestaPersonalizada {

    @Getter
    @Setter
    private String codigo;
    @Getter
    @Setter
    private String mensaje;
    @Getter
    @Setter
    private int estado;
    @Getter
    @Setter
    private Object objectoRespuesta;

    public RespuestaPersonalizada() {
    }

    public RespuestaPersonalizada(String mensaje, HttpStatus estado) {
        super();
        this.mensaje = mensaje;
        this.estado = estado.value();
        this.codigo = estado.name();
    }
}