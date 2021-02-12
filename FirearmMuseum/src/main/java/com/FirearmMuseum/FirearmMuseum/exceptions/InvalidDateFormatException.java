package com.FirearmMuseum.FirearmMuseum.exceptions;

public class InvalidDateFormatException extends Exception{

    public InvalidDateFormatException (String message){super(message);}

    public InvalidDateFormatException(String message, Throwable innerException){super(message,innerException);}

}
