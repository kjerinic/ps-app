package so.ambalaza;

import domen.Ambalaza;
import domen.ApstraktniDomenskiObjekat;
import so.ApstraktnaGenerickaOperacija;

public class VratiAmbalazuSO extends ApstraktnaGenerickaOperacija {

    ApstraktniDomenskiObjekat ambalaza;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Ambalaza)) {
            throw new Exception("Objekat nije instanca klase Ambalaza!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN ReciklazniKod ON ambalaza.reciklazniKod = reciklaznikod.kod JOIN kategorija ON reciklaznikod.kategorijaID = kategorija.kategorijaID JOIN korisnik ON ambalaza.korisnikID = korisnik.korisnikID";
        ambalaza = (ApstraktniDomenskiObjekat) dbb.vratiPoPrimarnomKljucu((Ambalaza) entity, join);
    }

    public ApstraktniDomenskiObjekat getAmbalaza() {
        return ambalaza;
    }

}
