package niti;

import domen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.*;
import kontroler.Kontroler;
import sesija.Sesija;
import transfer.*;

public class PokretanjeKlijenta extends Thread {

    public Socket soket;
    Kontroler k;
    boolean kraj;
    ObjectInputStream in;
    ObjectOutputStream out;
    AktivnostServera aktivnostServera;

    public PokretanjeKlijenta() {
        k = Kontroler.getInstanca();
        kraj = false;
    }

    @Override
    public void run() {
        povezi();

        while (!kraj) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                System.err.println("Prekinuta nit dok spava.");
            }

            System.out.println("Cekanje odgovora od servera.");

            //analiza odgovora
            Odgovor odg = primiOdgovor();

            if (odg == null) {
                continue;
            }

            if (odg.getStatusniKod() == StatusniKod.SERVER_UGASEN) {
                System.out.println("Server se ugasio.");
                Sesija.getInstance().setStatusServera(StatusniKod.SERVER_NEAKTIVAN);
                k.obavestiServerUgasen();
//                povezi();
                continue;
            }

            int operacija = odg.getOperacija();
            switch (operacija) {
                case Operacije.PRIJAVI_SE:
                    obradiPrijavljivanje(odg);
                    break;

                case Operacije.NAPRAVI_NOV_NALOG:
                    obradiPravljenjeNaloga(odg);
                    break;

                case Operacije.IZMENI_NALOG:
                    obradiIzmenuNaloga(odg);
                    break;

                case Operacije.OBRISI_NALOG:
                    obradiBrisanjeNaloga(odg);
                    break;

                case Operacije.VRATI_SVE_RECIKLAZERE:
                    obradiSveReciklazere(odg);
                    break;

                case Operacije.VRATI_RECIKLAZERE_PO_USLOVU:
                    obradiSveReciklazere(odg);
                    break;

                case Operacije.UNESI_NOVOG_RECIKLAZERA:
                    obradiUnosNovogReciklazera(odg);
                    break;

                case Operacije.VRATI_JEDNOG_RECIKLAZERA:
                    obradiVracenogJednogReciklazera(odg);
                    break;

                case Operacije.VRATI_SVE_AMBALAZE:
                    obradiSveAmbalaze(odg);
                    break;

                case Operacije.VRATI_AMBALAZE_PO_USLOVU:
                    obradiSveAmbalaze(odg);
                    break;

                case Operacije.VRATI_SVE_RECIKLAZNE_KODOVE:
                    obradiSveReciklazneKodove(odg);
                    break;

                case Operacije.UNESI_NOVU_AMBALAZU:
                    obradiUnosNoveAmbalaze(odg);
                    break;

                case Operacije.VRATI_JEDNU_AMBALAZU:
                    obradiVracenuJednuAmbalazu(odg);
                    break;

                case Operacije.UNESI_LISTU_RECIKLIRANJA:
                    obradiUnosNovogRecikliranja(odg);
                    break;
            }

        }

    }

    public void posaljiZahtev(Zahtev zahtev) {
        try {
            if (soket != null && !soket.isClosed()) {
                out = new ObjectOutputStream(soket.getOutputStream());
                out.writeObject(zahtev);
                out.flush();
            } else {
                System.out.println("\n***sacekaj***");
                Kontroler.getInstanca().vratiNaGlavnu();
                Kontroler.getInstanca().vratiNaPocetnu();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\n***prekinuta konekcija***");
            k.obavestiServerNeaktivan();
        }
    }

    public Odgovor primiOdgovor() {
        Odgovor odg = new Odgovor();
        try {
            if (soket != null) {
                in = new ObjectInputStream(soket.getInputStream());
                odg = (Odgovor) in.readObject();
            }
        } catch (IOException ex) {
            Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\n***Konekcija je problem***");
            k.obavestiServerUgasen();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokretanjeKlijenta.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Odgovor je problem");
            System.exit(0);

        }
        return odg;
    }

    public void zaustaviKlijenta() {
        kraj = true;
        interrupt();
    }

    private void obradiPrijavljivanje(Odgovor odg) {
        int statusniKod = odg.getStatusniKod();

        if (statusniKod == StatusniKod.NEUSPESNO_PRIJAVLJIVANJE) {
            k.obavestiOPrijavljivanju("", statusniKod);
        }
        if (statusniKod == StatusniKod.USPESNO_PRIJAVLJIVANJE) {
            Korisnik kor = (Korisnik) odg.getPodaci();
            Sesija.getInstance().setPrijavljeniKorisnik(kor);
            k.obavestiOPrijavljivanju(kor.getIme() + " " + kor.getPrezime(), statusniKod);
            k.postaviKorisnika(kor);
        }
    }

    public void povezi() {
        while (Sesija.getInstance().getStatusServera() == StatusniKod.SERVER_NEAKTIVAN) {
            try {
                soket = new Socket("localhost", 10000);
                if (soket.isConnected()) {
                    System.out.println("POVEZAN");
                    Sesija.getInstance().setStatusServera(StatusniKod.SERVER_AKTIVAN);
                }
            } catch (IOException ex) {
                Sesija.getInstance().setStatusServera(StatusniKod.SERVER_NEAKTIVAN);
            }

            System.out.println("" + Sesija.getInstance().getStatusServera());
        }
    }

    private void obradiSveReciklazere(Odgovor odg) {
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            Kontroler.getInstanca().obavestiNeuspesnoVracanjeListeReciklazera();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            ArrayList<Reciklazer> listaReciklazera = (ArrayList<Reciklazer>) odg.getPodaci();
            System.out.println("stigli su reciklazeri");
            k.popuniTabeluReciklazera(listaReciklazera);
        }

    }

    private void obradiPravljenjeNaloga(Odgovor odg) {
        int uspesno = odg.getStatusniKod();
        k.obavestiOPravljenjuNaloga(uspesno);
    }

    private void obradiIzmenuNaloga(Odgovor odg) {
        int uspesno = odg.getStatusniKod();
        k.obavestiOIzmeniNaloga(uspesno);
    }

    private void obradiBrisanjeNaloga(Odgovor odg) {
        int uspesno = odg.getStatusniKod();
        k.obavestiBrisanjuNaloga(uspesno);
    }

    private void obradiUnosNovogReciklazera(Odgovor odg) {
        int statusniKod = odg.getStatusniKod();

        k.obavestiUnosReciklazera(statusniKod);
    }

    private void obradiSveAmbalaze(Odgovor odg) {
        ArrayList<Ambalaza> listaAmbalaza = new ArrayList<>();
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesnoVracanjeListeAmbalaza();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            listaAmbalaza = (ArrayList<Ambalaza>) odg.getPodaci();
            k.popuniTabeluAmbalaza(listaAmbalaza);
        }

    }

    private void obradiSveReciklazneKodove(Odgovor odg) {
        ArrayList<ReciklazniKod> listaKodova = new ArrayList<>();
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesnoVracanjeListeReciklaznihKodova();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            listaKodova = (ArrayList<ReciklazniKod>) odg.getPodaci();
            k.vratiFormiListuReciklaznihKodova(listaKodova);
        }
    }

    private void obradiUnosNoveAmbalaze(Odgovor odg) {
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesanUnosNoveAmbalaze();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            k.obavestiUspesanUnosNoveAmbalaze();
        }
    }

    private void obradiVracenuJednuAmbalazu(Odgovor odg) {
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesnoVracenaJednaAmbalaza();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            Ambalaza amb = (Ambalaza) odg.getPodaci();
            k.obavestiUspesnoVracenaJednaAmbalaza(amb);
        }

    }

    private void obradiVracenogJednogReciklazera(Odgovor odg) {
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesnoVracenJedanReciklazer();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            Reciklazer rec = (Reciklazer) odg.getPodaci();
            k.obavestiUspesnoVracenJedanReciklazer(rec);
        }
    }

    private void obradiUnosNovogRecikliranja(Odgovor odg) {
        if (odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            k.obavestiNeuspesanUnosRecikliranja();
        }
        if (odg.getStatusniKod() == StatusniKod.USPESNO) {
            k.obavestiUspesanUnosNovogRecikliranja();
        }
    }

}
