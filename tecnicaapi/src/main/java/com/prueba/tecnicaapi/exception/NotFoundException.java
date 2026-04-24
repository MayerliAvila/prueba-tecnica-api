package com.prueba.tecnicaapi.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException (String msje){
        super(msje);
    }
}
