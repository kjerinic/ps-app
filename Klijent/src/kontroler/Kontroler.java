package kontroler;

import forme.korisnik.GlavnaForma;
import forme.korisnik.LoginForma;
import domen.*;
import forme.*;
import forme.ambalaza.FormaPretraziAmbalaze;
import forme.reciklazer.*;
import forme.recikliranje.FormaDodajRecikliranje;
import java.util.ArrayList;
import konstante.*;
import niti.PokretanjeKlijenta;
import sesija.Sesija;
import transfer.Odgovor;
import transfer.Zahtev;

public class Kontroler {

    private static Kontroler instanca;

    private LoginForma lf;
    private GlavnaForma gf;
    private PocetnaForma pf;
    private PokretanjeKlijenta pk;
    private FormaPretraziReciklazere formaPretraziReciklazere;
    private FormaPretraziAmbalaze formaPretraziAmbalaze;
    private FormaDodajRecikliranje formaDodajRecikliranje;

    public Kontroler() {
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public void setFormaPretraziReciklazere(FormaPretraziReciklazere formaPretraziReciklazere) {
        this.formaPretraziReciklazere = formaPretraziReciklazere;
    }

    public void setFormaPretraziAmbalaze(FormaPretraziAmbalaze formaPretraziAmbalaze) {
        this.formaPretraziAmbalaze = formaPretraziAmbalaze;
    }

    public void setFormaDodajRecikliranje(FormaDodajRecikliranje formaDodajRecikliranje) {
        this.formaDodajRecikliranje = formaDodajRecikliranje;
    }

    // POVEZIVANJE
    public void povezi() {
        pk = new PokretanjeKlijenta();
        pk.start();
    }

    public void obavestiServerNeaktivan() {
        if (pf != null && pf.isVisible()) {
            pf.onemoguciAkciju();
        }

        if (lf != null && lf.isVisible()) {
            lf.onemoguciAkciju();
            pf.setVisible(true);
        }

        if (gf != null && gf.isVisible()) {
            gf.onemoguciAkciju();
        }
    }

    public void obavestiServerAktivan() {
        if (pk == null) {
            pk = new PokretanjeKlijenta();
            pk.start();
        }

        if (pf != null && pf.isVisible()) {
            pf.omoguciAkciju();
        }
        if (lf != null && lf.isVisible()) {
            lf.omoguciAkciju();
        }
    }

    // LOGIN
    public void obavestiOPrijavljivanju(String poruka, int statusniKod) {
        if (statusniKod == StatusniKod.USPESNO_PRIJAVLJIVANJE) {
            lf.uspesnoPrijavljivanje(poruka);
        }
        if (statusniKod == StatusniKod.NEUSPESNO_PRIJAVLJIVANJE) {
            lf.neuspesnoPrijavljivanje(poruka);
        }
    }

    public void prijaviSe(String korisnickoIme, String sifra) {
        Zahtev zah = new Zahtev();
        zah.setOperacija(Operacije.PRIJAVI_SE);
        Korisnik kor = new Korisnik(0, korisnickoIme, sifra, "", "", "");
        zah.setPodaci(kor);
        pk.posaljiZahtev(zah);
    }

    public void postaviKorisnika(Korisnik kor) {
        lf.setVisible(false);
        gf = new GlavnaForma();
        Sesija.getInstance().setPrijavljeniKorisnik(kor);
        gf.postaviKorisnika(kor.getIme() + " " + kor.getPrezime());
    }

    public void pokreniPocetnuFormu() {
        PocetnaForma pf = new PocetnaForma();
        this.pf = pf;
    }

    public void pokreniLoginFormu() {
        LoginForma lf = new LoginForma();
        this.lf = lf;
    }

    public void obavestiServerUgasen() {
//        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
//            formaPretraziAmbalaze.dispose();
//        }
//        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
//            formaPretraziReciklazere.dispose();
//        }
//
//        if (lf != null && lf.isVisible()) {
//            //izloguj iz sesije
//            lf.dispose();
//            Sesija.getInstance().setPrijavljeniKorisnik(null);
//            pf.setVisible(true);
//            pf.onemoguciAkciju();
//        }
//
        if (gf != null && gf.isVisible()) {
            gf.dispose();
            Sesija.getInstance().setPrijavljeniKorisnik(null);
            pf.setVisible(true);
            pf.onemoguciAkciju();
        }

        if (lf != null && lf.isVisible()) {
            lf.onemoguciAkciju();
            pf.setVisible(true);
        }

        if (pf != null && pf.isVisible()) {
            pf.onemoguciAkciju();
            pk.zaustaviKlijenta();
            pk = null;
            povezi();
        }

    }

    //korisnik
    public void napraviNovNalog(Korisnik korisnik) {
        Zahtev zah = new Zahtev(Operacije.NAPRAVI_NOV_NALOG, korisnik);
        pk.posaljiZahtev(zah);
    }

    public void obavestiOPravljenjuNaloga(int uspesno) {
        if (uspesno == StatusniKod.USPESNO) {
            pf.obavestiUspesnoPravljenje();
        }
        if (uspesno == StatusniKod.NEUSPESNO) {
            pf.obavestiNeuspesnoPravljenje();
        }

    }

    public void odjaviSe() {
        Zahtev zah = new Zahtev(Operacije.ODJAVI_SE, "");
        pk.posaljiZahtev(zah);

        Sesija.getInstance().setPrijavljeniKorisnik(null);
        if (lf != null && lf.isVisible()) {
            //izloguj iz sesije
            lf.dispose();
            pf.setVisible(true);
        }

        if (gf != null && gf.isVisible()) {
            gf.dispose();
            pf.setVisible(true);
        }

    }

    public void izmeniNalog(Korisnik korisnik) {
        Zahtev zah = new Zahtev(Operacije.IZMENI_NALOG, korisnik);
        pk.posaljiZahtev(zah);
    }

    public void obavestiOIzmeniNaloga(int uspesno) {
        if (uspesno == StatusniKod.USPESNO) {
            gf.obavestiUspesnaIzmena();
            gf.obavestiOdjavljivanje();
            odjaviSe();
        }
        if (uspesno == StatusniKod.NEUSPESNO) {
            gf.obavestiNeuspesnaIzmena();
        }
    }

    public void obrisiKorisnika() {
        Zahtev zah = new Zahtev(Operacije.OBRISI_NALOG, Sesija.getInstance().getPrijavljeniKorisnik());
        pk.posaljiZahtev(zah);
    }

    public void obavestiBrisanjuNaloga(int uspesno) {
        if (uspesno == StatusniKod.USPESNO) {
            gf.obavestiUspesnoBrisanje();
            gf.obavestiOdjavljivanje();
            //odjaviSe();
        }
        if (uspesno == StatusniKod.NEUSPESNO) {
            gf.obavestiNeuspesnoBrisanje();
        }
    }

    //kategorija
    public ArrayList<Kategorija> vratiSveKategorije() {
        ArrayList<Kategorija> lista = new ArrayList<>();
        Zahtev zah = new Zahtev(Operacije.VRATI_SVE_KATEGORIJE, "");
        pk.posaljiZahtev(zah);

        Odgovor odg = pk.primiOdgovor();
        if (odg == null || odg.getStatusniKod() == StatusniKod.NEUSPESNO) {
            if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
                formaPretraziReciklazere.obavestiNeuspesnoVracanjeListeKategorija();
            }
        } else {
            lista = (ArrayList<Kategorija>) odg.getPodaci();
        }

        return lista;
    }

