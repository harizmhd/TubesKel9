package model;

import controller.Controller;
import java.util.Scanner;

public class Travelink {
    public static void main(String[] args) {
        Aplikasi a = new Aplikasi();
        System.out.print("Apakah anda ingin menggunakan versi GUI?\n"
            + "(1) Ya (2) Tidak (-) Exit : ");
        try {
            int pil;
            Scanner input = new Scanner(System.in);
            pil = input.nextInt();
            switch(pil) {
                case 1:
                    Controller control = new Controller();
                    break;
                case 2:
                    a.mainMenu();
                    break;
            }
        } catch (java.util.InputMismatchException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
