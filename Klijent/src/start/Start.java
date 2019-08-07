package start;

import kontroler.Kontroler;
import niti.AktivnostServera;

public class Start {

    public static void main(String[] args) {
        AktivnostServera aktivnostServera = new AktivnostServera();
        aktivnostServera.start();

        Kontroler.getInstanca().povezi();
        Kontroler.getInstanca().pokreniPocetnuFormu();
    }
}
