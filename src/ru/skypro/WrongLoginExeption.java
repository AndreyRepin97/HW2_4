package ru.skypro;

public class WrongLoginExeption extends Exception{
    public WrongLoginExeption(String message) {
        super(message);
    }
}