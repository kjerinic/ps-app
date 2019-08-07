package niti;

import domen.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import konstante.*;
import kontrola.Kontroler;
import transfer.*;

public class ObradaZahteva extends Thread {

    Socket soket;
    boolean kraj;
    ObjectInputStream in;
    ObjectOutputStream out;
    Kontroler k;
    Korisnik korisnik;

    public ObradaZahteva(Socket soket) {
        this.soket = soket;
        k = Kontroler.getInstanca();
    }

    public Korisnik getKorisnik() {
        return korisnik;
    }

    @Override
    public void run() {

        while (!kraj) {

            //primanje zahteva
            Zahtev zahtev = primiZahtev();

            //obrada zahteva
            obradiZahtev(zahtev);

        }

        k.ukloniObradu(this);
    }

    private void obradiZahtev(Zahtev zahtev) {
        Odgovor odg = new Odgovor();

        //analiza zahteva
        int operacija = zahtev.getOperacija();
        odg.setOperacija(operacija);

        switch (operacija) {

            //
            //
            //ambalaze
            case Operacije.VRATI_SVE_AMBALAZE:
                try {
                    ArrayList<ApstraktniDomenskiObjekat> listaAmbalaza = (ArrayList<ApstraktniDomenskiObjekat>) k.vratiSveAmbalaze();
                    //ApstraktniDomenskiObjekat[] niz = listaAmbalaza.toArray(new ApstraktniDomenskiObjekat[listaAmbalaza.size()]);
                    if (listaAmbalaza == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaAmbalaza);
                        //System.out.println("***\n" + niz[1].toString() + "\n***\n");
                        System.out.println("***\n" + listaAmbalaza.get(1).toString() + "\n***\n");

                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setPodaci("");
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            case Operacije.VRATI_SVE_RECIKLAZNE_KODOVE:
                try {
                    ArrayList<ApstraktniDomenskiObjekat> listaKodova = (ArrayList<ApstraktniDomenskiObjekat>) k.vratiSveReciklazneKodove();
                    if (listaKodova == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaKodova);
                        //System.out.println("***\n" + niz[1].toString() + "\n***\n");
                        System.out.println("***\n" + listaKodova.get(1).toString() + "\n***\n");

                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setPodaci("");
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            case Operacije.UNESI_NOVU_AMBALAZU:
                try {
                    Ambalaza probaAmbalaza = (Ambalaza) zahtev.getPodaci();
                    k.unesiNovuAmbalazu(probaAmbalaza);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            case Operacije.VRATI_AMBALAZE_PO_USLOVU:
                try {
                    String[] uslovi = (String[]) zahtev.getPodaci();
                    List<ApstraktniDomenskiObjekat> listaAmbalaza = Kontroler.getInstanca().vratiAmbalazePoUslovu(uslovi);
                    if (listaAmbalaza == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaAmbalaza);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            case Operacije.VRATI_JEDNU_AMBALAZU: {
                try {
                    int ambalazaID = (int) zahtev.getPodaci();
                    ApstraktniDomenskiObjekat amb = Kontroler.getInstanca().vratiAmbalazu(ambalazaID);
                    if (amb == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(amb);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
            }

            break;

            case Operacije.PRIJAVI_SE:
                try {
                    Korisnik probaKorisnik = (Korisnik) zahtev.getPodaci();
                    ApstraktniDomenskiObjekat vraceniKorisnik = Kontroler.getInstanca().prijaviKorisnika(probaKorisnik.getKorisnickoIme(), probaKorisnik.getSifra());

                    if (vraceniKorisnik == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO_PRIJAVLJIVANJE);
                    } else {
                        odg.setPodaci(vraceniKorisnik);
                        odg.setStatusniKod(StatusniKod.USPESNO_PRIJAVLJIVANJE);
                        this.korisnik = (Korisnik) vraceniKorisnik;
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
                break;

            case Operacije.ODJAVI_SE:
                odjaviKlijenta();
                break;

            case Operacije.NAPRAVI_NOV_NALOG: {
                try {
                    Korisnik probaKorisnik = (Korisnik) zahtev.getPodaci();
                    k.napraviNovNalog(probaKorisnik);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
            }
            break;

            case Operacije.OBRISI_NALOG:
                try {
                    Korisnik probaKorisnik = (Korisnik) zahtev.getPodaci();
                    k.obrisiKorisnika(probaKorisnik);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
                break;

            case Operacije.IZMENI_NALOG: {
                try {
                    Korisnik probaKorisnik = (Korisnik) zahtev.getPodaci();
                    k.izmeniNalog(probaKorisnik);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
            }
            break;

            //
            //
            //kategorije
            case Operacije.VRATI_SVE_KATEGORIJE:
                try {
                    List<ApstraktniDomenskiObjekat> listaKategorija;
                    listaKategorija = k.vratiSveKategorije();
                    if (listaKategorija == null || listaKategorija.isEmpty()) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaKategorija);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }

                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setPodaci("");
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            //
            //
            //reciklazeri
            case Operacije.VRATI_SVE_RECIKLAZERE:
                try {
                    List<ApstraktniDomenskiObjekat> listaReciklazera;
                    listaReciklazera = k.vratiSveReciklazere();
                    if (listaReciklazera == null || listaReciklazera.isEmpty()) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaReciklazera);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
                break;

            case Operacije.UNESI_NOVOG_RECIKLAZERA:
                try {
                    Reciklazer reciklazer = (Reciklazer) zahtev.getPodaci();
                    k.sacuvajNovogReciklazera(reciklazer);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
                break;

            case Operacije.VRATI_RECIKLAZERE_PO_USLOVU:
                try {
                    String[] uslovi = (String[]) zahtev.getPodaci();
                    List<ApstraktniDomenskiObjekat> listaReciklazera = Kontroler.getInstanca().vratiReciklazerePoUslovu(uslovi);
                    if (listaReciklazera == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(listaReciklazera);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

            case Operacije.VRATI_JEDNOG_RECIKLAZERA: {
                try {
                    int reciklazerID = (int) zahtev.getPodaci();
                    ApstraktniDomenskiObjekat amb = Kontroler.getInstanca().vratiReciklazera(reciklazerID);
                    if (amb == null) {
                        odg.setStatusniKod(StatusniKod.NEUSPESNO);
                    } else {
                        odg.setPodaci(amb);
                        odg.setStatusniKod(StatusniKod.USPESNO);
                    }
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }
            }
            break;

            case Operacije.UNESI_LISTU_RECIKLIRANJA:
                try {
                    ArrayList<Recikliranje> listaRecikliranja = (ArrayList<Recikliranje>) zahtev.getPodaci();
                    Kontroler.getInstanca().dodajRecikliranje(listaRecikliranja);
                    odg.setStatusniKod(StatusniKod.USPESNO);
                } catch (Exception ex) {
                    Logger.getLogger(ObradaZahteva.class.getName()).log(Level.SEVERE, null, ex);
                    odg.setStatusniKod(StatusniKod.NEUSPESNO);
                }

                break;

        }

        posaljiOdgovor(odg);

    }

    public void zaustaviObradu() {
        kraj = true;
        interrupt();
    }

    private Zahtev primiZahtev() {
        Zahtev zah = new Zahtev();

        try {
            in = new ObjectInputStream(soket.getInputStream());
            zah = (Zahtev) in.readObject();

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Prekinuta konekcija.\n***");
            this.zaustaviObradu();
            k.ukloniObradu(this);
        }

        return zah;
    }

    public void posaljiOdgovor(Odgovor odg) {
        try {
            out = new ObjectOutputStream(soket.getOutputStream());
            out.writeObject(odg);
            out.flush();
        } catch (IOException ex) {
            System.out.println("Prekinuta konekcija.\n***");
            this.zaustaviObradu();
            k.ukloniObradu(this);

        }
    }

    private void odjaviKlijenta() {
        this.korisnik = null;
    }

}
