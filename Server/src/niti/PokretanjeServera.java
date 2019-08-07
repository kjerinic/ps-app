package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import konfiguracija.Konfiguracija;
import kontrola.Kontroler;

public class PokretanjeServera extends Thread {

    ServerSocket ss;
    boolean kraj;
    Kontroler k;

    public PokretanjeServera() {
        kraj = false;
        k = Kontroler.getInstanca();
    }

    @Override
    public void run() {
        try {
            int port = Integer.parseInt(Konfiguracija.getInstance().getProperty("port"));
            ss = new ServerSocket(port);
            k.obavestiPokrenut();

            while (!kraj) {
                //prihvataj nove zahteve i pravi obrade
                System.out.println("Cekam konekciju.");
                Socket soket = ss.accept();
                System.out.println("Klijent se povezao");

                ObradaZahteva obrada = new ObradaZahteva(soket);
                k.dodajObradu(obrada);
                obrada.start();

            }

        } catch (IOException ex) {
            //k.zaustaviServer();
            System.out.println("Kraj glavne serverske niti.");
        }

    }

    public void zaustaviServer() {
        k.zaustaviSveObrade();
        kraj = true;

        try {
            ss.close();
        } catch (IOException ex) {
            System.err.println("greska pri zatvaranju soketa");
        }

        k.obavestiZaustavljen();
        interrupt();

    }

}
