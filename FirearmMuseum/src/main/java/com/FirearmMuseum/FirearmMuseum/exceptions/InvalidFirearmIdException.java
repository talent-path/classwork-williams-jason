package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidFirearmIdException extends Exception{

    public InvalidFirearmIdException(String message){super(message);}

    public InvalidFirearmIdException(String message,Throwable innerException){super(message,innerException);}
}
