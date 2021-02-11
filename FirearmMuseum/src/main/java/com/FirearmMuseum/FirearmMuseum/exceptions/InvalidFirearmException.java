package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidFirearmException extends Exception{

    public InvalidFirearmException(String message){super(message);}

    public InvalidFirearmException(String message, Throwable innerException){super(message,innerException);}
}
