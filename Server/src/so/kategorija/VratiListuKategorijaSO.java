package so.kategorija;

import domen.ApstraktniDomenskiObjekat;
import domen.Kategorija;
import domen.Reciklazer;
import java.util.ArrayList;
import so.ApstraktnaGenerickaOperacija;

public class VratiListuKategorijaSO extends ApstraktnaGenerickaOperacija {

    ArrayList<ApstraktniDomenskiObjekat> lista;

    @Override
    protected void validiraj(Object entity) throws Exception {
        if (!(entity instanceof Kategorija)) {
            throw new Exception("Objekat nije instanca klase Kategorija!");
        }
    }

    @Override
    protected void izvrsi(Object entity, String keyword) throws Exception {
        lista = (ArrayList<ApstraktniDomenskiObjekat>) dbb.vratiSve((Kategorija) entity, null);
    }

    public ArrayList<ApstraktniDomenskiObjekat> getLista() {
        return lista;
    }

}
