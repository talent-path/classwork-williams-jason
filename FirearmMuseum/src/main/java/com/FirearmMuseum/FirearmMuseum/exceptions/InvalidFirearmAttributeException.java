package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidFirearmAttributeException extends Exception{

    public InvalidFirearmAttributeException(String message) {super(message);}

    public InvalidFirearmAttributeException(String message, Throwable innerException ) { super(message,innerException);}
}
