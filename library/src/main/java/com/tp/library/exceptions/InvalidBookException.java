package com.tp.library.exceptions;

public class InvalidBookException extends Exception{

    public InvalidBookException(String message){super(message);}

    public InvalidBookException(String message, Throwable innerException){super(message,innerException);}
}
