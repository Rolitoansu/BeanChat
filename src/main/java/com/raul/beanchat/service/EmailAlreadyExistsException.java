package com.raul.beanchat.service;

/**
 * Se lanza cuando se intenta registrar un usuario con un email que ya existe.
 */
public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String email) {
        super("Email ya registrado: " + email);
    }
}

