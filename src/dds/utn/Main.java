package dds.utn;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static final String PASSWORD_REGEX = "^[0-9a-zA-Z-_?=:;.,]{8,}$";
    public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        //validación de contraseña
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        String password = scanner.nextLine();
        Matcher matcher = pattern.matcher(password);

        boolean validPassword = matcher.matches();
        if(validPassword){
            System.out.println("La contraseña corresponde con la validación.");
        }else{
            System.out.println("La contraseña no es válida.");
        }
    }
}
