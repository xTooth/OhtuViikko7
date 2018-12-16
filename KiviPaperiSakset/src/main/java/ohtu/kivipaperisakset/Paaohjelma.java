package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Paaohjelma {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = scanner.nextLine();
            System.out.println("peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s");
            Peli peli;

            if (vastaus.endsWith("a")) {
                peli = new Peli(null, scanner);
            } else if (vastaus.endsWith("b")) {
                peli = new Peli(new Tekoaly(), scanner);
            } else if (vastaus.endsWith("c")) {
                peli = new Peli(new TekoalyParannettu(20), scanner);
            } else {
                break;
            }
            peli.pelaa();
            

        }

    }
}
