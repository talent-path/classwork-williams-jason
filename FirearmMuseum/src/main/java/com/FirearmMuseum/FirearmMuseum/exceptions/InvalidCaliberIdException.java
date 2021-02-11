package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidCaliberIdException extends Exception {

    public InvalidCaliberIdException(String message){super(message);}

    public InvalidCaliberIdException(String message, Throwable innerException){super(message,innerException);}

}
