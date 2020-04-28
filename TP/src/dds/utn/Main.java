package dds.utn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*TODO
* Cortar espacios cuando hay mas de 1
* */

public class Main {

    public static Scanner scanner = new Scanner(System.in);
    public static boolean blocked = false;
    public static final String PASSWORD_REGEX = "^.{8,}$";
    public static void main(String[] args) {

        System.out.println("Ingrese nombre de usuario: ");
        User user = new User(scanner.nextLine());

        printOptions(); //Imprime opciones por consola
        boolean quit = false;

        while(!quit){ //Si decide no salir
            System.out.println("Ingrese una opción: ");
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option){
                case 1:
                    createPassword(user); //Se crea la contraseña y se le setea al usuario
                    break;
                case 2:
                    login(user); // Se loguea
                    if(blocked){
                        quit = true; //Se sale de la app si se bloquea el usuario
                    }
                    break;
                case 3:
                    System.out.println("Chau.");
                    quit = true;
            }
        }
    }

    public static void printOptions(){
        System.out.println("Opciones: ");
        System.out.println("1 - Crear contraseña");
        System.out.println("2 - Ingresar");
        System.out.println("3 - Salir");
    }

    public static void createPassword(User user){
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher;
        File filePassword = new File("./pass.txt");
        String password;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePassword)); //Busca que el archivo exista
            String linea = "";
            boolean isSecure = false;
            while(!isSecure) {
                System.out.println("Ingrese su contraseña: ");
                password = scanner.nextLine();
                matcher = pattern.matcher(password);

                while ((linea = bufferedReader.readLine()) != null) { //Recorre lina por linea del archivo
                    if ((linea.equals(password) || !matcher.matches())) { //Comparo la linea con la contraseña y veo que cumpla la regex
                        System.out.println("Tu contraseña no es segura.");
                        break;
                    } else {
                        System.out.println("La contraseña corresponde con la validación.");
                        user.setPassword(password);
                        isSecure = true;
                        break;
                    }
                }
            }

        }catch (Exception exception){
            System.out.println("No pudimos abrir el archivo.");
        }
    }

    public static void login(User user){
        System.out.println("Ingrese su contraseña: ");
        String myPassword = scanner.nextLine();
        int tries = 0;
        while(!myPassword.equals(user.getPassword())){ //Si la contraseña ingresada es distinta a la que tengo guardada
            System.out.println("Contraseña inválida.");
            System.out.println("Ingrese su contraseña: ");
            myPassword = scanner.nextLine();
            tries++;
            if(tries == 5){ //Elegimos 5 porque no especifica en ningun lado. 3 parecia muy poco.
                System.out.println("Tu usuario esta bloqueado.");
                blocked = true;
                break;
            }
        }

        if(myPassword.equals(user.getPassword())){
            System.out.println("Ha sido ingresado.");
        }
    }
}
