package so.reciklazer;

import domen.ApstraktniDomenskiObjekat;
import domen.Reciklazer;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class VratiListuReciklazeraSO extends ApstraktnaGenerickaOperacija {

    private List<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Reciklazer)) {
            throw new Exception("Objekat nije instanca klase Reciklazer!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN kategorija ON reciklazer.kategorijaID = kategorija.kategorijaID"
                + " JOIN korisnik ON reciklazer.korisnikID = korisnik.korisnikID";
        lista = dbb.vratiSve((Reciklazer) entity, join);
    }

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

}
