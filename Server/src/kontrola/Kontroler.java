package kontrola;

import db.DBBroker;
import domen.*;
import forme.ServerskaForma;
import java.util.ArrayList;
import java.util.List;
import konstante.*;
import niti.*;
import so.*;
import so.ambalaza.*;
import so.kategorija.*;
import so.korisnik.*;
import so.reciklazer.*;
import so.reciklaznikod.VratiListuReciklaznihKodovaSO;
import so.recikliranje.DodajRecikliranjeSO;
import transfer.*;

public class Kontroler {

    private static Kontroler instanca;
    private ServerskaForma sf;
    private PokretanjeServera ps;
    private ArrayList<ObradaZahteva> listaObrada;
    private DBBroker dbb;

    private Kontroler() {
        dbb = new DBBroker();
        listaObrada = new ArrayList<>();
    }

    public static Kontroler getInstanca() {
        if (instanca == null) {
            instanca = new Kontroler();
        }
        return instanca;
    }

    public void setSf(ServerskaForma sf) {
        this.sf = sf;
    }

    public void pokreniServer() {
        ps = new PokretanjeServera();
        ps.start();
    }

    public void obavestiZaustavljen() {
        sf.obavestiZaustavljen();
    }

    public void obavestiPokrenut() {
        sf.obavestiPokrenut();
    }

    public void zaustaviServer() {
        Odgovor odg = new Odgovor(0, "", StatusniKod.SERVER_UGASEN);
        posaljiSvima(odg);
        ps.zaustaviServer();
    }

    public void dodajObradu(ObradaZahteva obrada) {
        listaObrada.add(obrada);
    }

    public void zaustaviSveObrade() {
        for (ObradaZahteva obradaZahteva : listaObrada) {
            obradaZahteva.zaustaviObradu();
        }
    }

    public void posaljiSvima(Odgovor odg) {
        for (ObradaZahteva obradaZahteva : listaObrada) {
            obradaZahteva.posaljiOdgovor(odg);
        }
    }

    public int vratiBrojOnlajn() {
        return listaObrada.size();
    }

    public void ukloniObradu(ObradaZahteva oz) {
        listaObrada.remove(oz);
    }

    public ApstraktniDomenskiObjekat prijaviKorisnika(String korisnickoIme, String sifra) throws Exception {
        ApstraktnaGenerickaOperacija so = new PrijaviSeSO();
        Korisnik korisnik = new Korisnik();
        korisnik.setKorisnickoIme(korisnickoIme);
        korisnik.setSifra(sifra);
        so.templateExecute(korisnik, null);
        return ((PrijaviSeSO) so).getKorisnik();
    }

    public void napraviNovNalog(Korisnik korisnik) throws Exception {
        ApstraktnaGenerickaOperacija so = new NapraviNovogKorisnikaSO();
        so.templateExecute(korisnik, null);
    }

    public void izmeniNalog(Korisnik probaKorisnik) throws Exception {
        ApstraktnaGenerickaOperacija so = new ZapamtiKorisnikaSO();
        so.templateExecute(probaKorisnik, null);
    }

    public List<ApstraktniDomenskiObjekat> vratiSveKategorije() throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiListuKategorijaSO();
        so.templateExecute(new Kategorija(), null);
        return ((VratiListuKategorijaSO) so).getLista();
    }

    public List<ApstraktniDomenskiObjekat> vratiSveReciklazere() throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiListuReciklazeraSO();
        so.templateExecute(new Reciklazer(), null);
        return ((VratiListuReciklazeraSO) so).getLista();
    }

    public void sacuvajNovogReciklazera(Reciklazer reciklazer) throws Exception {
        ApstraktnaGenerickaOperacija so = new DodajReciklazeraSO();
        so.templateExecute(reciklazer, null);
    }

    public List<ApstraktniDomenskiObjekat> vratiReciklazerePoUslovu(String[] uslovi) throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiReciklazerePoUslovuSO();
        String jedanUslov = uslovi[0] + "," + uslovi[1];
        so.templateExecute(new Reciklazer(), jedanUslov);
        return ((VratiReciklazerePoUslovuSO) so).getLista();
    }

    public List<ApstraktniDomenskiObjekat> vratiSveAmbalaze() throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiListuAmbalazaSO();
        so.templateExecute(new Ambalaza(), null);
        return ((VratiListuAmbalazaSO) so).getLista();
    }

    public void obrisiKorisnika(Korisnik probaKorisnik) throws Exception {
        ApstraktnaGenerickaOperacija so = new ObrisiKorisnikaSO();
        so.templateExecute(probaKorisnik, null);
    }

    public List<ApstraktniDomenskiObjekat> vratiSveReciklazneKodove() throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiListuReciklaznihKodovaSO();
        so.templateExecute(new ReciklazniKod(), null);
        return ((VratiListuReciklaznihKodovaSO) so).getLista();
    }

    public void unesiNovuAmbalazu(Ambalaza probaAmbalaza) throws Exception {
        ApstraktnaGenerickaOperacija so = new DodajAmbalazuSO();
        so.templateExecute(probaAmbalaza, null);
    }

    public List<ApstraktniDomenskiObjekat> vratiAmbalazePoUslovu(String[] uslovi) throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiAmbalazePoUslovuSO();
        String jedanUslov = uslovi[0] + "," + uslovi[1];
        so.templateExecute(new Ambalaza(), jedanUslov);
        return ((VratiAmbalazePoUslovuSO) so).getLista();

    }

    public ApstraktniDomenskiObjekat vratiAmbalazu(int ambalazaID) throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiAmbalazuSO();
        Ambalaza amb = new Ambalaza(ambalazaID, "", new ReciklazniKod(), new Korisnik());
        so.templateExecute(amb, null);
        return ((VratiAmbalazuSO) so).getAmbalaza();
    }

    public ApstraktniDomenskiObjekat vratiReciklazera(int reciklazerID) throws Exception {
        ApstraktnaGenerickaOperacija so = new VratiReciklazeraSO();
        Reciklazer rec = new Reciklazer(reciklazerID, "", "", "", new Kategorija(), new Korisnik());
        so.templateExecute(rec, null);
        return ((VratiReciklazeraSO) so).getReciklazer();
    }

    public void dodajRecikliranje(ArrayList<Recikliranje> listaRecikliranja) throws Exception {
        ApstraktnaGenerickaOperacija so = new DodajRecikliranjeSO();
        for (Recikliranje rec : listaRecikliranja) {
            so.templateExecute(rec, null);

        }
    }

}
