package so.ambalaza;

import domen.ApstraktniDomenskiObjekat;

import domen.Ambalaza;
import java.util.List;
import so.ApstraktnaGenerickaOperacija;

public class VratiListuAmbalazaSO extends ApstraktnaGenerickaOperacija {

    private List<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Ambalaza)) {
            throw new Exception("Objekat nije instanca klase Ambalaza!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        String join = " JOIN reciklaznikod ON ambalaza.reciklaznikod = reciklazniKod.kod"
                + " JOIN kategorija ON reciklazniKod.kategorijaID = kategorija.kategorijaID"
                + " JOIN korisnik ON ambalaza.korisnikID = korisnik.korisnikID";
        //Ambalaza amb = new Ambalaza(1, "proba", new ReciklazniKod(1, "sss", new Kategorija(1, "plastika")), new Korisnik(1, "a", "a", "a", "a", "a"));
        lista = dbb.vratiSve((Ambalaza) entity, join);
        //lista = new ArrayList<>();
        //lista.add(amb);
//        lista.remove(4);
//        lista.remove(5);
//        lista.remove(6);
//        lista.remove(7);
//        lista.remove(8);

    }

    public List<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

}
