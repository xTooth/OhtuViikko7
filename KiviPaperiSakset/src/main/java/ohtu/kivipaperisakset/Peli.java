package ohtu.kivipaperisakset;

import java.util.Scanner;

public class Peli {

    private Scanner scanner;
    private Tuomari tuomari;
    private TKOAly aly;
    private boolean onAly;

    public Peli(TKOAly ta, Scanner s) {
        scanner = s;
        aly = ta;
        if(aly != null){
            onAly = true;
        }else{
            onAly = false;
        }

    }

    public void pelaa() {

        tuomari = new Tuomari();
        
        System.out.println("Ensimmäisen pelaajan siirto: ");
        String ekanSiirto = scanner.nextLine();
        String tokanSiirto = tokaSiirto();

        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            System.out.println("Ensimmäisen pelaajan siirto: ");
            ekanSiirto = scanner.nextLine();
            tokanSiirto = tokaSiirto();
            
            if(onAly){
                aly.asetaSiirto(ekanSiirto);
            }
            
        }
        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);

    }

    private String tokaSiirto() {
        if (!onAly) {
            System.out.println("Toisen pelaajan siirto: ");
            return scanner.nextLine();
        } else {
            String siirto = aly.annaSiirto();
            System.out.println("Tietokone valitsi: " + siirto);
            return siirto;
        }

    }

    private static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}
