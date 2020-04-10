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
                    user.setPassword(createPassword()); //Se crea la contraseña y se le setea al usuario
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

    public static String createPassword(){
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher;
        File filePassword = new File("./pass.txt");
        String password;
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePassword)); //Busca que el archivo exista
            String linea = "";
            boolean isSecure = false;
            while(!isSecure){
                System.out.println("Ingrese su contraseña: ");
                password = scanner.nextLine();
                while ((linea = bufferedReader.readLine()) != null) { //Recorre lina por linea del archivo
                    if (linea.equals(password)) { //Comparo la linea con la contraseña
                        System.out.println("Tu contraseña no es segura.");
                        break;
                    }
                }

                matcher = pattern.matcher(password);
                boolean validPassword = matcher.matches();

                while(!validPassword){
                    System.out.println("La contraseña no es válida.");
                    System.out.println("Ingrese su contraseña: ");
                    password = scanner.nextLine();

                    matcher = pattern.matcher(password);
                    if(matcher.matches()){
                        validPassword = true;
                    }
                }

                System.out.println("La contraseña corresponde con la validación.");
                isSecure = true;
                return password;
            }
        }catch (Exception exception){
            System.out.println("No pudimos abrir el archivo.");
        }

        return null; //revisar
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
