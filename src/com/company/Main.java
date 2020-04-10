package com.company;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.Scanner;
import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String password;
        String strRegEx = "^(?!.*(.)\\1{1})(?=(.*[\\d]){1,})(?=(.*[a-z]){1,})(?=(.*[A-Z]){1,})(?=(.*[@#$%!]){1,})(?:[\\da-zA-Z@#$%!]){8,100}";
//        https://regexr.com/3bguv    --link de donde saque este regex --> lo cambie para que sea por lo menos 1 upper case, lower case, digit, special

        List listaPass = readFileInList("./pass.txt");
        boolean valido = false;

        while(!valido) {
            System.out.println("Ingrese su contraseña: ");
            password = scanner.nextLine();
            if (password.matches(strRegEx) && !listaPass.contains(password)){
                System.out.println("c00l");
                valido = true;
            }else{
                System.out.println("mal");
            }
        }
    }

    public static List<String> readFileInList(String fileName){
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return lines;
    }
}

