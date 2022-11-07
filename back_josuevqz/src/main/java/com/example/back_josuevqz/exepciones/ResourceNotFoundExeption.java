package com.example.back_josuevqz.exepciones;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/*
esta clase se crea para validar cuando no se encuentra algun registro dentro de empleado
seran exepciones para validaciones
*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundExeption extends RuntimeException {

    private static  final long serialVersionID = 1L;

    public ResourceNotFoundExeption(String mensaje) {
        super(mensaje);
    }
}
