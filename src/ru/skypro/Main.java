package ru.skypro;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        boolean result = Validator.check("Andr","12","12");
        if(result){
            System.out.println("norm");
        }else{
            System.out.println("ne norm");
        }
    }
}
