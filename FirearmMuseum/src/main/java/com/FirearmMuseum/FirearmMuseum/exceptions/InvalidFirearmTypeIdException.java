package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidFirearmTypeIdException extends Exception {

    public InvalidFirearmTypeIdException(String message){super(message);}

    public InvalidFirearmTypeIdException(String message, Throwable innerException){super(message,innerException);}


}
