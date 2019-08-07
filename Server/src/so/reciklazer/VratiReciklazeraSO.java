package so.reciklazer;

import domen.ApstraktniDomenskiObjekat;
import domen.Reciklazer;
import so.ApstraktnaGenerickaOperacija;

public class VratiReciklazeraSO extends ApstraktnaGenerickaOperacija {

    ApstraktniDomenskiObjekat reciklazer;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Reciklazer)) {
            throw new Exception("Objekat nije instanca klase Reciklazer!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN kategorija ON reciklazer.kategorijaID = kategorija.kategorijaID JOIN korisnik ON reciklazer.korisnikID = korisnik.korisnikID";

        reciklazer = dbb.vratiPoPrimarnomKljucu((ApstraktniDomenskiObjekat) entity, join);
    }

    public ApstraktniDomenskiObjekat getReciklazer() {
        return reciklazer;
    }

}
