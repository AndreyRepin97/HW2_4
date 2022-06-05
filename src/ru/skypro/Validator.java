package ru.skypro;


import java.util.Objects;

public class Validator {
    private static final String VALID_SYMB = "abcdefghijkmnopqrstuvwxyzABCDEFGHIJKMNOPQRSTUVWXYZ1234567890_-";

    public static boolean check(String login,
                                String password,
                                String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
            return true;
        } catch (WrongLoginExeption | WrongPassworExeption e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void validate(String login,
                                   String password,
                                   String confirmPassword) throws WrongLoginExeption, WrongPassworExeption {
        if (Objects.isNull(login) || login.length() > 20) {// || !containsSymb(login)
            throw new WrongLoginExeption("Длинна логина должна быть не больше 20");
        }
        if(!containsSymb(login)){
            throw new WrongLoginExeption("Неверные символы в логине");
        }
        if (isNotValidPass(password) || isNotValidPass(confirmPassword)) {
            throw new WrongLoginExeption("Длинна пароля должна быть меньше 20");
        }
        if(!containsSymb(password)){
            throw new WrongLoginExeption("Неверные символы в пароле");
        }
        if(!password.equals(confirmPassword)){
            throw new WrongLoginExeption("Пароли не совпадают");
        }
    }
private static boolean isNotValidPass(String password){
        return Objects.isNull(password)|| password.length()>=20;
}
        private static boolean containsSymb(String s){
            char[] symbols = s.toCharArray();
            for (char symbol : symbols) {
                if (!VALID_SYMB.contains(String.valueOf(symbol))) {
                    return false;
                }
            }
            return true;
        }
    }
