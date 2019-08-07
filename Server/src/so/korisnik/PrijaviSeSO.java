package so.korisnik;

import domen.ApstraktniDomenskiObjekat;
import domen.Korisnik;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class PrijaviSeSO extends ApstraktnaGenerickaOperacija {

    private ApstraktniDomenskiObjekat korisnik;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Korisnik)) {
            throw new Exception("Objekat nije instanca klase Korisnik!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String korisnickoIme = ((Korisnik) entity).getKorisnickoIme();
        String sifra = ((Korisnik) entity).getSifra();
        String uslov = "korisnickoIme = '" + korisnickoIme + "' AND sifra = '" + sifra + "' LIMIT 1";
        List<ApstraktniDomenskiObjekat> lista = dbb.vratiPoUslovu((ApstraktniDomenskiObjekat) entity, "", uslov);

        if (lista.isEmpty()) {
            korisnik = null;
        } else {
            korisnik = (Korisnik) lista.get(0);
        }
    }

    public ApstraktniDomenskiObjekat getKorisnik() {
        return korisnik;
    }

}