    public void vratiNaPocetnu() {
        if (!pf.isVisible()) {
            pf.setVisible(true);
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }
    }

    public void vratiSveReciklazere() {
        Zahtev zah = new Zahtev(Operacije.VRATI_SVE_RECIKLAZERE, "");
        pk.posaljiZahtev(zah);
    }

    public void popuniTabeluReciklazera(ArrayList<Reciklazer> listaReciklazera) {
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.popuniTabeluReciklazera(listaReciklazera);
        }

        if (formaDodajRecikliranje != null && formaDodajRecikliranje.isVisible()) {
            formaDodajRecikliranje.popuniTabeluReciklazera(listaReciklazera);
        }
    }

    public void sacuvajNovogReciklazera(Reciklazer rec) {
        Zahtev zah = new Zahtev(Operacije.UNESI_NOVOG_RECIKLAZERA, rec);
        pk.posaljiZahtev(zah);
    }

    public void obavestiNeuspesnoVracanjeListeReciklazera() {
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.obavestiNeuspesnoVracanjuListeReciklazera();
        }

        if (formaDodajRecikliranje != null && formaDodajRecikliranje.isVisible()) {
            formaDodajRecikliranje.obavestiNeuspesnoVracanjuListeReciklazera();
        }

    }

    public void vratiReciklazerePoUslovu(String[] uslovi) {
        Zahtev zah = new Zahtev(Operacije.VRATI_RECIKLAZERE_PO_USLOVU, uslovi);
        System.out.println("Kategorija koja je trazena:" + uslovi[0]);
        System.out.println("Termin pretrage:" + uslovi[1]);
        pk.posaljiZahtev(zah);
    }

    public void obavestiUnosReciklazera(int statusniKod) {
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            if (statusniKod == StatusniKod.NEUSPESNO) {
                formaPretraziReciklazere.obavestiNeuspesanUnos();
            }
            if (statusniKod == StatusniKod.USPESNO) {
                formaPretraziReciklazere.obavestiUspesanUnos();
            }
        }
    }

    public void vratiSveAmbalaze() {
        Zahtev zah = new Zahtev(Operacije.VRATI_SVE_AMBALAZE, "");
        pk.posaljiZahtev(zah);
    }

    public void obavestiNeuspesnoVracanjeListeAmbalaza() {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiNeuspesnoVracanjeListeAmbalaza();
        }

        if (formaDodajRecikliranje != null && formaDodajRecikliranje.isVisible()) {
            formaDodajRecikliranje.obavestiNeuspesnoVracanjeListeAmbalaza();
        }
    }

    public void popuniTabeluAmbalaza(ArrayList<Ambalaza> listaAmbalaza) {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.popuniTabeluAmbalaza(listaAmbalaza);
        }

        if (formaDodajRecikliranje != null && formaDodajRecikliranje.isVisible()) {
            formaDodajRecikliranje.popuniTabeluAmbalaza(listaAmbalaza);
        }
    }

    public void vratiSveReciklazneKodove() {
        Zahtev zah = new Zahtev(Operacije.VRATI_SVE_RECIKLAZNE_KODOVE, "");
        pk.posaljiZahtev(zah);
    }

    public void obavestiNeuspesnoVracanjeListeReciklaznihKodova() {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiNeuspesnoVracanjeListeKodova();
        }
    }

    public void vratiFormiListuReciklaznihKodova(ArrayList<ReciklazniKod> listaKodova) {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.primiListuKodova(listaKodova);
        }

    }

    public void sacuvajNovuAmbalazu(Ambalaza amb) {
        Zahtev zah = new Zahtev(Operacije.UNESI_NOVU_AMBALAZU, amb);
        pk.posaljiZahtev(zah);
    }

    public void obavestiNeuspesanUnosNoveAmbalaze() {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiNeuspesanUnosNoveAmbalaze();
        }
    }

    public void obavestiUspesanUnosNoveAmbalaze() {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiUspesanUnosNoveAmbalaze();
        }
    }

    public void zaustaviPokretanjeKlijenta() {
        pk.zaustaviKlijenta();
    }

    public void vratiAmbalazePoUslovu(String[] uslovi) {
        Zahtev zah = new Zahtev(Operacije.VRATI_AMBALAZE_PO_USLOVU, uslovi);
        System.out.println("Kategorija koja je trazena:" + uslovi[0]);
        System.out.println("Termin pretrage:" + uslovi[1]);
        pk.posaljiZahtev(zah);
    }

    public void vratiAmbalazu(int odabranaAmbalazaID) {
        Zahtev zah = new Zahtev(Operacije.VRATI_JEDNU_AMBALAZU, odabranaAmbalazaID);
        pk.posaljiZahtev(zah);
    }

    public void obavestiUspesnoVracenaJednaAmbalaza(Ambalaza amb) {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiUspesnoVracenaJednaAmbalaza(amb);
        }
    }

    public void obavestiNeuspesnoVracenaJednaAmbalaza() {
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.obavestiNeuspesnoVracenaJednaAmbalaza();
        }
    }

    public void vratiReciklazera(int odabraniReciklazerID) {
        Zahtev zah = new Zahtev(Operacije.VRATI_JEDNOG_RECIKLAZERA, odabraniReciklazerID);
        pk.posaljiZahtev(zah);
    }

    public void obavestiNeuspesnoVracenJedanReciklazer() {
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.obavestiNeuspesnoVracenJedanReciklazer();
        }
    }

    public void obavestiUspesnoVracenJedanReciklazer(Reciklazer rec) {
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.obavestiUspesnoVracenJedanReciklazer(rec);
        }
    }

    public void sacuvajListuRecikliranja(ArrayList<Recikliranje> listaRecikliranje) {
        Zahtev zah = new Zahtev(Operacije.UNESI_LISTU_RECIKLIRANJA, listaRecikliranje);
        pk.posaljiZahtev(zah);
    }

    public void obavestiUspesanUnosNovogRecikliranja() {
        if (gf != null && gf.isVisible()) {
            gf.obavestiUspesanUnosRecikliranja();
        }

    }

    public void obavestiNeuspesanUnosRecikliranja() {
        if (gf != null && gf.isVisible()) {
            gf.obavestiNeuspesanUnosRecikliranja();
        }
    }

    public void vratiNaGlavnu() {
        if (formaDodajRecikliranje != null && formaDodajRecikliranje.isVisible()) {
            gf.setVisible(true);
            formaDodajRecikliranje.dispose();
        }
        if (formaPretraziAmbalaze != null && formaPretraziAmbalaze.isVisible()) {
            formaPretraziAmbalaze.dispose();
        }
        if (formaPretraziReciklazere != null && formaPretraziReciklazere.isVisible()) {
            formaPretraziReciklazere.dispose();
        }

    }

}
